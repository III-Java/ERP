import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Properties;

import javax.swing.DefaultComboBoxModel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

public class Employee extends javax.swing.JPanel {
	private int employeeNum;
	private String name;
	private String address;
	private String tel;
	private String birthday;
	private String position;
	private String department;
	private String note;
	private String gender;
	private Properties prop;
	private Connection con;
	private PreparedStatement pstmt = null;
	private ResultSet rs = null;
	
	private void setDBProp() {

		prop = new Properties();
		prop.setProperty("user", "root");
		prop.setProperty("password", "");
		prop.setProperty("characterEncoding", "UTF-8");
		prop.setProperty("useUnicode", "true");
		prop.setProperty("useSSL", "False");
		try {
			con = DriverManager.getConnection("jdbc:mysql://localhost/erp", prop);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	public Employee(Connection con) {
		
		initComponents();
		setDBProp();
		getDepartments();
		cbDepartment.setModel(new DefaultComboBoxModel(getDepartments()));
		this.con = con;
	}
	
	

	private void initComponents() {

		 bgGender = new javax.swing.ButtonGroup();
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

	        setPreferredSize(new java.awt.Dimension(980, 470));

	        jLabel1.setFont(new java.awt.Font("微軟正黑體", 0, 15)); // NOI18N
	        jLabel1.setText("員工編號");

	        jLabel2.setFont(new java.awt.Font("微軟正黑體", 0, 15)); // NOI18N
	        jLabel2.setText("姓名");

	        jLabel3.setFont(new java.awt.Font("微軟正黑體", 0, 15)); // NOI18N
	        jLabel3.setText("住址");

	        jLabel4.setFont(new java.awt.Font("微軟正黑體", 0, 15)); // NOI18N
	        jLabel4.setText("電話");

	        jLabel5.setFont(new java.awt.Font("微軟正黑體", 0, 15)); // NOI18N
	        jLabel5.setText("性別");

	        txtTel.setFont(new java.awt.Font("微軟正黑體", 0, 15)); // NOI18N

	        txtName.setFont(new java.awt.Font("微軟正黑體", 0, 15)); // NOI18N

	        txtAddress.setFont(new java.awt.Font("微軟正黑體", 0, 15)); // NOI18N

	        bgGender.add(rbMale);
	        rbMale.setFont(new java.awt.Font("微軟正黑體", 0, 15)); // NOI18N
	        rbMale.setText("男");

	        bgGender.add(rbFemale);
	        rbFemale.setFont(new java.awt.Font("微軟正黑體", 0, 15)); // NOI18N
	        rbFemale.setText("女");

	        jLabel6.setFont(new java.awt.Font("微軟正黑體", 0, 15)); // NOI18N
	        jLabel6.setText("出生年月日");

	        dateBirthday.setFont(new java.awt.Font("微軟正黑體", 0, 15)); // NOI18N

	        jLabel7.setFont(new java.awt.Font("微軟正黑體", 0, 18)); // NOI18N

	        jLabel8.setFont(new java.awt.Font("微軟正黑體", 0, 15)); // NOI18N
	        jLabel8.setText("部門");

	        jLabel9.setFont(new java.awt.Font("微軟正黑體", 0, 15)); // NOI18N
	        jLabel9.setText("職等");

	        jLabel10.setFont(new java.awt.Font("微軟正黑體", 0, 15)); // NOI18N
	        jLabel10.setText("備註");

	        cbPosition.setFont(new java.awt.Font("微軟正黑體", 0, 15)); // NOI18N

	        cbDepartment.setFont(new java.awt.Font("微軟正黑體", 0, 15)); // NOI18N
	        cbDepartment.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "　　", " " }));
	        cbDepartment.addActionListener(new java.awt.event.ActionListener() {
	            public void actionPerformed(java.awt.event.ActionEvent evt) {
	                cbDepartmentActionPerformed(evt);
	            }
	        });

	        txtNote.setFont(new java.awt.Font("微軟正黑體", 0, 14)); // NOI18N
	        jScrollPane1.setViewportView(txtNote);

	        lbEmployeeNum.setFont(new java.awt.Font("微軟正黑體", 0, 15)); // NOI18N

	        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
	        this.setLayout(layout);
	        layout.setHorizontalGroup(
	            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
	            .addGroup(layout.createSequentialGroup()
	                .addGap(59, 59, 59)
	                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
	                    .addComponent(jLabel3)
	                    .addComponent(jLabel5)
	                    .addComponent(jLabel4)
	                    .addComponent(jLabel2)
	                    .addComponent(jLabel1))
	                .addGap(30, 30, 30)
	                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
	                    .addGroup(layout.createSequentialGroup()
	                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
	                            .addComponent(txtAddress, javax.swing.GroupLayout.DEFAULT_SIZE, 225, Short.MAX_VALUE)
	                            .addComponent(txtName)
	                            .addComponent(txtTel, javax.swing.GroupLayout.DEFAULT_SIZE, 225, Short.MAX_VALUE)
	                            .addComponent(lbEmployeeNum, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
	                        .addGap(127, 127, 127)
	                        .addComponent(jLabel7))
	                    .addGroup(layout.createSequentialGroup()
	                        .addComponent(rbMale)
	                        .addGap(18, 18, 18)
	                        .addComponent(rbFemale)))
	                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 21, Short.MAX_VALUE)
	                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
	                    .addComponent(jLabel9, javax.swing.GroupLayout.Alignment.TRAILING)
	                    .addComponent(jLabel6, javax.swing.GroupLayout.Alignment.TRAILING)
	                    .addComponent(jLabel10, javax.swing.GroupLayout.Alignment.TRAILING)
	                    .addComponent(jLabel8, javax.swing.GroupLayout.Alignment.TRAILING))
	                .addGap(18, 18, 18)
	                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
	                    .addComponent(dateBirthday, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
	                    .addComponent(cbPosition, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
	                    .addComponent(cbDepartment, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
	                    .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 274, Short.MAX_VALUE))
	                .addContainerGap(91, Short.MAX_VALUE))
	        );
	        layout.setVerticalGroup(
	            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
	            .addGroup(layout.createSequentialGroup()
	                .addGap(62, 62, 62)
	                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
	                    .addGroup(layout.createSequentialGroup()
	                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
	                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
	                                .addComponent(jLabel6)
	                                .addComponent(lbEmployeeNum, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE))
	                            .addComponent(jLabel1, javax.swing.GroupLayout.Alignment.TRAILING))
	                        .addGap(18, 18, 18)
	                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
	                            .addComponent(jLabel2)
	                            .addComponent(txtName, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
	                            .addComponent(jLabel8)
	                            .addComponent(cbDepartment, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
	                        .addGap(18, 18, 18)
	                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
	                            .addComponent(jLabel3)
	                            .addComponent(txtAddress, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
	                            .addComponent(jLabel7)
	                            .addComponent(jLabel9)
	                            .addComponent(cbPosition, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
	                    .addComponent(dateBirthday, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
	                .addGap(35, 35, 35)
	                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
	                    .addGroup(layout.createSequentialGroup()
	                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
	                            .addComponent(jLabel4)
	                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
	                                .addComponent(txtTel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
	                                .addComponent(jLabel10)))
	                        .addGap(34, 34, 34)
	                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
	                            .addComponent(jLabel5)
	                            .addComponent(rbMale)
	                            .addComponent(rbFemale)))
	                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE))
	                .addContainerGap(168, Short.MAX_VALUE))
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
		if (getUserInputParm() == true) {
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
		if (getUserInputParm() == true) {
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
		cbPosition.setSelectedIndex(0);
		cbDepartment.setSelectedIndex(0);
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
	
	protected  LinkedList<String[]> search(String value){
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
		txtAddress.setText(data.get(2));
		txtTel.setText(data.get(3));
		if (data.get(4).equals("男")) {
			rbMale.setSelected(true);
		} else {
			rbFemale.setSelected(true);
		}
		try {
			java.util.Date date = new SimpleDateFormat("yyyy-MM-dd").parse(data.get(5));
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
