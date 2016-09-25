package panels;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.LinkedList;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;

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
	ImageIcon newIcon;
	BufferedImage BIMG;
	
    public Material(Connection con) {
    	this.con = con;
        initComponents();
		try {
			BIMG = ImageIO.read(Login.class.getResource("/panelBG.jpg"));
			newIcon = new ImageIcon(new ImageIcon(BIMG).getImage().getScaledInstance(980, 470, Image.SCALE_DEFAULT));
	
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">                          
    private void initComponents() {
    	jPanel1 = new javax.swing.JPanel(){
    		public void paintComponent(Graphics g){
				try {
	    			Image image = newIcon.getImage();
	    			g.drawImage(image, 0, 0, this.getSize().width, this.getSize().height, this);

				} catch (Exception e) {
					System.out.println("login img xx");
					e.printStackTrace();
				}
    		}    		
    	};
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

        setMaximumSize(new java.awt.Dimension(980, 470));
        setMinimumSize(new java.awt.Dimension(980, 470));
        setPreferredSize(new java.awt.Dimension(980, 470));

        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setFont(new java.awt.Font("微軟正黑體", 0, 15)); // NOI18N
        jLabel1.setText("原料編號");
        jPanel1.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(59, 65, 72, -1));

        jLabel2.setFont(new java.awt.Font("微軟正黑體", 0, 15)); // NOI18N
        jLabel2.setText("數量");
        jPanel1.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(59, 278, 72, -1));

        jLabel7.setFont(new java.awt.Font("微軟正黑體", 0, 18)); // NOI18N
        jPanel1.add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(596, 89, -1, -1));

        jLabel10.setFont(new java.awt.Font("微軟正黑體", 0, 15)); // NOI18N
        jLabel10.setText("備註");
        jPanel1.add(jLabel10, new org.netbeans.lib.awtextra.AbsoluteConstraints(552, 163, -1, -1));

        txtNote.setFont(new java.awt.Font("微軟正黑體", 0, 14)); // NOI18N
        jScrollPane1.setViewportView(txtNote);

        jPanel1.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(660, 161, 225, 142));

        txtMaterialName.setFont(new java.awt.Font("微軟正黑體", 0, 15)); // NOI18N
        jPanel1.add(txtMaterialName, new org.netbeans.lib.awtextra.AbsoluteConstraints(145, 160, 225, -1));

        jLabel11.setFont(new java.awt.Font("微軟正黑體", 0, 15)); // NOI18N
        jLabel11.setText("進貨廠商編號");
        jPanel1.add(jLabel11, new org.netbeans.lib.awtextra.AbsoluteConstraints(552, 65, -1, -1));

        spQty.setFont(new java.awt.Font("微軟正黑體", 0, 15)); // NOI18N
        jPanel1.add(spQty, new org.netbeans.lib.awtextra.AbsoluteConstraints(145, 275, 105, -1));

        txtVendorNum.setFont(new java.awt.Font("微軟正黑體", 0, 15)); // NOI18N
        txtVendorNum.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtVendorNumKeyReleased(evt);
            }
        });
        jPanel1.add(txtVendorNum, new org.netbeans.lib.awtextra.AbsoluteConstraints(660, 62, 225, -1));

        jLabel3.setFont(new java.awt.Font("微軟正黑體", 0, 15)); // NOI18N
        jLabel3.setText("原料名稱");
        jPanel1.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(59, 163, 72, -1));

        lbMaterialNum.setFont(new java.awt.Font("微軟正黑體", 0, 15)); // NOI18N
        jPanel1.add(lbMaterialNum, new org.netbeans.lib.awtextra.AbsoluteConstraints(145, 62, 225, 27));

        lbVendorName.setFont(new java.awt.Font("微軟正黑體", 0, 15)); // NOI18N
        jPanel1.add(lbVendorName, new org.netbeans.lib.awtextra.AbsoluteConstraints(660, 107, 225, 28));

        cbUnit.setFont(new java.awt.Font("微軟正黑體", 0, 15)); // NOI18N
        cbUnit.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { " ", "公斤", "公升", "台斤", "包", "個", "組", "罐", "隻", "盒" }));
        jPanel1.add(cbUnit, new org.netbeans.lib.awtextra.AbsoluteConstraints(268, 274, 102, 28));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );    
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
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel lbMaterialNum;
    private javax.swing.JLabel lbVendorName;
    private javax.swing.JSpinner spQty;
    private javax.swing.JTextField txtMaterialName;
    private javax.swing.JEditorPane txtNote;
    private javax.swing.JTextField txtVendorNum;   
}
