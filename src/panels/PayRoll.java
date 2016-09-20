package panels;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.LinkedList;

public class PayRoll extends javax.swing.JPanel {

	private Connection con;
	private PreparedStatement pstmt = null;
	private ResultSet rs = null;
	private String employeeNum;
	private String payRoll;
	private String note;

	public PayRoll(Connection con) {
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
	        txtPay = new javax.swing.JFormattedTextField();
	        txtEmpoyeeNum = new javax.swing.JFormattedTextField();
	        lbName = new javax.swing.JLabel();

	        setPreferredSize(new java.awt.Dimension(980, 470));
	        setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

	        jLabel1.setFont(new java.awt.Font("微軟正黑體", 0, 15)); // NOI18N
	        jLabel1.setText("員工編號");
	        add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(59, 62, -1, -1));

	        jLabel2.setFont(new java.awt.Font("微軟正黑體", 0, 15)); // NOI18N
	        jLabel2.setText("薪資");
	        add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(59, 247, 60, 30));

	        jLabel7.setFont(new java.awt.Font("微軟正黑體", 0, 18)); // NOI18N
	        add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(495, 160, -1, -1));

	        jLabel10.setFont(new java.awt.Font("微軟正黑體", 0, 15)); // NOI18N
	        jLabel10.setText("備註");
	        add(jLabel10, new org.netbeans.lib.awtextra.AbsoluteConstraints(570, 67, -1, -1));

	        txtNote.setFont(new java.awt.Font("微軟正黑體", 0, 14)); // NOI18N
	        jScrollPane1.setViewportView(txtNote);

	        add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(618, 62, 254, 216));

	        txtPay.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.NumberFormatter(new java.text.DecimalFormat("#,##0"))));
	        txtPay.setFont(new java.awt.Font("微軟正黑體", 0, 15)); // NOI18N
	        add(txtPay, new org.netbeans.lib.awtextra.AbsoluteConstraints(147, 248, 225, 30));

	        txtEmpoyeeNum.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.NumberFormatter(new java.text.DecimalFormat("#0"))));
	        txtEmpoyeeNum.setToolTipText("");
	        txtEmpoyeeNum.setFont(new java.awt.Font("微軟正黑體", 0, 15)); // NOI18N
	        txtEmpoyeeNum.addKeyListener(new java.awt.event.KeyAdapter() {
	            public void keyReleased(java.awt.event.KeyEvent evt) {
	                txtEmpoyeeNumKeyReleased(evt);
	            }
	        });
	        add(txtEmpoyeeNum, new org.netbeans.lib.awtextra.AbsoluteConstraints(147, 62, 225, 31));

	        lbName.setFont(new java.awt.Font("微軟正黑體", 0, 15)); // NOI18N
	        add(lbName, new org.netbeans.lib.awtextra.AbsoluteConstraints(147, 106, 225, 29));
	}// </editor-fold>

	private void setName() {
		String name = "";
		try {
			pstmt = con.prepareStatement("SELECT name FROM employee Where employeeNum = ?");
			pstmt.setString(1, txtEmpoyeeNum.getText());
			rs = pstmt.executeQuery();
			while (rs.next()) {
				name = rs.getString("name");
			}
			lbName.setText(name);
		} catch (SQLException ee) {
			System.out.println(ee.toString());
		}

	}
	
	protected void setInputValue(HashMap<Integer, String> data) {
		txtEmpoyeeNum.setText(data.get(0));
		txtPay.setText(data.get(1));
		txtNote.setText(data.get(2));
		setName();
	}

	private boolean getUserInputParm() {
		boolean isRightData = false;
		employeeNum = txtEmpoyeeNum.getText();
		payRoll = txtPay.getText();
		note = txtNote.getText();
		if (employeeNum.equals("") || payRoll.equals("")||lbName.getText().equals("查無此員工")) {
			isRightData = false;
		} else {
			isRightData = true;
		}
		return isRightData;
	}

	protected void clearInput() {
		txtEmpoyeeNum.setText("");
		txtPay.setText("");
		txtNote.setText("");
		lbName.setText("");
	}

	protected int insertData() {
		int isInsert = 0;
		if (getUserInputParm() == true) {
			try {
				pstmt = con.prepareStatement("INSERT INTO payroll(employeeNum,pay,note)VALUES(?,?,?)");
				pstmt.setString(1, employeeNum);
				pstmt.setString(2, payRoll);
				pstmt.setString(3, note);
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
		if (getUserInputParm() == true) {
			try {
				pstmt = con.prepareStatement("UPDATE payroll SET pay=?,note=? WHERE employeeNum = ?");
				pstmt.setString(1, payRoll);
				pstmt.setString(2, note);
				pstmt.setString(3, employeeNum);
				isUpdate = pstmt.executeUpdate();
			} catch (SQLException ee) {
				System.out.println(ee.toString());
			}
		}
		employeeNum = "";
		clearInput();
		return isUpdate;
	}

	protected int delData() {
		int isDel = 0;
		employeeNum = txtEmpoyeeNum.getText();
		if (!employeeNum.equals("")) {
			try {
				pstmt = con.prepareStatement("DELETE FROM payroll WHERE employeeNum=?");
				pstmt.setString(1, employeeNum);
				isDel = pstmt.executeUpdate();
			} catch (SQLException ee) {
				System.out.println(ee.toString());
			}
		}
		clearInput();
		return isDel;
	}

	protected LinkedList<String[]> queryData() {
		LinkedList<String[]> data = new LinkedList<>();
		try {
			pstmt = con.prepareStatement("SELECT * FROM payRoll");
			rs = pstmt.executeQuery();
			while (rs.next()) {
				String[] row = new String[3];
				row[0] = rs.getString("employeeNum");
				row[1] = rs.getString("pay");
				row[2] = rs.getString("note");
				data.add(row);
			}
		} catch (SQLException ee) {
			System.out.println(ee.toString());
		}
		return data;
	}

	protected LinkedList<String[]> search(String value) {
		LinkedList<String[]> data = new LinkedList<>();
		try {
			pstmt = con.prepareStatement("SELECT * FROM payroll WHERE employeeNum LIKE ? OR pay LIKE ? OR note LIKE ?");
			String query = "%" + value + "%";
			for (int i = 1; i < 4; i++) {
				pstmt.setString(i, query);
			}
			rs = pstmt.executeQuery();
			while (rs.next()) {
				String[] row = new String[3];
				row[0] = rs.getString("employeeNum");
				row[1] = rs.getString("pay");
				row[2] = rs.getString("note");
				data.add(row);
			}
		} catch (SQLException ee) {
			System.out.println(ee.toString());
		}
		return data;
	}

	private void txtEmpoyeeNumKeyReleased(java.awt.event.KeyEvent evt) {
		String employeeNum = "";
		try {
			pstmt = con.prepareStatement("SELECT employeeNum FROM employee Where employeeNum = ?");
			pstmt.setString(1, txtEmpoyeeNum.getText());
			rs = pstmt.executeQuery();
			while (rs.next()) {
				employeeNum = rs.getString("employeeNum");
			}
			setName();
		} catch (SQLException ee) {
			System.out.println(ee.toString());
		}
		if (employeeNum.equals("")) {
			lbName.setText("查無此員工");
		}
	}

	private javax.swing.JLabel jLabel1;
	private javax.swing.JLabel jLabel10;
	private javax.swing.JLabel jLabel2;
	private javax.swing.JLabel jLabel7;
	private javax.swing.JScrollPane jScrollPane1;
	private javax.swing.JLabel lbName;
	private javax.swing.JFormattedTextField txtEmpoyeeNum;
	private javax.swing.JEditorPane txtNote;
	private javax.swing.JFormattedTextField txtPay;
}
