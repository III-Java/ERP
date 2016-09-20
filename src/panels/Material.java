package panels;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.LinkedList;

public class Material extends javax.swing.JPanel {

	private Connection con;
	private PreparedStatement pstmt = null;
	private ResultSet rs = null;
	private String materialNum;
	private String materialName;
	private int qty;
	private String unit;
	private String vendorNum;
	private String note;
    public Material(Connection con) {
    	this.con = con;
        initComponents();
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">                          
    private void initComponents() {

    	 jLabel1 = new javax.swing.JLabel();
         jLabel2 = new javax.swing.JLabel();
         jLabel7 = new javax.swing.JLabel();
         jLabel10 = new javax.swing.JLabel();
         jScrollPane1 = new javax.swing.JScrollPane();
         txtNote = new javax.swing.JEditorPane();
         txtMaterialName = new javax.swing.JTextField();
         jLabel11 = new javax.swing.JLabel();
         spQty = new javax.swing.JSpinner();
         txtVendorNum = new javax.swing.JTextField();
         jLabel3 = new javax.swing.JLabel();
         lbMaterialNum = new javax.swing.JLabel();
         lbVendorName = new javax.swing.JLabel();
         cbUnit = new javax.swing.JComboBox<>();

         setPreferredSize(new java.awt.Dimension(980, 470));
         setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

         jLabel1.setFont(new java.awt.Font("微軟正黑體", 0, 15)); // NOI18N
         jLabel1.setText("原料編號");
         add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(59, 65, 72, -1));

         jLabel2.setFont(new java.awt.Font("微軟正黑體", 0, 15)); // NOI18N
         jLabel2.setText("數量");
         add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(59, 278, 72, -1));

         jLabel7.setFont(new java.awt.Font("微軟正黑體", 0, 18)); // NOI18N
         add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(596, 89, -1, -1));

         jLabel10.setFont(new java.awt.Font("微軟正黑體", 0, 15)); // NOI18N
         jLabel10.setText("備註");
         add(jLabel10, new org.netbeans.lib.awtextra.AbsoluteConstraints(552, 163, -1, -1));

         txtNote.setFont(new java.awt.Font("微軟正黑體", 0, 14)); // NOI18N
         jScrollPane1.setViewportView(txtNote);

         add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(660, 161, 225, 142));

         txtMaterialName.setFont(new java.awt.Font("微軟正黑體", 0, 15)); // NOI18N
         add(txtMaterialName, new org.netbeans.lib.awtextra.AbsoluteConstraints(145, 160, 225, -1));

         jLabel11.setFont(new java.awt.Font("微軟正黑體", 0, 15)); // NOI18N
         jLabel11.setText("進貨廠商編號");
         add(jLabel11, new org.netbeans.lib.awtextra.AbsoluteConstraints(552, 65, -1, -1));

         spQty.setFont(new java.awt.Font("微軟正黑體", 0, 15)); // NOI18N
         add(spQty, new org.netbeans.lib.awtextra.AbsoluteConstraints(145, 275, 105, -1));

         txtVendorNum.setFont(new java.awt.Font("微軟正黑體", 0, 15)); // NOI18N
         txtVendorNum.addKeyListener(new java.awt.event.KeyAdapter() {
             public void keyReleased(java.awt.event.KeyEvent evt) {
                 txtVendorNumKeyReleased(evt);
             }
         });
         add(txtVendorNum, new org.netbeans.lib.awtextra.AbsoluteConstraints(660, 62, 225, -1));

         jLabel3.setFont(new java.awt.Font("微軟正黑體", 0, 15)); // NOI18N
         jLabel3.setText("原料名稱");
         add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(59, 163, 72, -1));

         lbMaterialNum.setFont(new java.awt.Font("微軟正黑體", 0, 15)); // NOI18N
         add(lbMaterialNum, new org.netbeans.lib.awtextra.AbsoluteConstraints(145, 62, 225, 27));

         lbVendorName.setFont(new java.awt.Font("微軟正黑體", 0, 15)); // NOI18N
         add(lbVendorName, new org.netbeans.lib.awtextra.AbsoluteConstraints(660, 107, 225, 28));

         cbUnit.setFont(new java.awt.Font("微軟正黑體", 0, 15)); // NOI18N
         cbUnit.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { " ", "公斤", "公升", "台斤", "包", "個", "組", "罐", "隻", "盒" }));
         add(cbUnit, new org.netbeans.lib.awtextra.AbsoluteConstraints(268, 274, 102, 28));
    }// </editor-fold>                        
    
    private void setVendorName() {
		String vendorName = "";
		try {
			pstmt = con.prepareStatement("SELECT vendorName FROM vendor Where vendorNum = ?");
			pstmt.setString(1, txtVendorNum.getText());
			rs = pstmt.executeQuery();
			while (rs.next()) {
				vendorName = rs.getString("vendorName");
			}
			lbVendorName.setText(vendorName);
		} catch (SQLException ee) {
			System.out.println(ee.toString());
		}
    }
    
    protected void setInputValue(HashMap<Integer, String> data) {
    	lbMaterialNum.setText(data.get(0));
    	txtMaterialName.setText(data.get(1));
    	spQty.setValue(Integer.parseInt(data.get(2)));
    	cbUnit.setSelectedItem((Object)data.get(3));
    	txtVendorNum.setText(data.get(4));
    	txtNote.setText(data.get(5));
    	setVendorName();
    }
    
    protected void clearInput() {
    	txtMaterialName.setText("");
    	lbMaterialNum.setText("");
    	spQty.setValue(0);
    	txtVendorNum.setText("");
    	txtNote.setText("");
    	lbVendorName.setText("");
    	cbUnit.setSelectedIndex(0);
    }
    
    private boolean getUserInputParm() {
    	boolean isRightData = false;
    	materialName = txtMaterialName.getText();
    	qty = (Integer)spQty.getValue();
    	unit = cbUnit.getSelectedItem().toString();
    	vendorNum = txtVendorNum.getText();
    	note = txtNote.getText();
    	if(materialName.equals("")||qty<=0||vendorNum.equals("")||unit.equals(" ")||lbVendorName.getText().equals("查無此廠商")){
    		isRightData = false;
    	}
    	else{
    		isRightData = true;
    	}
    	return isRightData;
    }
    
    protected boolean isDuplicatedData(){
    	try{
    		pstmt = con.prepareStatement("SELECT materialName FROM material WHERE materialName =?");
			pstmt.setString(1, materialName);
    		rs = pstmt.executeQuery();
			while (rs.next()) {
				return true;
			}
    	}
    	catch(SQLException ee){
    		System.out.println(ee.toString());
    	}
    	return false;
    }

    protected boolean isSameMaterialName(){
    	if(!txtMaterialName.getText().equals(materialName)){
    		try{
    			pstmt = con.prepareStatement("SELECT materialName FROM material WHERE materialName =?");
    			pstmt.setString(1, txtMaterialName.getText());
        		rs = pstmt.executeQuery();
    			while (rs.next()) {
    				return true;
    			}
    		}
    		catch(SQLException ee){
    			System.out.println(ee.toString());
    		}
    	}
    	return false;
    }
    protected int insertData() {
		int isInsert = 0;
		if(getUserInputParm() == true && isDuplicatedData() == false){
			try {
				pstmt = con.prepareStatement("INSERT INTO material(materialName,qty,unit,vendorNum,note)VALUES(?,?,?,?,?)");
				pstmt.setString(1, materialName);
				pstmt.setString(2, Integer.toString(qty));
				pstmt.setString(3, unit);
				pstmt.setString(4, vendorNum);
				pstmt.setString(5, note);
				isInsert = pstmt.executeUpdate();
			} catch (SQLException ee) {
				System.out.println(ee.toString());
			}
		}
		clearInput();
		return isInsert;
    }
    
    protected int updateData() {
    	int isUpdate = 0;
    	materialNum = lbMaterialNum.getText();
    	if (getUserInputParm() == true && !materialNum.equals("") && isSameMaterialName() == false) {
    		try {
				pstmt = con.prepareStatement("UPDATE material SET materialName=?,qty=?,unit=?,vendorNum=?,note=? WHERE materialNum = ?");
				pstmt.setString(1, materialName);
				pstmt.setString(2, Integer.toString(qty));
				pstmt.setString(3, unit);
				pstmt.setString(4, vendorNum);
				pstmt.setString(5, note);
				pstmt.setString(6, materialNum);
				isUpdate = pstmt.executeUpdate();
			} catch (SQLException e) {
				System.out.println(e.toString());
			}
    		
    	}
    	clearInput();
    	return isUpdate;
    }
    
    protected int delData(){
    	int isDel = 0;
    	materialNum = lbMaterialNum.getText();
    	if(!materialNum.equals("")){
    		try{
    			pstmt = con.prepareStatement("DELETE FROM material WHERE materialNum=?");
    			pstmt.setString(1, materialNum);
    			isDel = pstmt.executeUpdate();
    		}
    		catch(SQLException ee){
    			System.out.println(ee.toString());
    		}
    	}
    	clearInput();
    	return isDel;
    }
   
    protected LinkedList<String[]> queryData() {
		LinkedList<String[]> data = new LinkedList<>();
		try{
			pstmt = con.prepareStatement("SELECT * FROM material");
			rs = pstmt.executeQuery();
			while (rs.next()) {
				String[] row = new String[6];
				row[0] = rs.getString("materialNum");
				row[1] = rs.getString("materialName");
				row[2] = rs.getString("qty");
				row[3] = rs.getString("unit");
				row[4] = rs.getString("vendorNum");
				row[5] = rs.getString("note");
				data.add(row);
			}
		}
		catch(SQLException ee){
			System.out.println(ee.toString());
		}
		return data;
    }
    
    protected  LinkedList<String[]> search(String value){
		LinkedList<String[]> data = new LinkedList<>();
		try{
			pstmt = con.prepareStatement("SELECT * FROM material WHERE materialNum LIKE ? OR materialName LIKE ? OR qty LIKE ?  OR unit LIKE ? OR vendorNum LIKE ? OR note LIKE ?");
			String query = "%" + value +"%";
			for(int i=1 ; i<7; i++){
				pstmt.setString(i, query);
			}
			rs = pstmt.executeQuery();
			while (rs.next()) {
				String[] row = new String[6];
				row[0] = rs.getString("materialNum");
				row[1] = rs.getString("materialName");
				row[2] = rs.getString("qty");
				row[3] = rs.getString("unit");
				row[4] = rs.getString("vendorNum");
				row[5] = rs.getString("note");
				data.add(row);
			}
		}
		catch(SQLException ee){
			System.out.println(ee.toString());
		}
		return data;
    }
    
    private void txtVendorNumKeyReleased(java.awt.event.KeyEvent evt) {                                         
        String vendorNum = "";
        try {
			pstmt = con.prepareStatement("SELECT vendorNum FROM vendor Where vendorNum = ?");
			pstmt.setString(1, txtVendorNum.getText());
			rs = pstmt.executeQuery();
			while (rs.next()) {
				vendorNum = rs.getString("vendorNum");
			}
			setVendorName();
		} catch (SQLException ee) {
			System.out.println(ee.toString());
		}
		if (vendorNum.equals("")) {
			lbVendorName.setText("查無此廠商");
		}
    }       
   
    private javax.swing.JComboBox<String> cbUnit;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel lbMaterialNum;
    private javax.swing.JLabel lbVendorName;
    private javax.swing.JSpinner spQty;
    private javax.swing.JTextField txtMaterialName;
    private javax.swing.JEditorPane txtNote;
    private javax.swing.JTextField txtVendorNum;      
}
