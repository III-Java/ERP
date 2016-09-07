package panels;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Properties;

import javax.swing.JOptionPane;
import javax.swing.JTextField;

import java.awt.Font;
import javax.swing.GroupLayout.Alignment;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.GroupLayout;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JFormattedTextField;

/**
 *
 * @author Elite2615
 */

public class Product extends javax.swing.JPanel {
	private String productNum;
	private String productName;
	private String price;
	private String category;
	private String note;
	private Properties prop;
	private Connection con;
	private PreparedStatement pstmt = null;
	private ResultSet rs = null;

	private List<String> checkRp;
	public Product(Connection conn) {
		this.con = conn;
		initComponents();
		checkRp = new ArrayList<String>(); //產生List裝key過的單

	}

	private void initComponents() {
		label_productNum = new javax.swing.JLabel();
        label_pNum = new javax.swing.JLabel();
        label_productName = new javax.swing.JLabel();
        label_note = new javax.swing.JLabel();
        label_price = new javax.swing.JLabel();
        text_price = new javax.swing.JFormattedTextField();
        label_category = new javax.swing.JLabel();
        CBcategory = new javax.swing.JComboBox<>();
        text_productName = new javax.swing.JTextField();
        text_note = new javax.swing.JTextField();

        setPreferredSize(new java.awt.Dimension(980, 470));

        label_productNum.setFont(new java.awt.Font("微軟正黑體", 0, 15)); // NOI18N
        label_productNum.setText("產品編號");

        label_pNum.setFont(new java.awt.Font("微軟正黑體", 0, 15)); // NOI18N

        label_productName.setFont(new java.awt.Font("微軟正黑體", 0, 15)); // NOI18N
        label_productName.setText("品名");

        label_note.setFont(new java.awt.Font("微軟正黑體", 0, 15)); // NOI18N
        label_note.setText("備註");

        label_price.setFont(new java.awt.Font("微軟正黑體", 0, 15)); // NOI18N
        label_price.setText("單價");

        ((JFormattedTextField) text_price).setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.NumberFormatter(new java.text.DecimalFormat("#0"))));
        text_price.setFont(new java.awt.Font("微軟正黑體", 0, 15)); // NOI18N
        text_price.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                actionPerformed(evt);
            }
        });

        label_category.setFont(new java.awt.Font("微軟正黑體", 0, 15)); // NOI18N
        label_category.setText("類別");

        CBcategory.setFont(new java.awt.Font("微軟正黑體", 0, 15)); // NOI18N
        CBcategory.setModel(new DefaultComboBoxModel(new String[] {"","原味茶系列", "鮮奶茶系列", "拿鐵系列", "美味抹茶系列", "100%鮮果系列"}));

        text_productName.setFont(new java.awt.Font("微軟正黑體", 0, 15)); // NOI18N

        text_note.setFont(new java.awt.Font("微軟正黑體", 0, 14)); // NOI18N

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(112, 112, 112)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(label_productNum)
                    .addComponent(label_productName)
                    .addComponent(label_note))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(text_productName, javax.swing.GroupLayout.PREFERRED_SIZE, 210, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(label_pNum))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 68, Short.MAX_VALUE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(label_category)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(CBcategory, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(label_price)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(text_price, javax.swing.GroupLayout.PREFERRED_SIZE, 169, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(315, 315, 315))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(text_note)
                        .addGap(297, 297, 297))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(53, 53, 53)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(label_productNum)
                            .addComponent(label_pNum))
                        .addGap(27, 27, 27)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(label_productName)
                            .addComponent(text_productName, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(label_price)
                            .addComponent(text_price, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(24, 24, 24)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(label_category)
                            .addComponent(CBcategory, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addGap(46, 46, 46)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(text_note, javax.swing.GroupLayout.PREFERRED_SIZE, 237, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(label_note))
                .addContainerGap(56, Short.MAX_VALUE))
		);
		this.setLayout(layout);
	}// </editor-fold>

	private boolean getUserInputParm() {
		boolean isRightData = false;

		productName = text_productName.getText();
		price = text_price.getText();
		category = CBcategory.getSelectedItem().toString();
		// category = text_category.getText();
		note = text_note.getText();
		// productName = text_productName.getText();
		if (productName.equals("")) {
			isRightData = false;
		} else {
			isRightData = true;
		}
		return isRightData;
	}

	private boolean checkRepeat(){
		getUserInputParm();//抓到輸入值
		try{
			PreparedStatement prep = con.prepareStatement("select * from product");
			ResultSet rs = prep.executeQuery();
			while(rs.next()){
				String productN = rs.getString("productName");
				checkRp.add(productN);
			}
			
			for(int i = 0; i < checkRp.size(); i++) {
	    		String checkRpString = checkRp.get(i);	    		
	    		if(productName.equals(checkRpString)){
	    			return true;
	    		}	    		
	    	}	
		}catch(Exception a){
			System.out.println("checkRepeat xx");
			a.printStackTrace();
		}
		return false;
	}
	
	protected void setInputValue(HashMap<Integer, String> data) {

		label_pNum.setText(data.get(0));
		text_productName.setText(data.get(1));
		text_price.setText((data.get(2)));

		switch (data.get(3)) {
		// "原味茶系列", "鮮奶茶系列", "拿鐵系列", "美味抹茶系列", "100%鮮果系列"
		case "":
			CBcategory.setSelectedIndex(0);
			break;
		case "原味茶系列":
			CBcategory.setSelectedIndex(1);
			break;
		case "鮮奶茶系列":
			CBcategory.setSelectedIndex(2);
			break;
		case "拿鐵系列":
			CBcategory.setSelectedIndex(3);
			break;
		case "美味抹茶系列":
			CBcategory.setSelectedIndex(4);
		case "100%鮮果系列":
			CBcategory.setSelectedIndex(5);
			break;
			
		default:
			CBcategory.setSelectedIndex(0);
			break;
		}
		text_note.setText(data.get(4));
	}

	protected void clearInput() {
		label_pNum.setText("");
		text_productName.setText("");
		text_price.setText("");
		CBcategory.setSelectedIndex(0);
		text_note.setText("");
	}

	protected int insertData() {
		int isInsert = 0;
		boolean ifRepeat = checkRepeat();
		if(!ifRepeat){
			try {
				pstmt = con.prepareStatement(
	
						"INSERT INTO product(productName,price,category,note) VALUES('" + "" + text_productName.getText()
								+ "','" + "" + text_price.getText() + "','" + "" + CBcategory.getSelectedItem() + "','" + ""
								+ text_note.getText() + "')");
				//
				// "INSERT INTO
				// product(productName,price,category,note)VALUES(?,?,?,?)");
				// //pstmt.setString(1, productNum);
				// pstmt.setString(1, productName);
				// pstmt.setString(2, price);
				// pstmt.setString(3, category);
				// pstmt.setString(4, note);
				isInsert = pstmt.executeUpdate();
				pstmt.close();
				clearInput();
	
			} catch (SQLException e) {
				System.out.println(e.toString());
			}
		}
		return isInsert;
	}

	protected int updateData() {
		int isUpdate = 0;
		productNum = label_pNum.getText();
		if (getUserInputParm() == true) {
			try {

				pstmt = con.prepareStatement(
						"UPDATE product SET productName=?,price=?,category=?,note=? WHERE productNum=?");
				pstmt.setString(1, productName);
				pstmt.setString(2, price);
				pstmt.setString(3, category);
				pstmt.setString(4, note);
				pstmt.setString(5, productNum);

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
		productNum = label_pNum.getText();
		if (!productNum.equals("")) {
			try {
				pstmt = con.prepareStatement("DELETE FROM product WHERE productNum=?");
				pstmt.setString(1, productNum);
				isDel = pstmt.executeUpdate();
				clearInput();
			} catch (SQLException ee) {
				System.out.println(ee.toString());
			}
		}
		return isDel;
	}

	protected LinkedList<String[]> queryData() {
		clearInput();
		LinkedList<String[]> data = new LinkedList<>();
		try {
			pstmt = con.prepareStatement("SELECT * FROM product");
			rs = pstmt.executeQuery();
			while (rs.next()) {
				String[] row = new String[5];
				row[0] = rs.getString("productNum");
				row[1] = rs.getString("productName");
				row[2] = rs.getString("price");
				row[3] = rs.getString("category");
				row[4] = rs.getString("note");

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
					"SELECT * FROM product WHERE productNum LIKE? OR productName LIKE ? OR price LIKE ? OR category LIKE ? OR note LIKE ?");
			String query = "%" + value + "%";
			for (int i = 1; i < 6; i++) {
				pstmt.setString(i, query);
			}
			rs = pstmt.executeQuery();
			while (rs.next()) {
				String[] row = new String[5];

				row[0] = rs.getString("productNum");
				row[1] = rs.getString("productName");
				row[2] = rs.getString("price");
				row[3] = rs.getString("category");
				row[4] = rs.getString("note");
				data.add(row);
			}
		} catch (SQLException ee) {
			System.out.println(ee.toString());
		}
		return data;
	}

	private void txtVendorNumKeyReleased(java.awt.event.KeyEvent evt) {
		String productNum = "";
		try {
			pstmt = con.prepareStatement("SELECT productNum FROM product Where productNum = ?");
			pstmt.setString(1, label_pNum.getText());
			rs = pstmt.executeQuery();
			while (rs.next()) {
				productNum = rs.getString("productNum");
			}
		} catch (SQLException ee) {
			System.out.println(ee.toString());
		}
		if (productNum.equals("")) {
			JOptionPane.showMessageDialog(label_pNum, "查無此商品");
		}
	}

	private javax.swing.JScrollPane jScrollPane2;
	private javax.swing.JLabel label_category;
	private javax.swing.JLabel label_note;
	private javax.swing.JLabel label_price;
	private javax.swing.JLabel label_productName;
	private javax.swing.JLabel label_productNum;
	private JTextField text_note;
	private javax.swing.JTextField text_price;
	private javax.swing.JTextField text_productName;
	private JComboBox CBcategory;
	private JLabel label_pNum;
	private JFormattedTextField formattedTextField;
}
