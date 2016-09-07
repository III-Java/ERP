package panels;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Properties;

public class Department extends javax.swing.JPanel {
	private Connection conn;
	private String depId=null, depName=null, depTitle=null, depNote=null;
	private List<String> checkRp;
	
    public Department(Connection connection) {
    	this.conn = connection;
    	checkRp = new ArrayList<String>();
//    	databaseConnect();
        initComponents();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">                          
    private void initComponents() {

        depLabel1 = new javax.swing.JLabel();
        depLabel2 = new javax.swing.JLabel();
        id_department = new javax.swing.JLabel();
        depName_department = new javax.swing.JTextField();
        depLabel3 = new javax.swing.JLabel();
        title_department = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        note_department = new javax.swing.JTextArea();

        setFont(new java.awt.Font("微軟正黑體", 0, 18)); // NOI18N
        setMinimumSize(new java.awt.Dimension(980, 470));
        setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        depLabel1.setFont(new java.awt.Font("微軟正黑體", 0, 15)); // NOI18N
        depLabel1.setText("部門ID");
        add(depLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 90, -1, 30));

        depLabel2.setFont(new java.awt.Font("微軟正黑體", 0, 15)); // NOI18N
        depLabel2.setText("部門名稱");
        depLabel2.setMaximumSize(new java.awt.Dimension(75, 25));
        depLabel2.setMinimumSize(new java.awt.Dimension(75, 25));
        depLabel2.setPreferredSize(new java.awt.Dimension(75, 25));
        add(depLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 200, -1, -1));

        id_department.setFont(new java.awt.Font("微軟正黑體", 0, 15)); // NOI18N
        add(id_department, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 90, 269, 30));

        depName_department.setFont(new java.awt.Font("微軟正黑體", 0, 15)); // NOI18N
        add(depName_department, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 190, 269, -1));

        depLabel3.setFont(new java.awt.Font("微軟正黑體", 0, 15)); // NOI18N
        depLabel3.setText("職銜");
        add(depLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(94, 296, -1, -1));

        title_department.setFont(new java.awt.Font("微軟正黑體", 0, 15)); // NOI18N
        add(title_department, new org.netbeans.lib.awtextra.AbsoluteConstraints(178, 293, 269, -1));

        jLabel1.setFont(new java.awt.Font("微軟正黑體", 0, 15)); // NOI18N
        jLabel1.setText("備註");
        add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(524, 197, -1, -1));

        note_department.setColumns(20);
        note_department.setFont(new java.awt.Font("微軟正黑體", 0, 14)); // NOI18N
        note_department.setRows(5);
        jScrollPane1.setViewportView(note_department);

        add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(572, 197, 370, 123));
    }// </editor-fold>    
  
    protected void getDefault(){
    	depId=null; depName=null;
    	depName_department.setText("");
    	id_department.setText("");
    	title_department.setText("");
    	note_department.setText("");    	
    }
    
  //取得輸入資料
    protected boolean getSelect(){
    	boolean isRightData = false;
    	//get remark content
    	depName = depName_department.getText();
    	depTitle = title_department.getText();
    	depNote = note_department.getText();    	
    	if (depName.equals("")) {
			isRightData = false;
		} else {
			isRightData = true;
		}
		return isRightData;
    }
    
    public boolean checkRepeat(){ //部門名+title=pk來比對    
    	getSelect();
    	try{	    		    		
	    	PreparedStatement checkDep = conn.prepareStatement("select * from department"); 
	    	ResultSet rs = checkDep.executeQuery();
	    	while(rs.next()){
	    		String depN = rs.getString("department");
	    		String title = rs.getString("jobTitle");	    		
	    		String _rpCheck = depN+title;
//	    		System.out.println(_rpCheck);
	    		checkRp.add(_rpCheck);	    		
	    	}			    	
	    	String _dep_rpCheck = depName+depTitle;;
	    	for(int i = 0; i < checkRp.size(); i++) {
	    		String checkRpString = checkRp.get(i);	    		
	    		if(_dep_rpCheck.equals(checkRpString)){
	    			return true;
	    		}	    		
	    	}	    	
    	}catch(Exception a){
    		System.out.println("checkRepeat xx");
    		a.printStackTrace();
    	}
    	return false;
    }
    
    protected int insertDB(){
    	int isInsert = 0;
		boolean ifdeptRepeat = checkRepeat();

    	if (getSelect() == true & !ifdeptRepeat) {
	    	String sql = "insert into department(department,jobTitle,note) values(?,?,?)";
	    	try{	    			    		
		    	PreparedStatement insertdb = conn.prepareStatement(sql); 
		    	insertdb.setString(1, depName);
		    	insertdb.setString(2, depTitle);
		    	insertdb.setString(3, depNote);
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
		if(!id_department.getText().equals("")){
			try{
				PreparedStatement pstmt = conn.prepareStatement("DELETE FROM department WHERE id = ?");
				pstmt.setString(1, id_department.getText());
				isDel = pstmt.executeUpdate();
			}
			catch(SQLException ee){
				System.out.println(ee.toString());
			}
		}
		
		return isDel;
	}
    
    protected int editDB(){	
    	depId = id_department.getText();
		int isUpdate = 0;
		if (getSelect() == true) {
	    	String sql = "update department set department=?, jobTitle=?, note=? where id="+depId;
	  	 	try{	    			    		
		    	PreparedStatement editdb = conn.prepareStatement(sql); 
		    	editdb.setString(1, depName);
		    	editdb.setString(2, depTitle);
		    	editdb.setString(3, depNote);
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
			PreparedStatement pstmt = conn.prepareStatement("SELECT * FROM department WHERE id LIKE ? "
					+ "OR department LIKE ? OR jobTitle LIKE ? OR note LIKE ?");
			String query = "%" + value +"%";
			for(int i=1 ; i<5; i++){
				pstmt.setString(i, query);
			}
			ResultSet rs = pstmt.executeQuery();
			while (rs.next()) {
				String[] row = new String [4];	
	    		row [0] = rs.getString("id");
	    		row [1] = rs.getString("department"); 
	    		row [2] = rs.getString("jobTitle"); 
	    		row [3] = rs.getString("note"); 
	    		data.add(row);
			}
		}
		catch(SQLException ee){
			System.out.println("search xx");
			System.out.println(ee.toString());
		}
		return data;
	}
    
    protected LinkedList<String[]> queryData() {
    	getDefault();
		LinkedList<String[]> data = new LinkedList<>();
		try{
			PreparedStatement pstmt = conn.prepareStatement("SELECT * FROM department");
			ResultSet rs = pstmt.executeQuery();
	    	while(rs.next()){
	    		String[] row = new String [4];	
	    		row [0] = rs.getString("id");
	    		row [1] = rs.getString("department"); 	
	    		row [2] = rs.getString("jobTitle"); 
	    		row [3] = rs.getString("note"); 
	    		data.add(row);
			}
		}
		catch(SQLException ee){			
			System.out.println("queryData xx");
			System.out.println("p_query"+ee.toString());
		}
		return data;
    }
    
    protected void setInputValue(HashMap<Integer, String> data) {
    	id_department.setText(data.get(0));    	
    	depName_department.setText(data.get(1)); 
    	title_department.setText(data.get(2));
    	note_department.setText(data.get(3));    	
	}
   
    
    // Variables declaration - do not modify                     
    private javax.swing.JLabel depLabel1;
    private javax.swing.JLabel depLabel2;
    private javax.swing.JLabel depLabel3;
    private javax.swing.JTextField depName_department;
    private javax.swing.JLabel id_department;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextArea note_department;
    private javax.swing.JTextField title_department;
    // End of variables declaration                   
}
