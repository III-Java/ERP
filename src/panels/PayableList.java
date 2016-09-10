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
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Properties;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JTextField;

/**
* @author Veronica.C
*/
public class PayableList extends javax.swing.JPanel {
	private Connection conn;
	private List<String> venList, purList, paywithList;  
	private String venArray[], purArray[],  paywithArray[];
	private String payableListID =null, vendorNum=null, transactionDate=null, payDue=null, amount=null,
			       note=null, purchaseNum=null, payDate=null, actualPayAmount=null, discount="0", payWith=null, ifClose="N";
	private String vendorName=null, payListId=null;
	private boolean repeatPurNum =false, editRepeat=true;

    public PayableList(Connection connection) {
    	this.conn = connection;
//    	databaseConnect();
    	venList = new ArrayList<String>(); //產生List裝id
    	purList = new ArrayList<String>(); //產生List裝id
    	paywithList = new ArrayList<String>(); //產生List裝id
    	venList.add("");  purList.add(""); paywithList.add("");
    	getEmpIdlist();
        initComponents();
    }    
   

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">                          
    private void initComponents() {

        purchaseLabel01 = new javax.swing.JLabel();
        purchaseLabel02 = new javax.swing.JLabel();
        purchaseLabel03 = new javax.swing.JLabel();
        purchaseLabel04 = new javax.swing.JLabel();
        purchaseLabel05 = new javax.swing.JLabel();
        purchaseLabel06 = new javax.swing.JLabel();
        amount_Accn = new javax.swing.JTextField();
        purchaseLabel07 = new javax.swing.JLabel();
        actualPayAmount_Accn = new javax.swing.JTextField();
        purchaseLabel08 = new javax.swing.JLabel();
        jScrollPane4 = new javax.swing.JScrollPane();
        note_Accn = new javax.swing.JTextArea();
        purchaseNum_Accn = new javax.swing.JComboBox<>();
        payDue_Accn = new com.toedter.calendar.JDateChooser();
        payDate_Accn = new com.toedter.calendar.JDateChooser();
        purchaseLabel8 = new javax.swing.JLabel();
        purchaseLabel9 = new javax.swing.JLabel();
        discount_Accn = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        ifClose_Accn = new javax.swing.JLabel();
        vendorName_Accn = new javax.swing.JLabel();
        payWith_Accn = new javax.swing.JComboBox<>();
        payableListID_Accn = new javax.swing.JLabel();
        vendorNum_Accn = new javax.swing.JComboBox<>();
        transactionDate_Accn = new com.toedter.calendar.JDateChooser();

        setMinimumSize(new java.awt.Dimension(980, 470));
        setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        purchaseLabel01.setFont(new java.awt.Font("微軟正黑體", 0, 15)); // NOI18N
        purchaseLabel01.setText("廠商編號");
        add(purchaseLabel01, new org.netbeans.lib.awtextra.AbsoluteConstraints(65, 51, -1, 32));

        purchaseLabel02.setFont(new java.awt.Font("微軟正黑體", 0, 15)); // NOI18N
        purchaseLabel02.setText("進貨單號");
        add(purchaseLabel02, new org.netbeans.lib.awtextra.AbsoluteConstraints(65, 121, -1, 30));

        purchaseLabel03.setFont(new java.awt.Font("微軟正黑體", 0, 15)); // NOI18N
        purchaseLabel03.setText("交易日期");
        add(purchaseLabel03, new org.netbeans.lib.awtextra.AbsoluteConstraints(65, 186, -1, 30));

        purchaseLabel04.setFont(new java.awt.Font("微軟正黑體", 0, 15)); // NOI18N
        purchaseLabel04.setText("應付日期");
        add(purchaseLabel04, new org.netbeans.lib.awtextra.AbsoluteConstraints(65, 255, -1, 30));

        purchaseLabel05.setFont(new java.awt.Font("微軟正黑體", 0, 15)); // NOI18N
        purchaseLabel05.setText("沖帳日期");
        add(purchaseLabel05, new org.netbeans.lib.awtextra.AbsoluteConstraints(488, 51, -1, 30));

        purchaseLabel06.setFont(new java.awt.Font("微軟正黑體", 0, 15)); // NOI18N
        purchaseLabel06.setText("應付金額");
        purchaseLabel06.setToolTipText("");
        add(purchaseLabel06, new org.netbeans.lib.awtextra.AbsoluteConstraints(65, 320, -1, 30));

        amount_Accn.setFont(new java.awt.Font("微軟正黑體", 0, 14)); // NOI18N
       //key check
        amount_Accn.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                amount_AccnKeyTyped(evt);
            }
        });
        add(amount_Accn, new org.netbeans.lib.awtextra.AbsoluteConstraints(155, 320, 180, 30));

        purchaseLabel07.setFont(new java.awt.Font("微軟正黑體", 0, 15)); // NOI18N
        purchaseLabel07.setText("沖帳金額");
        add(purchaseLabel07, new org.netbeans.lib.awtextra.AbsoluteConstraints(488, 118, -1, 30));

        actualPayAmount_Accn.setFont(new java.awt.Font("微軟正黑體", 0, 14)); // NOI18N
        //key check
        actualPayAmount_Accn.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                actualPayAmount_AccnKeyTyped(evt);
            }
        });
        add(actualPayAmount_Accn, new org.netbeans.lib.awtextra.AbsoluteConstraints(614, 120, 216, 30));

        purchaseLabel08.setFont(new java.awt.Font("微軟正黑體", 0, 15)); // NOI18N
        purchaseLabel08.setText("備註");
        add(purchaseLabel08, new org.netbeans.lib.awtextra.AbsoluteConstraints(485, 333, 111, 30));

        note_Accn.setColumns(20);
        note_Accn.setFont(new java.awt.Font("微軟正黑體", 0, 14)); // NOI18N
        note_Accn.setRows(5);
        jScrollPane4.setViewportView(note_Accn);

        add(jScrollPane4, new org.netbeans.lib.awtextra.AbsoluteConstraints(614, 323, 348, -1));

        purchaseNum_Accn.setFont(new java.awt.Font("微軟正黑體", 0, 15)); // NOI18N
        purchaseNum_Accn.setModel(new DefaultComboBoxModel(purArray));      
//        purchaseNum_Accn.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        add(purchaseNum_Accn, new org.netbeans.lib.awtextra.AbsoluteConstraints(155, 121, 180, 30));
        
        payDue_Accn.setDateFormatString("yyyy/MM/dd");
        payDue_Accn.setFont(new java.awt.Font("微軟正黑體", 0, 15)); // NOI18N
        add(payDue_Accn, new org.netbeans.lib.awtextra.AbsoluteConstraints(155, 255, 180, 30));

        payDate_Accn.setDateFormatString("yyyy/MM/dd");
        payDate_Accn.setFont(new java.awt.Font("微軟正黑體", 0, 15)); // NOI18N
        add(payDate_Accn, new org.netbeans.lib.awtextra.AbsoluteConstraints(614, 51, 216, 30));

        purchaseLabel8.setFont(new java.awt.Font("微軟正黑體", 0, 15)); // NOI18N
        purchaseLabel8.setText("付款方式");
        add(purchaseLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(485, 254, -1, 30));

        purchaseLabel9.setFont(new java.awt.Font("微軟正黑體", 0, 15)); // NOI18N
        purchaseLabel9.setText("沖帳折讓金額");
        add(purchaseLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(488, 186, -1, 30));

        discount_Accn.setFont(new java.awt.Font("微軟正黑體", 0, 14)); // NOI18N       
        //key check
        discount_Accn.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                discount_AccnKeyTyped(evt);
            }
        });
        add(discount_Accn, new org.netbeans.lib.awtextra.AbsoluteConstraints(614, 188, 216, 30));

        jLabel1.setFont(new java.awt.Font("微軟正黑體", 0, 15)); // NOI18N
        jLabel1.setText("結案Y/N");
        add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(65, 389, 72, -1));

        ifClose_Accn.setFont(new java.awt.Font("微軟正黑體", 0, 15)); // NOI18N
        ifClose_Accn.setForeground(new java.awt.Color(255, 51, 51));
        ifClose_Accn.setText("N");
        add(ifClose_Accn, new org.netbeans.lib.awtextra.AbsoluteConstraints(155, 386, 180, 30));

        vendorName_Accn.setFont(new java.awt.Font("微軟正黑體", 0, 15)); // NOI18N
        vendorName_Accn.setText("廠商名稱");
        add(vendorName_Accn, new org.netbeans.lib.awtextra.AbsoluteConstraints(350, 51, 110, 32));

        payWith_Accn.setFont(new java.awt.Font("微軟正黑體", 0, 15)); // NOI18N
//        payWith_Accn.setModel(new DefaultComboBoxModel(paywithArray));
//        payWith_Accn.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        payWith_Accn.setMinimumSize(new java.awt.Dimension(73, 30));
        payWith_Accn.setPreferredSize(new java.awt.Dimension(73, 30));
        add(payWith_Accn, new org.netbeans.lib.awtextra.AbsoluteConstraints(614, 256, 216, -1));

        payableListID_Accn.setFont(new java.awt.Font("微軟正黑體", 0, 15)); // NOI18N
        payableListID_Accn.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
//        payableListID_Accn.setText("應付帳款單號");
        add(payableListID_Accn, new org.netbeans.lib.awtextra.AbsoluteConstraints(818, 21, 147, -1));

        vendorNum_Accn.setFont(new java.awt.Font("微軟正黑體", 0, 15)); // NOI18N
        vendorNum_Accn.setModel(new DefaultComboBoxModel(venArray));
//        vendorNum_Accn.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        vendorNum_Accn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                vendorNum_AccnActionPerformed(evt);
            }
        });
        add(vendorNum_Accn, new org.netbeans.lib.awtextra.AbsoluteConstraints(155, 51, 180, 32));

        transactionDate_Accn.setDateFormatString("yyyy/MM/dd");
        transactionDate_Accn.setFont(new java.awt.Font("微軟正黑體", 0, 15)); // NOI18N
        add(transactionDate_Accn, new org.netbeans.lib.awtextra.AbsoluteConstraints(155, 186, 180, 30));
    }// </editor-fold>    
    //key in judge
    private void amount_AccnKeyTyped(java.awt.event.KeyEvent evt) {                                     
    	char c = evt.getKeyChar();
        if(!(Character.isDigit(c)) || (c == KeyEvent.VK_SPACE) || (c == KeyEvent.VK_DELETE)){
            getToolkit().beep();
            evt.consume();
        }
    }                                    

    private void actualPayAmount_AccnKeyTyped(java.awt.event.KeyEvent evt) {                                              
    	char c = evt.getKeyChar();
        if(!(Character.isDigit(c)) || (c == KeyEvent.VK_SPACE) || (c == KeyEvent.VK_DELETE)){
            getToolkit().beep();
            evt.consume();
        }
    }                                             

    private void discount_AccnKeyTyped(java.awt.event.KeyEvent evt) {                                       
    	char c = evt.getKeyChar();
        if(!(Character.isDigit(c)) || (c == KeyEvent.VK_SPACE) || (c == KeyEvent.VK_DELETE)){
            getToolkit().beep();
            evt.consume();
        }
    }      

    private void vendorNum_AccnActionPerformed(java.awt.event.ActionEvent evt) { 
    	paywithList.clear();//未送出,再次選擇下拉選單前要清空 
    	paywithList.add("");
    	vendorName();
    }  
    
    private void vendorName(){
    	vendorNum = (String) vendorNum_Accn.getSelectedItem();
    	if(vendorNum.length()>0){
    		generateInfo();//帶出對應名稱
    	}
    }
    
    
    
    private void generateInfo(){ //帶出對應名稱
    	//select * from employee where employeeNum = employID
    	try {
			PreparedStatement getVen = conn.prepareStatement("select * from vendor where vendorNum="+vendorNum);
    		ResultSet rs = getVen.executeQuery();
			while(rs.next()){				
				vendorName = rs.getString("vendorName");	
				String idList3 = rs.getString("paymentTerm");
				vendorName_Accn.setText(vendorName);				
				
				paywithList.add(idList3);
				paywithArray = new String[paywithList.size()];
		    	for(int i = 0; i < paywithArray.length; i++) {
		    		paywithArray[i] = paywithList.get(i);
		    	}
		    	Arrays.sort(paywithArray);
		        payWith_Accn.setModel(new DefaultComboBoxModel(paywithArray));
			}	
    	} catch (Exception e) {
			System.out.println("sql-01 check");
			e.printStackTrace();
		}
    }    
   
    protected boolean checkPIdrepeat(){
    	repeatPurNum=false;
    	try{
	    	PreparedStatement stat = conn.prepareStatement("select * from payablelist where purchaseNum='"+purchaseNum+"'");
	    	ResultSet rs = stat.executeQuery();
    		while(rs.next()){
    			repeatPurNum =true;
    			break;
    		}
    	}catch(Exception a){
    		System.out.println("checkPIdrepeat xx");
    		a.printStackTrace();
    	}    	
    	return repeatPurNum;
    }
    
    //check if select row is close
    protected boolean rowClose(){
    	String sClose =null;
    	int id2 = Integer.parseInt(payableListID_Accn.getText());
    	try{
	    	PreparedStatement stat = conn.prepareStatement("select * from payablelist where payableListID="+id2);
	    	ResultSet rs = stat.executeQuery();
	    	while(rs.next()){
	    		sClose = rs.getString("ifClose");
	    	}
    	}catch(Exception a){
    		System.out.println("rowClose xx");
    		a.printStackTrace();
    	}    	
    	if(sClose.equals("Y")){
    		return true;
    	}    	
    	return false;
    }
    
    //check if pay equals to payable amount
    protected int payCheck(){ //check this before edit and insert    	
    	getSelect();  
    	int ifPayOk =-2; //-1 pay less, 0 pay ok, 2 pay more;
    	if(discount.equals("")){
    		discount ="0";
    	}
    	
    	if(actualPayAmount.equals("")){
    		actualPayAmount ="0";
    	}
    	
    	int payBalance = Integer.parseInt(amount) - (Integer.parseInt(actualPayAmount) + Integer.parseInt(discount));
    	
    	
		if(payBalance == 0){
	    	ifClose_Accn.setText("Y");
	    	ifClose="Y";
	    	ifPayOk =0;	    	
	    }else if(payBalance < 0){//pay more
	    	ifClose_Accn.setText("N");
	    	ifClose="N";
	    	ifPayOk = 9;
	    }else if(payBalance > 0){ //pay less
	    	ifClose_Accn.setText("N");
	    	ifClose="N";
	    	ifPayOk =-1;
	    }
	    return ifPayOk;
    }
    //get input data
    protected boolean getSelect(){  
    	boolean isRightData = false;
    	//get remark content
    	amount = amount_Accn.getText();
    	actualPayAmount = actualPayAmount_Accn.getText();
    	discount = discount_Accn.getText();
    	note = note_Accn.getText();
    	
    	//get jdateChooser value
    	transactionDate  = ((JTextField)transactionDate_Accn.getDateEditor().getUiComponent()).getText();    	
    	payDue  = ((JTextField)payDue_Accn.getDateEditor().getUiComponent()).getText();    	
    	payDate  = ((JTextField)payDate_Accn.getDateEditor().getUiComponent()).getText();    	

    	//combobox get selected & use combobox get empName----->apply in actionListener  
    	purchaseNum = (String) purchaseNum_Accn.getSelectedItem();
    	payWith = (String) payWith_Accn.getSelectedItem();
    	
    	//get PId
    	payableListID = payableListID_Accn.getText();
    	
    	//結案的判斷要寫
    	ifClose = ifClose_Accn.getText();      	
    	
    	if (amount.equals("") || transactionDate.equals("") || payDue.equals("")
			||purchaseNum.equals("")|| vendorNum.equals("")) {
			isRightData = false;
		} else {
			isRightData = true;
		}
		return isRightData;
}
    
    protected int insertDB(){
    	int isInsert = 0;    	
    	if (getSelect() == true) {
    		//check if payId repeat
    		checkPIdrepeat();    		
    		payCheck();
    		if(payDate.equals("") & !repeatPurNum){// paydate blank
		    	String sql = "insert into payablelist("
		    			+ "vendorNum,transactionDate,payDue,amount,note,purchaseNum,"
		    			+ "actualPayAmount,discount,payWith,ifClose) "
		    			+ "values(?,?,?,?,?,?,?,?,?,?)";    
		  	 	try{	    			    		
			    	PreparedStatement insertdb = conn.prepareStatement(sql); 
			    	insertdb.setString(1, vendorNum);
			    	insertdb.setString(2, transactionDate);
			    	insertdb.setString(3, payDue);
			    	insertdb.setString(4, amount);
			    	insertdb.setString(5, note);
			    	insertdb.setString(6, purchaseNum);
			    	insertdb.setString(7, actualPayAmount);
			    	insertdb.setString(8, discount);
			    	insertdb.setString(9, payWith);
			    	insertdb.setString(10, ifClose);
			    	
			    	isInsert = insertdb.executeUpdate();
		    	}catch(Exception a){
		    		System.out.println("insertDB01 error");
		    		a.printStackTrace();
		    	}
	    	}else if(!payDate.equals("") & !repeatPurNum){
		    	String sql = "insert into payablelist("
		    			+ "vendorNum,transactionDate,payDue,amount,note,purchaseNum,"
		    			+ "payDate,actualPayAmount,discount,payWith,ifClose) "
		    			+ "values(?,?,?,?,?,?,?,?,?,?,?)";  
		  	 	try{	    			    		
			    	PreparedStatement insertdb = conn.prepareStatement(sql); 
			    	insertdb.setString(1, vendorNum);
			    	insertdb.setString(2, transactionDate);
			    	insertdb.setString(3, payDue);
			    	insertdb.setString(4, amount);
			    	insertdb.setString(5, note);
			    	insertdb.setString(6, purchaseNum);
			    	insertdb.setString(7, payDate);
			    	insertdb.setString(8, actualPayAmount);
			    	insertdb.setString(9, discount);
			    	insertdb.setString(10, payWith);
			    	insertdb.setString(11, ifClose);
			    	
			    	isInsert = insertdb.executeUpdate();
		    	}catch(Exception a){
		    		System.out.println("insertDB02 error");
		    		a.printStackTrace();
		    	}
	    	}
    	}
  	 	return isInsert;
    }
    
    //判斷edit那一筆id變更後的purN是否一樣，一樣ok,不一樣要check資料庫是否有重覆purN
    protected int ifEditPurRepeat(){
    	int nowWhat =0;
    	String pID = payableListID_Accn.getText();
    	String newPurN = (String)purchaseNum_Accn.getSelectedItem();
    	String oldPurN =null;
    	try{
    		PreparedStatement prep = conn.prepareStatement("select * from payablelist where payableListID='"+pID+"'");
    		ResultSet rs = prep.executeQuery();
    		while(rs.next()){
    			oldPurN = rs.getString("purchaseNum");
    			break;
    		}
    		if(newPurN.equals(oldPurN)){//edit前後的單號相同 
    			nowWhat = 1; //不重覆可編輯
    		}else if(!newPurN.equals(oldPurN)){//edit前後的單號不相同
    			boolean sqlRepeat = false;
    			try{
    				PreparedStatement prep2 = conn.prepareStatement("select * from payablelist where purchaseNum='"+newPurN+"'");
    				ResultSet rs2 = prep2.executeQuery();
    				while(rs2.next()){ //check是否sql有相同採購單 
    					nowWhat = 2; //edit前後的單號不相同，且資料庫已有相同單據號碼，不給編輯
    					sqlRepeat = true;
    					break;
    				}    		
    				
	    			if(!sqlRepeat){
	    				nowWhat = 3;//edit前後的單號不相同,但資料庫無相同單據號碼，可編輯
	    			}
    			}catch(Exception a){
    				System.out.println("ifEditPurRepeat xxx 02");
    				a.printStackTrace();
    			}
    		}
    	}catch(Exception a){
    		System.out.println("ifEditPurRepeat xx");
    		a.printStackTrace();
    	}
    	return nowWhat;
    }
    
    
    protected int editDB(){  
		int isUpdate = 0;
		if (getSelect() == true) {
			payCheck();
			int nowWhatRs = ifEditPurRepeat(); //1可編輯  2 不給編輯  3可編輯
			if(nowWhatRs == 1 || nowWhatRs ==3){
		       	String sql = "update payablelist set vendorNum=?, transactionDate=?, payDue=?, amount=?, note=?, purchaseNum=?, "
		    			+ "payDate=?, actualPayAmount=?, discount=?, payWith=?, ifClose=? where payableListID="+payableListID;    
			 	try{	    			    		
			    	PreparedStatement editdb = conn.prepareStatement(sql); 
			    	editdb.setString(1, vendorNum);
			    	editdb.setString(2, transactionDate);
			    	editdb.setString(3, payDue);
			    	editdb.setString(4, amount);
			    	editdb.setString(5, note);
			    	editdb.setString(6, purchaseNum);
			    	editdb.setString(7, payDate);
			    	editdb.setString(8, actualPayAmount);
			    	editdb.setString(9, discount);
			    	editdb.setString(10, payWith);
			    	editdb.setString(11, ifClose);
			    	
			    	isUpdate = editdb.executeUpdate();
		      	}catch(Exception a){
			    		System.out.println("editDB error");
			    		a.printStackTrace();
			    }  
			}
		}
		return isUpdate;
    }
    
	protected int delData(){		
		int isDel = 0;
		
		String id = payableListID_Accn.getText();
		String ifCloseSQL ="";
		//結案不能刪
		PreparedStatement pstmt;
		try{
			pstmt = conn.prepareStatement("select * from payablelist WHERE payableListID = ?");
			pstmt.setString(1, id);
			ResultSet rs =  pstmt.executeQuery();
			while(rs.next()){
				ifCloseSQL = rs.getString("ifClose");
			}
		}
		catch(SQLException ee){
			System.out.println(ee.toString());
		}
				
		if(!ifCloseSQL.equals("Y")){
			if(!payableListID_Accn.getText().equals("")){
				try{
					pstmt = conn.prepareStatement("DELETE FROM payablelist WHERE payableListID = ?");
					pstmt.setString(1, payableListID_Accn.getText());
					isDel = pstmt.executeUpdate();
				}
				catch(SQLException ee){
					System.out.println(ee.toString());
				}
			}
		}
		
		return isDel;
	}
	
	protected  LinkedList<String[]> search(String value){
		LinkedList<String[]> data = new LinkedList<>();
		try{
			PreparedStatement pstmt = conn.prepareStatement("SELECT * FROM payablelist WHERE payableListID LIKE ? OR vendorNum LIKE ? OR transactionDate LIKE ?"
					+ " OR payDue LIKE ? OR amount LIKE ? OR payWith LIKE ? OR purchaseNum LIKE ? OR payDate LIKE ? OR actualPayAmount LIKE ?"
					+ " OR discount LIKE ? OR ifClose LIKE ? OR note LIKE ?");
			String query = "%" + value +"%";
			for(int i=1 ; i<13; i++){
				pstmt.setString(i, query);
			}
			ResultSet rs = pstmt.executeQuery();
			while (rs.next()) {
				String[] row = new String [12];		    		
	    		row [0] = rs.getString("payableListID");
	    		row [1] = rs.getString("vendorNum");
	    		row [2] = rs.getString("transactionDate");
	    		row [3] = rs.getString("payDue");
	    		row [4] = rs.getString("amount");
	    		row [5] = rs.getString("payWith");
	    		row [6] = rs.getString("purchaseNum");
	    		row [7] = rs.getString("payDate");	 
	    		row [8] = rs.getString("actualPayAmount");
	    		row [9] = rs.getString("discount");
	    		row [10] = rs.getString("ifClose");
	    		row [11] = rs.getString("note"); 
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
			PreparedStatement pstmt = conn.prepareStatement("SELECT * FROM payablelist");
			ResultSet rs = pstmt.executeQuery();
	    	while(rs.next()){
	    		String[] row = new String [12];		    		
	    		row [0] = rs.getString("payableListID");
	    		row [1] = rs.getString("vendorNum");
	    		row [2] = rs.getString("transactionDate");
	    		row [3] = rs.getString("payDue");
	    		row [4] = rs.getString("amount");
	    		row [5] = rs.getString("payWith");
	    		row [6] = rs.getString("purchaseNum");
	    		row [7] = rs.getString("payDate");	 
	    		row [8] = rs.getString("actualPayAmount");
	    		row [9] = rs.getString("discount");
	    		row [10] = rs.getString("ifClose");
	    		row [11] = rs.getString("note"); 		
	    		data.add(row);
			}
		}
		catch(SQLException ee){			
			System.out.println("pay_query"+ee.toString());
		}
		return data;
    }
    
    protected void setInputValue(HashMap<Integer, String> data) {
    	payableListID_Accn.setText(data.get(0));   	
    	
    	vendorNum_Accn.setSelectedItem(data.get(1));
    	vendorName();
    	
    	purchaseNum_Accn.setSelectedItem(data.get(6));

    	try {
			java.util.Date date = new SimpleDateFormat("yyyy/MM/dd").parse(data.get(2));
			transactionDate_Accn.setDate(date);
			
			java.util.Date date2 = new SimpleDateFormat("yyyy/MM/dd").parse(data.get(3));
			payDue_Accn.setDate(date2);	
			
			if(data.get(7) != null){
			java.util.Date date3 = new SimpleDateFormat("yyyy/MM/dd").parse(data.get(7));
			payDate_Accn.setDate(date3);
			}else{
				payDate_Accn.setDate(null);
			}
			
    	} catch (ParseException e) {
			e.printStackTrace();
		}
    	
    	amount_Accn.setText(data.get(4));
    	ifClose_Accn.setText(data.get(10));
    	actualPayAmount_Accn.setText(data.get(8));
    	discount_Accn.setText(data.get(9));  
    	if(data.get(5)!=null){
    		payWith_Accn.setSelectedItem(data.get(5)); 
    	}
    	note_Accn.setText(data.get(11));
	}
    
//  抓到資料庫人員id資料塞入list
    private void getEmpIdlist(){
    	try{
	    	PreparedStatement getId = conn.prepareStatement("select * from vendor");
	    	ResultSet rs = getId.executeQuery();
	    	while(rs.next()){
	    		String idList = rs.getString("vendorNum");
//	    		String idList3 = rs.getString("paymentTerm");
	    		venList.add(idList);
//	    		paywithList.add(idList3);
	    	}
	    	
	    	PreparedStatement getId2 = conn.prepareStatement("select * from purchase");
	    	ResultSet rs2 = getId2.executeQuery();
	    	while(rs2.next()){
	    		String idList2 = rs2.getString("purchaseNum");
	    		purList.add(idList2);
	    	}	    	
	    	
    	}catch(Exception e){
    		System.out.println("getEmpIdlist error");
    		e.printStackTrace();
    	}
    	
    	//將list轉為array塞入comobox modle當項目
    	venArray = new String[venList.size()];
    	for(int i = 0; i < venArray.length; i++) {
    		venArray[i] = venList.get(i);
    	}
    	
    	purArray = new String[purList.size()];
    	for(int i = 0; i < purArray.length; i++) {
    		purArray[i] = purList.get(i);
    	}    	
    	
    	Arrays.sort(venArray);
    	Arrays.sort(purArray);
    }
    
    protected void getDefault(){
//    	paywithList.add(""); payWith_Accn.setModel(new DefaultComboBoxModel(paywithArray));
    	vendorName_Accn.setText("");
    	transactionDate_Accn.setCalendar(null);
    	payDue_Accn.setCalendar(null);
    	payDate_Accn.setCalendar(null);
    	amount_Accn.setText("");
    	actualPayAmount_Accn.setText("");
    	discount_Accn.setText("");
    	note_Accn.setText("");
    	payableListID =null; vendorNum=null; transactionDate=null; payDue=null; amount=null;
    	note=null; purchaseNum=null; payDate=null; actualPayAmount=null; discount="0"; payWith=null; ifClose=null;
    	vendorName=null; payableListID_Accn.setText(""); ifClose_Accn.setText("N");
    	vendorNum_Accn.setSelectedIndex(0);
    	purchaseNum_Accn.setSelectedIndex(0); 
    	if(paywithArray != null){
    		payWith_Accn.setSelectedIndex(0);
    	}
    	repeatPurNum =false; editRepeat=true;
    }

    // Variables declaration - do not modify                     
    private javax.swing.JTextField actualPayAmount_Accn;
    private javax.swing.JTextField amount_Accn;
    private javax.swing.JTextField discount_Accn;
    private javax.swing.JLabel ifClose_Accn;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JTextArea note_Accn;
    private com.toedter.calendar.JDateChooser payDate_Accn;
    private com.toedter.calendar.JDateChooser payDue_Accn;
    private com.toedter.calendar.JDateChooser transactionDate_Accn;
    private javax.swing.JComboBox<String> payWith_Accn;
    private javax.swing.JLabel payableListID_Accn;
    private javax.swing.JLabel purchaseLabel01;
    private javax.swing.JLabel purchaseLabel02;
    private javax.swing.JLabel purchaseLabel03;
    private javax.swing.JLabel purchaseLabel04;
    private javax.swing.JLabel purchaseLabel05;
    private javax.swing.JLabel purchaseLabel06;
    private javax.swing.JLabel purchaseLabel07;
    private javax.swing.JLabel purchaseLabel08;
    private javax.swing.JLabel purchaseLabel8;
    private javax.swing.JLabel purchaseLabel9;
    private javax.swing.JComboBox<String> purchaseNum_Accn;
    private javax.swing.JButton testBtn;
    private javax.swing.JLabel vendorName_Accn;
    private javax.swing.JComboBox<String> vendorNum_Accn;
    // End of variables declaration                   
}
