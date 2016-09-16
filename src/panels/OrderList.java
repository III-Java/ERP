package panels;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Properties;

import javax.swing.JComboBox;
import javax.swing.JTextField;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author 許哲浩
 */
public class OrderList extends javax.swing.JPanel {
    private Connection conn;
	private Properties prop;
	private PreparedStatement pstmt = null;
	private ResultSet rs = null;
    HashMap <String,String[]> member = new HashMap<>();
    private String[] statusfields = new String[]{"","新訂單","製作中","已出貨"};
    private String[] dispatchfields = new String[]{"","外送","店取"};
    
    public OrderList() {
        initComponents();
        setDBProp();
        init();
    }
    public OrderList(Connection conn) {
        initComponents();
        this.conn = conn;
        init();
    }
    private void setItem(JComboBox<String> cbox , String[] fields){        
        cbox.setModel(new javax.swing.DefaultComboBoxModel<>(fields));
    }
    private void init(){
    	setItem(combo_dispatch, dispatchfields);
        setItem(combo_status, statusfields);
        
        
        LinkedList<String[]> members = selectMember();
        String[] memberNum = new String[members.size()+1];
        String[] memberName  = new String[members.size()+1];

        memberNum[0] = "";
        memberName[0] = "";
        
        for(int i = 0; i < members.size();i++){
            memberNum[i +1] = members.get(i)[0];
            memberName[i +1] = members.get(i)[1];
        }

        member.put("memberNum", memberNum);
        member.put("memberName", memberName);
        combo_customerId.setModel(new javax.swing.DefaultComboBoxModel<>(memberNum));
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
				|| combo_customerId.getSelectedItem().toString().equals("")
				|| ((JTextField) date_orderDate.getDateEditor().getUiComponent()).getText().equals("")
				|| combo_status.getSelectedItem().toString().equals("")
				|| combo_dispatch.getSelectedItem().toString().equals("")) {
			isRightData = false;
		} else {
			isRightData = true;
		}
		return isRightData;
	}
	private LinkedList<String[]> selectMember(){
        try{
            pstmt = conn.prepareStatement("SELECT * FROM member");
            ResultSet result =  pstmt.executeQuery();                    
            LinkedList<String[]> rows = new LinkedList<String[]>();
           
            while(result.next()){
                String[] member = new String[2];
                member[0] = result.getString("customerId");
                member[1] = result.getString("memberName");
                rows.add(member);
            }
            
            return rows;
        }catch(Exception e){
            e.printStackTrace();
            return null;
        }
    }
	
	
    protected int insertData(){
    	int isInsert = 0;	//紀錄資料有沒有insert成功
        java.util.Date date = date_orderDate.getDate();        
        String strDate =DateFormat.getDateInstance().format(date);      
        try{
            pstmt = conn.prepareStatement(
                    "INSERT INTO orderlist(orderNum,customerId,orderDate,status,dispatch,note) VALUES('"
                            + ""+text_orderNum.getText()+"','"
                            + ""+combo_customerId.getSelectedItem().toString()+"','"
                            + ""+strDate+"','"
                            + ""+combo_status.getSelectedItem().toString()+"','"
                            + ""+combo_dispatch.getSelectedItem().toString()+"','"
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
				pstmt = conn.prepareStatement("DELETE FROM orderList WHERE orderNum = ?");
				pstmt.setString(1, text_orderNum.getText());
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
		String strOrderNum = text_orderNum.getText();
        java.util.Date date = date_orderDate.getDate();        
        String strDate =DateFormat.getDateInstance().format(date);   
		int isUpdate = 0;
		if (getUserInputParm() == true && !isShipped(strOrderNum)) {
			try {
				pstmt = conn.prepareStatement(
						"UPDATE orderList SET customerId=?,orderDate=?,status=?,dispatch=?,note=? WHERE orderNum = ?" );
				pstmt.setString(1, combo_customerId.getSelectedItem().toString());
				pstmt.setString(2, strDate);
				pstmt.setString(3, combo_status.getSelectedItem().toString());
				pstmt.setString(4, combo_dispatch.getSelectedItem().toString());
				pstmt.setString(5, text_note.getText());
				pstmt.setString(6, strOrderNum);
				isUpdate = pstmt.executeUpdate();
				
				
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
            pstmt = conn.prepareStatement("SELECT * FROM orderlist");
            rs =  pstmt.executeQuery();

            while(rs.next()){
                String[] row = new String[6];
                row[0] = rs.getString("orderNum");
                row[1] = rs.getString("customerId");
                row[2] = rs.getString("orderDate");
                row[3] = rs.getString("status");
                row[4] = rs.getString("dispatch");
                row[5] = rs.getString("note");

                rows.add(row);
            }
            clearInput();
            
            
        }catch(Exception e){
            e.printStackTrace();
        }
        return rows;
    }
    
    protected String[] getColumn(){ 
        String[] columnName = 
                new String[]{"orderNum","customerId","orderDate","status","dispatch","note"};
        return columnName;
    }
    
    protected void clearInput(){
        text_orderNum.setText("");
        label_customerName.setText("");
        combo_customerId.setSelectedIndex(0);
        date_orderDate.setDate(null);
        combo_dispatch.setSelectedIndex(0);
        combo_status.setSelectedIndex(0);  
        text_note.setText("");
    }

	protected  LinkedList<String[]> search(String value){
		LinkedList<String[]> data = new LinkedList<>();
		try {
			pstmt = conn.prepareStatement(
					"SELECT * FROM orderlist WHERE orderNum LIKE ? OR customerId LIKE? "
					+ "OR orderDate LIKE ? OR status LIKE ? OR dispatch LIKE ? OR note LIKE ?");
			String query = "%" + value +"%";
			for(int i=1 ; i<7; i++){
				pstmt.setString(i, query);
			}
			rs = pstmt.executeQuery();
			while (rs.next()) {
				String[] row = new String[6];
				row[0] = rs.getString("orderNum");
				row[1] = rs.getString("customerId");
				row[2] = rs.getString("orderDate");
				row[3] = rs.getString("status");
				row[4] = rs.getString("dispatch");
				row[5] = rs.getString("note");
				data.add(row);
			}
		} catch (SQLException ee) {
			ee.toString();
		}
		return data;
	}  
	//已出貨訂單不給修改
    private boolean isShipped(String orderNum){
        try{
            pstmt = conn.prepareStatement("SELECT * FROM orderlist WHERE orderNum=?");
            pstmt.setString(1, orderNum);
            rs =  pstmt.executeQuery();
            while(rs.next()){
            	if(rs.getString("status").equals("已出貨")) return true;
            }
        }catch(Exception e){
            e.printStackTrace();
        }
    	return false;
    }
    
    
	protected void setInputValue(HashMap<Integer, String> data) {
		
		
		text_orderNum.setText(data.get(0));
		combo_customerId.setSelectedItem(data.get(1));
		java.util.Date date;
		try {
			date = new SimpleDateFormat("yyyy-MM-dd").parse(data.get(2));
			date_orderDate.setDate(date);
		} catch (ParseException e) {
			e.printStackTrace();
		}
		combo_status.setSelectedItem(data.get(3));	
		combo_dispatch.setSelectedItem(data.get(4));
		text_note.setText(data.get(5));
	}
	private void combo_customerIdActionPerformed(java.awt.event.ActionEvent evt) {                                                 
        String slt = combo_customerId.getSelectedItem().toString();
        for(int i = 0; i < member.get("memberNum").length;i++){
            if(member.get("memberNum")[i].equals(slt)){
                label_customerName.setText(member.get("memberName")[i]);
            }
        }
    }        
    private void text_orderNumKeyTyped(java.awt.event.KeyEvent evt) {                                          
    	String re = "\\d*?";
        if(!text_orderNum.getText().matches(re))
        	 text_orderNum.setText("");
    }   
    
    
    @SuppressWarnings("unchecked")
    private void initComponents() {

        label_orderNum = new javax.swing.JLabel();
        label_customerId = new javax.swing.JLabel();
        label_orderDate = new javax.swing.JLabel();
        label_status = new javax.swing.JLabel();
        label_dispatch = new javax.swing.JLabel();
        label_note = new javax.swing.JLabel();
        text_orderNum = new javax.swing.JTextField();
        date_orderDate = new com.toedter.calendar.JDateChooser();
        scroll_note = new javax.swing.JScrollPane();
        text_note = new javax.swing.JTextArea();
        combo_customerId = new javax.swing.JComboBox<>();
        combo_dispatch = new javax.swing.JComboBox<>();
        combo_status = new javax.swing.JComboBox<>();
        label_customerName = new javax.swing.JLabel();

        setMinimumSize(new java.awt.Dimension(980, 470));
        setPreferredSize(new java.awt.Dimension(980, 470));
        setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        label_orderNum.setFont(new java.awt.Font("微軟正黑體", 0, 15)); // NOI18N
        label_orderNum.setText("訂單編號");
        add(label_orderNum, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 80, -1, -1));

        label_customerId.setFont(new java.awt.Font("微軟正黑體", 0, 15)); // NOI18N
        label_customerId.setText("客戶編號");
        add(label_customerId, new org.netbeans.lib.awtextra.AbsoluteConstraints(550, 80, -1, -1));

        label_orderDate.setFont(new java.awt.Font("微軟正黑體", 0, 15)); // NOI18N
        label_orderDate.setText("下單日期");
        add(label_orderDate, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 200, -1, 20));

        label_status.setFont(new java.awt.Font("微軟正黑體", 0, 15)); // NOI18N
        label_status.setText("狀態");
        add(label_status, new org.netbeans.lib.awtextra.AbsoluteConstraints(550, 200, -1, -1));

        label_dispatch.setFont(new java.awt.Font("微軟正黑體", 0, 15)); // NOI18N
        label_dispatch.setText("配送方式");
        add(label_dispatch, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 330, -1, -1));

        label_note.setFont(new java.awt.Font("微軟正黑體", 0, 15)); // NOI18N
        label_note.setText("備註");
        add(label_note, new org.netbeans.lib.awtextra.AbsoluteConstraints(550, 320, -1, -1));

        text_orderNum.setFont(new java.awt.Font("微軟正黑體", 0, 14)); // NOI18N
        text_orderNum.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                text_orderNumKeyTyped(evt);
            }
        });
        add(text_orderNum, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 75, 200, 35));

        date_orderDate.setDateFormatString("yyyy/M/d h:m:s");
        add(date_orderDate, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 195, 200, 35));

        text_note.setColumns(20);
        text_note.setFont(new java.awt.Font("微軟正黑體", 0, 14)); // NOI18N
        text_note.setRows(5);
        scroll_note.setViewportView(text_note);

        add(scroll_note, new org.netbeans.lib.awtextra.AbsoluteConstraints(630, 320, -1, -1));

        combo_customerId.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                combo_customerIdActionPerformed(evt);
            }
        });
        add(combo_customerId, new org.netbeans.lib.awtextra.AbsoluteConstraints(630, 75, 80, 35));

        add(combo_dispatch, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 325, 80, 35));

        add(combo_status, new org.netbeans.lib.awtextra.AbsoluteConstraints(630, 195, 80, 35));

        label_customerName.setFont(new java.awt.Font("微軟正黑體", 0, 15)); // NOI18N
        add(label_customerName, new org.netbeans.lib.awtextra.AbsoluteConstraints(760, 75, 150, 40));
    }// </editor-fold>         


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JComboBox<String> combo_customerId;
    private javax.swing.JComboBox<String> combo_dispatch;
    private javax.swing.JComboBox<String> combo_status;
    private com.toedter.calendar.JDateChooser date_orderDate;
    private javax.swing.JLabel label_customerId;
    private javax.swing.JLabel label_customerName;
    private javax.swing.JLabel label_dispatch;
    private javax.swing.JLabel label_note;
    private javax.swing.JLabel label_orderDate;
    private javax.swing.JLabel label_orderNum;
    private javax.swing.JLabel label_status;
    private javax.swing.JScrollPane scroll_note;
    private javax.swing.JTextArea text_note;
    private javax.swing.JTextField text_orderNum;
    // End of variables declaration//GEN-END:variables
}
