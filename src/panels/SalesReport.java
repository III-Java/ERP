package panels;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Calendar;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Properties;
import javax.swing.JComboBox;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author 許哲浩
 */
public class SalesReport extends javax.swing.JPanel {
    private Connection conn;
    private Properties prop;
    private PreparedStatement pstmt = null;
    private ResultSet rs = null;
    
    private boolean isYearSelected;
    private boolean isMonthSelected;
    private boolean isProductSelected;
    //記錄當前選擇的欄位值
    private String sltYear;
    private String sltMonth;
    private String sltProduct;
    private int unitPrice;
    
    //欄位名稱
    private String[] shiftfields;
    private LinkedList<String> productfields;
    private LinkedList<String> yearfields;
    private LinkedList<String> monthfields;
    

    private LinkedList<String[]> orderList;//存訂單資訊(id,年,月)
    private LinkedList<String[]> productList;//存產品資訊(id,名稱,價格)
    private LinkedList<String> listNums; //記錄符合日期區間的訂單ID 
    private LinkedList<String> finalLists; //記錄符合全部條件的訂單ID 
    
    //TO DO 要將所有結果存入LinkedList中
    private LinkedList<String[]> data = new LinkedList<String[]>();
    private String[] datas = new String[5];
    
    public SalesReport() {
        initComponents();
        init();
        setDBProp();
        orderList = selectOrderList(); 
        setDefault();
        selectAttendance();
    }
    
    public SalesReport(Connection conn) {
        initComponents();
        init();
        this.conn = conn;
        setDBProp();
        orderList = selectOrderList(); 
        setDefault();
        selectAttendance();
    }
    private void init(){       
        shiftfields = new String[]{"全部","早班","中班","晚班"};
        productfields = new LinkedList<String>();   
        yearfields = new LinkedList<String>();
        monthfields = new LinkedList<String>();    
        orderList = new LinkedList<String[]>();
        productList = new LinkedList<String[]>();
        listNums = new LinkedList<String>();
        finalLists = new LinkedList<>();
        isYearSelected = false;
        isMonthSelected = false;
        isProductSelected = false;
        sltYear = new String();
        sltMonth = new String();
        sltProduct = new String();

        
    }
    
    
    private void setDBProp() {

		prop = new Properties();
		prop.setProperty("user", "root");
		prop.setProperty("password", "");
		prop.setProperty("characterEncoding", "UTF-8");
		prop.setProperty("useUnicode", "true");
		prop.setProperty("useSSL", "False");
		try {
			conn = DriverManager.getConnection("jdbc:mysql://localhost/erp", prop);
		} catch (Exception e) {
			e.printStackTrace();
		}
    }

    
    private void setItem(JComboBox<String> cbox , String[] fields){        
        cbox.setModel(new javax.swing.DefaultComboBoxModel<>(fields));
    }
    protected void setDefault(){
        setItem(year, getDateFields(yearfields));
        setItem(month, new String[]{});
        setItem(product, new String[]{});
        label_total.setText("");
//        month.setVisible(false);
//        shift.setVisible(false);
//        employee.setVisible(false);
//        product.setVisible(false);
    }

    private LinkedList selectProduct(LinkedList<String> proNums){
        productfields.clear();
        productfields.add("---全部---");
        try{
            PreparedStatement pstmt = conn.prepareStatement("SELECT * FROM product");
            ResultSet result =  pstmt.executeQuery();
            
            
            LinkedList<String[]> rows = new LinkedList<String[]>();
            while(result.next()){
                String[] row = new String[3];
                row[0] = result.getString("productNum");
                row[1] = result.getString("productName");
                row[2] = result.getString("price");
                if(proNums != null){
                    for(int i = 0; i < proNums.size();i++){
                        if(row[0].equals(proNums.get(i)))
                            productfields.add( row[0] + "--" + row[1]);
                    }
                }
                rows.add(row);
            }

            pstmt.close();
            return rows;
        }catch(Exception e){
            e.printStackTrace();
            return null;
        }
    }
    private LinkedList<String[]> selectOrderItem(String onum){
        try{
            PreparedStatement pstmt = conn.prepareStatement("SELECT * FROM orderItem WHERE orderNum = ?");
            pstmt.setString(1, onum);
            ResultSet result =  pstmt.executeQuery();          
            LinkedList<String[]> rows = new LinkedList<String[]>();     
            while(result.next()){
                String[] row = new String[4];
                row[0] = result.getString("orderNum");
                row[1] = result.getString("productNum");
                row[2] = result.getString("qty");                
                row[3] = result.getString("note");
                rows.add(row);
            }      
            result.close();
            pstmt.close();
            return rows;
        }catch(Exception e){
            e.printStackTrace();
            return null;
        }
    }
    private LinkedList<String[]> selectOrderItem(String onum,String sltProduct){
        try{
            PreparedStatement pstmt = conn.prepareStatement("SELECT * FROM orderItem WHERE orderNum = ? AND productNum= ?");
            pstmt.setString(1, onum);
            pstmt.setString(2, sltProduct);
            ResultSet result =  pstmt.executeQuery();          
            LinkedList<String[]> rows = new LinkedList<String[]>();     
            while(result.next()){
                String[] row = new String[4];
                row[0] = result.getString("orderNum");
                row[1] = result.getString("productNum");
                row[2] = result.getString("qty");                
                row[3] = result.getString("note");
                rows.add(row);
            }      
            result.close();
            pstmt.close();
            return rows;
        }catch(Exception e){
            e.printStackTrace();
            return null;
        }
    }
    
    private LinkedList selectOrderList(){
        try{
            PreparedStatement pstmt = conn.prepareStatement("SELECT * FROM orderList");
            ResultSet result =  pstmt.executeQuery();
           
            LinkedList<String[]> rows = new LinkedList<String[]>();
            while(result.next()){
                
                Calendar c = Calendar.getInstance();
                c.setTime(result.getDate("orderDate"));
                String y = Integer.toString(c.get(Calendar.YEAR));
                String m = Integer.toString(c.get(Calendar.MONTH)+1);                
                String[] row = new String[3];
                row[0] = result.getString("orderNum");
                row[1] = y;
                row[2] = m;

                if(yearfields.indexOf(y) < 0)yearfields.add(y);                
                rows.add(row);
            }           
            //排序
            java.util.Collections.sort(yearfields);
            pstmt.close();
            return rows;
        }catch(Exception e){
            e.printStackTrace();
            return null;
        }
    }
  
    private String[] selectOrderList(String onum){
        try{
            PreparedStatement pstmt = conn.prepareStatement("SELECT * FROM orderList WHERE orderNum = ?");
            pstmt.setString(1, onum);
            ResultSet result =  pstmt.executeQuery();
           
            String[] row = new String[6];
            if(result.next()){
                row[0] = result.getString("orderNum");
                row[1] = result.getString("customerId");
                row[2] = result.getString("orderDate");
                row[3] = result.getString("status");
                row[4] = result.getString("dispatch");
                row[5] = result.getString("note");

            }           
            
            result.close();
            pstmt.close();
            return row;
        }catch(Exception e){
            e.printStackTrace();
            return null;
        }
    }
    protected LinkedList<String[]> getData(){
        return data;
    }
    private String[] getDateFields(LinkedList<String> date){
        String[] strDate = new String[date.size()+1];
        strDate[0] = "";
        for(int i = 1; i < strDate.length;i++){
            strDate[i] = date.get(i-1);
        }
        return strDate;
    }
    private void getProductNum(){
        //找符合日期區間的訂單ID
        LinkedList<LinkedList<String[]>> productInfo = new LinkedList<>();
        LinkedList<String> prodNums = new LinkedList<>();
        listNums.clear();
        for(int i = 0; i < orderList.size();i++){
            if(sltYear.equals(orderList.get(i)[1])&&sltMonth.equals(orderList.get(i)[2]))
                listNums.add(orderList.get(i)[0]);
        }
        //用訂單ID去orderItem找產品編號
        for(int i = 0; i < listNums.size();i++){
            productInfo.add(selectOrderItem(listNums.get(i)));
        }
        //用產品編號去product找產品名稱
        for(int i = 0; i < productInfo.size();i++){
            for(int j = 0; j < productInfo.get(i).size();j++){
                String prodNum = productInfo.get(i).get(j)[1];
                if(prodNums.indexOf(prodNum) < 0){
                    prodNums.add(prodNum);
                }
            }
        }    
        selectProduct(prodNums);
    }
    private int getQty(LinkedList<String> orderNum,String productNum){
        int qty = 0;
        for(int i = 0; i < orderNum.size();i++){
            LinkedList<String[]> temp = selectOrderItem(orderNum.get(i));
            for(int j = 0; j < temp.size();j++){
                if(temp.get(j)[1].equals(productNum)){
                    qty += Integer.parseInt(temp.get(j)[2]);
                    if(finalLists.indexOf(orderNum.get(i)) < 0)
                    		finalLists.add(orderNum.get(i));
                }
            }
        }
        return qty;
    }
    private int getTotal(String strSlt){
        //取得單價
        productList = selectProduct(null);
        for(int i = 0; i < productList.size();i++){
            if(productList.get(i)[0].equals(strSlt)){
                unitPrice = Integer.parseInt(productList.get(i)[2]);
            }
        }
        //取得總數量
        int qty = getQty(listNums,strSlt);    
        return qty * unitPrice;
    }
    
    
    private void setProduct(){
        if(isYearSelected == isMonthSelected == true){
            getProductNum();
            String pfields[] = new String[productfields.size()+1];
            pfields[0] = "";
            for(int i = 1; i < pfields.length;i++){
                pfields[i] = productfields.get(i-1);
            }       
            setItem(product,pfields);
            product.setVisible(true);
        }
    }
    private void setData(){
        data.clear();
        LinkedList<String[]> items = new LinkedList<>();
        if(isYearSelected == isMonthSelected == isProductSelected ==true){
            for(int i = 0; i < finalLists.size();i++){
                String[] list = selectOrderList(finalLists.get(i));
                if(sltProduct.equals("---全部"))
                	items = selectOrderItem(finalLists.get(i));
                else
                	items = selectOrderItem(finalLists.get(i) , sltProduct);
                for(int j = 0; j<items.size();j++){
                    String[] merge = new String[9];
                    merge[0] = list[0];
                    merge[1] = list[2];
                    merge[2] = list[1];
                    merge[3] = items.get(j)[1];
                    merge[4] = items.get(j)[2];
                    merge[5] = list[3];
                    merge[6] = list[4];
                    merge[7] = list[5];
                    merge[8] = items.get(j)[3];
                    data.add(merge);

                }
            }
        }
    }
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        year = new javax.swing.JComboBox<>();
        month = new javax.swing.JComboBox<>();
        product = new javax.swing.JComboBox<>();
        label_total = new javax.swing.JLabel();
        label_date = new javax.swing.JLabel();
        label_product = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();

        setMinimumSize(new java.awt.Dimension(980, 470));
        setPreferredSize(new java.awt.Dimension(980, 470));
        setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        year.setFont(new java.awt.Font("微軟正黑體", 0, 14)); // NOI18N
        year.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        year.setToolTipText("");
        year.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                yearActionPerformed(evt);
            }
        });
        add(year, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 160, 120, 40));

        month.setFont(new java.awt.Font("微軟正黑體", 0, 14)); // NOI18N
        month.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        month.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                monthActionPerformed(evt);
            }
        });
        add(month, new org.netbeans.lib.awtextra.AbsoluteConstraints(370, 160, 120, 40));

        product.setFont(new java.awt.Font("微軟正黑體", 0, 14)); // NOI18N
        product.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        product.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                productActionPerformed(evt);
            }
        });
        add(product, new org.netbeans.lib.awtextra.AbsoluteConstraints(620, 160, 120, 40));

        label_total.setFont(new java.awt.Font("微軟正黑體", 0, 15)); // NOI18N
        label_total.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        label_total.setText("總額");
        add(label_total, new org.netbeans.lib.awtextra.AbsoluteConstraints(770, 160, 100, 40));

        label_date.setFont(new java.awt.Font("微軟正黑體", 0, 15)); // NOI18N
        label_date.setText("日期區間");
        label_date.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        add(label_date, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 120, 150, -1));

        label_product.setFont(new java.awt.Font("微軟正黑體", 0, 15)); // NOI18N
        label_product.setText("產品");
        add(label_product, new org.netbeans.lib.awtextra.AbsoluteConstraints(620, 120, -1, -1));

        jLabel1.setFont(new java.awt.Font("微軟正黑體", 0, 15)); // NOI18N
        jLabel1.setText("年");
        add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(290, 170, -1, -1));

        jLabel2.setFont(new java.awt.Font("微軟正黑體", 0, 15)); // NOI18N
        jLabel2.setText("月");
        add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(530, 170, -1, -1));
    }// </editor-fold>//GEN-END:initComponents

    private void yearActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_yearActionPerformed
        isYearSelected = true;
        orderList = selectOrderList();
        javax.swing.JComboBox cb = (javax.swing.JComboBox)evt.getSource();
        sltYear = cb.getSelectedItem().toString();
        monthfields.clear();    //選擇後將之前的清空
        //取得訂單資訊中該年存在的月份
        for(int i = 0; i < orderList.size();i++){
            if(orderList.get(i)[1].equals(cb.getSelectedItem())){
                if(monthfields.indexOf(orderList.get(i)[2]) < 0)
                    monthfields.add(orderList.get(i)[2]);
            }
        }

        java.util.Collections.sort(monthfields);    //排序
        setItem(month,getDateFields(monthfields));  
        month.setVisible(true);

        setProduct();
        setData();

    }

    private void monthActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_monthActionPerformed
        isMonthSelected = true;
        javax.swing.JComboBox cb = (javax.swing.JComboBox)evt.getSource();
        sltMonth = cb.getSelectedItem().toString();
        
        //取得符合日期區間的訂單ID
        for(int i = 0; i < orderList.size();i++){
            if(orderList.get(i)[1].equals(sltYear)&&orderList.get(i).equals(sltMonth))
                listNums.add(orderList.get(i)[0]);
        }  
        setProduct();

        setData();
    }

    
    private void productActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_productActionPerformed
        isProductSelected = true;
        javax.swing.JComboBox cb = (javax.swing.JComboBox)evt.getSource();
        
        String strSlt = new String();
        if(!cb.getSelectedItem().toString().equals(""))
        	strSlt = cb.getSelectedItem().toString().substring(0, 5);
        sltProduct = strSlt;
        int total = 0;
        if(strSlt.equals("---全部")){
            for(int i = 0; i < cb.getItemCount();i++){
            	if(!cb.getItemAt(i).equals("")){
	                String all = cb.getItemAt(i).toString().substring(0, 5);
	                total += getTotal(all);
                }
            }
        }else{
            total = getTotal(strSlt);
        }        
        label_total.setText(total + "");
        setData();
        finalLists.clear();
    }//GEN-LAST:event_productActionPerformed

    
    
    
    

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel label_date;
    private javax.swing.JLabel label_product;
    private javax.swing.JLabel label_total;
    private javax.swing.JComboBox<String> month;
    private javax.swing.JComboBox<String> product;
    private javax.swing.JComboBox<String> year;
    // End of variables declaration//GEN-END:variables

    protected LinkedList<String[]> selectAttendance(){
        try{
            PreparedStatement pstmt = conn.prepareStatement("SELECT * FROM attendance");
            
            ResultSet result =  pstmt.executeQuery();
            
            
            LinkedList<String[]> rows = new LinkedList<String[]>();
            
            while(result.next()){
                String[] row = new String[3];
                row[0] = result.getString("employeeNum");
                row[1] = result.getString("work");  //上班打卡時間
                row[2] = result.getString("offwork");//下班打卡時間              
                rows.add(row);
            }

            pstmt.close();
            return rows;
        }catch(Exception e){
            e.printStackTrace();
            return null;
        }
    }


}
