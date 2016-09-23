package panels;
import java.awt.Graphics;
import java.awt.Image;
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
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;

public class WebNews extends javax.swing.JPanel {
	
	private Connection con;
	private PreparedStatement pstmt = null;
	private ResultSet rs = null;
	private String filePath;
	private File selectedFile;
	private String fileName;
	private BufferedImage image;
	private String title;
	private String content;
	private boolean isPublish;
	private String note;
	private final String outPutFilePath = "D:/Coding/JavaEE/WorkSapce/EnterpriseWebsite/WebContent/img/";
	public WebNews(Connection con) {
		this.con = con;
		initComponents();	
	}
	
//	@Override
//	protected void paintChildren(Graphics g) {
//		ImageIcon newIcon;		
//		BufferedImage BIMG;
//		try {
//			BIMG = ImageIO.read(Login.class.getResource("/panelBG.jpg"));
//			newIcon = new ImageIcon(new ImageIcon(BIMG).getImage().getScaledInstance(980, 470, Image.SCALE_DEFAULT));
//			Image image = newIcon.getImage();
//			g.drawImage(image, 0, 0, this.getSize().width, this.getSize().height, this);
//
//		} catch (IOException e) {
//			System.out.println("login img xx");
//			e.printStackTrace();
//		}
//	}

	@SuppressWarnings("unchecked")
	private void initComponents() {
		bgPublish = new javax.swing.ButtonGroup();
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
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        txtTitle = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        txtContent = new javax.swing.JTextArea();
        rbPublish = new javax.swing.JRadioButton();
        rbPrivate = new javax.swing.JRadioButton();
        btnChooseFile = new javax.swing.JButton();
        btnWatchFile = new javax.swing.JButton();
        lbFilePath = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        txtNote = new javax.swing.JTextArea();
        lbId = new javax.swing.JLabel();

        setMaximumSize(new java.awt.Dimension(980, 470));
        setMinimumSize(new java.awt.Dimension(980, 470));

        jPanel1.setFont(new java.awt.Font("微軟正黑體", 0, 15)); // NOI18N
        jPanel1.setMaximumSize(new java.awt.Dimension(980, 470));
        jPanel1.setMinimumSize(new java.awt.Dimension(980, 470));
        jPanel1.setPreferredSize(new java.awt.Dimension(980, 470));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setFont(new java.awt.Font("微軟正黑體", 0, 15)); // NOI18N
        jLabel1.setText("ID");
        jPanel1.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 73, 45, -1));

        jLabel2.setFont(new java.awt.Font("微軟正黑體", 0, 15)); // NOI18N
        jLabel2.setText("標題");
        jPanel1.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 170, 45, -1));

        jLabel3.setFont(new java.awt.Font("微軟正黑體", 0, 15)); // NOI18N
        jLabel3.setText("內容");
        jPanel1.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 270, -1, -1));

        jLabel4.setFont(new java.awt.Font("微軟正黑體", 0, 15)); // NOI18N
        jLabel4.setText("上架");
        jPanel1.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(531, 70, 44, -1));

        jLabel5.setFont(new java.awt.Font("微軟正黑體", 0, 15)); // NOI18N
        jPanel1.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(531, 180, 30, -1));

        jLabel6.setFont(new java.awt.Font("微軟正黑體", 0, 15)); // NOI18N
        jLabel6.setText("備註");
        jPanel1.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(530, 270, -1, -1));

        txtTitle.setFont(new java.awt.Font("微軟正黑體", 0, 15)); // NOI18N
        txtTitle.setText("");
        jPanel1.add(txtTitle, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 170, 319, -1));

        txtContent.setColumns(20);
        txtContent.setFont(new java.awt.Font("微軟正黑體", 0, 14)); // NOI18N
        txtContent.setRows(5);
        jScrollPane1.setViewportView(txtContent);

        jPanel1.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 270, 319, 141));

        bgPublish.add(rbPublish);
        rbPublish.setFont(new java.awt.Font("微軟正黑體", 0, 15)); // NOI18N
        rbPublish.setText("是");
        jPanel1.add(rbPublish, new org.netbeans.lib.awtextra.AbsoluteConstraints(607, 70, -1, -1));

        bgPublish.add(rbPrivate);
        rbPrivate.setFont(new java.awt.Font("微軟正黑體", 0, 15)); // NOI18N
        rbPrivate.setText("否");
        jPanel1.add(rbPrivate, new org.netbeans.lib.awtextra.AbsoluteConstraints(718, 70, -1, -1));

        btnChooseFile.setFont(new java.awt.Font("微軟正黑體", 0, 15)); // NOI18N
        btnChooseFile.setText("選擇檔案");
        btnChooseFile.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnChooseFileActionPerformed(evt);
            }
        });
        jPanel1.add(btnChooseFile, new org.netbeans.lib.awtextra.AbsoluteConstraints(607, 117, -1, -1));

        btnWatchFile.setFont(new java.awt.Font("微軟正黑體", 0, 15)); // NOI18N
        btnWatchFile.setText("查看檔案");
        btnWatchFile.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnWatchFileActionPerformed(evt);
            }
        });
        jPanel1.add(btnWatchFile, new org.netbeans.lib.awtextra.AbsoluteConstraints(718, 117, -1, -1));

        lbFilePath.setFont(new java.awt.Font("微軟正黑體", 0, 12)); // NOI18N
        lbFilePath.setText("jLabel7");
        jPanel1.add(lbFilePath, new org.netbeans.lib.awtextra.AbsoluteConstraints(540, 170, 430, 30));

        txtNote.setColumns(20);
        txtNote.setFont(new java.awt.Font("微軟正黑體", 0, 14)); // NOI18N
        txtNote.setRows(5);
        jScrollPane2.setViewportView(txtNote);

        jPanel1.add(jScrollPane2, new org.netbeans.lib.awtextra.AbsoluteConstraints(610, 270, 318, -1));

        lbId.setFont(new java.awt.Font("微軟正黑體", 0, 15)); // NOI18N
        lbId.setText("");
        jPanel1.add(lbId, new org.netbeans.lib.awtextra.AbsoluteConstraints(113, 73, 316, -1));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
    }// </editor-fold>                      

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
				lbFilePath.setText("檔案類型須為jpg或png");
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
		lbFilePath.setText(outPutFilePath + data.get(3));
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
			if (fileType.equals("jpg")||fileType.equals("png")) {
				return true;
			}
		}
		return false;
	}

	private void outputImg() {
		File theDir = new File(outPutFilePath);
		// if the directory does not exist, create it
		if (!theDir.exists()) {
			try {
				theDir.mkdir();
			} catch (SecurityException se) {
				System.out.println(se.toString());
			}
		}
		
		try {
			File outputFile = new File(outPutFilePath + fileName);
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
	    private javax.swing.JLabel jLabel2;
	    private javax.swing.JLabel jLabel3;
	    private javax.swing.JLabel jLabel4;
	    private javax.swing.JLabel jLabel5;
	    private javax.swing.JLabel jLabel6;
	    private javax.swing.JPanel jPanel1;
	    private javax.swing.JScrollPane jScrollPane1;
	    private javax.swing.JScrollPane jScrollPane2;
	    private javax.swing.JLabel lbFilePath;
	    private javax.swing.JLabel lbId;
	    private javax.swing.JRadioButton rbPrivate;
	    private javax.swing.JRadioButton rbPublish;
	    private javax.swing.JTextArea txtContent;
	    private javax.swing.JTextArea txtNote;
	    private javax.swing.JTextField txtTitle;
}
