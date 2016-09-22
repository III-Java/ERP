package panels;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.LinkedList;
import javax.swing.JOptionPane;
import javax.swing.GroupLayout.Alignment;
import javax.imageio.ImageIO;
import javax.swing.GroupLayout;
import javax.swing.ImageIcon;
import javax.swing.LayoutStyle.ComponentPlacement;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.KeyEvent;
import java.awt.image.BufferedImage;
import java.io.IOException;

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
	private void initComponents() {
		gender_member = new javax.swing.ButtonGroup();
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
        label_customerId = new javax.swing.JLabel();
        label_password = new javax.swing.JLabel();
        label_memberName = new javax.swing.JLabel();
        label_note = new javax.swing.JLabel();
        label_tel = new javax.swing.JLabel();
        label_gender = new javax.swing.JLabel();
        label_address = new javax.swing.JLabel();
        text_customerId = new javax.swing.JTextField();
        text_password = new javax.swing.JTextField();
        text_memberName = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        text_note = new javax.swing.JTextArea();
        text_tel = new javax.swing.JTextField();
        radio_male = new javax.swing.JRadioButton();
        radio_female = new javax.swing.JRadioButton();
        text_address = new javax.swing.JTextField();

        setMaximumSize(new java.awt.Dimension(980, 470));
        setMinimumSize(new java.awt.Dimension(980, 470));
        setName(""); // NOI18N
        setPreferredSize(new java.awt.Dimension(980, 470));

        jPanel1.setMaximumSize(new java.awt.Dimension(980, 470));
        jPanel1.setMinimumSize(new java.awt.Dimension(980, 470));
        jPanel1.setPreferredSize(new java.awt.Dimension(980, 470));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        label_customerId.setFont(new java.awt.Font("微軟正黑體", 0, 15)); // NOI18N
        label_customerId.setText("客戶編號");
        jPanel1.add(label_customerId, new org.netbeans.lib.awtextra.AbsoluteConstraints(108, 63, -1, -1));

        label_password.setFont(new java.awt.Font("微軟正黑體", 0, 15)); // NOI18N
        label_password.setText("客戶密碼");
        jPanel1.add(label_password, new org.netbeans.lib.awtextra.AbsoluteConstraints(108, 141, -1, -1));

        label_memberName.setFont(new java.awt.Font("微軟正黑體", 0, 15)); // NOI18N
        label_memberName.setText("客戶名稱");
        jPanel1.add(label_memberName, new org.netbeans.lib.awtextra.AbsoluteConstraints(108, 219, -1, -1));

        label_note.setFont(new java.awt.Font("微軟正黑體", 0, 15)); // NOI18N
        label_note.setText("備註");
        jPanel1.add(label_note, new org.netbeans.lib.awtextra.AbsoluteConstraints(108, 293, 60, -1));

        label_tel.setFont(new java.awt.Font("微軟正黑體", 0, 15)); // NOI18N
        label_tel.setText("電話");
        jPanel1.add(label_tel, new org.netbeans.lib.awtextra.AbsoluteConstraints(545, 63, 60, -1));

        label_gender.setFont(new java.awt.Font("微軟正黑體", 0, 15)); // NOI18N
        label_gender.setText("性別");
        jPanel1.add(label_gender, new org.netbeans.lib.awtextra.AbsoluteConstraints(545, 141, 60, -1));

        label_address.setFont(new java.awt.Font("微軟正黑體", 0, 15)); // NOI18N
        label_address.setText("地址");
        jPanel1.add(label_address, new org.netbeans.lib.awtextra.AbsoluteConstraints(545, 219, 60, -1));

        text_customerId.setFont(new java.awt.Font("微軟正黑體", 0, 15)); // NOI18N
        jPanel1.add(text_customerId, new org.netbeans.lib.awtextra.AbsoluteConstraints(186, 60, 210, -1));

        text_password.setFont(new java.awt.Font("微軟正黑體", 0, 15)); // NOI18N
        jPanel1.add(text_password, new org.netbeans.lib.awtextra.AbsoluteConstraints(186, 138, 210, -1));

        text_memberName.setFont(new java.awt.Font("微軟正黑體", 0, 15)); // NOI18N
        jPanel1.add(text_memberName, new org.netbeans.lib.awtextra.AbsoluteConstraints(186, 216, 210, -1));

        text_note.setColumns(20);
        text_note.setFont(new java.awt.Font("微軟正黑體", 0, 14)); // NOI18N
        text_note.setRows(5);
        jScrollPane1.setViewportView(text_note);

        jPanel1.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(186, 293, 687, -1));

        text_tel.setFont(new java.awt.Font("微軟正黑體", 0, 15)); // NOI18N
        text_tel.setToolTipText("格式：0212345678,0912345678");
        text_tel.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                text_telKeyTyped(evt);
            }
        });
        jPanel1.add(text_tel, new org.netbeans.lib.awtextra.AbsoluteConstraints(623, 60, 250, -1));

        gender_member.add(radio_male);
        radio_male.setFont(new java.awt.Font("微軟正黑體", 0, 15)); // NOI18N
        radio_male.setText("男");
        jPanel1.add(radio_male, new org.netbeans.lib.awtextra.AbsoluteConstraints(623, 137, 98, -1));

        gender_member.add(radio_female);
        radio_female.setFont(new java.awt.Font("微軟正黑體", 0, 15)); // NOI18N
        radio_female.setText("女");
        jPanel1.add(radio_female, new org.netbeans.lib.awtextra.AbsoluteConstraints(739, 137, 83, -1));

        text_address.setFont(new java.awt.Font("微軟正黑體", 0, 15)); // NOI18N
        jPanel1.add(text_address, new org.netbeans.lib.awtextra.AbsoluteConstraints(623, 216, 250, -1));
        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 517, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
	}// </editor-fold>                        

    private void text_telKeyTyped(java.awt.event.KeyEvent evt) {                                  
    	 char c = evt.getKeyChar();
         if(!(Character.isDigit(c)) || (c == KeyEvent.VK_SPACE) || (c == KeyEvent.VK_DELETE)){
             getToolkit().beep();
         	evt.consume();
         }
    }     

	protected void setInputValue(HashMap<Integer, String> data) {
		text_customerId.setText(data.get(0));
		text_password.setText(data.get(1));
		text_memberName.setText((data.get(2)));
		text_tel.setText(data.get(3));
		text_address.setText(data.get(5));
		text_note.setText(data.get(6));
		
		if (data.get(4).equals("男")) {
			radio_male.setSelected(true);
		} else if(data.get(4).equals("女")){
			radio_female.setSelected(true);
		}
	}

	protected void clearInput() {
		text_customerId.setText("");
		text_password.setText("");
		text_memberName.setText("");
		text_tel.setText("");
		text_address.setText("");
		text_note.setText("");
		gender_member.clearSelection();		
		customerId ="";
		password ="";
		memberName ="";
		tel ="";
		gender ="";
		address ="";
		note ="";
	}

	private boolean getUserInputParm() {
		boolean isRightData = false;
		customerId = text_customerId.getText();
		password = text_password.getText();
		memberName = text_memberName.getText();
		tel = text_tel.getText();
		address = text_address.getText();
		note = text_note.getText();
    	if(radio_male.isSelected()){gender = "男";}else if(radio_female.isSelected()){gender = "女";}   	
    	
		if (customerId.equals("") || password.equals("") ||memberName.equals("") ||tel.equals("") ||gender.equals("")) {
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
			for (int i = 1; i < 8; i++) {
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

	private javax.swing.ButtonGroup gender_member;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel label_address;
    private javax.swing.JLabel label_customerId;
    private javax.swing.JLabel label_gender;
    private javax.swing.JLabel label_memberName;
    private javax.swing.JLabel label_note;
    private javax.swing.JLabel label_password;
    private javax.swing.JLabel label_tel;
    private javax.swing.JRadioButton radio_female;
    private javax.swing.JRadioButton radio_male;
    private javax.swing.JTextField text_address;
    private javax.swing.JTextField text_customerId;
    private javax.swing.JTextField text_memberName;
    private javax.swing.JTextArea text_note;
    private javax.swing.JTextField text_password;
    private javax.swing.JTextField text_tel;
}