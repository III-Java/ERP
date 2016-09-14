package panels;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.LinkedList;

public class Achievement extends javax.swing.JPanel {

	private Connection con;
	private PreparedStatement pstmt = null;
	private ResultSet rs = null;
	private String employeeNum;
	private String month;
	private String score;
	private String note;
	private String id;
	private String employeeNum_org;
	private String month_org;
	public Achievement(Connection con) {
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
        txtMonth = new javax.swing.JFormattedTextField();
        jLabel11 = new javax.swing.JLabel();
        cbScore = new javax.swing.JComboBox<>();
        txtEmployeeNum = new javax.swing.JFormattedTextField();
        lbName = new javax.swing.JLabel();

        setPreferredSize(new java.awt.Dimension(980, 470));

        jLabel1.setFont(new java.awt.Font("微軟正黑體", 0, 15)); // NOI18N
        jLabel1.setText("員工編號");

        jLabel2.setFont(new java.awt.Font("微軟正黑體", 0, 15)); // NOI18N
        jLabel2.setText("月份");

        jLabel7.setFont(new java.awt.Font("微軟正黑體", 0, 18)); // NOI18N

        jLabel10.setFont(new java.awt.Font("微軟正黑體", 0, 15)); // NOI18N
        jLabel10.setText("備註");

        txtNote.setFont(new java.awt.Font("微軟正黑體", 0, 14)); // NOI18N
        jScrollPane1.setViewportView(txtNote);

        txtMonth.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.DateFormatter(new java.text.SimpleDateFormat("yyyy/MM"))));
        txtMonth.setToolTipText("yyyy/MM");
        txtMonth.setFont(new java.awt.Font("微軟正黑體", 0, 15)); // NOI18N

        jLabel11.setFont(new java.awt.Font("微軟正黑體", 0, 15)); // NOI18N
        jLabel11.setText("考績");

        cbScore.setFont(new java.awt.Font("微軟正黑體", 0, 15)); // NOI18N
        cbScore.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "  ", "A", "B", "C", "D", "E" }));

        txtEmployeeNum.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.NumberFormatter(new java.text.DecimalFormat("#0"))));
        txtEmployeeNum.setFont(new java.awt.Font("微軟正黑體", 0, 15)); // NOI18N
        txtEmployeeNum.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtEmployeeNumKeyReleased(evt);
            }
        });

        lbName.setFont(new java.awt.Font("微軟正黑體", 0, 15)); // NOI18N

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(59, 59, 59)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(376, 376, 376)
                        .addComponent(jLabel7))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(28, 28, 28)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(txtMonth, javax.swing.GroupLayout.DEFAULT_SIZE, 225, Short.MAX_VALUE)
                            .addComponent(txtEmployeeNum, javax.swing.GroupLayout.DEFAULT_SIZE, 225, Short.MAX_VALUE)
                            .addComponent(lbName, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGap(78, 78, 78)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel10)
                            .addComponent(jLabel11))))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(cbScore, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 356, Short.MAX_VALUE))
                .addContainerGap(115, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(62, 62, 62)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(jLabel11)
                    .addComponent(cbScore, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtEmployeeNum, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addComponent(lbName, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 21, Short.MAX_VALUE)
                        .addComponent(jLabel7)
                        .addGap(26, 26, 26)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtMonth, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel10))
                        .addGap(251, 251, 251))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(106, 106, 106)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
        );
	}// </editor-fold>

	private boolean getUserInputParm() {
		boolean isRightData = false;
		employeeNum = txtEmployeeNum.getText();
		month = txtMonth.getText();
		score = cbScore.getSelectedItem().toString();
		note = txtNote.getText();
		if (employeeNum.equals("") || month.equals("") || score.equals("") || lbName.getText().equals("查無此員工")) {
			isRightData = false;
		}
		else {
			isRightData = true;
		}
		return isRightData;
	}

	protected void setInputValue(HashMap<Integer, String> data) {
		try {
			pstmt = con.prepareStatement("SELECT name FROM employee WHERE employeeNum = ?");
			pstmt.setString(1, data.get(1));
			rs = pstmt.executeQuery();
			String name = "";
			while (rs.next()) {
				name = rs.getString("name");
			}
			lbName.setText(name);
		} catch (SQLException ee) {
			ee.toString();
		}
		id = data.get(0);
		txtEmployeeNum.setText(data.get(1));
		employeeNum_org = data.get(1);
		txtMonth.setText(data.get(2));
		month_org = data.get(2);
		switch (data.get(3)) {
		case "A":
			cbScore.setSelectedIndex(1);
			break;
		case "B":
			cbScore.setSelectedIndex(2);
			break;
		case "C":
			cbScore.setSelectedIndex(3);
			break;
		case "D":
			cbScore.setSelectedIndex(4);
			break;
		case "E":
			cbScore.setSelectedIndex(5);
			break;
		default:
			cbScore.setSelectedIndex(0);
			break;
		}
		txtNote.setText(data.get(4));
	}

	protected void clearInput() {
		txtEmployeeNum.setText("");
		txtMonth.setText("");
		cbScore.setSelectedIndex(0);
		txtNote.setText("");
		lbName.setText("");
	}

	protected int insertData() {
		int isInsert = 0;
		if (getUserInputParm() == true && isDuplicatedData(employeeNum,month) == false) {
			try {
				pstmt = con.prepareStatement("INSERT INTO achievement(employeeNum,month,score,note)VALUES(?,?,?,?)");
				pstmt.setString(1, employeeNum);
				pstmt.setString(2, month);
				pstmt.setString(3, score);
				pstmt.setString(4, note);
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
			pstmt = con.prepareStatement("SELECT * FROM achievement");
			rs = pstmt.executeQuery();
			while (rs.next()) {
				String[] row = new String[5];
				row[0] = rs.getString("id");
				row[1] = rs.getString("employeeNum");
				row[2] = rs.getString("month");
				row[3] = rs.getString("score");
				row[4] = rs.getString("note");
				data.add(row);
			}

		} catch (SQLException ee) {
			System.out.println(ee.toString());
		}
		return data;
	}

	protected boolean isDuplicatedData(String employeeNum_chk,String month_chk) {
		try {
			pstmt = con
					.prepareStatement("SELECT employeeNum,month FROM achievement WHERE employeeNum = ? AND month = ?");
			pstmt.setString(1, employeeNum);
			pstmt.setString(2, month);
			rs = pstmt.executeQuery();
			while (rs.next()) {
				return true;
			}
		} catch (SQLException ee) {
			System.out.println(ee.toString());
		}
		return false;
	}
	
	private boolean checkUpdateData(){
		if(employeeNum.equals(employeeNum_org)&& month.equals(month_org)){
			return true;
		}
		else if(isDuplicatedData(employeeNum,month)== false) {
				return true;
			}
		return false;
	}
	
	protected int updateData() {
		int isUpdate = 0;
		if (getUserInputParm() == true && checkUpdateData() == true) {
			try {
				pstmt = con.prepareStatement(
						"UPDATE achievement SET employeeNum = ?, month = ?, score = ?, note=? WHERE id = ?");
				pstmt.setString(1, employeeNum);
				pstmt.setString(2, month);
				pstmt.setString(3, score);
				pstmt.setString(4, note);
				pstmt.setString(5, id);
				isUpdate = pstmt.executeUpdate();
			} catch (SQLException ee) {
				System.out.println(ee.toString());
			}
		}
		clearInput();
		id = "";
		return isUpdate;
	}

	protected int delData() {
		int isDel = 0;
		if (!id.equals("")) {
			try {
				pstmt = con.prepareStatement("DELETE FROM achievement WHERE id=?");
				pstmt.setString(1, id);
				isDel = pstmt.executeUpdate();
			} catch (SQLException ee) {
				System.out.println(ee.toString());
			}
		}
		clearInput();
		return isDel;
	}

	protected LinkedList<String[]> search(String value) {
		LinkedList<String[]> data = new LinkedList<>();
		try {
			pstmt = con.prepareStatement(
					"SELECT * FROM achievement WHERE employeeNum LIKE ? OR month LIKE ? OR score LIKE ? OR note LIKE ?");
			String query = "%" + value + "%";
			for (int i = 1; i < 5; i++) {
				pstmt.setString(i, query);
			}
			rs = pstmt.executeQuery();
			while (rs.next()) {
				String[] row = new String[5];
				row[0] = rs.getString("id");
				row[1] = rs.getString("employeeNum");
				row[2] = rs.getString("month");
				row[3] = rs.getString("score");
				row[4] = rs.getString("note");
				data.add(row);
			}
		} catch (SQLException ee) {
			System.out.println(ee.toString());
		}
		return data;
	}

	private void txtEmployeeNumKeyReleased(java.awt.event.KeyEvent evt) {
		String employeeNum = "";
		String name = "";
		try {
			pstmt = con.prepareStatement("SELECT employeeNum,name FROM employee Where employeeNum = ?");
			pstmt.setString(1, txtEmployeeNum.getText());
			rs = pstmt.executeQuery();
			while (rs.next()) {
				employeeNum = rs.getString("employeeNum");
				name = rs.getString("name");
			}
			lbName.setText(name);
		} catch (SQLException ee) {
			System.out.println(ee.toString());
		}
		if (employeeNum.equals("")) {
			lbName.setText("查無此員工");
		}
	}

	private javax.swing.JComboBox<String> cbScore;
	private javax.swing.JLabel jLabel1;
	private javax.swing.JLabel jLabel10;
	private javax.swing.JLabel jLabel11;
	private javax.swing.JLabel jLabel2;
	private javax.swing.JLabel jLabel7;
	private javax.swing.JScrollPane jScrollPane1;
	private javax.swing.JLabel lbName;
	private javax.swing.JFormattedTextField txtEmployeeNum;
	private javax.swing.JFormattedTextField txtMonth;
	private javax.swing.JEditorPane txtNote;
}
