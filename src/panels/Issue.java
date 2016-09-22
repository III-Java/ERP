package panels;

import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.KeyEvent;
import java.awt.image.BufferedImage;
import java.io.IOException;
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

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JTextField;

public class Issue extends javax.swing.JPanel {
	private Connection conn;
	private Properties prop;
	private PreparedStatement pstmt = null;
	private ResultSet rs = null;
	HashMap<String, String[]> member = new HashMap<>();
	private String issueId = new String();
	
	public Issue() {
		initComponents();
		setDBProp();
		init();
	}

	public Issue(Connection conn) {
		initComponents();
		this.conn = conn;
		init();
	}

	private void setDBProp() {

		prop = new Properties();
		prop.setProperty("user", "root");
		prop.setProperty("password", "");
		prop.setProperty("characterEncoding", "UTF-8");
		prop.setProperty("useUnicode", "true");
		prop.setProperty("useSSL", "False");
		try {
			conn = DriverManager.getConnection("jdbc:mysql://localhost/erp", prop);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	private void init() {
		setComboCustomer();
	}
	//comboBox 即時更新 
    private void setComboCustomer(){
    	member.clear();
		LinkedList<String[]> members = selectMember();
		String[] memberNum = new String[members.size()+1];
		String[] memberName = new String[members.size()+1];
		memberNum[0] = "";
		memberName[0] = "";
		for (int i = 0; i < members.size(); i++) {
			memberNum[i+1] = members.get(i)[0];
			memberName[i+1] = members.get(i)[1];
		}

		member.put("memberNum", memberNum);
		member.put("memberName", memberName);
		combo_customerId.setModel(new javax.swing.DefaultComboBoxModel<>(memberNum));
		label_customName.setText(member.get("memberName")[0]);
    }
	
	// 判斷input有無空白
	private boolean getUserInputParm() {
		boolean isRightData = false;
		if (combo_customerId.getSelectedItem().toString().equals("") || text_complaint.getText().equals("")
				|| text_price.getText().equals("")) {
			isRightData = false;
		} else {
			isRightData = true;
		}
		return isRightData;
	}

	// 增
	protected int insertData() {

		int isInsert = 0; // 紀錄資料有沒有insert成功
		if (getUserInputParm() == true) {
			try {
				pstmt = conn.prepareStatement("INSERT INTO issue(customerId,complaint,price,note) VALUES('" + ""
						+ combo_customerId.getSelectedItem().toString() + "','" + "" + text_complaint.getText() + "','"
						+ "" + text_price.getText() + "','" + "" + text_note.getText() + "')");
				isInsert = pstmt.executeUpdate();

				
			} catch (Exception e) {
				e.printStackTrace();
			}
		}

		return isInsert;
	}

	protected int delData() {
		int isDel = 0;
		if (!combo_customerId.getSelectedItem().toString().equals("")) {
			try {
				pstmt = conn.prepareStatement("DELETE FROM issue WHERE id = ?");
				pstmt.setString(1, issueId);
				isDel = pstmt.executeUpdate();
				
				
				clearInput();
			} catch (SQLException ee) {
				System.out.println(ee.toString());
			}
		}

		return isDel;
	}

	// 修
	protected int updateData() {
		String strCustomerNum = combo_customerId.getSelectedItem().toString();
		int isUpdate = 0;
		if (getUserInputParm() == true) {
			try {
				pstmt = conn.prepareStatement("UPDATE issue SET complaint=?,price=?,note=?,customerId=? WHERE id=?");
				pstmt.setString(1, text_complaint.getText());
				pstmt.setString(2, text_price.getText());
				pstmt.setString(3, text_note.getText());
				pstmt.setString(4, strCustomerNum);
				pstmt.setString(5,issueId);
				isUpdate = pstmt.executeUpdate();
				
				
				
				clearInput();
			} catch (SQLException ee) {
				System.out.println(ee.toString());
			}
		}
		return isUpdate;
	}

	// 查
	protected LinkedList<String[]> queryData() {
		setComboCustomer();
		LinkedList<String[]> rows = new LinkedList<String[]>();
		try {
			pstmt = conn.prepareStatement("SELECT * FROM issue");
			rs = pstmt.executeQuery();

			while (rs.next()) {
				String[] row = new String[5];
				row[0] = rs.getString("id");
				row[1] = rs.getString("customerId");
				row[2] = rs.getString("complaint");
				row[3] = rs.getString("price");
				row[4] = rs.getString("note");	
				rows.add(row);
			}
			
			
			clearInput();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return rows;
	}

	private LinkedList<String[]> selectMember() {
		try {
			pstmt = conn.prepareStatement("SELECT * FROM member");
			ResultSet result = pstmt.executeQuery();
			LinkedList<String[]> rows = new LinkedList<String[]>();

			while (result.next()) {
				String[] member = new String[2];
				member[0] = result.getString("customerId");
				member[1] = result.getString("memberName");
				rows.add(member);
			}
			
			return rows;
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}

	protected String[] getColumn() {
		String[] columnName = new String[] { "customerId", "complaint", "price", "note", };
		return columnName;
	}

	protected LinkedList<String[]> search(String value) {
		LinkedList<String[]> data = new LinkedList<>();
		try {
			pstmt = conn.prepareStatement(
					"SELECT * FROM issue WHERE customerId LIKE ? OR complaint LIKE? OR price LIKE ? OR note LIKE ?");
			String query = "%" + value + "%";
			for (int i = 1; i < 5; i++) {
				pstmt.setString(i, query);
			}
			rs = pstmt.executeQuery();
			while (rs.next()) {
				String[] row = new String[4];
				row[0] = rs.getString("customerId");
				row[1] = rs.getString("complaint");
				row[2] = rs.getString("price");
				row[3] = rs.getString("note");
				data.add(row);
			}
		} catch (SQLException ee) {
			ee.toString();
		}
		return data;
	}

	protected void setInputValue(HashMap<Integer, String> data) {
		issueId = data.get(0);
		combo_customerId.setSelectedItem(data.get(1));
		text_complaint.setText(data.get(2));
		text_price.setText(data.get(3));
		text_note.setText(data.get(4));	
	}

	protected void clearInput() {
		combo_customerId.setSelectedItem("");
		label_customName.setText(member.get("memberName")[0]);
		text_complaint.setText("");
		text_price.setText("");
		text_note.setText("");
	}

	private void combo_customerIdActionPerformed(java.awt.event.ActionEvent evt) {
		String slt = combo_customerId.getSelectedItem().toString();
		for (int i = 0; i < member.get("memberNum").length; i++) {
			if (member.get("memberNum")[i].equals(slt)) {
				label_customName.setText(member.get("memberName")[i]);
			}
		}
	}
    
    private void text_priceKeyTyped(java.awt.event.KeyEvent evt) {                                       
    	char c = evt.getKeyChar();
        if(!(Character.isDigit(c)) || (c == KeyEvent.VK_SPACE) || (c == KeyEvent.VK_DELETE)){
            getToolkit().beep();
            evt.consume();  
        }
        if(text_price.getText().indexOf("0") == 0){text_price.setText("");}
    }   
   
    

	@SuppressWarnings("unchecked")
    private void initComponents() {

        label_customerId = new javax.swing.JLabel();
        label_price = new javax.swing.JLabel();
        label_complaint = new javax.swing.JLabel();
        label_note = new javax.swing.JLabel();
        text_price = new javax.swing.JTextField();
        scroll_complaint = new javax.swing.JScrollPane();
        text_complaint = new javax.swing.JTextArea();
        scroll_note = new javax.swing.JScrollPane();
        text_note = new javax.swing.JTextArea();
        combo_customerId = new javax.swing.JComboBox<>();
        label_customName = new javax.swing.JLabel();

        setMinimumSize(new java.awt.Dimension(980, 470));
        setPreferredSize(new java.awt.Dimension(980, 470));
        setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        label_customerId.setFont(new java.awt.Font("微軟正黑體", 0, 15)); // NOI18N
        label_customerId.setText("客戶編號");
        add(label_customerId, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 80, -1, -1));

        label_price.setFont(new java.awt.Font("微軟正黑體", 0, 15)); // NOI18N
        label_price.setText("金額");
        add(label_price, new org.netbeans.lib.awtextra.AbsoluteConstraints(550, 80, -1, -1));

        label_complaint.setFont(new java.awt.Font("微軟正黑體", 0, 15)); // NOI18N
        label_complaint.setText("客訴內容");
        add(label_complaint, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 160, -1, -1));

        label_note.setFont(new java.awt.Font("微軟正黑體", 0, 15)); // NOI18N
        label_note.setText("備註");
        add(label_note, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 340, -1, -1));

        text_price.setFont(new java.awt.Font("微軟正黑體", 0, 15)); // NOI18N
        text_price.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                text_priceKeyTyped(evt);
            }
        });
        add(text_price, new org.netbeans.lib.awtextra.AbsoluteConstraints(630, 75, 200, 35));

        text_complaint.setColumns(20);
        text_complaint.setFont(new java.awt.Font("微軟正黑體", 0, 15)); // NOI18N
        text_complaint.setRows(5);
        scroll_complaint.setViewportView(text_complaint);

        add(scroll_complaint, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 160, 620, 150));

        scroll_note.setToolTipText("");
        scroll_note.setVerticalScrollBarPolicy(javax.swing.ScrollPaneConstants.VERTICAL_SCROLLBAR_NEVER);

        text_note.setColumns(20);
        text_note.setFont(new java.awt.Font("微軟正黑體", 0, 14)); // NOI18N
        text_note.setRows(5);
        scroll_note.setViewportView(text_note);

        add(scroll_note, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 346, 620, 80));

        combo_customerId.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                combo_customerIdActionPerformed(evt);
            }
        });
        add(combo_customerId, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 75, 80, 35));

        label_customName.setFont(new java.awt.Font("微軟正黑體", 0, 15)); // NOI18N
        add(label_customName, new org.netbeans.lib.awtextra.AbsoluteConstraints(310, 70, 100, 40));
    }// </editor-fold>                      

	private javax.swing.JComboBox<String> combo_customerId;
	private javax.swing.JLabel label_complaint;
	private javax.swing.JLabel label_customName;
	private javax.swing.JLabel label_customerId;
	private javax.swing.JLabel label_note;
	private javax.swing.JLabel label_price;
	private javax.swing.JScrollPane scroll_complaint;
	private javax.swing.JScrollPane scroll_note;
	private javax.swing.JTextArea text_complaint;
	private javax.swing.JTextArea text_note;
	private javax.swing.JTextField text_price;

}
