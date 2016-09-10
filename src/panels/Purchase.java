package panels;
import java.awt.event.KeyEvent;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Properties;

import javax.swing.DefaultComboBoxModel;
import javax.swing.JTextField;
/**
* @author Veronica.C
*/
public class Purchase extends javax.swing.JPanel {
	private Connection conn;
	private String purid =null, materilNo =null, purDate =null, empNo =null, 
			vendorNo =null, purQty =null, pUnit=null, purPrice =null, note=null;
	private String matName=null, empName=null, venName=null, sqlID=null;
	private Date date;
	private List<String> empList;
	private List<String> venList; 
	private List<String> matList;
	private List<String> checkRp;
	private String empArray[], venArray[], matArray[];
	private String unitArray[] = {"","公斤", "台斤","包","個","組","公升","罐","支"};
	private boolean repeat =false;

    public Purchase(Connection connection) {
    	this.conn = connection;
//    	databaseConnect();
    	empList = new ArrayList<String>(); //產生List裝id
    	venList = new ArrayList<String>(); //產生List裝id
    	matList = new ArrayList<String>(); //產生List裝id
    	checkRp = new ArrayList<String>(); //產生List裝key過的單
    	empList.add(""); venList.add(""); matList.add("");
    	getIdtoCombolist();//抓到資料庫id資料塞入list
        initComponents();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">                          
    private void initComponents() {
        purchaseLabel01 = new javax.swing.JLabel();
        purchaseNum_Purc = new javax.swing.JTextField();
        purchaseLabel02 = new javax.swing.JLabel();
        purchaseLabel03 = new javax.swing.JLabel();
        purchaseLabel04 = new javax.swing.JLabel();
        purchaseDate_Purc = new com.toedter.calendar.JDateChooser();
        purchaseLabel05 = new javax.swing.JLabel();
        purchaseLabel06 = new javax.swing.JLabel();
        qty_Purc = new javax.swing.JTextField();
        purchaseLabel07 = new javax.swing.JLabel();
        price_Purc = new javax.swing.JTextField();
        purchaseLabel08 = new javax.swing.JLabel();
        jScrollPane4 = new javax.swing.JScrollPane();
        note_Purc = new javax.swing.JTextArea();
        materialName_Purc = new javax.swing.JLabel();
        employName_Purc = new javax.swing.JLabel();
        vendorName_Purc = new javax.swing.JLabel();
        materialNum_Purc = new javax.swing.JComboBox<>();
        employNum_Purc = new javax.swing.JComboBox<>();
        vendorNum_Purc = new javax.swing.JComboBox<>();
        showInfo = new javax.swing.JLabel();
        SQLID = new javax.swing.JLabel();
        unit_Purc = new javax.swing.JComboBox<>();

        setMinimumSize(new java.awt.Dimension(980, 470));
        setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        purchaseLabel01.setFont(new java.awt.Font("微軟正黑體", 0, 15)); // NOI18N
        purchaseLabel01.setText("進貨單號");
        add(purchaseLabel01, new org.netbeans.lib.awtextra.AbsoluteConstraints(65, 53, -1, 30));

        purchaseNum_Purc.setFont(new java.awt.Font("微軟正黑體", 0, 15)); // NOI18N
        purchaseNum_Purc.setPreferredSize(new java.awt.Dimension(10, 26));
        add(purchaseNum_Purc, new org.netbeans.lib.awtextra.AbsoluteConstraints(155, 55, 180, 30));

        purchaseLabel02.setFont(new java.awt.Font("微軟正黑體", 0, 15)); // NOI18N
        purchaseLabel02.setText("原料編號");
        add(purchaseLabel02, new org.netbeans.lib.awtextra.AbsoluteConstraints(65, 124, -1, 30));

        purchaseLabel03.setFont(new java.awt.Font("微軟正黑體", 0, 15)); // NOI18N
        purchaseLabel03.setText("進貨日期");
        add(purchaseLabel03, new org.netbeans.lib.awtextra.AbsoluteConstraints(65, 195, -1, 30));

        purchaseLabel04.setFont(new java.awt.Font("微軟正黑體", 0, 15)); // NOI18N
        purchaseLabel04.setText("採購人員");
        add(purchaseLabel04, new org.netbeans.lib.awtextra.AbsoluteConstraints(65, 260, -1, 30));

        purchaseDate_Purc.setDateFormatString("yyyy/MM/dd");
        purchaseDate_Purc.setFont(new java.awt.Font("微軟正黑體", 0, 15)); // NOI18N
        add(purchaseDate_Purc, new org.netbeans.lib.awtextra.AbsoluteConstraints(155, 195, 180, 30));

        purchaseLabel05.setFont(new java.awt.Font("微軟正黑體", 0, 15)); // NOI18N
        purchaseLabel05.setText("廠商編號");
        add(purchaseLabel05, new org.netbeans.lib.awtextra.AbsoluteConstraints(515, 53, -1, 30));

        purchaseLabel06.setFont(new java.awt.Font("微軟正黑體", 0, 15)); // NOI18N
        purchaseLabel06.setText("進貨數量");
        purchaseLabel06.setToolTipText("");
        add(purchaseLabel06, new org.netbeans.lib.awtextra.AbsoluteConstraints(512, 124, -1, 30));

        qty_Purc.setFont(new java.awt.Font("微軟正黑體", 0, 15)); // NOI18N
       //keyIn check
        qty_Purc.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                qty_PurcKeyTyped(evt);
            }
        });
        add(qty_Purc, new org.netbeans.lib.awtextra.AbsoluteConstraints(629, 126, 150, 30));

        purchaseLabel07.setFont(new java.awt.Font("微軟正黑體", 0, 15)); // NOI18N
        purchaseLabel07.setText("採購單價");
        add(purchaseLabel07, new org.netbeans.lib.awtextra.AbsoluteConstraints(512, 193, -1, 30));

        price_Purc.setFont(new java.awt.Font("微軟正黑體", 0, 15)); // NOI18N
        //keyIn check
        price_Purc.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                price_PurcKeyTyped(evt);
            }
        });
        add(price_Purc, new org.netbeans.lib.awtextra.AbsoluteConstraints(629, 195, 150, 30));

        purchaseLabel08.setFont(new java.awt.Font("微軟正黑體", 0, 15)); // NOI18N
        purchaseLabel08.setText("備註");
        add(purchaseLabel08, new org.netbeans.lib.awtextra.AbsoluteConstraints(512, 265, -1, 30));

        note_Purc.setColumns(20);
        note_Purc.setFont(new java.awt.Font("微軟正黑體", 0, 14)); // NOI18N
        note_Purc.setRows(5);
        jScrollPane4.setViewportView(note_Purc);

        add(jScrollPane4, new org.netbeans.lib.awtextra.AbsoluteConstraints(610, 270, 350, 170));

        materialName_Purc.setFont(new java.awt.Font("微軟正黑體", 0, 15)); // NOI18N
        materialName_Purc.setText("原料名稱");
        add(materialName_Purc, new org.netbeans.lib.awtextra.AbsoluteConstraints(339, 124, 120, 30));

        employName_Purc.setFont(new java.awt.Font("微軟正黑體", 0, 15)); // NOI18N
        employName_Purc.setText("員工姓名");
        add(employName_Purc, new org.netbeans.lib.awtextra.AbsoluteConstraints(339, 260, 120, 30));

        vendorName_Purc.setFont(new java.awt.Font("微軟正黑體", 0, 15)); // NOI18N
        vendorName_Purc.setText("廠商名稱");
        add(vendorName_Purc, new org.netbeans.lib.awtextra.AbsoluteConstraints(783, 65, 187, -1));

        materialNum_Purc.setFont(new java.awt.Font("微軟正黑體", 0, 15)); // NOI18N
//        materialNum_Purc.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        materialNum_Purc.setModel(new DefaultComboBoxModel(matArray));  
        materialNum_Purc.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                materialNum_PurcActionPerformed(evt);
            }
        });
        add(materialNum_Purc, new org.netbeans.lib.awtextra.AbsoluteConstraints(155, 126, 180, 30));

        employNum_Purc.setFont(new java.awt.Font("微軟正黑體", 0, 14)); // NOI18N
//        employNum_Purc.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        employNum_Purc.setModel(new DefaultComboBoxModel(empArray));

        employNum_Purc.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                employNum_PurcActionPerformed(evt);
            }
        });
        add(employNum_Purc, new org.netbeans.lib.awtextra.AbsoluteConstraints(155, 260, 180, 30));

        vendorNum_Purc.setFont(new java.awt.Font("微軟正黑體", 0, 14)); // NOI18N
//        vendorNum_Purc.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        vendorNum_Purc.setModel(new DefaultComboBoxModel(venArray));

        vendorNum_Purc.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                vendorNum_PurcActionPerformed(evt);
            }
        });
        add(vendorNum_Purc, new org.netbeans.lib.awtextra.AbsoluteConstraints(629, 55, 150, 30));

        showInfo.setFont(new java.awt.Font("微軟正黑體", 0, 15)); // NOI18N
        showInfo.setText("系統編號");
        add(showInfo, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 320, 80, 40));

        SQLID.setFont(new java.awt.Font("微軟正黑體", 0, 15)); // NOI18N       
        add(SQLID, new org.netbeans.lib.awtextra.AbsoluteConstraints(155, 328, 183, -1));
        
        unit_Purc.setFont(new java.awt.Font("微軟正黑體", 0, 15)); // NOI18N
//        unit_Purc.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        unit_Purc.setModel(new DefaultComboBoxModel(unitArray));
        add(unit_Purc, new org.netbeans.lib.awtextra.AbsoluteConstraints(788, 125, 125, 30));
    }// </editor-fold>     
    
  //key type check
    private void qty_PurcKeyTyped(java.awt.event.KeyEvent evt) {                                  
        char c = evt.getKeyChar();
        if(!(Character.isDigit(c)) || (c == KeyEvent.VK_SPACE) || (c == KeyEvent.VK_DELETE)){
            getToolkit().beep();
        	evt.consume();
        }
    }                                 

    private void price_PurcKeyTyped(java.awt.event.KeyEvent evt) {                                    
       char c = evt.getKeyChar();
        if(!(Character.isDigit(c)) || (c == KeyEvent.VK_SPACE) || (c == KeyEvent.VK_DELETE)){
            getToolkit().beep();
            evt.consume();
        }
    }   
    
    private void employNum_PurcActionPerformed(java.awt.event.ActionEvent evt) {  //點選單，帶出名字                                             
    	empName();
    }    
    
    private void empName(){
    	empNo = (String) employNum_Purc.getSelectedItem();
        if(empNo.length()>0){//排除空白選項
	        try {
				PreparedStatement getEmp = conn.prepareStatement("select * from employee where employeeNum="+empNo);
	    		ResultSet rs = getEmp.executeQuery();
				while(rs.next()){				
					empName = rs.getString("name");				
					employName_Purc.setText(empName);							
				}
	        } catch (Exception e) {
				System.out.println("ActionPerformed error");
				e.printStackTrace();
			}
        }
    }
    
    private void materialNum_PurcActionPerformed(java.awt.event.ActionEvent evt) {                                                 
    	materN();	
    }   
    
    private void materN(){
    	materilNo = (String) materialNum_Purc.getSelectedItem(); 
    	if(materilNo.length()>0){//排除空白選項
	    	try {					
				PreparedStatement getMaterial = conn.prepareStatement("select * from material where materialNum="+materilNo);
	    		ResultSet rs2 = getMaterial.executeQuery();
				while(rs2.next()){				
					matName = rs2.getString("materialName");
					materialName_Purc.setText(matName);
				}
	    	} catch (Exception e) {
				System.out.println("getSelect error");
				e.printStackTrace();
			}
    	}
    }
    
    private void vendorNum_PurcActionPerformed(java.awt.event.ActionEvent evt) {                                               
    	vendorName();
    }  
    
    private void vendorName(){
    	vendorNo = (String) vendorNum_Purc.getSelectedItem(); 
    	if(vendorNo.length()>0){//排除空白選項
	    	try {
				PreparedStatement getVendor = conn.prepareStatement("select * from vendor where vendorNum="+vendorNo);
	    		ResultSet rs3 = getVendor.executeQuery();
				while(rs3.next()){				
					venName = rs3.getString("vendorName");
					vendorName_Purc.setText(venName);
				}
				
	    	} catch (Exception e) {
				System.out.println("getSelect error");
				e.printStackTrace();
			}
    	}
    }
    
    public boolean checkRepeatPurchase(){ //單號+料號+廠商編號+數量=pk來比對    
    	getSelect();
    	try{	    		    		
	    	PreparedStatement checkPur = conn.prepareStatement("select * from purchase"); 
	    	ResultSet rs = checkPur.executeQuery();
	    	while(rs.next()){
	    		String purId = rs.getString("purchaseNum");
	    		String purMatId = rs.getString("materialNum");
	    		String purVen = rs.getString("vendorNum");
	    		String purQty = rs.getString("qty");
	    		String _pur_rpCheck = purId+purMatId+purVen+purQty;
	    		checkRp.add(_pur_rpCheck);
	    	}		
	    	
	    	String getKeyInInfo = purid+materilNo+vendorNo+purQty;
	    	for(int i = 0; i < checkRp.size(); i++) {
	    		String checkRpString = checkRp.get(i);	    		
	    		if(getKeyInInfo.equals(checkRpString)){
	    			return true;
	    		}	    		
	    	}	    	
    	}catch(Exception a){
    		System.out.println("editDB error");
    		a.printStackTrace();
    	}
    	return false;
    }
   
	protected int delData(){
		int isDel = 0;
		if(!SQLID.getText().equals("")){
			try{
				PreparedStatement pstmt = conn.prepareStatement("DELETE FROM purchase WHERE id = ?");
				pstmt.setString(1, SQLID.getText());
				isDel = pstmt.executeUpdate();
			}
			catch(SQLException ee){
				System.out.println(ee.toString());
			}
		}
		
		return isDel;
	}
    
    protected int editDB(){  
    	int isUpdate = 0;
    	sqlID = SQLID.getText();
    	if (getSelect() == true && !sqlID.equals("")) {
	    	String sql = "update purchase set purchaseNum=?, materialNum=?, purchaseDate=?, vendorNum=?, "
	    			+ "qty=?, price=?, employeeNum=?, note=?, unit=? where id=?";
	    	try{	    		    		
		    	PreparedStatement insertdb = conn.prepareStatement(sql); 		    	
		    	insertdb.setString(1, purid);
		    	insertdb.setString(2, materilNo);
		    	insertdb.setString(3, purDate);
		    	insertdb.setString(4, vendorNo);
		    	insertdb.setString(5, purQty);
		    	insertdb.setString(6, purPrice);
		    	insertdb.setString(7, empNo);
		    	insertdb.setString(8, note);
		    	insertdb.setString(9, pUnit);
		    	insertdb.setString(10, sqlID);
		    		    	
		    	isUpdate = insertdb.executeUpdate();			    
	    	}catch(Exception a){
	    		System.out.println("editDB error");
	    		a.printStackTrace();
	    	}
	    }
    	return isUpdate;
    }
    
    protected LinkedList<String[]> search(String value){
		LinkedList<String[]> data = new LinkedList<>();
		try{
			PreparedStatement pstmt = conn.prepareStatement("SELECT * FROM purchase WHERE id LIKE ? OR purchaseNum LIKE ? OR materialNum LIKE ?"
					+ " OR purchaseDate LIKE ? OR vendorNum LIKE ? OR qty LIKE ? OR price LIKE ? OR employeeNum LIKE ? OR note LIKE ?");
			String query = "%" + value +"%";
			for(int i=1 ; i<11; i++){
				pstmt.setString(i, query);
			}
			ResultSet rs = pstmt.executeQuery();
			while (rs.next()) {
				String[] row = new String [9];	
	    		row [0] = rs.getString("id");
	    		row [1] = rs.getString("purchaseNum");
	    		row [2] = rs.getString("materialNum");
	    		row [3] = rs.getString("purchaseDate");
	    		row [4] = rs.getString("vendorNum");
	    		row [5] = rs.getString("qty");
	    		row [6] = rs.getString("unit");
	    		row [7] = rs.getString("price");
	    		row [8] = rs.getString("employeeNum");	 
	    		row [9] = rs.getString("note");    	   
				data.add(row);
			}
		}
		catch(SQLException ee){
			System.out.println(ee.toString());
		}
		return data;
	}
  
    protected LinkedList<String[]> queryData() {
    	getDefault();
		LinkedList<String[]> data = new LinkedList<>();
		try{
			PreparedStatement pstmt = conn.prepareStatement("SELECT * FROM purchase");
			ResultSet rs = pstmt.executeQuery();
	    	while(rs.next()){
	    		String[] row = new String [10];
	    		row [0] = rs.getString("id");
	    		row [1] = rs.getString("purchaseNum");
	    		row [2] = rs.getString("materialNum");
	    		row [3] = rs.getString("purchaseDate");
	    		row [4] = rs.getString("vendorNum");
	    		row [5] = rs.getString("qty");
	    		row [6] = rs.getString("unit");
	    		row [7] = rs.getString("price");
	    		row [8] = rs.getString("employeeNum");	 
	    		row [9] = rs.getString("note");    	   
				data.add(row);
			}
		}
		catch(SQLException ee){			
			System.out.println("p_query"+ee.toString());
		}
		return data;
    }
    
    protected void setInputValue(HashMap<Integer, String> data) {
    	purchaseNum_Purc.setText(data.get(1));
		materialNum_Purc.setSelectedItem(data.get(2));
		materN();
		
		unit_Purc.setSelectedItem(data.get(6));
		

		try {
			java.util.Date date = new SimpleDateFormat("yyyy/MM/dd").parse(data.get(3));
			purchaseDate_Purc.setDate(date);
		} catch (ParseException e) {
			
			e.printStackTrace();
		}
		
		employNum_Purc.setSelectedItem(data.get(8));
		empName();
		
		vendorNum_Purc.setSelectedItem(data.get(4));
		vendorName();
		
		qty_Purc.setText(data.get(5));
		price_Purc.setText(data.get(7));
		note_Purc.setText(data.get(9));

		SQLID.setText(data.get(0));		
	}
    
    
    protected void getDefault(){//表格初始化
    	purid =null; materilNo =null; purDate =null; empNo =null; pUnit=null;
    	vendorNo =null; purQty =null; purPrice =null; note=null;
    	matName=null; empName=null; venName=null;
    	purchaseNum_Purc.setText("");
    	materialName_Purc.setText("");
    	purchaseDate_Purc.setCalendar(null);;
    	employName_Purc.setText("");
    	vendorName_Purc.setText("");
    	qty_Purc.setText("");
    	price_Purc.setText("");
    	note_Purc.setText("");
    	checkRp.clear();
    	SQLID.setText("");
    	materialNum_Purc.setSelectedIndex(0);employNum_Purc.setSelectedIndex(0); vendorNum_Purc.setSelectedIndex(0);
    	unit_Purc.setSelectedIndex(0);
    }
    
  //抓到資料庫人員id資料塞入list
    private void getIdtoCombolist(){
    	try{
	    	PreparedStatement empId = conn.prepareStatement("select * from employee");
	    	ResultSet rs = empId.executeQuery();
	    	while(rs.next()){
	    		String idList = rs.getString("employeeNum");
	    		empList.add(idList);
	    	}
	    	
	    	PreparedStatement venId = conn.prepareStatement("select * from vendor");
	    	ResultSet rs2 = venId.executeQuery();
	    	while(rs2.next()){
	    		String idList2 = rs2.getString("vendorNum");
	    		venList.add(idList2);
	    	}
	    	
	    	PreparedStatement matId = conn.prepareStatement("select * from material");
	    	ResultSet rs3 = matId.executeQuery();
	    	while(rs3.next()){
	    		String idList3 = rs3.getString("materialNum");
	    		matList.add(idList3);
	    	}   
    	}catch(Exception e){
    		System.out.println("getEmpIdlist error");
    		e.printStackTrace();
    	}
    	
    	//將list轉為array塞入comobox modle當項目
    	empArray = new String[empList.size()];
    	for(int i = 0; i < empArray.length; i++) {
    		empArray[i] = empList.get(i);
    	}    	
    	
    	venArray = new String[venList.size()];
    	for(int j = 0; j < venArray.length; j++) {
    		venArray[j] = venList.get(j);
    	}
    	
    	matArray = new String[matList.size()];
    	for(int k = 0; k < matArray.length; k++) {
    		if(k==0){}
    		matArray[k] = matList.get(k);
    	}
    	
    	Arrays.sort(empArray);
    	Arrays.sort(venArray);
    	Arrays.sort(matArray);
    	
    }
    
  //取得輸入資料
    protected boolean getSelect(){ 
    	boolean isRightData = false;
    	//get textfield content
    	purid = purchaseNum_Purc.getText();
    	purQty = qty_Purc.getText();
    	purPrice = price_Purc.getText();
    	note = note_Purc.getText();   
    	
    	//get picking unit
    	pUnit = (String)unit_Purc.getSelectedItem();
    	
    	//get jdateChooser value
    	purDate  = ((JTextField)purchaseDate_Purc.getDateEditor().getUiComponent()).getText();
    
    	//combobox get selected  & use combobox get empName-->in each listener
    	if (purid.equals("") || purQty.equals("") || purPrice.equals("") || vendorNo.equals("") || materilNo.equals("")
			|| empNo.equals("")||purDate.equals("") || pUnit.equals("")) {
			isRightData = false;
		} else {
			isRightData = true;
		}
		return isRightData;
    }

    protected int insertDB(){
    	int isInsert = 0;
    	if (getSelect() == true) {
	    	String sql = "insert into purchase(purchaseNum,materialNum,purchaseDate,vendorNum,qty,"
	    			+ "price,employeeNum,note,unit) values(?,?,?,?,?,?,?,?,?)";    	
	    	try{	    			    		
		    	PreparedStatement insertdb = conn.prepareStatement(sql); 
		    	insertdb.setString(1, purid);
		    	insertdb.setString(2, materilNo);
		    	insertdb.setString(3, purDate);
		    	insertdb.setString(4, vendorNo);
		    	insertdb.setString(5, purQty);
		    	insertdb.setString(6, purPrice);
		    	insertdb.setString(7, empNo);
		    	insertdb.setString(8, note);	
		    	insertdb.setString(9, pUnit);
		    	isInsert = insertdb.executeUpdate();
	    	}catch(Exception a){
	    		System.out.println("insertDB error");
	    		a.printStackTrace();
	    	}
    	}
    	return isInsert;
    }
    
    // Variables declaration - do not modify                     
    private javax.swing.JLabel SQLID;
    private javax.swing.JLabel employName_Purc;
    private javax.swing.JComboBox<String> employNum_Purc;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JLabel materialName_Purc;
    private javax.swing.JComboBox<String> materialNum_Purc;
    private javax.swing.JTextArea note_Purc;
    private javax.swing.JTextField price_Purc;
    private com.toedter.calendar.JDateChooser purchaseDate_Purc;
    private javax.swing.JLabel purchaseLabel01;
    private javax.swing.JLabel purchaseLabel02;
    private javax.swing.JLabel purchaseLabel03;
    private javax.swing.JLabel purchaseLabel04;
    private javax.swing.JLabel purchaseLabel05;
    private javax.swing.JLabel purchaseLabel06;
    private javax.swing.JLabel purchaseLabel07;
    private javax.swing.JLabel purchaseLabel08;
    private javax.swing.JTextField purchaseNum_Purc;
    private javax.swing.JTextField qty_Purc;
    private javax.swing.JLabel showInfo;
    private javax.swing.JLabel vendorName_Purc;
    private javax.swing.JComboBox<String> vendorNum_Purc;
    private javax.swing.JComboBox<String> unit_Purc;
    // End of variables declaration                   
}
