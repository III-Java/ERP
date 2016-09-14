package panels;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.LinkedList;
import javax.swing.JOptionPane;
import javax.swing.GroupLayout.Alignment;
import javax.swing.GroupLayout;
import javax.swing.LayoutStyle.ComponentPlacement;
import java.awt.Font;

public class Member extends javax.swing.JPanel {
	private String customerId;
	private String password;
	private String memberName;
	private String tel;
	private String gender;
	private String address;
	private String note;
	private Connection con;
	private PreparedStatement pstmt = null;
	private ResultSet rs = null;

	
	public Member(Connection conn) {
		this.con = conn;
		initComponents();
	}

	@SuppressWarnings("unchecked")
	// <editor-fold defaultstate="collapsed" desc="Generated Code">
	private void initComponents() {

		label_customerId = new javax.swing.JLabel();
		label_password = new javax.swing.JLabel();
		label_memberName = new javax.swing.JLabel();
		label_tel = new javax.swing.JLabel();
		label_note = new javax.swing.JLabel();
		jScrollPane2 = new javax.swing.JScrollPane();
		text_customerId = new javax.swing.JTextField();
		text_password = new javax.swing.JTextField();
		text_memberName = new javax.swing.JTextField();
		text_tel = new javax.swing.JTextField();
		label_gender = new javax.swing.JLabel();
		text_gender = new javax.swing.JTextField();
		label_address = new javax.swing.JLabel();
		text_address = new javax.swing.JTextField();

		setPreferredSize(new java.awt.Dimension(980, 470));

		label_customerId.setFont(new Font("微軟正黑體", Font.PLAIN, 15)); // NOI18N
		label_customerId.setText("客戶編號");

		label_password.setFont(new Font("微軟正黑體", Font.PLAIN, 15)); // NOI18N
		label_password.setText("客戶密碼");

		label_memberName.setFont(new Font("微軟正黑體", Font.PLAIN, 15)); // NOI18N
		label_memberName.setText("客戶名稱");

		label_tel.setFont(new Font("微軟正黑體", Font.PLAIN, 15)); // NOI18N
		label_tel.setText("電話");

		label_note.setFont(new Font("微軟正黑體", Font.PLAIN, 14)); // NOI18N
		label_note.setText("備註");
		label_note.setToolTipText("");

		text_customerId.setFont(new java.awt.Font("微軟正黑體", 0, 14)); // NOI18N

		text_password.setFont(new java.awt.Font("微軟正黑體", 0, 14)); // NOI18N

		text_memberName.setFont(new java.awt.Font("微軟正黑體", 0, 14)); // NOI18N

		text_tel.setFont(new java.awt.Font("微軟正黑體", 0, 14));

		label_gender.setFont(new Font("微軟正黑體", Font.PLAIN, 15)); // NOI18N
		label_gender.setText("性別");

		text_gender.setFont(new java.awt.Font("微軟正黑體", 0, 14)); // NOI18N

		label_address.setFont(new Font("微軟正黑體", Font.PLAIN, 15)); // NOI18N
		label_address.setText("地址");

		text_address.setFont(new java.awt.Font("微軟正黑體", 0, 14)); // NOI18N
		text_note = new javax.swing.JTextArea();
		
				text_note.setColumns(20);
				text_note.setFont(new java.awt.Font("微軟正黑體", 0, 14)); // NOI18N
				text_note.setRows(5);

		javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
		layout.setHorizontalGroup(
			layout.createParallelGroup(Alignment.LEADING)
				.addGroup(layout.createSequentialGroup()
					.addGap(66)
					.addGroup(layout.createParallelGroup(Alignment.TRAILING)
						.addComponent(label_note)
						.addComponent(label_customerId)
						.addComponent(label_password)
						.addComponent(label_memberName))
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(layout.createParallelGroup(Alignment.LEADING)
						.addGroup(layout.createSequentialGroup()
							.addGroup(layout.createParallelGroup(Alignment.LEADING)
								.addComponent(text_memberName, Alignment.TRAILING)
								.addComponent(text_password)
								.addComponent(text_customerId, GroupLayout.DEFAULT_SIZE, 208, Short.MAX_VALUE))
							.addPreferredGap(ComponentPlacement.RELATED)
							.addGroup(layout.createParallelGroup(Alignment.LEADING)
								.addComponent(label_tel)
								.addComponent(label_gender)
								.addComponent(label_address))
							.addPreferredGap(ComponentPlacement.RELATED)
							.addGroup(layout.createParallelGroup(Alignment.LEADING)
								.addComponent(text_tel, GroupLayout.PREFERRED_SIZE, 150, GroupLayout.PREFERRED_SIZE)
								.addComponent(text_address, GroupLayout.PREFERRED_SIZE, 150, GroupLayout.PREFERRED_SIZE)
								.addComponent(text_gender, GroupLayout.PREFERRED_SIZE, 150, GroupLayout.PREFERRED_SIZE)))
						.addComponent(text_note, GroupLayout.DEFAULT_SIZE, 396, Short.MAX_VALUE))
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(jScrollPane2, GroupLayout.PREFERRED_SIZE, 400, GroupLayout.PREFERRED_SIZE)
					.addContainerGap(48, Short.MAX_VALUE))
		);
		layout.setVerticalGroup(
			layout.createParallelGroup(Alignment.LEADING)
				.addGroup(layout.createSequentialGroup()
					.addGap(53)
					.addGroup(layout.createParallelGroup(Alignment.LEADING)
						.addGroup(layout.createSequentialGroup()
							.addGroup(layout.createParallelGroup(Alignment.TRAILING)
								.addGroup(layout.createSequentialGroup()
									.addComponent(label_tel)
									.addGap(13))
								.addGroup(layout.createSequentialGroup()
									.addGroup(layout.createParallelGroup(Alignment.TRAILING)
										.addComponent(text_tel, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
										.addComponent(text_customerId, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
									.addPreferredGap(ComponentPlacement.RELATED)))
							.addGroup(layout.createParallelGroup(Alignment.BASELINE)
								.addComponent(label_gender)
								.addComponent(text_gender, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
								.addComponent(text_password, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
							.addPreferredGap(ComponentPlacement.RELATED)
							.addGroup(layout.createParallelGroup(Alignment.BASELINE)
								.addComponent(label_address)
								.addComponent(text_address, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
								.addComponent(text_memberName, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
								.addComponent(label_memberName)))
						.addGroup(layout.createSequentialGroup()
							.addComponent(label_customerId)
							.addGap(13)
							.addComponent(label_password)))
					.addGroup(layout.createParallelGroup(Alignment.LEADING)
						.addGroup(layout.createSequentialGroup()
							.addGap(64)
							.addGroup(layout.createParallelGroup(Alignment.LEADING)
								.addComponent(label_note)
								.addComponent(jScrollPane2, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)))
						.addGroup(layout.createSequentialGroup()
							.addPreferredGap(ComponentPlacement.UNRELATED)
							.addComponent(text_note, GroupLayout.PREFERRED_SIZE, 190, GroupLayout.PREFERRED_SIZE)))
					.addContainerGap(125, Short.MAX_VALUE))
		);
		this.setLayout(layout);
	}// </editor-fold>

	protected void setInputValue(HashMap<Integer, String> data) {
		text_customerId.setText(data.get(0));
		text_password.setText(data.get(1));
		text_memberName.setText((data.get(2)));
		text_tel.setText(data.get(3));
		text_gender.setText(data.get(4));
		text_address.setText(data.get(5));
		text_note.setText(data.get(6));
	}

	protected void clearInput() {
		text_customerId.setText("");
		text_password.setText("");
		text_memberName.setText("");
		text_tel.setText("");
		text_gender.setText("");
		text_address.setText("");
		text_note.setText("");
	}

	private boolean getUserInputParm() {
		boolean isRightData = false;
		customerId = text_customerId.getText();
		password = text_password.getText();
		memberName = text_memberName.getText();
		tel = text_tel.getText();
		gender = text_gender.getText();
		address = text_address.getText();
		note = text_note.getText();
		if (customerId.equals("") || password.equals("")) {
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
						"INSERT INTO member(customerId,password,memberName,tel,gender,address,note)VALUES(?,?,?,?,?,?,?)");
				pstmt.setString(1, customerId);
				pstmt.setString(2, password);
				pstmt.setString(3, memberName);
				pstmt.setString(4, tel);
				pstmt.setString(5, gender);
				pstmt.setString(6, address);
				pstmt.setString(7, note);
				isInsert = pstmt.executeUpdate();
				clearInput();

			} catch (SQLException e) {
				System.out.println(e.toString());
			}
		}
		return isInsert;
	}

	protected int updateData() {
		int isUpdate = 0;
		customerId = text_customerId.getText();
		if (getUserInputParm() == true) {
			try {
				pstmt = con.prepareStatement(
						"UPDATE member SET password=?,memberName=?,tel=?,gender=?,address=?,note=? WHERE customerId=?");
				pstmt.setString(1, password);
				pstmt.setString(2, memberName);
				pstmt.setString(3, tel);
				pstmt.setString(4, gender);
				pstmt.setString(5, address);
				pstmt.setString(6, note);
				pstmt.setString(7, customerId);
				isUpdate = pstmt.executeUpdate();
				clearInput();
			} catch (SQLException e) {
				System.out.println(e.toString());
			}

		}
		return isUpdate;
	}

	protected int delData() {
		int isDel = 0;
		customerId = text_customerId.getText();
		if (!customerId.equals("")) {
			try {
				pstmt = con.prepareStatement("DELETE FROM member WHERE customerId=?");
				pstmt.setString(1, customerId);
				isDel = pstmt.executeUpdate();
				clearInput();
			} catch (SQLException ee) {
				System.out.println(ee.toString());
			}
		}
		return isDel;
	}

	protected LinkedList<String[]> queryData() {
		LinkedList<String[]> data = new LinkedList<>();
		try {
			pstmt = con.prepareStatement("SELECT * FROM member");
			rs = pstmt.executeQuery();
			while (rs.next()) {
				String[] row = new String[7];
				row[0] = rs.getString("customerId");
				row[1] = rs.getString("password");
				row[2] = rs.getString("memberName");
				row[3] = rs.getString("tel");
				row[4] = rs.getString("gender");
				row[5] = rs.getString("address");
				row[6] = rs.getString("note");

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
			pstmt = con.prepareStatement(
					"SELECT * FROM member WHERE customerId LIKE? OR password LIKE ? OR memberName LIKE ? OR tel LIKE ? OR gender LIKE ?OR address LIKE ? OR note LIKE ?");
			String query = "%" + value + "%";
			for (int i = 1; i < 7; i++) {
				pstmt.setString(i, query);
			}
			rs = pstmt.executeQuery();
			while (rs.next()) {
				String[] row = new String[7];

				row[0] = rs.getString("customerId");
				row[1] = rs.getString("password");
				row[2] = rs.getString("memberName");
				row[3] = rs.getString("tel");
				row[4] = rs.getString("gender");
				row[5] = rs.getString("address");
				row[6] = rs.getString("note");
				data.add(row);
			}
		} catch (SQLException ee) {
			System.out.println(ee.toString());
		}
		return data;
	}

	private javax.swing.JScrollPane jScrollPane2;
	private javax.swing.JLabel label_address;
	private javax.swing.JLabel label_customerId;
	private javax.swing.JLabel label_gender;
	private javax.swing.JLabel label_memberName;
	private javax.swing.JLabel label_note;
	private javax.swing.JLabel label_password;
	private javax.swing.JLabel label_tel;
	private javax.swing.JTextField text_address;
	private javax.swing.JTextField text_customerId;
	private javax.swing.JTextField text_gender;
	private javax.swing.JTextField text_memberName;
	private javax.swing.JTextArea text_note;
	private javax.swing.JTextField text_password;
	private javax.swing.JTextField text_tel;
}