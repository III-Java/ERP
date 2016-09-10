package panels;
import java.awt.Toolkit;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;
import java.util.Properties;

import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;

import javafx.scene.input.DataFormat;

public class Login extends javax.swing.JFrame {
	protected Connection conn;
	private String logId =null, logPW=null, editPW="no";
	private String ondutyT =null, offdutyT =null, onduty=null;
	private boolean idOk=false, pwOk=false, ifedit=false, repeatPW=false, noInput=false;
	private boolean hasOnDutyRecord=false, hasOffDutyRecord=false;

    public Login() {
    	databaseConnect();
        initComponents();
        init();
    }
    
    private void init(){
        setResizable(false);
        setLocationRelativeTo(null);//置中
        
        //title
        setIconImage(Toolkit.getDefaultToolkit().getImage(getClass().getResource("./image/drink.png")));
        setTitle("---ERP LOGIN---");
     }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">                          
    private void initComponents() {
    	login = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        loginLabel02 = new javax.swing.JLabel();
        loginLabel01 = new javax.swing.JLabel();
        jSeparator1 = new javax.swing.JSeparator();
        jSeparator2 = new javax.swing.JSeparator();
        employID_login = new javax.swing.JTextField();
        employPW_login = new javax.swing.JPasswordField();
        loginLabel03 = new javax.swing.JLabel();
        employPwEdit_login = new javax.swing.JPasswordField();
        login_log = new javax.swing.JButton();
        showResult_login = new javax.swing.JLabel();
        onduty_log = new javax.swing.JButton();
        offduty_log = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setMaximumSize(new java.awt.Dimension(650, 500));
        setMinimumSize(new java.awt.Dimension(600, 500));
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        login.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setFont(new java.awt.Font("微軟正黑體", 1, 36)); // NOI18N
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("ERP / 打卡系統");
        login.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(176, 16, 325, 82));

        loginLabel02.setFont(new java.awt.Font("微軟正黑體", 0, 18)); // NOI18N
        loginLabel02.setText("密碼");
        login.add(loginLabel02, new org.netbeans.lib.awtextra.AbsoluteConstraints(94, 206, 122, 53));

        loginLabel01.setFont(new java.awt.Font("微軟正黑體", 0, 18)); // NOI18N
        loginLabel01.setText("員工編號");
        login.add(loginLabel01, new org.netbeans.lib.awtextra.AbsoluteConstraints(94, 135, 122, 53));
        login.add(jSeparator1, new org.netbeans.lib.awtextra.AbsoluteConstraints(69, 107, 516, 10));
        login.add(jSeparator2, new org.netbeans.lib.awtextra.AbsoluteConstraints(69, 277, 516, 10));

        employID_login.setFont(new java.awt.Font("微軟正黑體", 0, 16)); // NOI18N
        //click event
        employID_login.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                employID_loginMouseClicked(evt);
            }
        });
        login.add(employID_login, new org.netbeans.lib.awtextra.AbsoluteConstraints(265, 135, 320, 53));

        employPW_login.setFont(new java.awt.Font("微軟正黑體", 0, 16)); // NOI18N
        login.add(employPW_login, new org.netbeans.lib.awtextra.AbsoluteConstraints(265, 206, 320, 53));

        loginLabel03.setFont(new java.awt.Font("微軟正黑體", 0, 18)); // NOI18N
        loginLabel03.setText("修改密碼");
        login.add(loginLabel03, new org.netbeans.lib.awtextra.AbsoluteConstraints(91, 296, 122, 53));

        employPwEdit_login.setFont(new java.awt.Font("微軟正黑體", 0, 16)); // NOI18N
        //add click listener
        employPwEdit_login.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                employPwEdit_loginMouseClicked(evt);
            }
        });
        
        login.add(employPwEdit_login, new org.netbeans.lib.awtextra.AbsoluteConstraints(265, 297, 320, 53));

        login_log.setFont(new java.awt.Font("微軟正黑體", 0, 18)); // NOI18N
        login_log.setForeground(new java.awt.Color(0, 0, 204));
        login_log.setText("登入");
        login_log.setMinimumSize(new java.awt.Dimension(90, 30));
        login_log.setPreferredSize(new java.awt.Dimension(90, 30));
        login_log.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                login_logActionPerformed(evt);
            }
        });
        login.add(login_log, new org.netbeans.lib.awtextra.AbsoluteConstraints(433, 424, 152, 47));

        showResult_login.setFont(new java.awt.Font("微軟正黑體", 0, 18)); // NOI18N
        showResult_login.setForeground(new java.awt.Color(255, 51, 51));
        showResult_login.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        login.add(showResult_login, new org.netbeans.lib.awtextra.AbsoluteConstraints(15, 359, 620, 47));

        onduty_log.setFont(new java.awt.Font("微軟正黑體", 0, 18)); // NOI18N
        onduty_log.setForeground(new java.awt.Color(102, 0, 102));
        onduty_log.setText("上班打卡");
        onduty_log.setMaximumSize(new java.awt.Dimension(90, 30));
        onduty_log.setPreferredSize(new java.awt.Dimension(69, 33));
        onduty_log.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                onduty_logActionPerformed(evt);
            }
        });
        login.add(onduty_log, new org.netbeans.lib.awtextra.AbsoluteConstraints(69, 424, 131, 47));

        offduty_log.setFont(new java.awt.Font("微軟正黑體", 0, 18)); // NOI18N
        offduty_log.setForeground(new java.awt.Color(102, 0, 102));
        offduty_log.setText("下班打卡");
        offduty_log.setMaximumSize(new java.awt.Dimension(90, 30));
        offduty_log.setMinimumSize(new java.awt.Dimension(90, 30));
        offduty_log.setPreferredSize(new java.awt.Dimension(90, 30));
        offduty_log.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                offduty_logActionPerformed(evt);
            }
        });
        login.add(offduty_log, new org.netbeans.lib.awtextra.AbsoluteConstraints(218, 424, 128, 47));

        getContentPane().add(login, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, 500));

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>     
    
    //when click input id, clear tip text
    private void employID_loginMouseClicked(java.awt.event.MouseEvent evt) {                                            
    	showResult_login.setText("");
    } 
    
    //click edit show tip
    private void employPwEdit_loginMouseClicked(java.awt.event.MouseEvent evt) {                                                
    	showResult_login.setText("輸入正確帳密後，直接輸入新密碼按登入(修改)。修改後請用新密碼登入.");
    }   
    
    private void login_logActionPerformed(java.awt.event.ActionEvent evt) {                                          
    	getInput();
    	if(!noInput){
    		checkId();
    	}else{
    		showResult_login.setText("請輸入帳號/密碼");
    	}
    }   
    
    private void onduty_logActionPerformed(java.awt.event.ActionEvent evt) {                                           
    	getInput();    	
    	if(!noInput){    
    		checkRecord();//今天是否打過卡
	    	dutyCheck();//check account passwd pwOk ok
	    	if(idOk & pwOk & !hasOnDutyRecord){ //帳密正確
	    		onduty = "on";
				Date getTime = new Date();
				SimpleDateFormat setTime = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");								
				ondutyT = setTime.format(getTime);
				showResult_login.setText("員編："+logId+"_上班時間："+ondutyT);	
				insertAttn();	
				defaultDuty();
			}else if(idOk & pwOk & hasOnDutyRecord){    			
				getDefault();//所有條件初始化
				showResult_login.setText("今天已打過上班卡");
			}else{    			
				getDefault();//所有條件初始化
				showResult_login.setText("帳號/密碼錯誤");
			}
    	}else{
    		showResult_login.setText("請輸入帳號/密碼");
    	}
    }                                          

    private void offduty_logActionPerformed(java.awt.event.ActionEvent evt) {                                            
    	getInput();
    	if(!noInput){
    		checkRecord();
	    	dutyCheck();//check account passwd pwOk ok
	    	if(idOk & pwOk & !hasOffDutyRecord){ //帳密正確
	    		onduty = "off";
				Date getTime = new Date();
				SimpleDateFormat setTime = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");								
				offdutyT = setTime.format(getTime);
				showResult_login.setText("員編："+logId+"_下班時間："+offdutyT);	
				insertAttn();
				defaultDuty();
			}else if(idOk & pwOk & hasOffDutyRecord){    			
				getDefault();//所有條件初始化
				showResult_login.setText("今天已打過下班卡");
			}else{
				getDefault();//所有條件初始化
				showResult_login.setText("帳號/密碼錯誤");
			}
    	}else{
    		showResult_login.setText("請輸入帳號/密碼");
    	}
    }    

    private void insertAttn(){
    	PreparedStatement insert =null, getDept=null;
    	String dept=null;
    	try{
    		getDept =conn.prepareStatement("select * from employee where employeeNum="+logId);
    		ResultSet rs = getDept.executeQuery();
    		while(rs.next()){
    			dept = rs.getString("department");
    			break;
    		}
	    	if(onduty.equals("on")){
	    		insert = conn.prepareStatement("insert into attendance(employeeNum,work,department) values(?,?,?)");
	    		insert.setString(1, logId);
	    		insert.setString(2, ondutyT);
	    		insert.setString(3, dept);
	    		
	    	}else if(onduty.equals("off")){				
	    		insert = conn.prepareStatement("update attendance set offWork='"+offdutyT+"' where employeeNum="+logId);	    	
	    	}
	    	insert.executeUpdate();  
    	}catch(Exception a){
    		System.out.println("insertAttn error");
    		a.printStackTrace();
    	}
    }
    
    //抓到輸入欄位資料
    private void getInput(){
    	logId = employID_login.getText();
    	logPW = new String(employPW_login.getPassword());
    	editPW = new String(employPwEdit_login.getPassword());
    	
    	if(logId.equals("") || logPW.equals("")){
    		noInput=true;
    	}
    }
    
    private void defaultDuty(){
    	employID_login.setText("");
    	employPW_login.setText("");
    	employPwEdit_login.setText("");
    	noInput=false;
    	onduty=null;
    	hasOnDutyRecord=false;
    	hasOffDutyRecord=false;
    }
   
    private void checkRecord(){
//    	System.out.println("checkRecord in");
    	PreparedStatement getInfo =null;
    	String nowDate=null, ondutyDate=null, offdutyDate=null;
    	
    	//取得今天日期與系統日期做比較
    	Date date = new Date();
    	SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd");
        nowDate = dateFormat.format(date);
//        System.out.println("今天日期: "+nowDate);
    	try{
    		getInfo = conn.prepareStatement("select * from attendance where employeeNum="+logId);
    		ResultSet rs = getInfo.executeQuery();
    		while(rs.next()){
    			String dbOnDate=rs.getString("work");
    			String dbOffDate=rs.getString("offWork");    			
    			String[] onArray=dbOnDate.split(" ", 2);
    			ondutyDate =onArray[0];   
    			
//    			System.out.println("ondutyDate split[0] "+ondutyDate);
    			if(dbOffDate != null){
	    			String[] offArray=dbOffDate.split(" ", 2);
	    			offdutyDate =offArray[0];
//	    			System.out.println("offdutyDate split[0] "+offdutyDate);
    			}
    			break;    			
    		}
    		if(nowDate.equals(ondutyDate)){
    			hasOnDutyRecord=true;
    		}
    		if(nowDate.equals(offdutyDate)){
    			hasOffDutyRecord=true;
    		}
    		
//    		System.out.println("onduty repeat "+hasOnDutyRecord+", offDuty Repeat: "+hasOffDutyRecord);
    		
    	}catch(Exception a){
    		System.out.println("insertAttn error");
    		a.printStackTrace();
    	}    
    }
   
    private void dutyCheck(){ //點送出後check資料    	
    	try{
    		PreparedStatement p1 = conn.prepareStatement("select * from employee where employeeNum="+logId);
    		ResultSet rs = p1.executeQuery();
    		while(rs.next()){    			
    			idOk =true;
    			break;
    		}
    		
    		PreparedStatement p2 = conn.prepareStatement("select * from admin where employeeNum="+logId);
    		ResultSet rs2 = p2.executeQuery();
    		while(rs2.next()){
    			String sqlPW = rs2.getString("password");
    			if(sqlPW.equals(logPW)){
    				pwOk =true;
    			}
    			break;
    		} 
    		
    	}catch(Exception a){
    		System.out.println("dutyCheck error");
    		a.printStackTrace();
    	}
    }       
    
    private void checkId(){ //點送出後check資料沒問題跳到下一頁
    	if(editPW.length()>0){
    		ifedit =true;
    	}    	
    	try{
    		PreparedStatement p1 = conn.prepareStatement("select * from employee where employeeNum="+logId);
    		ResultSet rs = p1.executeQuery();
    		while(rs.next()){    			
    			idOk =true;
    			break;
    		}
    		
    		PreparedStatement p2 = conn.prepareStatement("select * from admin where employeeNum="+logId);
    		ResultSet rs2 = p2.executeQuery();
    		while(rs2.next()){
    			String sqlPW = rs2.getString("password");
    			if(sqlPW.equals(logPW)){
    				pwOk =true;
    			}
    			
    			if(sqlPW.equals(editPW)){
    				repeatPW =true;
    			}
    			break;
    		}
    		
    		if(idOk & pwOk & !ifedit){
    			erp_frame erp_main = new erp_frame(logId, conn);//跳到main頁面    	
    			erp_main.setVisible(true);	      
    	        dispose(); //關掉原本的視窗
    		}else if(idOk & pwOk & ifedit & !repeatPW){ //帳密正確且要修改密碼
    			changePW();//修改密碼
    			getDefault();//所有條件初始化
    			showResult_login.setText("密碼修改成功，請重新登入");
    		
    		}else{    			
    			getDefault();//所有條件初始化
    			showResult_login.setText("帳號/密碼錯誤");
    		}
    	}catch(Exception a){
    		System.out.println("checkId error");
    		a.printStackTrace();
    	}
    }       
    
    private void getDefault(){ //所有條件初始化
    	employPwEdit_login.setText("");
		employPW_login.setText("");
		employID_login.setText("");		
		idOk=false; 
		pwOk=false; 
		ifedit=false; 
		noInput=false;
		repeatPW=false; logId =null; logPW=null; editPW="no";
		hasOnDutyRecord=false;hasOffDutyRecord=false;
		
    }
    
    private void changePW(){ //修改密碼
//    	update admin set password= newid where employeeNum=userid;    	
    	try {
    		PreparedStatement p1 = conn.prepareStatement("update admin set password="+editPW+" where employeeNum="+logId);
    		p1.executeUpdate();
    		ifedit = false;
    	} catch (Exception e) {
			System.out.println("changePW error: "+ e.toString());
			e.printStackTrace();
		}
    }
        
    private void databaseConnect(){
    	try {
			Class.forName("com.mysql.jdbc.Driver");
			String url ="jdbc:mysql://localhost/erp";
//			String url ="jdbc:mysql://112.104.57.22/iii2003";
			Properties prop = new Properties();
			prop.setProperty("user", "root");
			prop.setProperty("password", "");
//			prop.setProperty("createDatabaseIfNotExist", "true");			
			prop.setProperty("useSSL", "false");
			prop.setProperty("useUnicode", "true");
			prop.setProperty("characterEncoding", "UTF-8");		
			
			conn = DriverManager.getConnection(url, prop);
		
        } catch (Exception e) {
			System.out.println("sql conn error: "+ e.toString());
			e.printStackTrace();
		}
    }
    
    public static void main(String args[]) {
          try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(Login.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Login.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Login.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Login.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Login().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify  
    private javax.swing.JTextField employID_login;
    private javax.swing.JPasswordField employPW_login;
    private javax.swing.JPasswordField employPwEdit_login;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JSeparator jSeparator2;
    private javax.swing.JPanel login;
    private javax.swing.JLabel loginLabel01;
    private javax.swing.JLabel loginLabel02;
    private javax.swing.JLabel loginLabel03;
    private javax.swing.JButton login_log;
    private javax.swing.JButton offduty_log;
    private javax.swing.JButton onduty_log;
    private javax.swing.JLabel showResult_login;
    // End of variables declaration                   
}
