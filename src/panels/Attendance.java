package panels;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.LinkedList;

public class Attendance extends javax.swing.JPanel {
	private String employeeNum;
	private String onWork;
	private String offWork;
	private String leaveSheet;
	private String department;
	private String note;
	private String id;
	private Connection con;
	private PreparedStatement pstmt = null;
	private ResultSet rs = null;
	private String employeeNum_Org;
	private String onWork_Org;

	public Attendance(Connection con) {
		this.con = con;
		initComponents();
	}

	@SuppressWarnings("unchecked")
	// <editor-fold defaultstate="collapsed" desc="Generated Code">
	private void initComponents() {

		  jLabel1 = new javax.swing.JLabel();
	        txtEmployeeNum = new javax.swing.JTextField();
	        jLabel2 = new javax.swing.JLabel();
	        jLabel3 = new javax.swing.JLabel();
	        jLabel4 = new javax.swing.JLabel();
	        jLabel7 = new javax.swing.JLabel();
	        jLabel8 = new javax.swing.JLabel();
	        jLabel10 = new javax.swing.JLabel();
	        jScrollPane1 = new javax.swing.JScrollPane();
	        txtNote = new javax.swing.JEditorPane();
	        cbLeaveSheet = new javax.swing.JComboBox<>();
	        txtOffWork = new javax.swing.JFormattedTextField();
	        txtOnWork1 = new javax.swing.JFormattedTextField();
	        lbDepartment = new javax.swing.JLabel();
	        lbName = new javax.swing.JLabel();

	        setPreferredSize(new java.awt.Dimension(980, 470));
	        setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

	        jLabel1.setFont(new java.awt.Font("微軟正黑體", 0, 18)); // NOI18N
	        jLabel1.setText("員工編號");
	        add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(59, 62, -1, -1));

	        txtEmployeeNum.setFont(new java.awt.Font("微軟正黑體", 0, 14)); // NOI18N
	        txtEmployeeNum.addKeyListener(new java.awt.event.KeyAdapter() {
	            public void keyReleased(java.awt.event.KeyEvent evt) {
	                txtEmployeeNumKeyReleased(evt);
	            }
	        });
	        add(txtEmployeeNum, new org.netbeans.lib.awtextra.AbsoluteConstraints(149, 63, 225, -1));

	        jLabel2.setFont(new java.awt.Font("微軟正黑體", 0, 18)); // NOI18N
	        jLabel2.setText("上班時間");
	        add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(59, 150, -1, -1));

	        jLabel3.setFont(new java.awt.Font("微軟正黑體", 0, 18)); // NOI18N
	        jLabel3.setText("下班時間");
	        add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(59, 230, -1, -1));

	        jLabel4.setFont(new java.awt.Font("微軟正黑體", 0, 18)); // NOI18N
	        jLabel4.setText("假別");
	        add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(59, 298, 72, -1));

	        jLabel7.setFont(new java.awt.Font("微軟正黑體", 0, 18)); // NOI18N
	        add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(481, 150, -1, -1));

	        jLabel8.setFont(new java.awt.Font("微軟正黑體", 0, 18)); // NOI18N
	        jLabel8.setText("部門");
	        add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(551, 62, -1, -1));

	        jLabel10.setFont(new java.awt.Font("微軟正黑體", 0, 18)); // NOI18N
	        jLabel10.setText("備註");
	        add(jLabel10, new org.netbeans.lib.awtextra.AbsoluteConstraints(551, 150, -1, -1));

	        txtNote.setFont(new java.awt.Font("微軟正黑體", 0, 15)); // NOI18N
	        jScrollPane1.setViewportView(txtNote);

	        add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(605, 150, 317, 175));

	        cbLeaveSheet.setFont(new java.awt.Font("微軟正黑體", 0, 15)); // NOI18N
	        cbLeaveSheet.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "無", "事假", "病假", "喪假", "生理假", "育嬰假" }));
	        add(cbLeaveSheet, new org.netbeans.lib.awtextra.AbsoluteConstraints(145, 298, 225, -1));

	        txtOffWork.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.DateFormatter(new java.text.SimpleDateFormat("yyyy/MM/dd HH:mm:ss"))));
	        txtOffWork.setToolTipText("yyyy/MM/dd HH:mm:ss");
	        txtOffWork.setFont(new java.awt.Font("微軟正黑體", 0, 15)); // NOI18N
	        add(txtOffWork, new org.netbeans.lib.awtextra.AbsoluteConstraints(145, 228, 225, -1));

	        txtOnWork1.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.DateFormatter(new java.text.SimpleDateFormat("yyyy/MM/dd HH:mm:ss"))));
	        txtOnWork1.setToolTipText("yyyy/MM/dd HH:mm:ss");
	        txtOnWork1.setFont(new java.awt.Font("微軟正黑體", 0, 15)); // NOI18N
	        add(txtOnWork1, new org.netbeans.lib.awtextra.AbsoluteConstraints(145, 150, 225, -1));

	        lbDepartment.setFont(new java.awt.Font("微軟正黑體", 0, 18)); // NOI18N
	        add(lbDepartment, new org.netbeans.lib.awtextra.AbsoluteConstraints(605, 62, 302, 27));

	        lbName.setFont(new java.awt.Font("微軟正黑體", 0, 15)); // NOI18N
	        add(lbName, new org.netbeans.lib.awtextra.AbsoluteConstraints(392, 60, 89, 29));
	}// </editor-fold>

	private void setName() {
		String name = "";
		try {
			pstmt = con.prepareStatement("SELECT name FROM employee Where employeeNum = ?");
			pstmt.setString(1, txtEmployeeNum.getText());
			rs = pstmt.executeQuery();
			while (rs.next()) {
				name = rs.getString("name");
			}
			lbName.setText(name);
		} catch (SQLException ee) {
			System.out.println(ee.toString());
		}

	}

	private boolean getUserInputParm() {
		boolean isRightData = false;
		employeeNum = txtEmployeeNum.getText();
		onWork = txtOnWork1.getText();
		offWork = txtOffWork.getText();
		leaveSheet = cbLeaveSheet.getSelectedItem().toString();
		note = txtNote.getText();
		department = lbDepartment.getText();
		if (employeeNum.equals("") || onWork.equals("")||lbName.getText().equals("查無此員工")) {
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
						"INSERT INTO attendance(employeeNum,work,leaveSheet,department,note)VALUES(?,?,?,?,?)");
				pstmt.setString(1, employeeNum);
				pstmt.setString(2, onWork);
				pstmt.setString(3, leaveSheet);
				pstmt.setString(4, lbDepartment.getText());
				pstmt.setString(5, txtNote.getText());
				isInsert = pstmt.executeUpdate();

			} catch (SQLException e) {
				System.out.println(e.toString());
			}
		}
		clearInput();
		return isInsert;
	}

	protected LinkedList<String[]> queryData() {
		LinkedList<String[]> data = new LinkedList<>();
		try {
			pstmt = con.prepareStatement("SELECT * FROM attendance");
			rs = pstmt.executeQuery();
			while (rs.next()) {
				String[] row = new String[7];
				row[0] = rs.getString("id");
				row[1] = rs.getString("employeeNum");
				row[2] = rs.getString("work");
				row[3] = rs.getString("offWork");
				row[4] = rs.getString("leaveSheet");
				row[5] = rs.getString("department");
				row[6] = rs.getString("note");
				data.add(row);
			}

		} catch (SQLException ee) {
			System.out.println(ee.toString());
		}
		return data;
	}

	protected int updateData() {
		int isUpdate = 0;
		if (getUserInputParm() == true && checkUpdateData() == true) {
			try {
				if (offWork.equals("")) {	
					pstmt = con.prepareStatement(
							"UPDATE attendance SET employeeNum = ?, work = ?, leaveSheet = ?, department = ?, note = ? WHERE id = ?");
					pstmt.setString(1, employeeNum);
					pstmt.setString(2, onWork);
					pstmt.setString(3, leaveSheet);
					pstmt.setString(4, department);
					pstmt.setString(5, note);
					pstmt.setString(6, id);	
				} else {
					pstmt = con.prepareStatement(
							"UPDATE attendance SET employeeNum = ?, work = ?,offWork = ?, leaveSheet = ?, department = ?, note = ? WHERE id = ?");
					pstmt.setString(1, employeeNum);
					pstmt.setString(2, onWork);
					pstmt.setString(3, offWork);
					pstmt.setString(4, leaveSheet);
					pstmt.setString(5, department);
					pstmt.setString(6, note);
					pstmt.setString(7, id);
					
				}
				isUpdate = pstmt.executeUpdate();
			} catch (SQLException ee) {
				System.out.println(ee.toString());
			}
		}
		id = "";
		clearInput();
		return isUpdate;
	}

	protected int delData() {
		int isDel = 0;
		if (!lbDepartment.getText().equals("")) {
			try {
				pstmt = con.prepareStatement("DELETE FROM attendance WHERE id =?");
				pstmt.setString(1, id);
				isDel = pstmt.executeUpdate();
			} catch (SQLException ee) {
				System.out.println(ee.toString());
			}
		}
		clearInput();
		return isDel;
	}

	protected void setInputValue(HashMap<Integer, String> data) {
		id = data.get(0);
		txtEmployeeNum.setText(data.get(1));
		employeeNum_Org = data.get(1);
		txtOnWork1.setText(data.get(2));
		onWork_Org = data.get(2);
		txtOffWork.setText(data.get(3));
		switch (data.get(4)) {
		case "無":
			cbLeaveSheet.setSelectedIndex(0);
			break;
		case "事假":
			cbLeaveSheet.setSelectedIndex(1);
			break;
		case "病假":
			cbLeaveSheet.setSelectedIndex(2);
			break;
		case "喪假":
			cbLeaveSheet.setSelectedIndex(3);
			break;
		case "生理假":
			cbLeaveSheet.setSelectedIndex(4);
			break;
		case "育嬰假":
			cbLeaveSheet.setSelectedIndex(5);
			break;
		}
		lbDepartment.setText(data.get(5));
		txtNote.setText(data.get(6));
		setName();
	}

	protected void clearInput() {
		txtEmployeeNum.setText("");
		txtOnWork1.setText("");
		txtOffWork.setText("");
		cbLeaveSheet.setSelectedIndex(0);
		lbDepartment.setText("");
		txtNote.setText("");
		lbName.setText("");
	}

	protected LinkedList<String[]> search(String value) {
		LinkedList<String[]> data = new LinkedList<>();
		try {
			pstmt = con.prepareStatement(
					"SELECT * FROM attendance WHERE id LIKE ? OR employeeNum LIKE ? OR work LIKE ? OR offWork LIKE ? OR leaveSheet LIKE ? OR department LIKE ? OR note LIKE ?");
			String query = "%" + value + "%";
			for (int i = 1; i < 8; i++) {
				pstmt.setString(i, query);
			}
			rs = pstmt.executeQuery();
			while (rs.next()) {
				String[] row = new String[7];
				row[0] = rs.getString("id");
				row[1] = rs.getString("employeeNum");
				row[2] = rs.getString("work");
				row[3] = rs.getString("offWork");
				row[4] = rs.getString("leaveSheet");
				row[5] = rs.getString("department");
				row[6] = rs.getString("note");
				data.add(row);
			}
		} catch (SQLException ee) {
			System.out.println(ee.toString());
		}
		return data;
	}

	private void txtEmployeeNumKeyReleased(java.awt.event.KeyEvent evt) {
		String department = "";
		try {
			pstmt = con.prepareStatement("SELECT department,name FROM employee Where employeeNum = ?");
			pstmt.setString(1, txtEmployeeNum.getText());
			rs = pstmt.executeQuery();
			while (rs.next()) {
				department = rs.getString("department");
				lbDepartment.setText(department);
			}
			setName();
		} catch (SQLException ee) {
			System.out.println(ee.toString());
		}
		if (department.equals("")) {
			lbName.setText("查無此員工");
			lbDepartment.setText("");
		}

	}

	private boolean isDuplicatedData(){
		String OnWorkDay = "%" + onWork.substring(0,10) + "%";
		try{
			pstmt = con.prepareStatement("SELECT work FROM attendance WHERE work LIKE ? AND employeeNum = ?");
			pstmt.setString(1, OnWorkDay);
			pstmt.setString(2,employeeNum);	
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
	//The modify item only accept onWork,not accept change employeeNum
	private boolean checkUpdateData(){
		if(!employeeNum.equals(employeeNum_Org)){
			return false;
		}
		else if(!onWork.substring(0,10).equals(onWork_Org.substring(0,10))){
			if(isDuplicatedData() == false){
				return true;
			}
			else{
				return false;
			}
		}
		return true;
	}
	
	private javax.swing.JComboBox<String> cbLeaveSheet;
	private javax.swing.JLabel jLabel1;
	private javax.swing.JLabel jLabel10;
	private javax.swing.JLabel jLabel2;
	private javax.swing.JLabel jLabel3;
	private javax.swing.JLabel jLabel4;
	private javax.swing.JLabel jLabel7;
	private javax.swing.JLabel jLabel8;
	private javax.swing.JScrollPane jScrollPane1;
	private javax.swing.JLabel lbDepartment;
	private javax.swing.JLabel lbName;
	private javax.swing.JTextField txtEmployeeNum;
	private javax.swing.JEditorPane txtNote;
	private javax.swing.JFormattedTextField txtOffWork;
	private javax.swing.JFormattedTextField txtOnWork1;
}
