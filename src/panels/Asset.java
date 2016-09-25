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
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Properties;
import java.util.Set;

import javax.imageio.ImageIO;
import javax.swing.DefaultComboBoxModel;
import javax.swing.ImageIcon;
import javax.swing.JTextField;

/**
* @author Veronica.C
*/
public class Asset extends javax.swing.JPanel {
	private Connection conn;
	private Set<String> depList;  
	private String depArray[];
	private String assetId =null, assetName=null, qty=null, value=null, buyDate=null,
			       note=null, depAsset=null, lifespan=null;
	
	private ImageIcon newIcon;
	private BufferedImage BIMG;

	
    public Asset(Connection connection) {
    	this.conn = connection;
//    	databaseConnect();
    	depList = new HashSet<String>(); //產生List裝id
    	depList.add("");
    	getEmpIdlist();
        initComponents();
        
		try {
			BIMG = ImageIO.read(Login.class.getResource("/panelBG.jpg"));
			newIcon = new ImageIcon(new ImageIcon(BIMG).getImage().getScaledInstance(980, 470, Image.SCALE_DEFAULT));
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">                          
    private void initComponents() {
    	//add bg
    	jPanel2 = new javax.swing.JPanel(){
    		public void paintComponent(Graphics g){
				try {
	    			Image image = newIcon.getImage();
	    			g.drawImage(image, 0, 0, this.getSize().width, this.getSize().height, this);

				} catch (Exception e) {
					System.out.println("login img xx");
					e.printStackTrace();
				}
    		}    		
    	};
        assetLabel01 = new javax.swing.JLabel();
        assetLabel02 = new javax.swing.JLabel();
        assetLabel03 = new javax.swing.JLabel();
        assetLabel04 = new javax.swing.JLabel();
        buyDate_asset = new com.toedter.calendar.JDateChooser();
        assetLabel05 = new javax.swing.JLabel();
        assetLabel06 = new javax.swing.JLabel();
        value_asset = new javax.swing.JTextField();
        assetLabel07 = new javax.swing.JLabel();
        lifespan_asset = new javax.swing.JTextField();
        assetLabel08 = new javax.swing.JLabel();
        jScrollPane4 = new javax.swing.JScrollPane();
        note_asset = new javax.swing.JTextArea();
        id_asset = new javax.swing.JLabel();
        department_asset = new javax.swing.JComboBox<>();
        assetName_asset = new javax.swing.JTextField();
        qty_asset = new javax.swing.JTextField();

        setMinimumSize(new java.awt.Dimension(980, 470));
        setPreferredSize(new java.awt.Dimension(980, 470));

        jPanel2.setMaximumSize(new java.awt.Dimension(980, 470));
        jPanel2.setMinimumSize(new java.awt.Dimension(980, 470));
        jPanel2.setPreferredSize(new java.awt.Dimension(980, 470));
        jPanel2.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        assetLabel01.setFont(new java.awt.Font("微軟正黑體", 0, 15)); // NOI18N
        assetLabel01.setText("資產編號");
        jPanel2.add(assetLabel01, new org.netbeans.lib.awtextra.AbsoluteConstraints(65, 53, -1, 30));

        assetLabel02.setFont(new java.awt.Font("微軟正黑體", 0, 15)); // NOI18N
        assetLabel02.setText("資產名稱");
        jPanel2.add(assetLabel02, new org.netbeans.lib.awtextra.AbsoluteConstraints(65, 123, -1, 30));

        assetLabel03.setFont(new java.awt.Font("微軟正黑體", 0, 15)); // NOI18N
        assetLabel03.setText("採購日期");
        jPanel2.add(assetLabel03, new org.netbeans.lib.awtextra.AbsoluteConstraints(65, 194, -1, 30));

        assetLabel04.setFont(new java.awt.Font("微軟正黑體", 0, 15)); // NOI18N
        assetLabel04.setText("使用部門");
        jPanel2.add(assetLabel04, new org.netbeans.lib.awtextra.AbsoluteConstraints(65, 264, -1, 30));

        buyDate_asset.setDateFormatString("yyyy/MM/dd");
        buyDate_asset.setFont(new java.awt.Font("微軟正黑體", 0, 14)); // NOI18N
        jPanel2.add(buyDate_asset, new org.netbeans.lib.awtextra.AbsoluteConstraints(155, 194, 180, 30));

        assetLabel05.setFont(new java.awt.Font("微軟正黑體", 0, 15)); // NOI18N
        assetLabel05.setText("數量");
        jPanel2.add(assetLabel05, new org.netbeans.lib.awtextra.AbsoluteConstraints(491, 53, -1, 30));

        assetLabel06.setFont(new java.awt.Font("微軟正黑體", 0, 15)); // NOI18N
        assetLabel06.setText("購入金額");
        assetLabel06.setToolTipText("");
        jPanel2.add(assetLabel06, new org.netbeans.lib.awtextra.AbsoluteConstraints(491, 123, -1, 30));

        value_asset.setFont(new java.awt.Font("微軟正黑體", 0, 15)); // NOI18N
        //keyIn check
        value_asset.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                value_assetKeyTyped(evt);
            }
        });
        jPanel2.add(value_asset, new org.netbeans.lib.awtextra.AbsoluteConstraints(629, 123, 150, 30));

        assetLabel07.setFont(new java.awt.Font("微軟正黑體", 0, 15)); // NOI18N
        assetLabel07.setText("折舊年限");
        jPanel2.add(assetLabel07, new org.netbeans.lib.awtextra.AbsoluteConstraints(491, 191, -1, 30));

        lifespan_asset.setFont(new java.awt.Font("微軟正黑體", 0, 15)); // NOI18N
        lifespan_asset.setMinimumSize(new java.awt.Dimension(6, 30));
        lifespan_asset.setPreferredSize(new java.awt.Dimension(6, 30));
        //keyIn check
        lifespan_asset.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                lifespan_assetKeyTyped(evt);
            }
        });
        jPanel2.add(lifespan_asset, new org.netbeans.lib.awtextra.AbsoluteConstraints(629, 191, 150, -1));

        assetLabel08.setFont(new java.awt.Font("微軟正黑體", 0, 15)); // NOI18N
        assetLabel08.setText("其它備註");
        jPanel2.add(assetLabel08, new org.netbeans.lib.awtextra.AbsoluteConstraints(491, 264, -1, 30));

        note_asset.setColumns(20);
        note_asset.setFont(new java.awt.Font("微軟正黑體", 0, 14)); // NOI18N
        note_asset.setRows(5);
        jScrollPane4.setViewportView(note_asset);

        jPanel2.add(jScrollPane4, new org.netbeans.lib.awtextra.AbsoluteConstraints(629, 264, 341, -1));

        id_asset.setFont(new java.awt.Font("微軟正黑體", 0, 15)); // NOI18N
        jPanel2.add(id_asset, new org.netbeans.lib.awtextra.AbsoluteConstraints(155, 53, 180, 30));

        department_asset.setFont(new java.awt.Font("微軟正黑體", 0, 15)); // NOI18N
        department_asset.setModel(new DefaultComboBoxModel(depArray));
//        department_asset.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        department_asset.setMinimumSize(new java.awt.Dimension(73, 30));
        department_asset.setPreferredSize(new java.awt.Dimension(73, 30));
        jPanel2.add(department_asset, new org.netbeans.lib.awtextra.AbsoluteConstraints(155, 264, 180, -1));
        
        assetName_asset.setFont(new java.awt.Font("微軟正黑體", 0, 15)); // NOI18N
        jPanel2.add(assetName_asset, new org.netbeans.lib.awtextra.AbsoluteConstraints(155, 123, 180, -1));

        qty_asset.setFont(new java.awt.Font("微軟正黑體", 0, 15)); // NOI18N
        //keyIn check
        qty_asset.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                qty_assetKeyTyped(evt);
            }
        });
        jPanel2.add(qty_asset, new org.netbeans.lib.awtextra.AbsoluteConstraints(629, 53, 150, 30));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );        
    }// </editor-fold>  
    
    //key in judge
    private void qty_assetKeyTyped(java.awt.event.KeyEvent evt) {                                   
        char c = evt.getKeyChar();
        if(!(Character.isDigit(c)) || (c == KeyEvent.VK_SPACE) || (c == KeyEvent.VK_DELETE)){
            getToolkit().beep();
            evt.consume();
        }
    }                                
    
    private void value_assetKeyTyped(java.awt.event.KeyEvent evt) {                                     
        char c = evt.getKeyChar();
        if(!(Character.isDigit(c)) || (c == KeyEvent.VK_SPACE) || (c == KeyEvent.VK_DELETE)){
            getToolkit().beep();
            evt.consume();
        }
    }     
    
    private void lifespan_assetKeyTyped(java.awt.event.KeyEvent evt) {                                        
    	 char c = evt.getKeyChar();
         if(!(Character.isDigit(c)) || (c == KeyEvent.VK_SPACE) || (c == KeyEvent.VK_DELETE)){
             getToolkit().beep();
             evt.consume();
         }
    } 
   
    protected void getDefault(){
    	id_asset.setText("系統自動產生");
    	assetName_asset.setText("");
    	buyDate_asset.setCalendar(null);;
    	qty_asset.setText("");
    	value_asset.setText("");
    	lifespan_asset.setText("");
    	note_asset.setText("");
    	assetId =null; assetName=null; qty=null; value=null; buyDate=null;
		note=null; depAsset=null; lifespan=null;
		id_asset.setText("");
		department_asset.setSelectedIndex(0);
    	
    }
    
    protected int insertDB(){
    	int isInsert = 0;
    	if (getSelect() == true) {
	    	String sql = "insert into asset(assetName,qty,value,buyDate,note,department,lifespan) "
	    			+ "values(?,?,?,?,?,?,?)";
	  	 	try{	    			    		
		    	PreparedStatement insertdb = conn.prepareStatement(sql); 
		    	insertdb.setString(1, assetName);
		    	insertdb.setString(2, qty);
		    	insertdb.setString(3, value);
		    	insertdb.setString(4, buyDate);
		    	insertdb.setString(5, note);
		    	insertdb.setString(6, depAsset);
		    	insertdb.setString(7, lifespan);	    	
		    	
		    	isInsert = insertdb.executeUpdate();
	    	}catch(Exception a){
	    		System.out.println("insertDB error");
	    		a.printStackTrace();
	    	}
    	}
  	 	return isInsert;
    }
    
    protected int editDB(){    	
    	assetId = id_asset.getText();
		int isUpdate = 0;
		if (getSelect() == true) {
		    String sql = "update asset set assetName=?, qty=?, value=?, buyDate=?, note=?, department=?, lifespan=? where id=?";	    			
	  	 	try{	    			    		
		    	PreparedStatement editdb = conn.prepareStatement(sql); 
		    	editdb.setString(1, assetName);
		    	editdb.setString(2, qty);
		    	editdb.setString(3, value);
		    	editdb.setString(4, buyDate);
		    	editdb.setString(5, note);
		    	editdb.setString(6, depAsset);
		    	editdb.setString(7, lifespan);	
		    	editdb.setString(8, assetId);
		    	
		    	isUpdate = editdb.executeUpdate();
	      	}catch(Exception a){
	    		System.out.println("editDB error");
	    		a.printStackTrace();
		    }    
	    }
		return isUpdate;
    }
    
    protected  LinkedList<String[]> search(String value){
		LinkedList<String[]> data = new LinkedList<>();
		try{
			PreparedStatement pstmt = conn.prepareStatement("SELECT * FROM asset WHERE id LIKE ? OR assetName LIKE ? OR qty LIKE ? OR value LIKE ?"
					+ " OR buyDate LIKE ? OR department LIKE ? OR lifespan LIKE ? OR note LIKE ?");
			String query = "%" + value +"%";
			for(int i=1 ; i<9; i++){
				pstmt.setString(i, query);
			}
			ResultSet rs = pstmt.executeQuery();
			while (rs.next()) {
				String[] row = new String [8];	
	    		row [0] = rs.getString("id");
	    		row [1] = rs.getString("assetName");
	    		row [2] = rs.getString("qty");
	    		row [3] = rs.getString("value");
	    		row [4] = rs.getString("buyDate");
	    		row [5] = rs.getString("department");
	    		row [6] = rs.getString("lifespan");
	    		row [7] = rs.getString("note");	   
				data.add(row);
			}
		}
		catch(SQLException ee){
			System.out.println(ee.toString());
		}
		return data;
	}
    
    private void updateInTime(){//combo box及時更新資料庫資料    	
    	depList.clear();
    	depList.add("");
    	
    	//re-update data from db
    	getEmpIdlist();    	
    	department_asset.setModel(new DefaultComboBoxModel(depArray));   	
    	
    }
    
    protected LinkedList<String[]> queryData() {
    	getDefault();
    	updateInTime();
		LinkedList<String[]> data = new LinkedList<>();
		try{
			PreparedStatement pstmt = conn.prepareStatement("SELECT * FROM asset");
			ResultSet rs = pstmt.executeQuery();
	    	while(rs.next()){
	    		String[] row = new String [8];	
	    		row [0] = rs.getString("id");
	    		row [1] = rs.getString("assetName");
	    		row [2] = rs.getString("qty");
	    		row [3] = rs.getString("value");
	    		row [4] = rs.getString("buyDate");
	    		row [5] = rs.getString("department");
	    		row [6] = rs.getString("lifespan");
	    		row [7] = rs.getString("note");	   	    		
	    		data.add(row);
			}
		}
		catch(SQLException ee){			
			System.out.println("as_query"+ee.toString());
		}
		return data;
    }
    
    protected void setInputValue(HashMap<Integer, String> data) {
    	id_asset.setText(data.get(0));
    	assetName_asset.setText(data.get(1));
    	
    	try {
			java.util.Date date = new SimpleDateFormat("yyyy/MM/dd").parse(data.get(4));
			buyDate_asset.setDate(date);
		} catch (ParseException e) {
			
			e.printStackTrace();
		}		
    	
    	department_asset.setSelectedItem(data.get(5));
    	qty_asset.setText(data.get(2));
    	value_asset.setText(data.get(3));
    	lifespan_asset.setText(data.get(6));
    	note_asset.setText(data.get(7));		
	}
    
	protected int delData(){
		int isDel = 0;
		if(!id_asset.getText().equals("")){
			try{
				PreparedStatement pstmt = conn.prepareStatement("DELETE FROM asset WHERE id = ?");
				pstmt.setString(1, id_asset.getText());
				isDel = pstmt.executeUpdate();
			}
			catch(SQLException ee){
				System.out.println(ee.toString());
			}
		}
		return isDel;
	}
    
    
  //取得輸入資料
    protected boolean getSelect(){  
    	boolean isRightData = false;
    	//get remark content
    	assetName = assetName_asset.getText();
    	qty = qty_asset.getText();
    	value = value_asset.getText();
    	lifespan = lifespan_asset.getText();
    	note = note_asset.getText();
    	
    	//get jdateChooser value
    	buyDate  = ((JTextField)buyDate_asset.getDateEditor().getUiComponent()).getText();    	
    	
    	//combobox get selected & use combobox get empName----->apply in actionListener  
    	depAsset = (String) department_asset.getSelectedItem();
    	
    	if (assetName.equals("") || qty.equals("") || value.equals("") || lifespan.equals("") || buyDate.equals("")
			|| depAsset.equals("")) {
			isRightData = false;
		} else {
			isRightData = true;
		}
		return isRightData;
    }
    
  //抓到資料庫人員id資料塞入list
    private void getEmpIdlist(){
    	try{
	    	PreparedStatement getId = conn.prepareStatement("select * from department");
	    	ResultSet rs = getId.executeQuery();
	    	while(rs.next()){
	    		String idList = rs.getString("department");
	    		depList.add(idList);
	    	}
    	}catch(Exception e){
    		System.out.println("getEmpIdlist error");
    		e.printStackTrace();
    	}
    	
    	//將Set<String>轉為array塞入comobox modle當項目
    	depArray = new String[depList.size()];
    	Object[] tempArray = depList.toArray();  //set.toArray是object[]
    	for(int i = 0; i < tempArray.length; i++) {
    		depArray[i] = (String)tempArray[i];
    	}
    	Arrays.sort(depArray);
    	
    }
    
    // Variables declaration - do not modify                     
    private javax.swing.JLabel assetLabel01;
    private javax.swing.JLabel assetLabel02;
    private javax.swing.JLabel assetLabel03;
    private javax.swing.JLabel assetLabel04;
    private javax.swing.JLabel assetLabel05;
    private javax.swing.JLabel assetLabel06;
    private javax.swing.JLabel assetLabel07;
    private javax.swing.JLabel assetLabel08;
    private javax.swing.JTextField assetName_asset;
    private com.toedter.calendar.JDateChooser buyDate_asset;
    private javax.swing.JComboBox<String> department_asset;
    private javax.swing.JLabel id_asset;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JTextField lifespan_asset;
    private javax.swing.JTextArea note_asset;
    private javax.swing.JTextField qty_asset;
    private javax.swing.JTextField value_asset;
    // End of variables declaration                   
}
