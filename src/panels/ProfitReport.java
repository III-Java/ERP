package panels;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Arrays;
import java.util.LinkedList;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;

public class ProfitReport extends javax.swing.JPanel {
	
	private Connection con;
	private PreparedStatement pstmt = null;
	private ResultSet rs = null;
	private String year;
	private String month;
    private String report;  
    private int sales;
    private int extend;
    public ProfitReport(Connection con) {
    	this.con = con;
        initComponents();
    }
    
    @Override
    protected void paintChildren(Graphics g) {
    	ImageIcon newIcon;		
		BufferedImage BIMG;
		try {
			BIMG = ImageIO.read(Login.class.getResource("/panelBG.jpg"));
			newIcon = new ImageIcon(new ImageIcon(BIMG).getImage().getScaledInstance(980, 470, Image.SCALE_DEFAULT));
			Image image = newIcon.getImage();
			g.drawImage(image, 0, 0, this.getSize().width, this.getSize().height, this);

		} catch (IOException e) {
			System.out.println("login img xx");
			e.printStackTrace();
		}
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">                          
    private void initComponents() {

    	 jLabel1 = new javax.swing.JLabel();
         jLabel2 = new javax.swing.JLabel();
         jLabel7 = new javax.swing.JLabel();
         jLabel10 = new javax.swing.JLabel();
         jLabel11 = new javax.swing.JLabel();
         jLabel12 = new javax.swing.JLabel();
         cbYear = new javax.swing.JComboBox<>();
         cbMonth = new javax.swing.JComboBox<>();
         lbProfit = new javax.swing.JLabel();
         lbExpend = new javax.swing.JLabel();
         lbSales1 = new javax.swing.JLabel();
         cbReport = new javax.swing.JComboBox<>();
         jLabel3 = new javax.swing.JLabel();

         setPreferredSize(new java.awt.Dimension(980, 470));
         setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

         jLabel1.setFont(new java.awt.Font("微軟正黑體", 0, 15)); // NOI18N
         jLabel1.setText("年份");
         add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(59, 65, -1, -1));

         jLabel2.setFont(new java.awt.Font("微軟正黑體", 0, 15)); // NOI18N
         jLabel2.setText("月份");
         add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(354, 60, -1, 31));

         jLabel7.setFont(new java.awt.Font("微軟正黑體", 0, 18)); // NOI18N
         add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(503, 241, -1, -1));

         jLabel10.setFont(new java.awt.Font("微軟正黑體", 0, 15)); // NOI18N
         jLabel10.setText("當月銷售");
         add(jLabel10, new org.netbeans.lib.awtextra.AbsoluteConstraints(59, 220, -1, -1));

         jLabel11.setFont(new java.awt.Font("微軟正黑體", 0, 15)); // NOI18N
         jLabel11.setText("當月支出");
         add(jLabel11, new org.netbeans.lib.awtextra.AbsoluteConstraints(59, 153, -1, -1));

         jLabel12.setFont(new java.awt.Font("微軟正黑體", 0, 15)); // NOI18N
         jLabel12.setText("當月盈餘");
         add(jLabel12, new org.netbeans.lib.awtextra.AbsoluteConstraints(59, 292, -1, -1));

         cbYear.setFont(new java.awt.Font("微軟正黑體", 0, 15)); // NOI18N
         cbYear.addActionListener(new java.awt.event.ActionListener() {
             public void actionPerformed(java.awt.event.ActionEvent evt) {
                 cbYearActionPerformed(evt);
             }
         });
         add(cbYear, new org.netbeans.lib.awtextra.AbsoluteConstraints(107, 62, 210, -1));

         cbMonth.setFont(new java.awt.Font("微軟正黑體", 0, 15)); // NOI18N
         add(cbMonth, new org.netbeans.lib.awtextra.AbsoluteConstraints(394, 62, 210, -1));

         lbProfit.setFont(new java.awt.Font("微軟正黑體", 0, 15)); // NOI18N
         lbProfit.setForeground(new java.awt.Color(255, 0, 0));
         add(lbProfit, new org.netbeans.lib.awtextra.AbsoluteConstraints(137, 292, 247, 27));

         lbExpend.setFont(new java.awt.Font("微軟正黑體", 0, 15)); // NOI18N
         add(lbExpend, new org.netbeans.lib.awtextra.AbsoluteConstraints(137, 153, 247, 27));

         lbSales1.setFont(new java.awt.Font("微軟正黑體", 0, 15)); // NOI18N
         add(lbSales1, new org.netbeans.lib.awtextra.AbsoluteConstraints(137, 220, 247, 27));

         cbReport.setFont(new java.awt.Font("微軟正黑體", 0, 15)); // NOI18N
         cbReport.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { " ", "支出報表", "銷售報表" }));
         add(cbReport, new org.netbeans.lib.awtextra.AbsoluteConstraints(683, 62, 210, -1));

         jLabel3.setFont(new java.awt.Font("微軟正黑體", 0, 15)); // NOI18N
         jLabel3.setText("觀看");
         add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(635, 60, -1, 31));
    }// </editor-fold>                        
        
    protected void clearInput(){
    	cbMonth.setSelectedIndex(0);
    	cbYear.setSelectedIndex(0);
    	cbReport.setSelectedIndex(0);
    	lbExpend.setText("");
    	lbSales1.setText("");
    	lbProfit.setText("");
    }
    
    protected void setReportSelectFirst(){
    	cbReport.setSelectedIndex(0);
    }
    
    protected void setLableDetail(){
    	lbSales1.setText(Integer.toString(sales));
    	lbExpend.setText(Integer.toString(extend));
    	if(sales-extend < 0){
    		lbProfit.setForeground(new java.awt.Color(255, 0, 0));
    	}
    	else{
    		lbProfit.setForeground(new java.awt.Color(0,0,255));
    	}
    	lbProfit.setText(Integer.toString(sales-extend));
    }

    protected void getYears(){
    	LinkedList<String> years = new LinkedList<>();
    	years.clear();
    	years.addFirst("");
    	try{
    		pstmt = con.prepareStatement("SELECT orderDate FROM orderlist");
    		rs = pstmt.executeQuery();
    		while(rs.next()){
    			String data = rs.getString(1);
    			String year = data.substring(0, 4);
    			if(!years.contains(year)){
    				years.add(year);
    			}	
    		}    		
    		String[] arrayYear = new String[years.size()];
    		years.toArray(arrayYear);
    		Arrays.sort(arrayYear);  		
    		cbYear.removeAllItems();
    		for(int i = 0 ;i<arrayYear.length; i++){
    			cbYear.addItem(arrayYear[i]);
    		}
    	}
    	catch(SQLException ee){
    		System.out.println(ee.toString());
    	}
    }
    
    protected void getMonths(){
    	cbMonth.removeAllItems();
    	LinkedList<String> months = new LinkedList<>();
    	months.clear();
    	months.addFirst("");
    	if(cbYear.getItemCount() >0){
    		String year = "%" + cbYear.getSelectedItem().toString() + "%";
        	try{
        		pstmt = con.prepareStatement("SELECT orderDate FROM orderlist WHERE orderDate LIKE ?");
        		pstmt.setString(1, year);
        		rs = pstmt.executeQuery();
        		while(rs.next()){
        			String data = rs.getString(1);
        			String month = data.substring(5, 7);
        			if(!months.contains(month)){
        				months.add(month);
        			}	
        		}
        		String[] arrayMonth = new String[months.size()];
        		months.toArray(arrayMonth);
        		Arrays.sort(arrayMonth);
        		
        		for(int i = 0 ;i<arrayMonth.length; i++){
        			cbMonth.addItem(arrayMonth[i]);
        		}
        	}
        	catch(SQLException ee){
        		System.out.println(ee.toString());
        	}
    	}

    }
    
    protected String getSelectReport(){
    	report = cbReport.getSelectedItem().toString();
    	return report;
    }
    
    protected LinkedList<String[]> querySales() {
    	sales = 0;
		LinkedList<String[]> data = new LinkedList<>();
		year = cbYear.getSelectedItem().toString();
		month = cbMonth.getSelectedItem().toString();	
		try{
			String QueryMonth = "%" + year + "-" + month + "%";
			pstmt = con.prepareStatement("SELECT orderitem.orderNum, orderitem.productNum ,product.productName,orderitem.qty,product.price, (orderitem.qty * product.price) AS TOTAL FROM orderitem ,product WHERE orderNum IN(SELECT orderNum FROM orderlist WHERE orderDate LIKE ? AND status = ?) AND orderitem.productNum = (product.productNum)");
			pstmt.setString(1, QueryMonth);
			pstmt.setString(2, "已出貨");
			rs = pstmt.executeQuery();
			
			while (rs.next()) {
				String[] row = new String[6];
				row[0] = rs.getString(1);
				row[1] = rs.getString(2);
				row[2] = rs.getString(3);
				row[3] = rs.getString(4);
				row[4] = rs.getString(5);
				row[5] = rs.getString(6);
				sales += Integer.parseInt(row[5]);
				data.add(row);
			}
		}
		catch(SQLException ee){
			System.out.println(ee.toString());
		}
		return data;
    }
    
    protected LinkedList<String[]> queryExpend() {
    	extend = 0;
    	LinkedList<String[]> data = new LinkedList<>();
    	year = cbYear.getSelectedItem().toString();
		month = cbMonth.getSelectedItem().toString();
    	try{
    		String QueryMonth = "%" + year + "/" + month + "%";
			pstmt = con.prepareStatement("SELECT purchaseDate, purchaseNum,materialNum,vendorNum,qty,price,(qty * price) AS TOTAL, employeeNum,note FROM purchase WHERE purchaseDate LIKE ?");
			pstmt.setString(1, QueryMonth);
			rs = pstmt.executeQuery();
			while (rs.next()) {
				
				String[] row = new String[9];
				row[0] = rs.getString(1);
				row[1] = rs.getString(2);
				row[2] = rs.getString(3);
				row[3] = rs.getString(4);
				row[4] = rs.getString(5);
				row[5] = rs.getString(6);
				row[6] = rs.getString(7);
				row[7] = rs.getString(8);
				row[8] = rs.getString(9);
				data.add(row);
				extend += Integer.parseInt(row[6]);
			}
    	}
    	catch(SQLException ee){
    		System.out.println(ee.toString());
    	}
    	return data;
    }
    
    private void cbYearActionPerformed(java.awt.event.ActionEvent evt) {                                       
    	getMonths();
    }                               
                     
    private javax.swing.JComboBox<String> cbMonth;
    private javax.swing.JComboBox<String> cbReport;
    private javax.swing.JComboBox<String> cbYear;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel lbExpend;
    private javax.swing.JLabel lbProfit;
    private javax.swing.JLabel lbSales1;                
}
