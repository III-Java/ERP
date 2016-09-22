package panels;
import java.awt.Graphics;
import java.awt.Image;
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
import java.util.LinkedList;
import java.util.List;
import java.util.Properties;

import javax.imageio.ImageIO;
import javax.swing.DefaultComboBoxModel;
import javax.swing.ImageIcon;
import javax.swing.JTextField;
/**
* @author Veronica.C
*/
public class Billboard extends javax.swing.JPanel {
	private Connection conn;
	private List<String> empList;  
	private String empArray[];
	private String boardId=null, issueDate=null, announce=null, deadline=null, remark=null, 
				   employeeNum=null, employeeName=null;

    public Billboard(Connection connection) {
    	this.conn = connection;
//    	databaseConnect();
    	empList = new ArrayList<String>(); //產生List裝id
    	empList.add("");
    	getEmpIdlist();
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
        billboardLabel01 = new javax.swing.JLabel();
        billboardLabel02 = new javax.swing.JLabel();
        billboardLabel03 = new javax.swing.JLabel();
        issueDate_billboard = new com.toedter.calendar.JDateChooser();
        billboardLabel04 = new javax.swing.JLabel();
        jScrollPane4 = new javax.swing.JScrollPane();
        announce_billboard = new javax.swing.JTextArea();
        id_billboard = new javax.swing.JLabel();
        employeeNum_billboard = new javax.swing.JComboBox<>();
        billboardLabel05 = new javax.swing.JLabel();
        deadline_billboard = new com.toedter.calendar.JDateChooser();
        billboardLabel06 = new javax.swing.JLabel();
        remark_billboard = new javax.swing.JTextField();
        jSeparator1 = new javax.swing.JSeparator();
        employeeName_billboard = new javax.swing.JLabel();

        setMinimumSize(new java.awt.Dimension(980, 470));

        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        billboardLabel01.setFont(new java.awt.Font("微軟正黑體", 0, 15)); // NOI18N
        billboardLabel01.setText("公告編號");
        jPanel1.add(billboardLabel01, new org.netbeans.lib.awtextra.AbsoluteConstraints(65, 53, -1, 30));

        billboardLabel02.setFont(new java.awt.Font("微軟正黑體", 0, 15)); // NOI18N
        billboardLabel02.setText("公告日期");
        jPanel1.add(billboardLabel02, new org.netbeans.lib.awtextra.AbsoluteConstraints(65, 123, -1, 30));

        billboardLabel03.setFont(new java.awt.Font("微軟正黑體", 0, 15)); // NOI18N
        billboardLabel03.setText("公告維護者");
        jPanel1.add(billboardLabel03, new org.netbeans.lib.awtextra.AbsoluteConstraints(65, 189, -1, 30));

        issueDate_billboard.setDateFormatString("yyyy/MM/dd");
        issueDate_billboard.setFont(new java.awt.Font("微軟正黑體", 0, 15)); // NOI18N
        jPanel1.add(issueDate_billboard, new org.netbeans.lib.awtextra.AbsoluteConstraints(173, 123, 180, 30));

        billboardLabel04.setFont(new java.awt.Font("微軟正黑體", 0, 15)); // NOI18N
        billboardLabel04.setText("公告內容");
        jPanel1.add(billboardLabel04, new org.netbeans.lib.awtextra.AbsoluteConstraints(65, 264, -1, 30));

        announce_billboard.setColumns(20);
        announce_billboard.setFont(new java.awt.Font("微軟正黑體", 0, 14)); // NOI18N
        announce_billboard.setRows(5);
        jScrollPane4.setViewportView(announce_billboard);

        jPanel1.add(jScrollPane4, new org.netbeans.lib.awtextra.AbsoluteConstraints(65, 300, 833, -1));

        id_billboard.setFont(new java.awt.Font("微軟正黑體", 0, 15)); // NOI18N
        id_billboard.setText("系統自動產生");
        jPanel1.add(id_billboard, new org.netbeans.lib.awtextra.AbsoluteConstraints(173, 53, 180, 30));

        employeeNum_billboard.setFont(new java.awt.Font("微軟正黑體", 0, 15)); // NOI18N
//        employeeNum_billboard.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        employeeNum_billboard.setModel(new DefaultComboBoxModel(empArray));

        employeeNum_billboard.setMinimumSize(new java.awt.Dimension(73, 30));
        employeeNum_billboard.setPreferredSize(new java.awt.Dimension(73, 30));
        employeeNum_billboard.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                employeeNum_billboardActionPerformed(evt);
            }
        });
        jPanel1.add(employeeNum_billboard, new org.netbeans.lib.awtextra.AbsoluteConstraints(173, 189, 180, -1));

        billboardLabel05.setFont(new java.awt.Font("微軟正黑體", 0, 15)); // NOI18N
        billboardLabel05.setText("有效日期");
        jPanel1.add(billboardLabel05, new org.netbeans.lib.awtextra.AbsoluteConstraints(534, 123, -1, 30));

        deadline_billboard.setFont(new java.awt.Font("微軟正黑體", 0, 15)); // NOI18N
        jPanel1.add(deadline_billboard, new org.netbeans.lib.awtextra.AbsoluteConstraints(616, 123, 282, 30));

        billboardLabel06.setFont(new java.awt.Font("微軟正黑體", 0, 15)); // NOI18N
        billboardLabel06.setText("備註");
        jPanel1.add(billboardLabel06, new org.netbeans.lib.awtextra.AbsoluteConstraints(534, 192, 72, -1));

        remark_billboard.setFont(new java.awt.Font("微軟正黑體", 0, 15)); // NOI18N
        jPanel1.add(remark_billboard, new org.netbeans.lib.awtextra.AbsoluteConstraints(616, 189, 282, -1));
        jPanel1.add(jSeparator1, new org.netbeans.lib.awtextra.AbsoluteConstraints(65, 248, 833, 10));

        employeeName_billboard.setFont(new java.awt.Font("微軟正黑體", 0, 18)); // NOI18N
        employeeName_billboard.setText("員工名");
        jPanel1.add(employeeName_billboard, new org.netbeans.lib.awtextra.AbsoluteConstraints(359, 192, 146, -1));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, 980, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, 470, Short.MAX_VALUE)
        );
    }// </editor-fold>        
     
    
    private void employeeNum_billboardActionPerformed(java.awt.event.ActionEvent evt) {                                                      
    	empName();
    }   
    
    private void empName(){
    	employeeNum = (String)employeeNum_billboard.getSelectedItem();
    	if(employeeNum.length()>0){
    		generateInfo();//帶出對應名稱
    	}
    }
    
    private void generateInfo(){ //帶出對應名稱
    	//select * from employee where employeeNum = employID
    	try {
			PreparedStatement getEmp = conn.prepareStatement("select * from employee where employeeNum="+employeeNum);
    		ResultSet rs = getEmp.executeQuery();
			while(rs.next()){				
				employeeName = rs.getString("name");
				employeeName_billboard.setText(employeeName);					
			}				
    	} catch (Exception e) {
			System.out.println("generateInfo error");
			e.printStackTrace();
		}
    }
     
    protected boolean getSelect(){  
    	boolean isRightData = false;
    	//get remark content
    	remark = remark_billboard.getText();
    	announce = announce_billboard.getText();  	
    	//get jdateChooser value
    	issueDate  = ((JTextField)issueDate_billboard.getDateEditor().getUiComponent()).getText();    	
    	deadline  = ((JTextField)deadline_billboard.getDateEditor().getUiComponent()).getText();    	
	   	//combobox get selected & use combobox get empName----->apply in actionListener  
    	if(issueDate.equals("")||announce.equals("")||deadline.equals("")||employeeNum.equals("")){
    		isRightData = false;
    	}
    	else{
    		isRightData = true;
    	}
    	return isRightData;
    
    }
    
    protected int insertDB(){    	
    	int isInsert = 0;
    	if (getSelect() == true) {
	    	String sql = "insert into billboard(issueDate,announce,deadline,remark,employeeNum) "
	    			+ "values(?,?,?,?,?)";
	  	 	try{	    			    		
		    	PreparedStatement insertdb = conn.prepareStatement(sql); 
		    	insertdb.setString(1, issueDate);
		    	insertdb.setString(2, announce);
		    	insertdb.setString(3, deadline);
		    	insertdb.setString(4, remark);
		    	insertdb.setString(5, employeeNum);    	
		    	
		    	isInsert = insertdb.executeUpdate();
	    	}catch(Exception a){
	    		System.out.println("insertDB error");
	    		a.printStackTrace();
	    	}
    	}
  	 	return isInsert;
    }
    
	protected int delData(){
		int isDel = 0;
		if(!id_billboard.getText().equals("")){
			try{
				PreparedStatement pstmt = conn.prepareStatement("DELETE FROM billboard WHERE id = ?");
				pstmt.setString(1, id_billboard.getText());
				isDel = pstmt.executeUpdate();
			}
			catch(SQLException ee){
				System.out.println(ee.toString());
			}
		}
		
		return isDel;
	}
   
    protected int editDB(){    
    	boardId = id_billboard.getText();
		int isUpdate = 0;
		if (getSelect() == true) {
	    	String sql = "update billboard set issueDate=?, announce=?, deadline=?, remark=?, employeeNum=? where id=?";
	    		
	  	 	try{	    			    		
		    	PreparedStatement editdb = conn.prepareStatement(sql); 
		    	editdb.setString(1, issueDate);
		    	editdb.setString(2, announce);
		    	editdb.setString(3, deadline);
		    	editdb.setString(4, remark);
		    	editdb.setString(5, employeeNum);	    	
		    	editdb.setString(6, boardId);
		    	
		    	isUpdate = editdb.executeUpdate();
	      	}catch(Exception a){
		    		System.out.println("editDB error");
		    		a.printStackTrace();
		    }    
		}
		return isUpdate;
    }
    
    private void updateInTime(){//combo box及時更新資料庫資料
    	empList.clear();
    	empList.add("");
    	
    	//re-update data from db
    	getEmpIdlist();    	
    	employeeNum_billboard.setModel(new DefaultComboBoxModel(empArray));    	
    	
    }
    
    protected  LinkedList<String[]> search(String value){
		LinkedList<String[]> data = new LinkedList<>();
		try{
			PreparedStatement pstmt = conn.prepareStatement("SELECT * FROM billboard WHERE id LIKE ? OR issueDate LIKE ? OR announce LIKE ?"
					+ " OR deadline LIKE ? OR employeeNum LIKE ? OR remark LIKE ?");
			String query = "%" + value +"%";
			for(int i=1 ; i<7; i++){
				pstmt.setString(i, query);
			}
			ResultSet rs = pstmt.executeQuery();
			while (rs.next()) {
				String[] row = new String [6];	
	    		row [0] = rs.getString("id");
	    		row [1] = rs.getString("issueDate");
	    		row [2] = rs.getString("announce");
	    		row [3] = rs.getString("deadline");
	    		row [4] = rs.getString("employeeNum");
	    		row [5] = rs.getString("remark");   	    		
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
    	updateInTime();
		LinkedList<String[]> data = new LinkedList<>();
		try{
			PreparedStatement pstmt = conn.prepareStatement("SELECT * FROM billboard");
			ResultSet rs = pstmt.executeQuery();
	    	while(rs.next()){
	    		String[] row = new String [6];	
	    		row [0] = rs.getString("id");
	    		row [1] = rs.getString("issueDate");
	    		row [2] = rs.getString("announce");
	    		row [3] = rs.getString("deadline");
	    		row [4] = rs.getString("employeeNum");
	    		row [5] = rs.getString("remark");   	    		
	    		data.add(row);
			}
		}
		catch(SQLException ee){			
			System.out.println("p_query"+ee.toString());
		}
		return data;
    }
    
    protected void setInputValue(HashMap<Integer, String> data) {
    	id_billboard.setText(data.get(0));
    	
    	try {
			java.util.Date date = new SimpleDateFormat("yyyy/MM/dd").parse(data.get(1));
			issueDate_billboard.setDate(date);
			
			java.util.Date date2 = new SimpleDateFormat("yyyy/MM/dd").parse(data.get(3));
			deadline_billboard.setDate(date2);
	
		} catch (ParseException e) {
			
			e.printStackTrace();
		}		
    	
    	employeeNum_billboard.setSelectedItem(data.get(4));
		empName();
    	
		remark_billboard.setText(data.get(5));
    	announce_billboard.setText(data.get(2));
    			
	}
    
    private void getEmpIdlist(){
    	try{
	    	PreparedStatement getId = conn.prepareStatement("select * from employee");
	    	ResultSet rs = getId.executeQuery();
	    	while(rs.next()){
	    		String idList = rs.getString("employeeNum");
	    		empList.add(idList);
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
    	Arrays.sort(empArray);
    	
    }
    
    protected void getDefault(){
    	id_billboard.setText("系統自動產生");
    	issueDate_billboard.setCalendar(null);
    	employeeName_billboard.setText("");
    	announce_billboard.setText("");
    	deadline_billboard.setCalendar(null);
    	remark_billboard.setText("");
    	
    	boardId=null; issueDate=null; announce=null; deadline=null; remark=null; 
		employeeNum=null; employeeName=null;
		id_billboard.setText("");
		employeeNum_billboard.setSelectedIndex(0);
    }
    
    
    // Variables declaration - do not modify                     
    private javax.swing.JTextArea announce_billboard;
    private javax.swing.JLabel billboardLabel01;
    private javax.swing.JLabel billboardLabel02;
    private javax.swing.JLabel billboardLabel03;
    private javax.swing.JLabel billboardLabel04;
    private javax.swing.JLabel billboardLabel05;
    private javax.swing.JLabel billboardLabel06;
    private com.toedter.calendar.JDateChooser deadline_billboard;
    private javax.swing.JLabel employeeName_billboard;
    private javax.swing.JComboBox<String> employeeNum_billboard;
    private javax.swing.JLabel id_billboard;
    private com.toedter.calendar.JDateChooser issueDate_billboard;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JTextField remark_billboard;
    // End of variables declaration                   
}
