package panels;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Properties;

import javax.swing.JOptionPane;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author 許哲浩
 */
public class OrderItem extends javax.swing.JPanel {
    private Connection conn;
	private Properties prop;
	private PreparedStatement pstmt = null;
	private ResultSet rs = null;
    HashMap <String,String[]> products = new HashMap<>();
    private String nowProductNum;
    
    public OrderItem() {
        initComponents();
        setDBProp();
        init();
    }
    public OrderItem(Connection conn) {
        initComponents();
        this.conn = conn;
        init();
    }
    private void init(){
        LinkedList<String[]> prods = selectProduct();
       String[] prodNum = new String[prods.size()+1];
       String[] prodName  = new String[prods.size()+1];
       nowProductNum = new String();
       
       prodNum[0] = "";
       prodName[0] = "";
       
       for(int i = 0; i < prods.size();i++){
           prodNum[i+1] = prods.get(i)[0];
           prodName[i+1] = prods.get(i)[1];
       }

       products.put("memberNum", prodNum);
       products.put("memberName", prodName);
       combo_productNum.setModel(new javax.swing.DefaultComboBoxModel<>(prodNum));
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
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	//判斷input有無空白
	private boolean getUserInputParm() {
		boolean isRightData = false;
		if (text_orderNum.getText().equals("") 
				|| combo_productNum.getSelectedItem().toString().equals("")
				|| text_qty.getText().equals("")) {
			isRightData = false;
		} else {
			isRightData = true;
		}
		return isRightData;
	}
    
        
    protected int insertData(){
    	int isInsert = 0;	//紀錄資料有沒有insert成功
        try{
            pstmt = conn.prepareStatement(
                    "INSERT INTO orderitem(orderNum,productNum,qty,note) VALUES('"
                            + ""+text_orderNum.getText()+"','"
                            + ""+combo_productNum.getSelectedItem().toString()+"','"
                            + ""+text_qty.getText()+"','"
                            + ""+text_note.getText()+"')");
            isInsert = pstmt.executeUpdate();
            
            clearInput();
            
        }catch(Exception e){
            e.printStackTrace();
        }
        return isInsert;
        
    }

	protected int delData(){
		int isDel = 0;
		if(!text_orderNum.getText().equals("")){
			try{
				pstmt = conn.prepareStatement("DELETE FROM orderItem WHERE orderNum = ? AND productNum = ?");
				pstmt.setString(1, text_orderNum.getText());
				pstmt.setString(2, combo_productNum.getSelectedItem().toString());
				isDel = pstmt.executeUpdate();
				clearInput();
			}
			catch(SQLException ee){
				System.out.println(ee.toString());
			}
		}
		
		return isDel;
	}
    
	protected int updateData() {
		String strorderNum = text_orderNum.getText();
		String strproductNum = combo_productNum.getSelectedItem().toString();
		int isUpdate = 0;
		if (getUserInputParm() == true) {
			try {
				pstmt = conn.prepareStatement(
						"UPDATE orderItem SET productNum=?,qty=?,note=? WHERE orderNum =? AND productNum=?" );
				pstmt.setString(1, strproductNum);
				pstmt.setString(2, text_qty.getText());
				pstmt.setString(3, text_note.getText());
				pstmt.setString(4, strorderNum);
				pstmt.setString(5, nowProductNum);
				isUpdate = pstmt.executeUpdate();
				nowProductNum = strproductNum;
				clearInput();
			} catch (SQLException ee) {
				System.out.println(ee.toString());
			}
		}
		return isUpdate;
	}
    
    
    
    protected LinkedList<String[]> queryData(){
    	 LinkedList<String[]> rows = new LinkedList<String[]>();
        try{
            pstmt = conn.prepareStatement("SELECT * FROM orderitem");
            rs =  pstmt.executeQuery();
             
            while(rs.next()){
                String[] row = new String[4];
                row[0] = rs.getString("orderNum");
                row[1] = rs.getString("productNum");
                row[2] = rs.getString("qty");
                row[3] = rs.getString("note");
                clearInput();
                rows.add(row);
            }

            
            
        }catch(Exception e){
            e.printStackTrace();

        }
        return rows;
    }
    
	protected  LinkedList<String[]> search(String value){
		LinkedList<String[]> data = new LinkedList<>();
		try {
			pstmt = conn.prepareStatement(
					"SELECT * FROM orderitem WHERE orderNum LIKE ? OR productNum LIKE? OR qty LIKE ? OR note LIKE ?");
			String query = "%" + value +"%";
			for(int i=1 ; i<5; i++){
				pstmt.setString(i, query);
			}
			rs = pstmt.executeQuery();
			while (rs.next()) {
				String[] row = new String[4];
				row[0] = rs.getString("orderNum");
				row[1] = rs.getString("productNum");
				row[2] = rs.getString("qty");
				row[3] = rs.getString("note");
				data.add(row);
			}
		} catch (SQLException ee) {
			ee.toString();
		}
		return data;
	}
    
	protected void setInputValue(HashMap<Integer, String> data) {
		text_orderNum.setText(data.get(0));
		combo_productNum.setSelectedItem(data.get(1));
		nowProductNum = data.get(1);
		text_qty.setText(data.get(2));	
		text_note.setText(data.get(3));
	}
    
    protected String[] getColumn(){ 
        String[] columnName = 
                new String[]{"orderNum","productNum","qty","note"};
        return columnName;
    }
    
    protected void clearInput(){
        text_orderNum.setText("");
        combo_productNum.setSelectedIndex(0);
        text_qty.setText("");      
        text_note.setText("");
    }
    private LinkedList selectProduct(){
        try{
            pstmt = conn.prepareStatement("SELECT * FROM product");
            ResultSet result =  pstmt.executeQuery();                    
            LinkedList<String[]> rows = new LinkedList<String[]>();
           
            while(result.next()){
                String[] product = new String[2];
                product[0] = result.getString("productNum");
                product[1] = result.getString("productName");
                rows.add(product);
            }
            
            return rows;
        }catch(Exception e){
            e.printStackTrace();
            return null;
        }
    }
    
    private void text_qtyKeyTyped(java.awt.event.KeyEvent evt) {                                     
        String re = "[1-9]\\d*?";
        if(!text_qty.getText().matches(re))
        	 text_qty.setText("");
    }                                    

    private void text_orderNumKeyTyped(java.awt.event.KeyEvent evt) {                                          
         String re = "\\d*?";
        if(!text_orderNum.getText().matches(re))
        	 text_orderNum.setText("");
    }     
    
    
    

    @SuppressWarnings("unchecked")
 // <editor-fold defaultstate="collapsed" desc="Generated Code">                          
    private void initComponents() {

        label_orderNum = new javax.swing.JLabel();
        label_productNum = new javax.swing.JLabel();
        label_qty = new javax.swing.JLabel();
        label_note = new javax.swing.JLabel();
        text_orderNum = new javax.swing.JTextField();
        text_qty = new javax.swing.JTextField();
        scroll_note = new javax.swing.JScrollPane();
        text_note = new javax.swing.JTextArea();
        combo_productNum = new javax.swing.JComboBox<>();
        label_productName = new javax.swing.JLabel();

        setMinimumSize(new java.awt.Dimension(980, 470));
        setPreferredSize(new java.awt.Dimension(980, 470));
        setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        label_orderNum.setFont(new java.awt.Font("微軟正黑體", 0, 15)); // NOI18N
        label_orderNum.setText("訂單編號");
        add(label_orderNum, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 80, -1, -1));

        label_productNum.setFont(new java.awt.Font("微軟正黑體", 0, 15)); // NOI18N
        label_productNum.setText("產品編號");
        add(label_productNum, new org.netbeans.lib.awtextra.AbsoluteConstraints(550, 80, -1, -1));

        label_qty.setFont(new java.awt.Font("微軟正黑體", 0, 15)); // NOI18N
        label_qty.setText("數量");
        add(label_qty, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 170, -1, -1));

        label_note.setFont(new java.awt.Font("微軟正黑體", 0, 15)); // NOI18N
        label_note.setText("備註");
        add(label_note, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 260, -1, -1));

        text_orderNum.setFont(new java.awt.Font("微軟正黑體", 0, 15)); // NOI18N
        text_orderNum.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                text_orderNumKeyTyped(evt);
            }
        });
        add(text_orderNum, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 75, 200, 35));

        text_qty.setFont(new java.awt.Font("微軟正黑體", 0, 15)); // NOI18N
        text_qty.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                text_qtyKeyTyped(evt);
            }
        });
        add(text_qty, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 165, 200, 35));

        text_note.setColumns(20);
        text_note.setFont(new java.awt.Font("微軟正黑體", 0, 15)); // NOI18N
        text_note.setRows(5);
        scroll_note.setViewportView(text_note);

        add(scroll_note, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 260, 660, -1));

        combo_productNum.setFont(new java.awt.Font("微軟正黑體", 0, 15)); // NOI18N
        combo_productNum.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                combo_productNumActionPerformed(evt);
            }
        });
        add(combo_productNum, new org.netbeans.lib.awtextra.AbsoluteConstraints(630, 75, 80, 35));

        label_productName.setFont(new java.awt.Font("微軟正黑體", 0, 15)); // NOI18N
        add(label_productName, new org.netbeans.lib.awtextra.AbsoluteConstraints(750, 75, 150, 40));
    }// </editor-fold>           
    private void combo_productNumActionPerformed(java.awt.event.ActionEvent evt) {                                                 
        String slt = combo_productNum.getSelectedItem().toString();
        for(int i = 0; i < products.get("memberNum").length;i++){
            if(products.get("memberNum")[i].equals(slt)){
                label_productName.setText(products.get("memberName")[i]);
            }
        }
    }     

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JComboBox<String> combo_productNum;
    private javax.swing.JLabel label_note;
    private javax.swing.JLabel label_orderNum;
    private javax.swing.JLabel label_productName;
    private javax.swing.JLabel label_productNum;
    private javax.swing.JLabel label_qty;
    private javax.swing.JScrollPane scroll_note;
    private javax.swing.JTextArea text_note;
    private javax.swing.JTextField text_orderNum;
    private javax.swing.JTextField text_qty;
    // End of variables declaration//GEN-END:variables
}
