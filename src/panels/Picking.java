package panels;
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
public class Picking extends javax.swing.JPanel {
	private Connection conn;
	private List<String> empList, matList;  
	private String empArray[], matArray[];
	private String unitArray[] = {"","公斤", "台斤","包","個","組","公升","罐","支"};
	private String id=null, matNum=null, pqty=null, pUnit=null,empNum=null, 
			pickDate=null, note=null, stockQty=null;
	private String employeeN=null, materialN=null;
	private boolean noStock =false;
	private int editchangeQty=0, editQty=0;
	
    public Picking(Connection connection) {
    	this.conn = connection;
//    	databaseConnect();
    	empList = new ArrayList<String>(); //產生List裝id
    	matList = new ArrayList<String>();
    	empList.add(""); 
    	matList.add("");
    	getIdtoCombolist();//抓到資料庫id資料塞入list
        initComponents();
    }
    //領料記錄表

    @SuppressWarnings("unchecked")
    private void initComponents() {
        jPanel1 = new javax.swing.JPanel();
        pickingLabel01 = new javax.swing.JLabel();
        pickingid = new javax.swing.JLabel();
        pickingDate = new com.toedter.calendar.JDateChooser();
        pickingLabel04 = new javax.swing.JLabel();
        pickingLabel03 = new javax.swing.JLabel();
        pickingLabel0２ = new javax.swing.JLabel();
        materialNum = new javax.swing.JComboBox<>();
        materialName = new javax.swing.JLabel();
        employeeNum = new javax.swing.JComboBox<>();
        employeeName = new javax.swing.JLabel();
        pickingLabel05 = new javax.swing.JLabel();
        pickingLabel06 = new javax.swing.JLabel();
        pickingqty = new javax.swing.JSpinner();
        pickingLabel07 = new javax.swing.JLabel();
        pickingUnit = new javax.swing.JComboBox<>();
        jScrollPane1 = new javax.swing.JScrollPane();
        remark_picking = new javax.swing.JTextArea();
        jLabel1 = new javax.swing.JLabel();
        stockNum = new javax.swing.JLabel();

        setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel1.setMinimumSize(new java.awt.Dimension(980, 470));
        jPanel1.setPreferredSize(new java.awt.Dimension(980, 470));
        jPanel1.setRequestFocusEnabled(false);
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        pickingLabel01.setFont(new java.awt.Font("微軟正黑體", 0, 15)); // NOI18N
        pickingLabel01.setText("領料單ID");
        jPanel1.add(pickingLabel01, new org.netbeans.lib.awtextra.AbsoluteConstraints(65, 53, -1, 30));

        pickingid.setFont(new java.awt.Font("微軟正黑體", 0, 15)); // NOI18N
        pickingid.setForeground(new java.awt.Color(0, 0, 153));
        jPanel1.add(pickingid, new org.netbeans.lib.awtextra.AbsoluteConstraints(173, 53, 180, 30));

        pickingDate.setFont(new java.awt.Font("微軟正黑體", 0, 15)); // NOI18N
        jPanel1.add(pickingDate, new org.netbeans.lib.awtextra.AbsoluteConstraints(620, 140, 282, 30));

        pickingLabel04.setFont(new java.awt.Font("微軟正黑體", 0, 15)); // NOI18N
        pickingLabel04.setText("備註");
        jPanel1.add(pickingLabel04, new org.netbeans.lib.awtextra.AbsoluteConstraints(530, 320, 88, 31));

        pickingLabel03.setFont(new java.awt.Font("微軟正黑體", 0, 15)); // NOI18N
        pickingLabel03.setText("領料人員");
        jPanel1.add(pickingLabel03, new org.netbeans.lib.awtextra.AbsoluteConstraints(65, 310, 73, 30));

        pickingLabel0２.setFont(new java.awt.Font("微軟正黑體", 0, 15)); // NOI18N
        pickingLabel0２.setText("原料編號");
        jPanel1.add(pickingLabel0２, new org.netbeans.lib.awtextra.AbsoluteConstraints(65, 138, 88, 30));

        materialNum.setFont(new java.awt.Font("微軟正黑體", 0, 15)); // NOI18N
//        materialNum.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        materialNum.setModel(new DefaultComboBoxModel(matArray));
        materialNum.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                materialNumActionPerformed(evt);
            }
        });
        jPanel1.add(materialNum, new org.netbeans.lib.awtextra.AbsoluteConstraints(171, 138, 180, 30));

        materialName.setFont(new java.awt.Font("微軟正黑體", 0, 15)); // NOI18N
        jPanel1.add(materialName, new org.netbeans.lib.awtextra.AbsoluteConstraints(366, 138, 160, 30));

        employeeNum.setFont(new java.awt.Font("微軟正黑體", 0, 15)); // NOI18N
//        employeeNum.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        employeeNum.setModel(new DefaultComboBoxModel(empArray));
        employeeNum.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                employeeNumActionPerformed(evt);
            }
        });
        jPanel1.add(employeeNum, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 310, 180, -1));

        employeeName.setFont(new java.awt.Font("微軟正黑體", 0, 15)); // NOI18N
        jPanel1.add(employeeName, new org.netbeans.lib.awtextra.AbsoluteConstraints(370, 310, 115, 31));

        pickingLabel05.setFont(new java.awt.Font("微軟正黑體", 0, 15)); // NOI18N
        pickingLabel05.setText("領料日期");
        jPanel1.add(pickingLabel05, new org.netbeans.lib.awtextra.AbsoluteConstraints(532, 138, 75, 30));

        pickingLabel06.setFont(new java.awt.Font("微軟正黑體", 0, 15)); // NOI18N
        pickingLabel06.setText("領料數量");
        jPanel1.add(pickingLabel06, new org.netbeans.lib.awtextra.AbsoluteConstraints(532, 226, 75, 31));

        pickingqty.setFont(new java.awt.Font("微軟正黑體", 0, 15)); // NOI18N
        jPanel1.add(pickingqty, new org.netbeans.lib.awtextra.AbsoluteConstraints(622, 229, 116, -1));

        pickingLabel07.setFont(new java.awt.Font("微軟正黑體", 0, 15)); // NOI18N
        pickingLabel07.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        pickingLabel07.setText("單位");
        jPanel1.add(pickingLabel07, new org.netbeans.lib.awtextra.AbsoluteConstraints(744, 226, -1, 33));

//        pickingUnit.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        pickingUnit.setModel(new DefaultComboBoxModel(unitArray));
        jPanel1.add(pickingUnit, new org.netbeans.lib.awtextra.AbsoluteConstraints(780, 229, 122, 30));

        remark_picking.setColumns(20);
        remark_picking.setFont(new java.awt.Font("微軟正黑體", 0, 14)); // NOI18N
        remark_picking.setRows(5);
        jScrollPane1.setViewportView(remark_picking);

        jPanel1.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(622, 316, 343, 139));

        jLabel1.setFont(new java.awt.Font("微軟正黑體", 0, 15)); // NOI18N
        jLabel1.setText("庫存量");
        jPanel1.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(65, 232, -1, -1));

        stockNum.setFont(new java.awt.Font("微軟正黑體", 0, 15)); // NOI18N
        jPanel1.add(stockNum, new org.netbeans.lib.awtextra.AbsoluteConstraints(171, 227, 180, 31));

        add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 980, 470));
    }
     
    
    private void materialNumActionPerformed(java.awt.event.ActionEvent evt) {                                            
    	matName();
    }         
    
    private void matName(){
    	matNum = (String)materialNum.getSelectedItem();
    	if(matNum.length()>0){//排除空白選項
	    	try {					
				PreparedStatement getMaterial = conn.prepareStatement("select * from material where materialNum="+matNum);
	    		ResultSet rs2 = getMaterial.executeQuery();
				while(rs2.next()){				
					materialN = rs2.getString("materialName");
					materialName.setText(materialN);
				}
		    	checkStock();
	    	} catch (Exception e) {
				System.out.println("getSelect error");
				e.printStackTrace();
			}
    	}
    }

    private void employeeNumActionPerformed(java.awt.event.ActionEvent evt) {                                            
    	empName();
    }     
   
    private void empName(){
    	empNum = (String)employeeNum.getSelectedItem();
    	if(empNum.length()>0){//排除空白選項
	        try {
				PreparedStatement getEmp = conn.prepareStatement("select * from employee where employeeNum="+empNum);
//				System.out.println(getEmp.toString());
	    		ResultSet rs = getEmp.executeQuery();
				while(rs.next()){				
					employeeN = rs.getString("name");				
					employeeName.setText(employeeN);							
				}
	        } catch (Exception e) {
				System.out.println("ActionPerformed error");
				e.printStackTrace();
			}
        }
    }
    
   
  //取得輸入資料
    protected boolean getSelect(){ 
    	boolean isRightData = false;
    	//get picking unit
    	pUnit = (String)pickingUnit.getSelectedItem();
    	
    	//get textfield content
    	note = remark_picking.getText();
    	pqty = (pickingqty.getValue()).toString(); 	
    	
    	//get jdateChooser value
    	pickDate  = ((JTextField)pickingDate.getDateEditor().getUiComponent()).getText();
    	
    	//combobox get selected  & use combobox get empName-->in each listener
    	if (matNum.equals("") || pqty.equals("") || empNum.equals("") || pickDate.equals("") ||pUnit.equals("")) {
			isRightData = false;
		} else {
			isRightData = true;
		}
		return isRightData;
    }
    
    protected void setInputValue(HashMap<Integer, String> data) {    	
    	pickingid.setText(data.get(0));
    	materialNum.setSelectedItem(data.get(1));
    	matName();
    	employeeNum.setSelectedItem(data.get(4));
    	empName();
    	pickingqty.setValue(Integer.parseInt(data.get(2)));		
    	pickingUnit.setSelectedItem(data.get(3));
		try {
			java.util.Date date = new SimpleDateFormat("yyyy/MM/dd").parse(data.get(5));
			pickingDate.setDate(date);
		} catch (ParseException e) {
			
			e.printStackTrace();
		}		
		remark_picking.setText(data.get(6));
	}
    
    protected LinkedList<String[]> queryData() {
    	getDefault();
		LinkedList<String[]> data = new LinkedList<>();
		try{
			PreparedStatement pstmt = conn.prepareStatement("SELECT * FROM picking");
			ResultSet rs = pstmt.executeQuery();
	    	while(rs.next()){	    
	    		String[] row = new String [7];	
	    		row [0] = rs.getString("pickingid");
	    		row [1] = rs.getString("materialNum");
	    		row [2] = rs.getString("pickingqty");
	    		row [3] = rs.getString("unit"); 
	    		row [4] = rs.getString("employeeNum");
	    		row [5] = rs.getString("pickingDate");
	    		row [6] = rs.getString("note");	    			
	    		data.add(row);
			}
		}
		catch(SQLException ee){			
			System.out.println("p_query"+ee.toString());
		}
		return data;
    }
        
    protected LinkedList<String[]> search(String value){
		LinkedList<String[]> data = new LinkedList<>();
		try{
			PreparedStatement pstmt = conn.prepareStatement("SELECT * FROM picking WHERE pickingid like ? OR materialNum like ? OR pickingqty like ?"
					+ " or unit like ? OR employeeNum like ? OR pickingDate like ? OR note like ? ");
			String query = "%" + value +"%";
			for(int i=1 ; i<8; i++){
				pstmt.setString(i, query);
			}
			ResultSet rs = pstmt.executeQuery();
			while (rs.next()) {
				String[] row = new String [7];	
				row [0] = rs.getString("pickingid");
	    		row [1] = rs.getString("materialNum");
	    		row [2] = rs.getString("pickingqty");
	    		row [3] = rs.getString("unit"); 
	    		row [4] = rs.getString("employeeNum");
	    		row [5] = rs.getString("pickingDate");
	    		row [6] = rs.getString("note");
				data.add(row);
			}
		}
		catch(SQLException ee){
			System.out.println(ee.toString());
		}
		return data;
	}
    
    protected void getDefault(){//表格初始化
    	id=null; matNum=null; pqty=null; empNum=null; pUnit=null;
    	pickDate=null; note=null; empNum=null; stockQty=null;
    	employeeN=null; materialN=null;   
    	
    	noStock =false;
    	
    	pickingid.setText("");
    	materialName.setText("");
    	pickingDate.setCalendar(null);;
    	employeeName.setText("");
    	remark_picking.setText("");
    	stockNum.setText("");
    	pickingqty.setValue(0); 
    	
    	materialNum.setSelectedIndex(0);
    	employeeNum.setSelectedIndex(0);
    	pickingUnit.setSelectedIndex(0);
    }
    
    protected int editDB(){      	
    	//如果原本輸入數量大與修改後數量，庫存要多扣(有庫存的前提)，數量小於原本的要加回去.
    	int isUpdate = 0;
    	checkStock();//抓庫存量+單位    	
    	id = pickingid.getText();
    	if (getSelect() == true && !id.equals("")) {
    		editCheck(); //confirm balance qty after change return editbalanceQty
    		if(editchangeQty>=0){
	    		editQtyUpdate();
		    	String sql = "update picking set materialNum=?, pickingqty=?, employeeNum=?, "
		    			+ "pickingDate=?, note=?, unit=? where pickingid=?";
		    	try{	    		    		
			    	PreparedStatement editdb = conn.prepareStatement(sql); 
			    	editdb.setString(1, matNum);
			    	editdb.setString(2, pqty);		    	
			    	editdb.setString(3, empNum);
			    	editdb.setString(4, pickDate);
			    	editdb.setString(5, note);
			    	editdb.setString(6, pUnit);
			    	editdb.setString(7, id);		    		    	
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
		if(!pickingid.getText().equals("")){
			try{
				PreparedStatement pstmt = conn.prepareStatement("DELETE FROM picking WHERE pickingid = ?");
				pstmt.setString(1, pickingid.getText());
				isDel = pstmt.executeUpdate();
			}
			catch(SQLException ee){
				System.out.println(ee.toString());
			}
		}
		
		return isDel;
	}

    protected int insertDB(){
    	int isInsert = 0;
    	if (getSelect() == true) {
    		recountStock();//回填新庫存量到material
    		if(!noStock){
	    	 	String sql = "insert into picking(materialNum,pickingqty,employeeNum,pickingDate,note,unit) values(?,?,?,?,?,?)";    	
		    	try{	    			    		
			    	PreparedStatement insertdb = conn.prepareStatement(sql); 
			    	insertdb.setString(1, matNum);
			    	insertdb.setString(2, pqty);
			    	insertdb.setString(3, empNum);
			    	insertdb.setString(4, pickDate);
			    	insertdb.setString(5, note); 
			    	insertdb.setString(6, pUnit);
			    	isInsert = insertdb.executeUpdate();
		    	}catch(Exception a){
		    		System.out.println("insertDB error");
		    		a.printStackTrace();
		    	}
    		}
    	}
    	//扣庫存
    	
    	return isInsert;
    }
    
    private void editCheck(){
    	String lastTimeQty =null;//抓這行資料上次輸入的數量    	
    	try{ 
    		PreparedStatement lastTime = conn.prepareStatement("select * from picking where pickingId="+id);
    		ResultSet rs = lastTime.executeQuery();
    		while(rs.next()){
    			lastTimeQty = rs.getString("pickingqty");
    		}    	
    	//本次與上次輸入量差異
    	editQty	 = (Integer.parseInt(lastTimeQty))-(Integer.parseInt(pqty));
    	
    	//check現有庫存-差異量後
    	editchangeQty = (Integer.parseInt(stockQty))-editQty;
    	
    	}catch(Exception e){
    		System.out.println("editCheck error");
    		e.printStackTrace();
    	}
    }

    private void editQtyUpdate(){
    	int newStockQty =0;
    	newStockQty = (Integer.parseInt(stockQty))+ editQty;//庫存+本次差異量
    	try{ 
    		PreparedStatement editQ = conn.prepareStatement("update material set qty="+newStockQty+" where materialNum="+matNum);
    		editQ.executeUpdate();	
    	}catch(Exception e){
    		System.out.println("editQtyUpdate error");
    		e.printStackTrace();
    	}
    }
    
    //after insert, recount the stock qty
    private void recountStock(){
		int newStockQty = (Integer.parseInt(stockQty))-(Integer.parseInt(pqty));		
		if(newStockQty<0){
			noStock = true;
		}else{		
	    	try{ 
	    		noStock = false; 
	    		PreparedStatement recountS = conn.prepareStatement("update material set qty="+newStockQty+" where materialNum="+matNum);
		    	recountS.executeUpdate();	
	    	}catch(Exception e){
	    		System.out.println("recountStock error");
	    		e.printStackTrace();
	    	}
		}
    }
    
     private void checkStock(){
    	try{
	    	PreparedStatement checkS = conn.prepareStatement("select * from material where materialNum="+matNum);
	    	ResultSet rs = checkS.executeQuery();
	    	while(rs.next()){
	    		stockQty = rs.getString("qty");
	    		String unit = rs.getString("unit");
	    		stockNum.setText(stockQty+unit);
	    	}
	    	
    	}catch(Exception e){
    		System.out.println("checkStock error");
    		e.printStackTrace();
    	}
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
    	
    	matArray = new String[matList.size()];
    	for(int k = 0; k < matArray.length; k++) {
    		if(k==0){}
    		matArray[k] = matList.get(k);
    	}  
    	
    	Arrays.sort(empArray);
    	Arrays.sort(matArray);
    }    
    // Variables declaration - do not modify                     
    private javax.swing.JLabel employeeName;
    private javax.swing.JComboBox<String> employeeNum;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel materialName;
    private javax.swing.JComboBox<String> materialNum;
    private com.toedter.calendar.JDateChooser pickingDate;
    private javax.swing.JLabel pickingLabel01;
    private javax.swing.JLabel pickingLabel03;
    private javax.swing.JLabel pickingLabel04;
    private javax.swing.JLabel pickingLabel05;
    private javax.swing.JLabel pickingLabel06;
    private javax.swing.JLabel pickingLabel07;
    private javax.swing.JLabel pickingLabel0２;
    private javax.swing.JComboBox<String> pickingUnit;
    private javax.swing.JLabel pickingid;
    private javax.swing.JSpinner pickingqty;
    private javax.swing.JTextArea remark_picking;
    private javax.swing.JLabel stockNum;
    // End of variables declaration                   
}
