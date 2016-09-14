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
 * @author fox70
 */
public class Attendance extends javax.swing.JPanel {
	private String employeeNum;
	private String onWork;
	private String offWork;
	private String leaveSheet;
	private String department;
	private String note;
	private String id;
	private Properties prop;
	private Connection con;
	private PreparedStatement pstmt = null;
	private ResultSet rs = null;

	public Attendance(Connection con) {
		initComponents();
		setDBProp();
		this.con = con;
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

	        jLabel1.setFont(new java.awt.Font("微軟正黑體", 0, 18)); // NOI18N
	        jLabel1.setText("員工編號");

	        txtEmployeeNum.setFont(new java.awt.Font("微軟正黑體", 0, 14)); // NOI18N
	        txtEmployeeNum.addKeyListener(new java.awt.event.KeyAdapter() {
	            public void keyReleased(java.awt.event.KeyEvent evt) {
	                txtEmployeeNumKeyReleased(evt);
	            }
	        });

	        jLabel2.setFont(new java.awt.Font("微軟正黑體", 0, 18)); // NOI18N
	        jLabel2.setText("上班時間");

	        jLabel3.setFont(new java.awt.Font("微軟正黑體", 0, 18)); // NOI18N
	        jLabel3.setText("下班時間");

	        jLabel4.setFont(new java.awt.Font("微軟正黑體", 0, 18)); // NOI18N
	        jLabel4.setText("假別");

	        jLabel7.setFont(new java.awt.Font("微軟正黑體", 0, 18)); // NOI18N

	        jLabel8.setFont(new java.awt.Font("微軟正黑體", 0, 18)); // NOI18N
	        jLabel8.setText("部門");

	        jLabel10.setFont(new java.awt.Font("微軟正黑體", 0, 18)); // NOI18N
	        jLabel10.setText("備註");

	        txtNote.setFont(new java.awt.Font("微軟正黑體", 0, 15)); // NOI18N
	        jScrollPane1.setViewportView(txtNote);

	        cbLeaveSheet.setFont(new java.awt.Font("微軟正黑體", 0, 15)); // NOI18N
	        cbLeaveSheet.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "無", "事假", "病假", "喪假", "生理假", "育嬰假" }));

	        txtOffWork.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.DateFormatter(new java.text.SimpleDateFormat("yyyy-MM-dd HH:mm:ss"))));
	        txtOffWork.setToolTipText("yyyy-MM-dd HH:mm:ss");
	        txtOffWork.setFont(new java.awt.Font("微軟正黑體", 0, 15)); // NOI18N

	        txtOnWork1.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.DateFormatter(new java.text.SimpleDateFormat("yyyy-MM-dd HH:mm:ss"))));
	        txtOnWork1.setToolTipText("yyyy-MM-dd HH:mm:ss");
	        txtOnWork1.setFont(new java.awt.Font("微軟正黑體", 0, 15)); // NOI18N

	        lbDepartment.setFont(new java.awt.Font("微軟正黑體", 0, 18)); // NOI18N

	        lbName.setFont(new java.awt.Font("微軟正黑體", 0, 15)); // NOI18N

	        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
	        this.setLayout(layout);
	        layout.setHorizontalGroup(
	            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
	            .addGroup(layout.createSequentialGroup()
	                .addGap(59, 59, 59)
	                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
	                    .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
	                    .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
	                    .addComponent(jLabel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
	                    .addComponent(jLabel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
	                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
	                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
	                    .addGroup(layout.createSequentialGroup()
	                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
	                            .addComponent(txtOnWork1, javax.swing.GroupLayout.PREFERRED_SIZE, 225, javax.swing.GroupLayout.PREFERRED_SIZE)
	                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
	                                .addComponent(txtOffWork, javax.swing.GroupLayout.DEFAULT_SIZE, 225, Short.MAX_VALUE)
	                                .addComponent(cbLeaveSheet, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
	                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
	                    .addGroup(layout.createSequentialGroup()
	                        .addGap(4, 4, 4)
	                        .addComponent(txtEmployeeNum, javax.swing.GroupLayout.PREFERRED_SIZE, 225, javax.swing.GroupLayout.PREFERRED_SIZE)
	                        .addGap(18, 18, Short.MAX_VALUE)
	                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
	                            .addComponent(lbName, javax.swing.GroupLayout.PREFERRED_SIZE, 89, javax.swing.GroupLayout.PREFERRED_SIZE)
	                            .addComponent(jLabel7))
	                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 98, Short.MAX_VALUE)
	                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
	                            .addComponent(jLabel10, javax.swing.GroupLayout.Alignment.TRAILING)
	                            .addComponent(jLabel8, javax.swing.GroupLayout.Alignment.TRAILING))
	                        .addGap(18, 18, 18)
	                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
	                            .addComponent(lbDepartment, javax.swing.GroupLayout.PREFERRED_SIZE, 302, javax.swing.GroupLayout.PREFERRED_SIZE)
	                            .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 317, javax.swing.GroupLayout.PREFERRED_SIZE))
	                        .addGap(58, 58, 58))))
	        );
	        layout.setVerticalGroup(
	            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
	            .addGroup(layout.createSequentialGroup()
	                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
	                    .addGroup(layout.createSequentialGroup()
	                        .addGap(62, 62, 62)
	                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
	                            .addComponent(jLabel1)
	                            .addComponent(txtEmployeeNum, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
	                            .addComponent(jLabel8)
	                            .addComponent(lbDepartment, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)))
	                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
	                        .addGap(60, 60, 60)
	                        .addComponent(lbName, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)))
	                .addGap(61, 61, 61)
	                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
	                    .addGroup(layout.createSequentialGroup()
	                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
	                            .addComponent(jLabel7)
	                            .addComponent(jLabel2)
	                            .addComponent(txtOnWork1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
	                            .addComponent(jLabel10))
	                        .addGap(51, 51, 51)
	                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
	                            .addComponent(jLabel3)
	                            .addComponent(txtOffWork, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
	                        .addGap(43, 43, 43)
	                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
	                            .addComponent(jLabel4)
	                            .addComponent(cbLeaveSheet, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
	                    .addComponent(jScrollPane1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 175, javax.swing.GroupLayout.PREFERRED_SIZE))
	                .addContainerGap(145, Short.MAX_VALUE))
	        );
	}// </editor-fold>

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
		if (getUserInputParm() == true) {
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
		
		if (getUserInputParm() == true) {
			
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
		txtOnWork1.setText(data.get(2));
		txtOffWork.setText(data.get(3));
		switch (data.get(4)) {
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
		default:
			cbLeaveSheet.setSelectedIndex(0);
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
			//JOptionPane.showMessageDialog(txtEmployeeNum, "無此帳號");
			//txtEmployeeNum.setText("");
			lbName.setText("查無此員工");
			lbDepartment.setText("");
		}

	}

	// Variables declaration - do not modify
	
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
	// End of variables declaration
}
