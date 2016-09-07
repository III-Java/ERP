import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Properties;

import javax.imageio.ImageIO;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;

import sun.swing.FilePane;

public class WebNews extends javax.swing.JPanel {

	private Properties prop;
	private Connection con;
	private PreparedStatement pstmt = null;
	private ResultSet rs = null;
	private String filePath;
	private File selectedFile;
	private String fileName;
	private BufferedImage image;
	private String id;
	private String title;
	private String content;
	private boolean isPublish;
	private String note;

	public WebNews(Connection con) {
		initComponents();
		setDBProp();
		this.con = con;
	}

	@SuppressWarnings("unchecked")
	private void initComponents() {

		bgPublish = new javax.swing.ButtonGroup();
		jLabel1 = new javax.swing.JLabel();
		jLabel2 = new javax.swing.JLabel();
		jLabel3 = new javax.swing.JLabel();
		jLabel5 = new javax.swing.JLabel();
		txtTitle = new javax.swing.JTextField();
		rbPublish = new javax.swing.JRadioButton();
		rbPrivate = new javax.swing.JRadioButton();
		jLabel7 = new javax.swing.JLabel();
		jLabel10 = new javax.swing.JLabel();
		jScrollPane1 = new javax.swing.JScrollPane();
		txtNote = new javax.swing.JEditorPane();
		lbId = new javax.swing.JLabel();
		jScrollPane2 = new javax.swing.JScrollPane();
		txtContent = new javax.swing.JTextArea();
		btnChooseFile = new javax.swing.JButton();
		btnWatchFile = new javax.swing.JButton();
		lbFilePath = new javax.swing.JLabel();
		jLabel4 = new javax.swing.JLabel();

		setPreferredSize(new java.awt.Dimension(980, 470));

		jLabel1.setFont(new java.awt.Font("微軟正黑體", 0, 15)); // NOI18N
		jLabel1.setText("ID:");

		jLabel2.setFont(new java.awt.Font("微軟正黑體", 0, 15)); // NOI18N
		jLabel2.setText("標題:");

		jLabel3.setFont(new java.awt.Font("微軟正黑體", 0, 15)); // NOI18N
		jLabel3.setText("內容:");

		jLabel5.setFont(new java.awt.Font("微軟正黑體", 0, 15)); // NOI18N
		jLabel5.setText("上架:");

		txtTitle.setFont(new java.awt.Font("微軟正黑體", 0, 14)); // NOI18N

		bgPublish.add(rbPublish);
		rbPublish.setFont(new java.awt.Font("微軟正黑體", 0, 15)); // NOI18N
		rbPublish.setText("是");

		bgPublish.add(rbPrivate);
		rbPrivate.setFont(new java.awt.Font("微軟正黑體", 0, 15)); // NOI18N
		rbPrivate.setText("否");
		rbPrivate.setActionCommand("否");

		jLabel7.setFont(new java.awt.Font("微軟正黑體", 0, 18)); // NOI18N

		jLabel10.setFont(new java.awt.Font("微軟正黑體", 0, 15)); // NOI18N
		jLabel10.setText("備註");

		txtNote.setFont(new java.awt.Font("微軟正黑體", 0, 14)); // NOI18N
		jScrollPane1.setViewportView(txtNote);

		lbId.setFont(new java.awt.Font("微軟正黑體", 0, 15)); // NOI18N

		txtContent.setColumns(20);
		txtContent.setFont(new java.awt.Font("微軟正黑體", 0, 14)); // NOI18N
		txtContent.setRows(5);
		jScrollPane2.setViewportView(txtContent);

		btnChooseFile.setFont(new java.awt.Font("微軟正黑體", 0, 15)); // NOI18N
		btnChooseFile.setText("選擇檔案");
		btnChooseFile.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				btnChooseFileActionPerformed(evt);
			}
		});

		btnWatchFile.setFont(new java.awt.Font("微軟正黑體", 0, 15)); // NOI18N
		btnWatchFile.setText("查看檔案");
		btnWatchFile.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				btnWatchFileActionPerformed(evt);
			}
		});

		lbFilePath.setFont(new java.awt.Font("微軟正黑體", 0, 15)); // NOI18N

		jLabel4.setFont(new java.awt.Font("微軟正黑體", 0, 15)); // NOI18N
		jLabel4.setText("標題:");

		javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
		this.setLayout(layout);
		layout.setHorizontalGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING).addGroup(layout
				.createSequentialGroup().addGap(59, 59, 59)
				.addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING).addComponent(jLabel3)
						.addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
								.addComponent(jLabel1).addComponent(jLabel2)))
				.addGap(54, 54, 54)
				.addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
						.addComponent(txtTitle)
						.addComponent(lbId, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE,
								Short.MAX_VALUE)
						.addComponent(jScrollPane2))
				.addGap(89, 89, 89)
				.addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
						.addGroup(layout.createSequentialGroup().addGap(42, 42, 42).addComponent(jLabel7))
						.addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
								.addComponent(jLabel5).addGroup(
										layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
												.addComponent(jLabel4).addComponent(jLabel10))))
				.addGap(18, 18, 18)
				.addGroup(layout
						.createParallelGroup(
								javax.swing.GroupLayout.Alignment.LEADING)
						.addGroup(layout.createSequentialGroup()
								.addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
										.addComponent(jScrollPane1)
										.addGroup(layout.createSequentialGroup().addGroup(layout
												.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
												.addComponent(btnChooseFile, javax.swing.GroupLayout.Alignment.LEADING,
														javax.swing.GroupLayout.DEFAULT_SIZE,
														javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
												.addGroup(layout.createSequentialGroup().addComponent(rbPublish)
														.addGap(18, 18, 18).addComponent(rbPrivate)))
												.addGap(36, 36, 36).addComponent(btnWatchFile,
														javax.swing.GroupLayout.DEFAULT_SIZE, 123, Short.MAX_VALUE)))
								.addGap(160, 160, 160))
						.addGroup(layout.createSequentialGroup()
								.addComponent(lbFilePath, javax.swing.GroupLayout.PREFERRED_SIZE, 385,
										javax.swing.GroupLayout.PREFERRED_SIZE)
								.addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))));
		layout.setVerticalGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
				.addGroup(layout.createSequentialGroup().addGap(58, 58, 58)
						.addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
								.addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
										.addComponent(jLabel5).addComponent(rbPublish).addComponent(rbPrivate))
								.addGroup(layout.createSequentialGroup()
										.addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
												.addComponent(
														lbId, javax.swing.GroupLayout.PREFERRED_SIZE, 25,
														javax.swing.GroupLayout.PREFERRED_SIZE)
												.addComponent(jLabel1, javax.swing.GroupLayout.Alignment.TRAILING))
										.addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
												.addGroup(layout.createSequentialGroup().addGap(57, 57, 57)
														.addComponent(jLabel7).addGap(18, 18, 18)
														.addGroup(layout
																.createParallelGroup(
																		javax.swing.GroupLayout.Alignment.BASELINE)
																.addComponent(jLabel2).addComponent(txtTitle,
																		javax.swing.GroupLayout.PREFERRED_SIZE,
																		javax.swing.GroupLayout.DEFAULT_SIZE,
																		javax.swing.GroupLayout.PREFERRED_SIZE))
														.addGap(71, 71, 71).addComponent(jLabel3))
												.addGroup(layout.createSequentialGroup().addGap(39, 39, 39)
														.addGroup(layout
																.createParallelGroup(
																		javax.swing.GroupLayout.Alignment.BASELINE)
																.addComponent(btnChooseFile,
																		javax.swing.GroupLayout.PREFERRED_SIZE, 26,
																		javax.swing.GroupLayout.PREFERRED_SIZE)
																.addComponent(btnWatchFile,
																		javax.swing.GroupLayout.PREFERRED_SIZE, 26,
																		javax.swing.GroupLayout.PREFERRED_SIZE))
														.addGap(18, 18, 18)
														.addGroup(layout
																.createParallelGroup(
																		javax.swing.GroupLayout.Alignment.LEADING)
																.addGroup(layout.createSequentialGroup()
																		.addComponent(lbFilePath,
																				javax.swing.GroupLayout.PREFERRED_SIZE,
																				33,
																				javax.swing.GroupLayout.PREFERRED_SIZE)
																		.addGap(37, 37, 37)
																		.addGroup(layout
																				.createParallelGroup(
																						javax.swing.GroupLayout.Alignment.LEADING)
																				.addComponent(jScrollPane2,
																						javax.swing.GroupLayout.PREFERRED_SIZE,
																						129,
																						javax.swing.GroupLayout.PREFERRED_SIZE)
																				.addComponent(jScrollPane1,
																						javax.swing.GroupLayout.PREFERRED_SIZE,
																						129,
																						javax.swing.GroupLayout.PREFERRED_SIZE)
																				.addComponent(jLabel10)))
																.addComponent(jLabel4))))))
						.addContainerGap(105, Short.MAX_VALUE)));
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

	private void btnChooseFileActionPerformed(java.awt.event.ActionEvent evt) {
		JFileChooser fileChooser = new JFileChooser();// 宣告filechooser
		int returnValue = fileChooser.showOpenDialog(null);// 叫出filechooser
		if (returnValue == JFileChooser.APPROVE_OPTION) // 判斷是否選擇檔案
		{
			selectedFile = fileChooser.getSelectedFile();// 指派給File
			filePath = selectedFile.getPath();
			fileName = selectedFile.getName();
			if (isJPGFile() == true) {
				lbFilePath.setText(filePath);
				try {
					image = ImageIO.read(selectedFile);
				} catch (IOException e) {
					System.out.println(e.toString());
				}
			} else {
				lbFilePath.setText("檔案類型須為jpg");
			}
		}

	}

	private boolean getUserInputParm() {
		boolean isRightData = false;
		title = txtTitle.getText();
		content = txtContent.getText();
		note = txtNote.getText();
		if (rbPublish.isSelected()) {
			isPublish = true;			
		} else if (rbPrivate.isSelected()) {
			isPublish = false;
			
		} else {
			isRightData = false;
		}
		
		if (title == null || content == null || fileName == null) {
			isRightData = false;
		} else {
			isRightData = true;
		}
		
		return isRightData;
	}
	
	
	protected void clearInput(){
		lbId.setText("");
		txtTitle.setText("");
		txtContent.setText("");
		bgPublish.clearSelection();
		lbFilePath.setText("");
		txtNote.setText("");
	}
	protected void setInputValue(HashMap<Integer, String> data) {
		lbId.setText(data.get(0));
		txtTitle.setText(data.get(1));
		txtContent.setText(data.get(2));
		lbFilePath.setText("D:/WebNewsIMG/" + data.get(3));
		fileName = data.get(3);
		if(data.get(4).equals("0")){
			rbPrivate.setSelected(true);
		}
		else if(data.get(4).equals("1")){
			rbPublish.setSelected(true);
		}
		txtNote.setText(data.get(5));
	}
	
	protected int insertData() {
		int isInsert = 0;
		if(getUserInputParm() == true){
			try {
				pstmt = con.prepareStatement("INSERT INTO webnews(title,content,picName,publish,note)VALUES(?,?,?,?,?)");
				pstmt.setString(1, title);
				pstmt.setString(2, content);
				pstmt.setString(3, fileName);
				pstmt.setBoolean(4, isPublish);
				pstmt.setString(5, note);
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
    	if (getUserInputParm() == true ) {
    		
    		try {
    			pstmt = con.prepareStatement("UPDATE webnews SET title = ?,content = ?,picName = ?,publish = ? ,note = ? WHERE id =?");
				pstmt.setString(1, title);
				pstmt.setString(2, content);
				pstmt.setString(3, fileName);
				pstmt.setBoolean(4, isPublish);
				pstmt.setString(5, note);
				pstmt.setString(6, lbId.getText());
				isUpdate = pstmt.executeUpdate();
			} catch (SQLException e) {
				System.out.println(e.toString());
			}
    		
    	}
    	clearInput();
    	return isUpdate;
    }

	
	protected int delData(){
    	int isDel = 0;
    	
    	if(!lbId.getText().equals("")){
    		try{
    			pstmt = con.prepareStatement("DELETE FROM webNews WHERE id=?");
    			pstmt.setString(1, lbId.getText());
    			isDel = pstmt.executeUpdate();
    		}
    		catch(SQLException ee){
    			System.out.println(ee.toString());
    		}
    	}
    	clearInput();
    	return isDel;
    }
	
	protected LinkedList<String[]> queryData() {
			LinkedList<String[]> data = new LinkedList<>();
			try{
				pstmt = con.prepareStatement("SELECT * FROM webnews");
				rs = pstmt.executeQuery();
				while (rs.next()) {
					String[] row = new String[6];
					row[0] = rs.getString("id");
					row[1] = rs.getString("title");
					row[2] = rs.getString("content");
					row[3] = rs.getString("picName");
					row[4] = rs.getString("publish");
					row[5] = rs.getString("note");
					data.add(row);
				}
			}
			catch(SQLException ee){
				System.out.println(ee.toString());
			}
			return data;
	    }
	    
	 protected  LinkedList<String[]> search(String value){
			LinkedList<String[]> data = new LinkedList<>();
			try{
				pstmt = con.prepareStatement("SELECT * FROM webnews WHERE id LIKE ? OR title LIKE ? OR content LIKE ? OR picName LIKE ? OR publish LIKE ? OR note LIKE ?");
				String query = "%" + value +"%";
				for(int i=1 ; i<7; i++){
					pstmt.setString(i, query);
				}
				rs = pstmt.executeQuery();
				while (rs.next()) {
					String[] row = new String[6];
					row[0] = rs.getString("id");
					row[1] = rs.getString("title");
					row[2] = rs.getString("content");
					row[3] = rs.getString("picName");
					row[4] = rs.getString("publish");
					row[5] = rs.getString("note");
					data.add(row);
				}
			}
			catch(SQLException ee){
				System.out.println(ee.toString());
			}
			return data;
	    }
	private boolean isJPGFile() {
		if (filePath != null) {
			String fileType = filePath.substring(filePath.length() - 3, filePath.length()).toLowerCase();
			if (fileType.equals("jpg")) {
				return true;
			}
		}
		return false;
	}

	private void outputImg() {
		File theDir = new File("D:/WebNewsIMG/");
		// if the directory does not exist, create it
		if (!theDir.exists()) {
			String directoryName = "D:/WebNewsIMG/";
			boolean result = false;
			try {
				theDir.mkdir();
				result = true;
			} catch (SecurityException se) {
				System.out.println(se.toString());
			}
		}
		try {
			File outputFile = new File("D:/WebNewsIMG/" + fileName);
			System.out.println(outputFile);
			ImageIO.write(image, "jpg", outputFile);
		} catch (Exception ee) {
			System.out.println(ee.toString());
		}

	}

	private void btnWatchFileActionPerformed(java.awt.event.ActionEvent evt) {
		if (isJPGFile() == true) {
			ImageView imgView = new ImageView(filePath);
			imgView.setVisible(true);
			outputImg();
		} else {
			JOptionPane.showMessageDialog(btnWatchFile, "未選擇一個檔案");
		}
	}

	private javax.swing.ButtonGroup bgPublish;
	private javax.swing.JButton btnChooseFile;
	private javax.swing.JButton btnWatchFile;
	private javax.swing.JLabel jLabel1;
	private javax.swing.JLabel jLabel10;
	private javax.swing.JLabel jLabel2;
	private javax.swing.JLabel jLabel3;
	private javax.swing.JLabel jLabel4;
	private javax.swing.JLabel jLabel5;
	private javax.swing.JLabel jLabel7;
	private javax.swing.JScrollPane jScrollPane1;
	private javax.swing.JScrollPane jScrollPane2;
	private javax.swing.JLabel lbFilePath;
	private javax.swing.JLabel lbId;
	private javax.swing.JRadioButton rbPrivate;
	private javax.swing.JRadioButton rbPublish;
	private javax.swing.JTextArea txtContent;
	private javax.swing.JEditorPane txtNote;
	private javax.swing.JTextField txtTitle;

}
