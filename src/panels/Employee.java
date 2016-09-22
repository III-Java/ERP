package panels;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Properties;

import javax.imageio.ImageIO;
import javax.swing.DefaultComboBoxModel;
import javax.swing.ImageIcon;
import javax.swing.JTextField;

public class Employee extends javax.swing.JPanel {
	
	private String name;
	private String address;
	private String tel;
	private String birthday;
	private String position;
	private String department;
	private String note;
	private String gender;
	private String name_Org;
	private String tel_Org;
	private Connection con;
	private PreparedStatement pstmt = null;
	private ResultSet rs = null;
	
	public Employee(Connection con) {
		this.con = con;
		initComponents();
		getDepartments();
		cbDepartment.setModel(new DefaultComboBoxModel(getDepartments()));
	}
	
	

	private void initComponents() {
		bgGender = new javax.swing.ButtonGroup();
        jPanel1 = new javax.swing.JPanel(){
    		ImageIcon newIcon;
    		public void paintComponent(Graphics g){
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
    	};
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        txtTel = new javax.swing.JTextField();
        txtName = new javax.swing.JTextField();
        txtAddress = new javax.swing.JTextField();
        rbMale = new javax.swing.JRadioButton();
        rbFemale = new javax.swing.JRadioButton();
        jLabel6 = new javax.swing.JLabel();
        dateBirthday = new com.toedter.calendar.JDateChooser();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        cbPosition = new javax.swing.JComboBox<>();
        cbDepartment = new javax.swing.JComboBox<>();
        jScrollPane1 = new javax.swing.JScrollPane();
        txtNote = new javax.swing.JEditorPane();
        lbEmployeeNum = new javax.swing.JLabel();

        setMaximumSize(new java.awt.Dimension(980, 470));
        setMinimumSize(new java.awt.Dimension(980, 470));
        setPreferredSize(new java.awt.Dimension(980, 470));

        jPanel1.setMaximumSize(new java.awt.Dimension(980, 470));
        jPanel1.setMinimumSize(new java.awt.Dimension(980, 470));
        jPanel1.setPreferredSize(new java.awt.Dimension(980, 470));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setFont(new java.awt.Font("微軟正黑體", 0, 15)); // NOI18N
        jLabel1.setText("員工編號");
        jPanel1.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(59, 66, -1, -1));

        jLabel2.setFont(new java.awt.Font("微軟正黑體", 0, 15)); // NOI18N
        jLabel2.setText("姓名");
        jPanel1.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(59, 108, -1, -1));

        jLabel3.setFont(new java.awt.Font("微軟正黑體", 0, 15)); // NOI18N
        jLabel3.setText("住址");
        jPanel1.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(59, 153, -1, -1));

        jLabel4.setFont(new java.awt.Font("微軟正黑體", 0, 15)); // NOI18N
        jLabel4.setText("電話");
        jPanel1.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(59, 218, -1, -1));

        jLabel5.setFont(new java.awt.Font("微軟正黑體", 0, 15)); // NOI18N
        jLabel5.setText("性別");
        jPanel1.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(59, 277, -1, -1));

        txtTel.setFont(new java.awt.Font("微軟正黑體", 0, 15)); // NOI18N
        jPanel1.add(txtTel, new org.netbeans.lib.awtextra.AbsoluteConstraints(149, 212, 225, -1));

        txtName.setFont(new java.awt.Font("微軟正黑體", 0, 15)); // NOI18N
        jPanel1.add(txtName, new org.netbeans.lib.awtextra.AbsoluteConstraints(149, 105, 225, -1));

        txtAddress.setFont(new java.awt.Font("微軟正黑體", 0, 15)); // NOI18N
        jPanel1.add(txtAddress, new org.netbeans.lib.awtextra.AbsoluteConstraints(149, 150, 225, -1));

        bgGender.add(rbMale);
        rbMale.setFont(new java.awt.Font("微軟正黑體", 0, 15)); // NOI18N
        rbMale.setText("男");
        jPanel1.add(rbMale, new org.netbeans.lib.awtextra.AbsoluteConstraints(149, 273, -1, -1));

        bgGender.add(rbFemale);
        rbFemale.setFont(new java.awt.Font("微軟正黑體", 0, 15)); // NOI18N
        rbFemale.setText("女");
        jPanel1.add(rbFemale, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 273, -1, -1));

        jLabel6.setFont(new java.awt.Font("微軟正黑體", 0, 15)); // NOI18N
        jLabel6.setText("出生年月日");
        jPanel1.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(522, 62, -1, -1));

        dateBirthday.setFont(new java.awt.Font("微軟正黑體", 0, 15)); // NOI18N
        jPanel1.add(dateBirthday, new org.netbeans.lib.awtextra.AbsoluteConstraints(615, 62, 274, -1));

        jLabel7.setFont(new java.awt.Font("微軟正黑體", 0, 18)); // NOI18N
        jPanel1.add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(501, 150, -1, -1));

        jLabel8.setFont(new java.awt.Font("微軟正黑體", 0, 15)); // NOI18N
        jLabel8.setText("部門");
        jPanel1.add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(567, 108, -1, -1));

        jLabel9.setFont(new java.awt.Font("微軟正黑體", 0, 15)); // NOI18N
        jLabel9.setText("職等");
        jPanel1.add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(567, 153, -1, -1));

        jLabel10.setFont(new java.awt.Font("微軟正黑體", 0, 15)); // NOI18N
        jLabel10.setText("備註");
        jPanel1.add(jLabel10, new org.netbeans.lib.awtextra.AbsoluteConstraints(567, 215, -1, -1));

        cbPosition.setFont(new java.awt.Font("微軟正黑體", 0, 15)); // NOI18N
        jPanel1.add(cbPosition, new org.netbeans.lib.awtextra.AbsoluteConstraints(615, 150, 274, -1));

        cbDepartment.setFont(new java.awt.Font("微軟正黑體", 0, 15)); // NOI18N
        cbDepartment.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "　　", " " }));
        cbDepartment.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbDepartmentActionPerformed(evt);
            }
        });
        jPanel1.add(cbDepartment, new org.netbeans.lib.awtextra.AbsoluteConstraints(615, 105, 274, -1));

        txtNote.setFont(new java.awt.Font("微軟正黑體", 0, 14)); // NOI18N
        jScrollPane1.setViewportView(txtNote);

        jPanel1.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(615, 212, 274, 90));

        lbEmployeeNum.setFont(new java.awt.Font("微軟正黑體", 0, 15)); // NOI18N
        jPanel1.add(lbEmployeeNum, new org.netbeans.lib.awtextra.AbsoluteConstraints(149, 62, 225, 25));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
	}// </editor-fold>
	
	private String[] getDepartments(){
		LinkedList<String> data = new LinkedList<>();
		data.add("");
		String[] departments = null;
		try{
			pstmt = con.prepareStatement("SELECT DISTINCT department FROM department");
			rs = pstmt.executeQuery();
			while(rs.next()){
				String department = rs.getString(1);
				data.add(department);
			}
			departments = data.toArray(new String[data.size()]);
			
		}
		catch(SQLException ee){
			System.out.println(ee.toString());}
		return departments;
	}
	
	private String[] getPositions(){
		LinkedList<String> data = new LinkedList<>();
		data.add("");
		String[] positions = null;
		try{
			pstmt = con.prepareStatement("SELECT jobTitle FROM department WHERE department = ?");
			pstmt.setString(1, cbDepartment.getSelectedItem().toString());
			rs = pstmt.executeQuery();
			while(rs.next()){
				String position = rs.getString(1);
				data.add(position);
			}
			positions = data.toArray(new String[data.size()]);
			
		}
		catch(SQLException ee){
			System.out.println(ee.toString());
			}
		
		return positions;
	}
	
	private boolean isDuplicatedData(){
		try{
			pstmt = con.prepareStatement("SELECT name,tel FROM employee WHERE name = ? AND tel = ?");
			pstmt.setString(1, name);
			pstmt.setString(2,tel);	
			rs = pstmt.executeQuery();
			if (rs.next()) {
				return true;
			}
		}
		catch(SQLException ee){
			System.out.println(ee.toString());
		}
		return false;
	}
	
	private boolean checkUpdateData(){
		if(!name.equals(name_Org)||!tel.equals(tel_Org)){
			try{
				pstmt = con.prepareStatement("SELECT name,tel FROM employee WHERE name = ? AND tel = ?");
				pstmt.setString(1, name);
				pstmt.setString(2,tel);	
				rs = pstmt.executeQuery();
				if (rs.next()) {
					return false;
				}
				else{
					return true;
				}
			}
			catch(SQLException ee){
				System.out.println(ee.toString());
			}
		}
		return true;
	}
	
	private boolean getUserInputParm() {
		boolean isRightData = false;

		name = txtName.getText();
		address = txtAddress.getText();
		tel = txtTel.getText();
		birthday = ((JTextField) dateBirthday.getDateEditor().getUiComponent()).getText();
		position = cbPosition.getSelectedItem().toString();
		department = cbDepartment.getSelectedItem().toString();
		note = txtNote.getText();
		if (rbMale.isSelected()) {
			gender = "男";
		} else if (rbFemale.isSelected()) {
			gender = "女";
		}
		if (name.equals("") || address.equals("") || tel.equals("") || birthday.equals("") || position.equals("")
				|| department.equals("")) {
			isRightData = false;
		} else {
			isRightData = true;
		}
		return isRightData;
	}
	
	protected int insertData() {	
		int isInsert = 0;
		if (getUserInputParm() == true && isDuplicatedData() == false) {
			try {
				pstmt = con.prepareStatement(
						"INSERT INTO employee(name,address,gender,birthday,position,department,tel,note) VALUES(?,?,?,?,?,?,?,?)");
				pstmt.setString(1, name);
				pstmt.setString(2, address);
				pstmt.setString(3, gender);
				pstmt.setString(4, birthday);
				pstmt.setString(5, position);
				pstmt.setString(6, department);
				pstmt.setString(7, tel);
				pstmt.setString(8, note);
				isInsert = pstmt.executeUpdate();

			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		clearInput();
		return isInsert;
	}

	protected int updateData() {
		String strEmployeeNum = lbEmployeeNum.getText();
		int isUpdate = 0;
		if (getUserInputParm() == true && checkUpdateData() == true) {
			try {
				pstmt = con.prepareStatement(
						"UPDATE employee SET name=?,address=?,gender=?,birthday=?,position=?,department=?,tel=?,note=? WHERE employeeNum=?" );
				pstmt.setString(1, name);
				pstmt.setString(2, address);
				pstmt.setString(3, gender);
				pstmt.setString(4, birthday);
				pstmt.setString(5, position);
				pstmt.setString(6, department);
				pstmt.setString(7, tel);
				pstmt.setString(8, note);
				pstmt.setString(9, strEmployeeNum);
				isUpdate = pstmt.executeUpdate();
			} catch (SQLException ee) {
				System.out.println(ee.toString());
			}
		}
		clearInput();
		strEmployeeNum = "";
		return isUpdate;
	}
	
	protected int delData(){
		int isDel = 0;
		if(!lbEmployeeNum.getText().equals("")){
			try{
				pstmt = con.prepareStatement("DELETE FROM employee WHERE employeeNum = ?");
				pstmt.setString(1, lbEmployeeNum.getText());
				isDel = pstmt.executeUpdate();
			}
			catch(SQLException ee){
				System.out.println(ee.toString());
			}
		}
		clearInput();
		return isDel;
	}
	
	protected void clearInput(){
		lbEmployeeNum.setText("");
		txtName.setText("");
		txtAddress.setText("");
		txtTel.setText("");
		bgGender.clearSelection();
		if(cbPosition.getItemCount() > 0){
			cbPosition.setSelectedIndex(0);
		}
		if(cbDepartment.getItemCount() > 0){
			cbDepartment.setSelectedIndex(0);
		}
		txtNote.setText("");
		dateBirthday.setCalendar(null);
	}
	
	protected LinkedList<String[]> queryData() {
		LinkedList<String[]> data = new LinkedList<>();

		try {
			pstmt = con.prepareStatement("SELECT * FROM employee");
			rs = pstmt.executeQuery();
			while (rs.next()) {
				String[] row = new String[9];
				row[0] = rs.getString("employeeNum");
				row[1] = rs.getString("name");
				row[2] = rs.getString("address");
				row[3] = rs.getString("tel");
				row[4] = rs.getString("gender");
				row[5] = rs.getString("birthday");
				row[6] = rs.getString("position");
				row[7] = rs.getString("department");
				row[8] = rs.getString("note");
				data.add(row);
			}
		} catch (SQLException ee) {
			ee.toString();
		}
		return data;
	}
	
	protected LinkedList<String[]> search(String value){
		LinkedList<String[]> data = new LinkedList<>();
		try {
			pstmt = con.prepareStatement("SELECT * FROM employee WHERE employeeNum LIKE ? OR name LIKE? OR address LIKE ? OR tel LIKE ? or gender LIKE ? or birthday LIKE ? OR position LIKE ? OR department LIKE ? OR note LIKE ?");
			String query = "%" + value +"%";
			for(int i=1 ; i<10; i++){
				pstmt.setString(i, query);
			}
			rs = pstmt.executeQuery();
			while (rs.next()) {
				String[] row = new String[9];
				row[0] = rs.getString("employeeNum");
				row[1] = rs.getString("name");
				row[2] = rs.getString("address");
				row[3] = rs.getString("tel");
				row[4] = rs.getString("gender");
				row[5] = rs.getString("birthday");
				row[6] = rs.getString("position");
				row[7] = rs.getString("department");
				row[8] = rs.getString("note");
				data.add(row);
			}
		} catch (SQLException ee) {
			ee.toString();
		}
		return data;
	}
	
	protected void setInputValue(HashMap<Integer, String> data) {
		lbEmployeeNum.setText(data.get(0));
		txtName.setText(data.get(1));
		name_Org = data.get(1);
		txtAddress.setText(data.get(2));
		txtTel.setText(data.get(3));
		tel_Org = data.get(3);
		if (data.get(4).equals("男")) {
			rbMale.setSelected(true);
		} else {
			rbFemale.setSelected(true);
		}
		try {
			java.util.Date date = new SimpleDateFormat("yyyy/MM/dd").parse(data.get(5));
			dateBirthday.setDate(date);
		} catch (ParseException e) {
			
			e.printStackTrace();
		}
			
		for(int i=0; i<cbDepartment.getItemCount(); i++){
			if(data.get(7).equals(cbDepartment.getItemAt(i).toString())){
				cbDepartment.setSelectedIndex(i);
			}
		}
		cbPosition.setModel(new DefaultComboBoxModel(getPositions()));
		for(int i=0; i<cbPosition.getItemCount(); i++){
			if(data.get(6).equals(cbPosition.getItemAt(i).toString())){
				cbPosition.setSelectedIndex(i);
			}
		}
		txtNote.setText(data.get(8));
	}
	
	private void cbDepartmentActionPerformed(java.awt.event.ActionEvent evt) { 
		cbPosition.setModel(new DefaultComboBoxModel(getPositions()));
	    }   
	
	
	// Variables declaration - do not modify
	private javax.swing.ButtonGroup bgGender;
    private javax.swing.JComboBox<String> cbDepartment;
    private javax.swing.JComboBox<String> cbPosition;
    private com.toedter.calendar.JDateChooser dateBirthday;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel lbEmployeeNum;
    private javax.swing.JRadioButton rbFemale;
    private javax.swing.JRadioButton rbMale;
    private javax.swing.JTextField txtAddress;
    private javax.swing.JTextField txtName;
    private javax.swing.JEditorPane txtNote;
    private javax.swing.JTextField txtTel;
	// End of variables declaration
}
