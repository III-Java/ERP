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
        txtPay = new javax.swing.JFormattedTextField();
        txtEmpoyeeNum = new javax.swing.JFormattedTextField();
        lbName = new javax.swing.JLabel();

        setMaximumSize(new java.awt.Dimension(980, 470));
        setMinimumSize(new java.awt.Dimension(980, 470));
        setPreferredSize(new java.awt.Dimension(980, 470));

        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setFont(new java.awt.Font("微軟正黑體", 0, 15)); // NOI18N
        jLabel1.setText("員工編號");
        jPanel1.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 70, -1, -1));

        jLabel2.setFont(new java.awt.Font("微軟正黑體", 0, 15)); // NOI18N
        jLabel2.setText("薪資");
        jPanel1.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 250, 60, 30));

        jLabel7.setFont(new java.awt.Font("微軟正黑體", 0, 18)); // NOI18N
        jPanel1.add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(495, 160, -1, -1));

        jLabel10.setFont(new java.awt.Font("微軟正黑體", 0, 15)); // NOI18N
        jLabel10.setText("備註");
        jPanel1.add(jLabel10, new org.netbeans.lib.awtextra.AbsoluteConstraints(570, 67, -1, -1));

        txtNote.setFont(new java.awt.Font("微軟正黑體", 0, 14)); // NOI18N
        jScrollPane1.setViewportView(txtNote);

        jPanel1.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(618, 62, 254, 216));

        txtPay.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.NumberFormatter(new java.text.DecimalFormat("#,##0"))));
        txtPay.setFont(new java.awt.Font("微軟正黑體", 0, 15)); // NOI18N
        jPanel1.add(txtPay, new org.netbeans.lib.awtextra.AbsoluteConstraints(220, 250, 225, 30));

        txtEmpoyeeNum.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.NumberFormatter(new java.text.DecimalFormat("#0"))));
        txtEmpoyeeNum.setToolTipText("");
        txtEmpoyeeNum.setFont(new java.awt.Font("微軟正黑體", 0, 15)); // NOI18N
        txtEmpoyeeNum.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtEmpoyeeNumKeyReleased(evt);
            }
        });
        jPanel1.add(txtEmpoyeeNum, new org.netbeans.lib.awtextra.AbsoluteConstraints(220, 70, 225, 31));

        lbName.setFont(new java.awt.Font("微軟正黑體", 0, 15)); // NOI18N
        jPanel1.add(lbName, new org.netbeans.lib.awtextra.AbsoluteConstraints(220, 110, 225, 29));

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
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel lbName;
    private javax.swing.JFormattedTextField txtEmpoyeeNum;
    private javax.swing.JEditorPane txtNote;
    private javax.swing.JFormattedTextField txtPay;
}
