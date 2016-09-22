package panels;

import java.awt.Graphics;
import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.LinkedList;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;

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

         jPanel1.setMaximumSize(new java.awt.Dimension(980, 470));
         jPanel1.setMinimumSize(new java.awt.Dimension(980, 470));
         jPanel1.setPreferredSize(new java.awt.Dimension(980, 470));
         jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

         jLabel1.setFont(new java.awt.Font("微軟正黑體", 0, 15)); // NOI18N
         jLabel1.setText("員工編號");
         jPanel1.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(59, 65, -1, -1));

         jLabel2.setFont(new java.awt.Font("微軟正黑體", 0, 15)); // NOI18N
         jLabel2.setText("月份");
         jPanel1.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(59, 188, 60, 31));

         jLabel7.setFont(new java.awt.Font("微軟正黑體", 0, 18)); // NOI18N
         jPanel1.add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(495, 162, -1, -1));

         jLabel10.setFont(new java.awt.Font("微軟正黑體", 0, 15)); // NOI18N
         jLabel10.setText("備註");
         jPanel1.add(jLabel10, new org.netbeans.lib.awtextra.AbsoluteConstraints(450, 193, -1, -1));

         txtNote.setFont(new java.awt.Font("微軟正黑體", 0, 14)); // NOI18N
         jScrollPane1.setViewportView(txtNote);

         jPanel1.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(509, 195, 356, 90));

         txtMonth.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.DateFormatter(new java.text.SimpleDateFormat("yyyy-MM"))));
         txtMonth.setToolTipText("yyyy-MM");
         txtMonth.setFont(new java.awt.Font("微軟正黑體", 0, 15)); // NOI18N
         jPanel1.add(txtMonth, new org.netbeans.lib.awtextra.AbsoluteConstraints(147, 189, 225, 30));

         jLabel11.setFont(new java.awt.Font("微軟正黑體", 0, 15)); // NOI18N
         jLabel11.setText("考績");
         jPanel1.add(jLabel11, new org.netbeans.lib.awtextra.AbsoluteConstraints(450, 65, -1, -1));

         cbScore.setFont(new java.awt.Font("微軟正黑體", 0, 15)); // NOI18N
         cbScore.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "  ", "A", "B", "C", "D", "E" }));
         jPanel1.add(cbScore, new org.netbeans.lib.awtextra.AbsoluteConstraints(509, 62, 356, -1));

         txtEmployeeNum.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.NumberFormatter(new java.text.DecimalFormat("#0"))));
         txtEmployeeNum.setFont(new java.awt.Font("微軟正黑體", 0, 15)); // NOI18N
         txtEmployeeNum.addKeyListener(new java.awt.event.KeyAdapter() {
             public void keyReleased(java.awt.event.KeyEvent evt) {
                 txtEmployeeNumKeyReleased(evt);
             }
         });
         jPanel1.add(txtEmployeeNum, new org.netbeans.lib.awtextra.AbsoluteConstraints(147, 62, 225, -1));

         lbName.setFont(new java.awt.Font("微軟正黑體", 0, 15)); // NOI18N
         jPanel1.add(lbName, new org.netbeans.lib.awtextra.AbsoluteConstraints(147, 107, 225, 34));

         javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
         this.setLayout(layout);
         layout.setHorizontalGroup(
             layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
             .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
         );
         layout.setVerticalGroup(
             layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
             .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, 473, Short.MAX_VALUE)
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
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel lbName;
    private javax.swing.JFormattedTextField txtEmployeeNum;
    private javax.swing.JFormattedTextField txtMonth;
    private javax.swing.JEditorPane txtNote;
}
