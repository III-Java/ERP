package panels;
import java.awt.Color;
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
import javax.swing.table.DefaultTableModel;

import org.w3c.dom.css.RGBColor;

/**
* @author Veronica.C
*/

public class Admin extends javax.swing.JPanel {
	private String passwd=null, employee=null, attendance=null, achieve=null, payroll=null, product=null, 
			   material=null, orderlist=null, orderitem=null, asset=null, issue=null, member=null,
			   vendor=null, purchase=null, payablelist=null, admin=null, note=null, department=null, billboard=null,
			   employName=null, employID=null, employPW=null, profit=null, sales=null, pickingB=null, news=null, authDept=null;
	private Connection conn; //db conn
	private List<String> empList;  
	private String empArray[];
	private boolean hasId = false; //資料庫是否有資料
	private ImageIcon newIcon;
	private BufferedImage BIMG;
	    
    public Admin(Connection connection) {    
    	this.conn = connection;
//    	databaseConnect(); 
    	empList = new ArrayList<String>(); //產生List裝id
    	empList.add("");
    	getEmpIdlist(); //抓到員工資料庫人員id資料塞入list
        initComponents();   
        
//        Color bgcolor = Color.decode("#f2eeeb");
        
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
    	employee_admin = new javax.swing.ButtonGroup();
        attendance_admin = new javax.swing.ButtonGroup();
        achievement_admin = new javax.swing.ButtonGroup();
        payRoll_admin = new javax.swing.ButtonGroup();
        purchase_admin = new javax.swing.ButtonGroup();
        product_admin = new javax.swing.ButtonGroup();
        material_admin = new javax.swing.ButtonGroup();
        orderList_admin = new javax.swing.ButtonGroup();
        orderItem_admin = new javax.swing.ButtonGroup();
        issue_admin = new javax.swing.ButtonGroup();
        payableList_admin = new javax.swing.ButtonGroup();
        asset_admin = new javax.swing.ButtonGroup();
        vendor_admin = new javax.swing.ButtonGroup();
        adminList_admin = new javax.swing.ButtonGroup();
        billboard_admin = new javax.swing.ButtonGroup();
        member_admin = new javax.swing.ButtonGroup();
        sales_admin = new javax.swing.ButtonGroup();
        profit_admin = new javax.swing.ButtonGroup();
        picking_admin = new javax.swing.ButtonGroup();
        news_admin = new javax.swing.ButtonGroup();
        dep_admin1 = new javax.swing.ButtonGroup();
        
        adminPanel = new javax.swing.JPanel(){
    		
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
        adminPanel.setBackground(new java.awt.Color(245,240,243));

        adminLabel01 = new javax.swing.JLabel();
        adminLabel02 = new javax.swing.JLabel();
        adminLabel04 = new javax.swing.JLabel();
        adminLabel05 = new javax.swing.JLabel();
        employeeNum_admin = new javax.swing.JComboBox<>();
        adminLabel03 = new javax.swing.JLabel();
        empPasswd_admin = new javax.swing.JLabel();
        empDepat_admin = new javax.swing.JLabel();
        employeeName_admin = new javax.swing.JLabel();
        jSeparator1 = new javax.swing.JSeparator();
        adminLabel06 = new javax.swing.JLabel();
        adminLabel07 = new javax.swing.JLabel();
        adminLabel08 = new javax.swing.JLabel();
        employeeY_admin = new javax.swing.JRadioButton();
        employeeN_admin = new javax.swing.JRadioButton();
        adminLabel10 = new javax.swing.JLabel();
        adminLabel11 = new javax.swing.JLabel();
        attendanceY_admin = new javax.swing.JRadioButton();
        achievementY_admin = new javax.swing.JRadioButton();
        payRollY_admin = new javax.swing.JRadioButton();
        purchaseY_admin = new javax.swing.JRadioButton();
        attendanceN_admin = new javax.swing.JRadioButton();
        achievementN_admin = new javax.swing.JRadioButton();
        payRollN_admin = new javax.swing.JRadioButton();
        purchaseN_admin = new javax.swing.JRadioButton();
        adminLabel12 = new javax.swing.JLabel();
        adminLabel13 = new javax.swing.JLabel();
        adminLabel14 = new javax.swing.JLabel();
        materialY_admin = new javax.swing.JRadioButton();
        orderListY_admin = new javax.swing.JRadioButton();
        orderItemY_admin = new javax.swing.JRadioButton();
        issueY_admin = new javax.swing.JRadioButton();
        payableListY_admin = new javax.swing.JRadioButton();
        materialN_admin = new javax.swing.JRadioButton();
        orderListN_admin = new javax.swing.JRadioButton();
        orderItemN_admin = new javax.swing.JRadioButton();
        issueN_admin = new javax.swing.JRadioButton();
        payableListN_admin = new javax.swing.JRadioButton();
        adminLabel15 = new javax.swing.JLabel();
        adminLabel16 = new javax.swing.JLabel();
        adminLabel17 = new javax.swing.JLabel();
        adminLabel18 = new javax.swing.JLabel();
        adminLabel19 = new javax.swing.JLabel();
        adminLabel09 = new javax.swing.JLabel();
        productY_admin = new javax.swing.JRadioButton();
        assetY_admin = new javax.swing.JRadioButton();
        productN_admin = new javax.swing.JRadioButton();
        assetN_admin = new javax.swing.JRadioButton();
        memberY_admin = new javax.swing.JRadioButton();
        vendorY_admin = new javax.swing.JRadioButton();
        adminY_admin = new javax.swing.JRadioButton();
        billboardY_admin = new javax.swing.JRadioButton();
        memberN_admin = new javax.swing.JRadioButton();
        vendorN_admin = new javax.swing.JRadioButton();
        adminN_admin = new javax.swing.JRadioButton();
        billboardN_admin = new javax.swing.JRadioButton();
        adminLabel20 = new javax.swing.JLabel();
        note_admin = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        profitY_admin = new javax.swing.JRadioButton();
        profitN_admin = new javax.swing.JRadioButton();
        salesN_admin = new javax.swing.JRadioButton();
        salesY_admin = new javax.swing.JRadioButton();
        jLabel2 = new javax.swing.JLabel();
        picking = new javax.swing.JLabel();
        pickingY_admin = new javax.swing.JRadioButton();
        pickingN_admin = new javax.swing.JRadioButton();
        jLabel3 = new javax.swing.JLabel();
        webNewsY_admin = new javax.swing.JRadioButton();
        webNewsN_admin = new javax.swing.JRadioButton();
        jLabel4 = new javax.swing.JLabel();
        depY_admin = new javax.swing.JRadioButton();
        depN_admin = new javax.swing.JRadioButton();

        setMinimumSize(new java.awt.Dimension(980, 470));
        setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        adminPanel.setMinimumSize(new java.awt.Dimension(980, 470));
        adminPanel.setPreferredSize(new java.awt.Dimension(980, 470));
        adminPanel.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        adminLabel01.setFont(new java.awt.Font("微軟正黑體", 0, 18)); // NOI18N
        adminLabel01.setText("員工編號");
        adminPanel.add(adminLabel01, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 10, -1, 30));

        adminLabel02.setFont(new java.awt.Font("微軟正黑體", 0, 18)); // NOI18N
        adminLabel02.setText("登入密碼");
        adminPanel.add(adminLabel02, new org.netbeans.lib.awtextra.AbsoluteConstraints(428, 10, -1, 30));

        adminLabel04.setFont(new java.awt.Font("微軟正黑體", 0, 15)); // NOI18N
        adminLabel04.setText("員工資料表");
        adminPanel.add(adminLabel04, new org.netbeans.lib.awtextra.AbsoluteConstraints(44, 86, -1, -1));

        adminLabel05.setFont(new java.awt.Font("微軟正黑體", 0, 15)); // NOI18N
        adminLabel05.setText("出缺勤表");
        adminPanel.add(adminLabel05, new org.netbeans.lib.awtextra.AbsoluteConstraints(44, 136, 75, -1));

        employeeNum_admin.setFont(new java.awt.Font("微軟正黑體", 0, 18)); // NOI18N
        employeeNum_admin.setForeground(new java.awt.Color(0, 0, 204));
        employeeNum_admin.setModel(new DefaultComboBoxModel(empArray));
//        employeeNum_admin.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        employeeNum_admin.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                employeeNum_adminActionPerformed(evt);
            }
        });
        adminPanel.add(employeeNum_admin, new org.netbeans.lib.awtextra.AbsoluteConstraints(92, 10, 149, 30));

        adminLabel03.setFont(new java.awt.Font("微軟正黑體", 0, 18)); // NOI18N
        adminLabel03.setText("所屬單位");
        adminPanel.add(adminLabel03, new org.netbeans.lib.awtextra.AbsoluteConstraints(742, 10, -1, 30));

        empPasswd_admin.setFont(new java.awt.Font("微軟正黑體", 0, 18)); // NOI18N
        empPasswd_admin.setForeground(new java.awt.Color(0, 0, 204));
        empPasswd_admin.setText("密碼");
        adminPanel.add(empPasswd_admin, new org.netbeans.lib.awtextra.AbsoluteConstraints(510, 10, 187, 30));

        empDepat_admin.setFont(new java.awt.Font("微軟正黑體", 0, 18)); // NOI18N
        empDepat_admin.setForeground(new java.awt.Color(0, 0, 204));
        empDepat_admin.setText("部門");
        adminPanel.add(empDepat_admin, new org.netbeans.lib.awtextra.AbsoluteConstraints(820, 10, 145, 30));

        employeeName_admin.setFont(new java.awt.Font("微軟正黑體", 0, 18)); // NOI18N
        employeeName_admin.setForeground(new java.awt.Color(0, 0, 204));
        employeeName_admin.setText("帶出員工姓名");
        adminPanel.add(employeeName_admin, new org.netbeans.lib.awtextra.AbsoluteConstraints(245, 10, -1, 30));
        adminPanel.add(jSeparator1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 58, 980, 10));

        adminLabel06.setFont(new java.awt.Font("微軟正黑體", 0, 15)); // NOI18N
        adminLabel06.setText("員工考績表");
        adminPanel.add(adminLabel06, new org.netbeans.lib.awtextra.AbsoluteConstraints(44, 182, -1, -1));

        adminLabel07.setFont(new java.awt.Font("微軟正黑體", 0, 15)); // NOI18N
        adminLabel07.setText("薪資表");
        adminPanel.add(adminLabel07, new org.netbeans.lib.awtextra.AbsoluteConstraints(44, 232, 75, 29));

        adminLabel08.setFont(new java.awt.Font("微軟正黑體", 0, 15)); // NOI18N
        adminLabel08.setText("進貨表");
        adminPanel.add(adminLabel08, new org.netbeans.lib.awtextra.AbsoluteConstraints(44, 284, 75, -1));

        employee_admin.add(employeeY_admin);
        employeeY_admin.setFont(new java.awt.Font("微軟正黑體", 0, 15)); // NOI18N
        employeeY_admin.setText("Yes");
        adminPanel.add(employeeY_admin, new org.netbeans.lib.awtextra.AbsoluteConstraints(178, 82, -1, -1));

        employee_admin.add(employeeN_admin);
        employeeN_admin.setFont(new java.awt.Font("微軟正黑體", 0, 15)); // NOI18N
        employeeN_admin.setText("No");
        adminPanel.add(employeeN_admin, new org.netbeans.lib.awtextra.AbsoluteConstraints(255, 82, 57, -1));

        adminLabel10.setFont(new java.awt.Font("微軟正黑體", 0, 15)); // NOI18N
        adminLabel10.setText("原料庫存表");
        adminPanel.add(adminLabel10, new org.netbeans.lib.awtextra.AbsoluteConstraints(395, 86, -1, -1));

        adminLabel11.setFont(new java.awt.Font("微軟正黑體", 0, 15)); // NOI18N
        adminLabel11.setText("訂單資料表");
        adminPanel.add(adminLabel11, new org.netbeans.lib.awtextra.AbsoluteConstraints(395, 136, -1, -1));

        attendance_admin.add(attendanceY_admin);
        attendanceY_admin.setFont(new java.awt.Font("微軟正黑體", 0, 15)); // NOI18N
        attendanceY_admin.setText("Yes");
        adminPanel.add(attendanceY_admin, new org.netbeans.lib.awtextra.AbsoluteConstraints(178, 132, -1, -1));

        achievement_admin.add(achievementY_admin);
        achievementY_admin.setFont(new java.awt.Font("微軟正黑體", 0, 15)); // NOI18N
        achievementY_admin.setText("Yes");
        adminPanel.add(achievementY_admin, new org.netbeans.lib.awtextra.AbsoluteConstraints(178, 182, -1, -1));

        payRoll_admin.add(payRollY_admin);
        payRollY_admin.setFont(new java.awt.Font("微軟正黑體", 0, 15)); // NOI18N
        payRollY_admin.setText("Yes");
        adminPanel.add(payRollY_admin, new org.netbeans.lib.awtextra.AbsoluteConstraints(178, 232, -1, -1));

        purchase_admin.add(purchaseY_admin);
        purchaseY_admin.setFont(new java.awt.Font("微軟正黑體", 0, 15)); // NOI18N
        purchaseY_admin.setText("Yes");
        adminPanel.add(purchaseY_admin, new org.netbeans.lib.awtextra.AbsoluteConstraints(178, 282, -1, -1));

        attendance_admin.add(attendanceN_admin);
        attendanceN_admin.setFont(new java.awt.Font("微軟正黑體", 0, 15)); // NOI18N
        attendanceN_admin.setText("No");
        adminPanel.add(attendanceN_admin, new org.netbeans.lib.awtextra.AbsoluteConstraints(253, 132, 57, -1));

        achievement_admin.add(achievementN_admin);
        achievementN_admin.setFont(new java.awt.Font("微軟正黑體", 0, 15)); // NOI18N
        achievementN_admin.setText("No");
        adminPanel.add(achievementN_admin, new org.netbeans.lib.awtextra.AbsoluteConstraints(253, 182, 57, -1));

        payRoll_admin.add(payRollN_admin);
        payRollN_admin.setFont(new java.awt.Font("微軟正黑體", 0, 15)); // NOI18N
        payRollN_admin.setText("No");
        adminPanel.add(payRollN_admin, new org.netbeans.lib.awtextra.AbsoluteConstraints(253, 232, 57, -1));

        purchase_admin.add(purchaseN_admin);
        purchaseN_admin.setFont(new java.awt.Font("微軟正黑體", 0, 15)); // NOI18N
        purchaseN_admin.setText("No");
        adminPanel.add(purchaseN_admin, new org.netbeans.lib.awtextra.AbsoluteConstraints(253, 282, 57, -1));

        adminLabel12.setFont(new java.awt.Font("微軟正黑體", 0, 15)); // NOI18N
        adminLabel12.setText("訂購項目表");
        adminPanel.add(adminLabel12, new org.netbeans.lib.awtextra.AbsoluteConstraints(395, 186, -1, -1));

        adminLabel13.setFont(new java.awt.Font("微軟正黑體", 0, 15)); // NOI18N
        adminLabel13.setText("異常資料表");
        adminPanel.add(adminLabel13, new org.netbeans.lib.awtextra.AbsoluteConstraints(395, 236, -1, -1));

        adminLabel14.setFont(new java.awt.Font("微軟正黑體", 0, 15)); // NOI18N
        adminLabel14.setText("應付管理表");
        adminPanel.add(adminLabel14, new org.netbeans.lib.awtextra.AbsoluteConstraints(395, 284, -1, -1));

        material_admin.add(materialY_admin);
        materialY_admin.setFont(new java.awt.Font("微軟正黑體", 0, 15)); // NOI18N
        materialY_admin.setText("Yes");
        adminPanel.add(materialY_admin, new org.netbeans.lib.awtextra.AbsoluteConstraints(496, 82, -1, -1));

        orderList_admin.add(orderListY_admin);
        orderListY_admin.setFont(new java.awt.Font("微軟正黑體", 0, 15)); // NOI18N
        orderListY_admin.setText("Yes");
        adminPanel.add(orderListY_admin, new org.netbeans.lib.awtextra.AbsoluteConstraints(496, 132, -1, -1));

        orderItem_admin.add(orderItemY_admin);
        orderItemY_admin.setFont(new java.awt.Font("微軟正黑體", 0, 15)); // NOI18N
        orderItemY_admin.setText("Yes");
        adminPanel.add(orderItemY_admin, new org.netbeans.lib.awtextra.AbsoluteConstraints(496, 182, -1, -1));

        issue_admin.add(issueY_admin);
        issueY_admin.setFont(new java.awt.Font("微軟正黑體", 0, 15)); // NOI18N
        issueY_admin.setText("Yes");
        adminPanel.add(issueY_admin, new org.netbeans.lib.awtextra.AbsoluteConstraints(496, 232, -1, -1));

        payableList_admin.add(payableListY_admin);
        payableListY_admin.setFont(new java.awt.Font("微軟正黑體", 0, 15)); // NOI18N
        payableListY_admin.setText("Yes");
        adminPanel.add(payableListY_admin, new org.netbeans.lib.awtextra.AbsoluteConstraints(496, 280, -1, -1));

        material_admin.add(materialN_admin);
        materialN_admin.setFont(new java.awt.Font("微軟正黑體", 0, 15)); // NOI18N
        materialN_admin.setText("No");
        adminPanel.add(materialN_admin, new org.netbeans.lib.awtextra.AbsoluteConstraints(571, 82, 57, -1));

        orderList_admin.add(orderListN_admin);
        orderListN_admin.setFont(new java.awt.Font("微軟正黑體", 0, 15)); // NOI18N
        orderListN_admin.setText("No");
        adminPanel.add(orderListN_admin, new org.netbeans.lib.awtextra.AbsoluteConstraints(571, 132, 57, -1));

        orderItem_admin.add(orderItemN_admin);
        orderItemN_admin.setFont(new java.awt.Font("微軟正黑體", 0, 15)); // NOI18N
        orderItemN_admin.setText("No");
        adminPanel.add(orderItemN_admin, new org.netbeans.lib.awtextra.AbsoluteConstraints(571, 182, 57, -1));

        issue_admin.add(issueN_admin);
        issueN_admin.setFont(new java.awt.Font("微軟正黑體", 0, 15)); // NOI18N
        issueN_admin.setText("No");
        adminPanel.add(issueN_admin, new org.netbeans.lib.awtextra.AbsoluteConstraints(571, 232, 57, -1));

        payableList_admin.add(payableListN_admin);
        payableListN_admin.setFont(new java.awt.Font("微軟正黑體", 0, 15)); // NOI18N
        payableListN_admin.setText("No");
        adminPanel.add(payableListN_admin, new org.netbeans.lib.awtextra.AbsoluteConstraints(571, 280, 57, -1));

        adminLabel15.setFont(new java.awt.Font("微軟正黑體", 0, 15)); // NOI18N
        adminLabel15.setText("資產管理表");
        adminPanel.add(adminLabel15, new org.netbeans.lib.awtextra.AbsoluteConstraints(395, 334, -1, -1));

        adminLabel16.setFont(new java.awt.Font("微軟正黑體", 0, 15)); // NOI18N
        adminLabel16.setText("客戶資料表");
        adminPanel.add(adminLabel16, new org.netbeans.lib.awtextra.AbsoluteConstraints(711, 86, -1, -1));

        adminLabel17.setFont(new java.awt.Font("微軟正黑體", 0, 15)); // NOI18N
        adminLabel17.setText("廠商資料表");
        adminPanel.add(adminLabel17, new org.netbeans.lib.awtextra.AbsoluteConstraints(711, 136, -1, -1));

        adminLabel18.setFont(new java.awt.Font("微軟正黑體", 0, 15)); // NOI18N
        adminLabel18.setText("帳號管理表");
        adminPanel.add(adminLabel18, new org.netbeans.lib.awtextra.AbsoluteConstraints(711, 186, -1, -1));

        adminLabel19.setFont(new java.awt.Font("微軟正黑體", 0, 15)); // NOI18N
        adminLabel19.setText("公告管理表");
        adminPanel.add(adminLabel19, new org.netbeans.lib.awtextra.AbsoluteConstraints(711, 236, -1, -1));

        adminLabel09.setFont(new java.awt.Font("微軟正黑體", 0, 15)); // NOI18N
        adminLabel09.setText("產品資料表");
        adminPanel.add(adminLabel09, new org.netbeans.lib.awtextra.AbsoluteConstraints(44, 334, -1, -1));

        product_admin.add(productY_admin);
        productY_admin.setFont(new java.awt.Font("微軟正黑體", 0, 15)); // NOI18N
        productY_admin.setText("Yes");
        adminPanel.add(productY_admin, new org.netbeans.lib.awtextra.AbsoluteConstraints(178, 332, -1, -1));

        asset_admin.add(assetY_admin);
        assetY_admin.setFont(new java.awt.Font("微軟正黑體", 0, 15)); // NOI18N
        assetY_admin.setText("Yes");
        adminPanel.add(assetY_admin, new org.netbeans.lib.awtextra.AbsoluteConstraints(496, 330, -1, -1));

        product_admin.add(productN_admin);
        productN_admin.setFont(new java.awt.Font("微軟正黑體", 0, 15)); // NOI18N
        productN_admin.setText("No");
        adminPanel.add(productN_admin, new org.netbeans.lib.awtextra.AbsoluteConstraints(253, 332, 57, -1));

        asset_admin.add(assetN_admin);
        assetN_admin.setFont(new java.awt.Font("微軟正黑體", 0, 15)); // NOI18N
        assetN_admin.setText("No");
        adminPanel.add(assetN_admin, new org.netbeans.lib.awtextra.AbsoluteConstraints(571, 330, 57, -1));

        member_admin.add(memberY_admin);
        memberY_admin.setFont(new java.awt.Font("微軟正黑體", 0, 15)); // NOI18N
        memberY_admin.setText("Yes");
        adminPanel.add(memberY_admin, new org.netbeans.lib.awtextra.AbsoluteConstraints(804, 82, -1, -1));

        vendor_admin.add(vendorY_admin);
        vendorY_admin.setFont(new java.awt.Font("微軟正黑體", 0, 15)); // NOI18N
        vendorY_admin.setText("Yes");
        adminPanel.add(vendorY_admin, new org.netbeans.lib.awtextra.AbsoluteConstraints(804, 132, -1, -1));

        adminList_admin.add(adminY_admin);
        adminY_admin.setFont(new java.awt.Font("微軟正黑體", 0, 15)); // NOI18N
        adminY_admin.setText("Yes");
        adminPanel.add(adminY_admin, new org.netbeans.lib.awtextra.AbsoluteConstraints(804, 182, -1, -1));

        billboard_admin.add(billboardY_admin);
        billboardY_admin.setFont(new java.awt.Font("微軟正黑體", 0, 15)); // NOI18N
        billboardY_admin.setText("Yes");
        adminPanel.add(billboardY_admin, new org.netbeans.lib.awtextra.AbsoluteConstraints(804, 232, -1, -1));

        member_admin.add(memberN_admin);
        memberN_admin.setFont(new java.awt.Font("微軟正黑體", 0, 15)); // NOI18N
        memberN_admin.setText("No");
        adminPanel.add(memberN_admin, new org.netbeans.lib.awtextra.AbsoluteConstraints(879, 82, 57, -1));

        vendor_admin.add(vendorN_admin);
        vendorN_admin.setFont(new java.awt.Font("微軟正黑體", 0, 15)); // NOI18N
        vendorN_admin.setText("No");
        adminPanel.add(vendorN_admin, new org.netbeans.lib.awtextra.AbsoluteConstraints(879, 132, 57, -1));

        adminList_admin.add(adminN_admin);
        adminN_admin.setFont(new java.awt.Font("微軟正黑體", 0, 15)); // NOI18N
        adminN_admin.setText("No");
        adminPanel.add(adminN_admin, new org.netbeans.lib.awtextra.AbsoluteConstraints(879, 182, 57, -1));

        billboard_admin.add(billboardN_admin);
        billboardN_admin.setFont(new java.awt.Font("微軟正黑體", 0, 15)); // NOI18N
        billboardN_admin.setText("No");
        adminPanel.add(billboardN_admin, new org.netbeans.lib.awtextra.AbsoluteConstraints(879, 232, 57, -1));

        adminLabel20.setFont(new java.awt.Font("微軟正黑體", 0, 15)); // NOI18N
        adminLabel20.setText("備註");
        adminPanel.add(adminLabel20, new org.netbeans.lib.awtextra.AbsoluteConstraints(710, 420, 75, -1));

        note_admin.setMaximumSize(new java.awt.Dimension(160, 30));
        note_admin.setMinimumSize(new java.awt.Dimension(160, 30));
        note_admin.setPreferredSize(new java.awt.Dimension(160, 30));
        adminPanel.add(note_admin, new org.netbeans.lib.awtextra.AbsoluteConstraints(810, 420, -1, 33));

        jLabel1.setFont(new java.awt.Font("微軟正黑體", 0, 15)); // NOI18N
        jLabel1.setText("營利報表");
        adminPanel.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(711, 284, 75, -1));

        profit_admin.add(profitY_admin);
        profitY_admin.setFont(new java.awt.Font("微軟正黑體", 0, 15)); // NOI18N
        profitY_admin.setText("Yes");
        adminPanel.add(profitY_admin, new org.netbeans.lib.awtextra.AbsoluteConstraints(804, 280, -1, -1));

        profit_admin.add(profitN_admin);
        profitN_admin.setFont(new java.awt.Font("微軟正黑體", 0, 15)); // NOI18N
        profitN_admin.setText("No");
        adminPanel.add(profitN_admin, new org.netbeans.lib.awtextra.AbsoluteConstraints(879, 280, 57, -1));

        sales_admin.add(salesN_admin);
        salesN_admin.setFont(new java.awt.Font("微軟正黑體", 0, 15)); // NOI18N
        salesN_admin.setText("No");
        adminPanel.add(salesN_admin, new org.netbeans.lib.awtextra.AbsoluteConstraints(883, 330, 57, -1));

        sales_admin.add(salesY_admin);
        salesY_admin.setFont(new java.awt.Font("微軟正黑體", 0, 15)); // NOI18N
        salesY_admin.setText("Yes");
        adminPanel.add(salesY_admin, new org.netbeans.lib.awtextra.AbsoluteConstraints(804, 330, -1, -1));

        jLabel2.setFont(new java.awt.Font("微軟正黑體", 0, 15)); // NOI18N
        jLabel2.setText("銷售報表");
        adminPanel.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(711, 334, 75, -1));

        picking.setFont(new java.awt.Font("微軟正黑體", 0, 15)); // NOI18N
        picking.setText("領料表");
        adminPanel.add(picking, new org.netbeans.lib.awtextra.AbsoluteConstraints(44, 385, 75, -1));

        picking_admin.add(pickingY_admin);
        pickingY_admin.setFont(new java.awt.Font("微軟正黑體", 0, 15)); // NOI18N
        pickingY_admin.setText("Yes");
        adminPanel.add(pickingY_admin, new org.netbeans.lib.awtextra.AbsoluteConstraints(178, 383, -1, -1));

        picking_admin.add(pickingN_admin);
        pickingN_admin.setFont(new java.awt.Font("微軟正黑體", 0, 15)); // NOI18N
        pickingN_admin.setText("No");
        adminPanel.add(pickingN_admin, new org.netbeans.lib.awtextra.AbsoluteConstraints(253, 382, 59, 31));

        jLabel3.setFont(new java.awt.Font("微軟正黑體", 0, 15)); // NOI18N
        jLabel3.setText("網站新聞");
        jLabel3.setPreferredSize(new java.awt.Dimension(75, 21));
        adminPanel.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(395, 385, -1, -1));

        news_admin.add(webNewsY_admin);
        webNewsY_admin.setFont(new java.awt.Font("微軟正黑體", 0, 15)); // NOI18N
        webNewsY_admin.setText("Yes");
        webNewsY_admin.setPreferredSize(new java.awt.Dimension(57, 29));
        adminPanel.add(webNewsY_admin, new org.netbeans.lib.awtextra.AbsoluteConstraints(496, 381, -1, -1));

        news_admin.add(webNewsN_admin);
        webNewsN_admin.setFont(new java.awt.Font("微軟正黑體", 0, 15)); // NOI18N
        webNewsN_admin.setText("No");
        webNewsN_admin.setPreferredSize(new java.awt.Dimension(57, 29));
        adminPanel.add(webNewsN_admin, new org.netbeans.lib.awtextra.AbsoluteConstraints(571, 381, -1, -1));

        jLabel4.setFont(new java.awt.Font("微軟正黑體", 0, 15)); // NOI18N
        jLabel4.setText("部門管理");
        jLabel4.setPreferredSize(new java.awt.Dimension(75, 21));
        adminPanel.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(711, 378, -1, -1));

        dep_admin1.add(depY_admin);
        depY_admin.setFont(new java.awt.Font("微軟正黑體", 0, 15)); // NOI18N
        depY_admin.setText("Yes");
        depY_admin.setPreferredSize(new java.awt.Dimension(57, 29));
        adminPanel.add(depY_admin, new org.netbeans.lib.awtextra.AbsoluteConstraints(804, 374, -1, -1));

        dep_admin1.add(depN_admin);
        depN_admin.setFont(new java.awt.Font("微軟正黑體", 0, 15)); // NOI18N
        depN_admin.setText("No");
        depN_admin.setPreferredSize(new java.awt.Dimension(57, 29));
        adminPanel.add(depN_admin, new org.netbeans.lib.awtextra.AbsoluteConstraints(883, 374, -1, -1));

        add(adminPanel, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, 470));

    }
    
    private void employeeNum_adminActionPerformed(java.awt.event.ActionEvent evt) {                                                  
    	employID = (String) employeeNum_admin.getSelectedItem();
    	if(employID.length()>0){
    		generateInfo();//帶出對應名稱
    	}
    }      
    
    protected void getDefault(){
        employee_admin.clearSelection();
        attendance_admin.clearSelection();
        achievement_admin.clearSelection();
        payRoll_admin.clearSelection();
        purchase_admin.clearSelection();
        product_admin.clearSelection();
        material_admin.clearSelection();
        orderList_admin.clearSelection();
        orderItem_admin.clearSelection();
        issue_admin.clearSelection();
        payableList_admin.clearSelection();
        asset_admin.clearSelection();
        vendor_admin.clearSelection();
        adminList_admin.clearSelection();
        billboard_admin.clearSelection();
        member_admin.clearSelection();
        sales_admin.clearSelection();
        profit_admin.clearSelection();
        picking_admin.clearSelection();
        news_admin.clearSelection();
        dep_admin1.clearSelection();
        employeeNum_admin.setSelectedIndex(0);
        hasId = false; empPasswd_admin.setText(""); empDepat_admin.setText(""); note_admin.setText(""); employeeName_admin.setText("");
        passwd=null; employee=null; attendance=null; achieve=null; payroll=null; product=null; 
 		material=null; orderlist=null; orderitem=null; asset=null; issue=null; member=null;
 		vendor=null; purchase=null; payablelist=null; admin=null; note=null; department=null; billboard=null;
 		employName=null; employID=null; employPW=null; profit=null; sales=null; pickingB=null; news=null; authDept=null;
    	
    }
    
    protected void generateInfo(){ //帶出對應名稱
    	//select * from employee where employeeNum = employID
    	try {
			PreparedStatement getEmp = conn.prepareStatement("select * from employee where employeeNum='"+employID+"'");

    		ResultSet rs = getEmp.executeQuery();
			while(rs.next()){				
				employName = rs.getString("name");
				department = rs.getString("department");
				
				employeeName_admin.setText(employName);
				empDepat_admin.setText(department);				
			}	
			
			PreparedStatement getPW = conn.prepareStatement("select * from admin where employeeNum='"+employID+"'");
    		ResultSet rs2 = getPW.executeQuery();
			while(rs2.next()){				
				employPW = rs2.getString("password");
				empPasswd_admin.setText(employPW);
			}
    	} catch (Exception e) {
			System.out.println("sql-01 check");
			e.printStackTrace();
		}
    }
 
  //取得輸入資料
    protected boolean getSelect(){
    	boolean isRightData = false;
    	//radioBtn selection
    	if(employeeY_admin.isSelected()){employee = "yes";}else if(employeeN_admin.isSelected()){employee = "No";}
    	if(attendanceY_admin.isSelected()){attendance = "yes";}else if(attendanceN_admin.isSelected()){attendance = "No";}
    	if(achievementY_admin.isSelected()){achieve = "yes";}else if(achievementN_admin.isSelected()){achieve = "No";}
    	if(payRollY_admin.isSelected()){payroll = "yes";}else if(payRollN_admin.isSelected()){payroll = "No";}
    	if(purchaseY_admin.isSelected()){purchase = "yes";}else if(purchaseN_admin.isSelected()){purchase = "No";}
    	if(productY_admin.isSelected()){product = "yes";}else if(productN_admin.isSelected()){product = "No";}
    	if(materialY_admin.isSelected()){material = "yes";}else if(materialN_admin.isSelected()){material = "No";}
    	if(orderListY_admin.isSelected()){orderlist = "yes";}else if(orderListN_admin.isSelected()){orderlist = "No";}
    	if(orderItemY_admin.isSelected()){orderitem = "yes";}else if(orderItemN_admin.isSelected()){orderitem = "No";}
    	if(issueY_admin.isSelected()){issue = "yes";}else if(issueN_admin.isSelected()){issue = "No";}
    	if(payableListY_admin.isSelected()){payablelist = "yes";}else if(payableListN_admin.isSelected()){payablelist = "No";}
    	if(assetY_admin.isSelected()){asset = "yes";}else if(assetN_admin.isSelected()){asset = "No";}
    	if(memberY_admin.isSelected()){member = "yes";}else if(memberN_admin.isSelected()){member = "No";}
    	if(vendorY_admin.isSelected()){vendor = "yes";}else if(vendorN_admin.isSelected()){vendor = "No";}
    	if(adminY_admin.isSelected()){admin = "yes";}else if(adminN_admin.isSelected()){admin = "No";}
    	if(billboardY_admin.isSelected()){billboard = "yes";}else if(billboardN_admin.isSelected()){billboard = "No";}
    	if(profitY_admin.isSelected()){profit = "yes";}else if(profitN_admin.isSelected()){profit = "No";}
    	if(salesY_admin.isSelected()){sales = "yes";}else if(salesN_admin.isSelected()){sales = "No";}
    	if(pickingY_admin.isSelected()){pickingB = "yes";}else if(pickingN_admin.isSelected()){pickingB = "No";}
    	if(webNewsY_admin.isSelected()){news = "yes";}else if(webNewsN_admin.isSelected()){news = "No";}
    	if(depY_admin.isSelected()){authDept = "yes";}else if(depN_admin.isSelected()){authDept = "No";}
	
    	//if password null, set default;
    	if(empPasswd_admin.getText()==""){
    		passwd = "123456";
    	}else{
    		passwd = empPasswd_admin.getText();
    	}
    	    	
    	//get remark content
    	note = note_admin.getText();    	
    	//combobox get selected & use combobox get empName----->apply in actionListener  
    	try{
	    	if(employee.equals("")||attendance.equals("")||achieve.equals("")||payroll.equals("")||purchase.equals("")||
	    			attendance.equals("")||achieve.equals("")||payroll.equals("")||purchase.equals("")||product.equals("")||
	    			material.equals("")||orderlist.equals("")||orderitem.equals("")||issue.equals("")||payablelist.equals("")||
	    			asset.equals("")||member.equals("")||vendor.equals("")||admin.equals("")||billboard.equals("")){
	    		isRightData = false;
	    	}
	    	else{
	    		isRightData = true;
	    	}
    	}catch(Exception a){
    		System.out.println("getSelect null xx");
    	}
    	return isRightData;
    }
    
  //抓到資料庫人員id資料塞入list
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
    
    private void updateInTime(){//combo box及時更新資料庫資料
    	empList.clear();    	
    	empList.add("");
    	
    	//re-update data from db
    	getEmpIdlist();    	
    	employeeNum_admin.setModel(new DefaultComboBoxModel(empArray));  
    }
    
    protected LinkedList<String[]> queryData() {
    	getDefault();
    	updateInTime();
    	generateInfo();
		LinkedList<String[]> data = new LinkedList<>();
		try{
			PreparedStatement pstmt = conn.prepareStatement("SELECT * FROM admin");
			ResultSet rs = pstmt.executeQuery();
	    	while(rs.next()){
	    		String[] row = new String[25];
	    		row [0] = rs.getString("employeeNum");
	    		row [1] = rs.getString("password");
	    		row [2] = rs.getString("employee");
	    		row [3] = rs.getString("attendance");
	    		row [4] = rs.getString("achievement");
	    		row [5] = rs.getString("payRoll");
	    		row [6] = rs.getString("products");
	    		row [7] = rs.getString("material");
	    		row [8] = rs.getString("orderList");
	    		row [9] = rs.getString("orderItem");
	    		row [10] = rs.getString("asset");
	    		row [11] = rs.getString("issue");
	    		row [12] = rs.getString("member");
	    		row [13] = rs.getString("vendor");
	    		row [14] = rs.getString("purchase");
	    		row [15] = rs.getString("payableList");
	    		row [16] = rs.getString("admin");
	    		row [17] = rs.getString("billboard");
	    		row [18] = rs.getString("department");
	    		row [19] = rs.getString("picking");
	    		row [20] = rs.getString("webnews");
	    		row [21] = rs.getString("sales");
	    		row [22] = rs.getString("profit");
	    		row [23] = rs.getString("deptSheet");
	    		row [24] = rs.getString("note");	  
	    		data.add(row);
			}
		}
		catch(SQLException ee){			
			System.out.println("adm_query"+ee.toString());
		}
		return data;
    }
    
    protected int delData(){
		int isDel = 0;
		String empN = (String)employeeNum_admin.getSelectedItem();
		if(!empN.equals("")){
			try{
				PreparedStatement pstmt = conn.prepareStatement("DELETE FROM admin WHERE employeeNum = ?");
				pstmt.setString(1, empN);
				isDel = pstmt.executeUpdate();
			}
			catch(SQLException ee){
				System.out.println(ee.toString());
			}
		}
		return isDel;
	}
    
    protected boolean ifIdexist(){
	    try{
			//先check資料庫是否有id,有就update,沒有insert
	    	PreparedStatement checkId = conn.prepareStatement("select * from admin where employeeNum ="+employID);     
	    	ResultSet rs = checkId.executeQuery();
	    	while(rs.next()){
	    		hasId = true;
	    		return true;	    		
	    	}	    	    	
		}catch(Exception a){
			System.out.println("ifIdexist error");
			a.printStackTrace();
		}    
	    return false;
    }
    
    protected int editDB(){   
    	int isUpdate = 0;
    	employID = (String) employeeNum_admin.getSelectedItem();
    	if (getSelect() == true && !employID.equals("")) {
    		ifIdexist();	    	
    		String sql = "update admin set employee=?, attendance=?, achievement=?, payRoll=?, products=?, "
	    			+ "material=?, orderList=?, orderItem=?, asset=?, issue=?, member=?,vendor=?, "
	    			+ "purchase=?, payableList=?, admin=?, note=?, billboard=?, department=?, password=?, "
	    			+ "sales=?, profit=?, picking=?, webnews=?, deptSheet=? where employeeNum ='"+employID+"'";
	    	
	    	if(hasId){ //資料庫有資料 	
		    	try{	    		    		
			    	PreparedStatement insertdb = conn.prepareStatement(sql); 		    	
			    	insertdb.setString(1, employee);
			    	insertdb.setString(2, attendance);
			    	insertdb.setString(3, achieve);
			    	insertdb.setString(4, payroll);
			    	insertdb.setString(5, product);
			    	insertdb.setString(6, material);
			    	insertdb.setString(7, orderlist);
			    	insertdb.setString(8, orderitem);
			    	insertdb.setString(9, asset);
			    	insertdb.setString(10, issue);
			    	insertdb.setString(11, member);
			    	insertdb.setString(12, vendor);
			    	insertdb.setString(13, purchase);
			    	insertdb.setString(14, payablelist);
			    	insertdb.setString(15, admin);
			    	insertdb.setString(16, note);
			    	insertdb.setString(17, billboard);
			    	insertdb.setString(18, department);
			    	insertdb.setString(19, passwd);
			    	insertdb.setString(20, sales);
			    	insertdb.setString(21, profit);
			    	insertdb.setString(22, pickingB);
			    	insertdb.setString(23, news);
			    	insertdb.setString(24, authDept);	
			    	isUpdate = insertdb.executeUpdate();
			    	hasId = false;
		    	}catch(Exception a){
		    		System.out.println("editDB error");
		    		a.printStackTrace();
		    	}
	    	}
    	}
    	return isUpdate;
    }
       
    
    protected int insertDB(){
    	int isInsert = 0;
    	String sql = "insert into admin(employeeNum,password,employee,attendance,achievement,payRoll,products,"
    			+ "material,orderList,orderItem,asset,issue,member,vendor,"
    			+ "purchase,payableList,admin,note,department,billboard,sales,profit,picking,webnews,deptSheet) values(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
      	if (getSelect() == true) {
	    	if(hasId == false){ //資料庫無資料 	
		    	try{	    			    		
			    	PreparedStatement insertdb = conn.prepareStatement(sql); 
			    	insertdb.setString(1, employID);
			    	insertdb.setString(2, passwd);
			    	insertdb.setString(3, employee);
			    	insertdb.setString(4, attendance);
			    	insertdb.setString(5, achieve);
			    	insertdb.setString(6, payroll);
			    	insertdb.setString(7, product);
			    	insertdb.setString(8, material);
			    	insertdb.setString(9, orderlist);
			    	insertdb.setString(10, orderitem);
			    	insertdb.setString(11, asset);
			    	insertdb.setString(12, issue);
			    	insertdb.setString(13, member);
			    	insertdb.setString(14, vendor);
			    	insertdb.setString(15, purchase);
			    	insertdb.setString(16, payablelist);
			    	insertdb.setString(17, admin);
			    	insertdb.setString(18, note);
			    	insertdb.setString(19, department);
			    	insertdb.setString(20, billboard);
			    	insertdb.setString(21, sales);
			    	insertdb.setString(22, profit);
			    	insertdb.setString(23, pickingB);
			    	insertdb.setString(24, news);
			    	insertdb.setString(25, authDept);		
			    	
			    	isInsert = insertdb.executeUpdate();
		    	}catch(Exception a){
		    		System.out.println("insertDB error");
		    		a.printStackTrace();
		    	}
	    	}	
    	}
    	return isInsert;
    }
    
    protected  LinkedList<String[]> search(String value){
		LinkedList<String[]> data = new LinkedList<>();
		try{
			PreparedStatement pstmt = conn.prepareStatement("SELECT * FROM admin WHERE employeeNum LIKE ? OR password LIKE ? OR employee LIKE ? "
					+ "OR attendance LIKE ? OR achievement LIKE ? OR payRoll LIKE ? OR products LIKE ? OR "
	    			+ "material LIKE ? OR orderList LIKE ? OR orderItem LIKE ? OR asset LIKE ? OR issue LIKE ? OR member LIKE ? OR vendor LIKE ? OR "
	    			+ "purchase LIKE ? OR payableList LIKE ? OR admin LIKE ? OR billboard LIKE ? OR department LIKE ? OR note LIKE ? "
	    			+ "OR picking LIKE ? OR webnews LIKE ? OR sales LIKE ? OR profit LIKE ? OR deptSheet LIKE ?");
			String query = "%" + value +"%";
			for(int i=1 ; i<26; i++){
				pstmt.setString(i, query);
			}
			ResultSet rs = pstmt.executeQuery();
			
			while(rs.next()){	    		
				String[] row = new String[25];
	    		row [0] = rs.getString("employeeNum");
	    		row [1] = rs.getString("password");
	    		row [2] = rs.getString("employee");
	    		row [3] = rs.getString("attendance");
	    		row [4] = rs.getString("achievement");
	    		row [5] = rs.getString("payRoll");
	    		row [6] = rs.getString("products");
	    		row [7] = rs.getString("material");
	    		row [8] = rs.getString("orderList");
	    		row [9] = rs.getString("orderItem");
	    		row [10] = rs.getString("asset");
	    		row [11] = rs.getString("issue");
	    		row [12] = rs.getString("member");
	    		row [13] = rs.getString("vendor");
	    		row [14] = rs.getString("purchase");
	    		row [15] = rs.getString("payableList");
	    		row [16] = rs.getString("admin");
	    		row [17] = rs.getString("billboard");
	    		row [18] = rs.getString("department");
	    		row [19] = rs.getString("picking");
	    		row [20] = rs.getString("webnews");
	    		row [21] = rs.getString("sales");
	    		row [22] = rs.getString("profit");
	    		row [23] = rs.getString("deptSheet");
	    		row [24] = rs.getString("note");  
	    		data.add(row);
			}			
		}
		catch(SQLException ee){
			System.out.println(ee.toString());
		}
		return data;
	}
    
        
    protected void setInputValue(HashMap<Integer, String> data) {
		
		if (data.get(2).equals("yes")) {
			employeeY_admin.setSelected(true);
		} else {
			employeeN_admin.setSelected(true);
		}
		if (data.get(3).equals("yes")) {
			attendanceY_admin.setSelected(true);
		} else {
			attendanceN_admin.setSelected(true);
		}
		if (data.get(4).equals("yes")) {
			achievementY_admin.setSelected(true);
		} else {
			achievementN_admin.setSelected(true);
		}
		if (data.get(5).equals("yes")) {
			payRollY_admin.setSelected(true);
		} else {
			payRollN_admin.setSelected(true);
		}
		if (data.get(6).equals("yes")) {
			productY_admin.setSelected(true);
		} else {
			productN_admin.setSelected(true);
		}
		if (data.get(7).equals("yes")) {
			materialY_admin.setSelected(true);
		} else {
			materialN_admin.setSelected(true);
		}
		if (data.get(8).equals("yes")) {
			orderListY_admin.setSelected(true);
		} else {
			orderListN_admin.setSelected(true);
		}
		if (data.get(9).equals("yes")) {
			orderItemY_admin.setSelected(true);
		} else {
			orderItemN_admin.setSelected(true);
		}
		if (data.get(10).equals("yes")) {
			assetY_admin.setSelected(true);
		} else {
			assetN_admin.setSelected(true);
		}
		if (data.get(11).equals("yes")) {
			issueY_admin.setSelected(true);
		} else {
			issueN_admin.setSelected(true);
		}
		if (data.get(12).equals("yes")) {
			memberY_admin.setSelected(true);
		} else {
			memberN_admin.setSelected(true);
		}
		if (data.get(13).equals("yes")) {
			vendorY_admin.setSelected(true);
		} else {
			vendorN_admin.setSelected(true);
		}
		if (data.get(14).equals("yes")) {
			purchaseY_admin.setSelected(true);
		} else {
			purchaseN_admin.setSelected(true);
		}
		if (data.get(15).equals("yes")) {
			payableListY_admin.setSelected(true);
		} else {
			payableListN_admin.setSelected(true);
		}
		if (data.get(16).equals("yes")) {
			adminY_admin.setSelected(true);
		} else {
			adminN_admin.setSelected(true);
		}
		if (data.get(17).equals("yes")) {
			billboardY_admin.setSelected(true);
		} else {
			billboardN_admin.setSelected(true);
		}
		//*------
		if (data.get(19).equals("yes")) {
			pickingY_admin.setSelected(true);
		} else {
			pickingN_admin.setSelected(true);
		}
		if (data.get(20).equals("yes")) {
			webNewsY_admin.setSelected(true);
		} else {
			webNewsN_admin.setSelected(true);
		}
		if (data.get(21).equals("yes")) {
			salesY_admin.setSelected(true);
		} else {
			salesN_admin.setSelected(true);
		}
		if (data.get(22).equals("yes")) {
			profitY_admin.setSelected(true);
		} else {
			profitN_admin.setSelected(true);
		}	
		if (data.get(23).equals("yes")) {
			depY_admin.setSelected(true);
		} else {
			depN_admin.setSelected(true);
		}	
		
		note_admin.setText(data.get(24));
		empPasswd_admin.setText(data.get(1));
		empDepat_admin.setText(data.get(18));
		employeeNum_admin.setSelectedItem(data.get(0));
		
	}
    

    // Variables declaration - do not modify                     
    private javax.swing.JRadioButton achievementN_admin;
    private javax.swing.JRadioButton achievementY_admin;
    private javax.swing.ButtonGroup achievement_admin;
    private javax.swing.JLabel adminLabel01;
    private javax.swing.JLabel adminLabel02;
    private javax.swing.JLabel adminLabel03;
    private javax.swing.JLabel adminLabel04;
    private javax.swing.JLabel adminLabel05;
    private javax.swing.JLabel adminLabel06;
    private javax.swing.JLabel adminLabel07;
    private javax.swing.JLabel adminLabel08;
    private javax.swing.JLabel adminLabel09;
    private javax.swing.JLabel adminLabel10;
    private javax.swing.JLabel adminLabel11;
    private javax.swing.JLabel adminLabel12;
    private javax.swing.JLabel adminLabel13;
    private javax.swing.JLabel adminLabel14;
    private javax.swing.JLabel adminLabel15;
    private javax.swing.JLabel adminLabel16;
    private javax.swing.JLabel adminLabel17;
    private javax.swing.JLabel adminLabel18;
    private javax.swing.JLabel adminLabel19;
    private javax.swing.JLabel adminLabel20;
    private javax.swing.ButtonGroup adminList_admin;
    private javax.swing.JRadioButton adminN_admin;
    private javax.swing.JPanel adminPanel;
    private javax.swing.JRadioButton adminY_admin;
    private javax.swing.JRadioButton assetN_admin;
    private javax.swing.JRadioButton assetY_admin;
    private javax.swing.ButtonGroup asset_admin;
    private javax.swing.JRadioButton attendanceN_admin;
    private javax.swing.JRadioButton attendanceY_admin;
    private javax.swing.ButtonGroup attendance_admin;
    private javax.swing.JRadioButton billboardN_admin;
    private javax.swing.JRadioButton billboardY_admin;
    private javax.swing.ButtonGroup billboard_admin;
    private javax.swing.JRadioButton depN_admin;
    private javax.swing.JRadioButton depY_admin;
    private javax.swing.ButtonGroup dep_admin1;
    private javax.swing.JLabel empDepat_admin;
    private javax.swing.JLabel empPasswd_admin;
    private javax.swing.JRadioButton employeeN_admin;
    private javax.swing.JLabel employeeName_admin;
    private javax.swing.JComboBox<String> employeeNum_admin;
    private javax.swing.JRadioButton employeeY_admin;
    private javax.swing.ButtonGroup employee_admin;
    private javax.swing.JRadioButton issueN_admin;
    private javax.swing.JRadioButton issueY_admin;
    private javax.swing.ButtonGroup issue_admin;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JRadioButton materialN_admin;
    private javax.swing.JRadioButton materialY_admin;
    private javax.swing.ButtonGroup material_admin;
    private javax.swing.JRadioButton memberN_admin;
    private javax.swing.JRadioButton memberY_admin;
    private javax.swing.ButtonGroup member_admin;
    private javax.swing.ButtonGroup news_admin;
    private javax.swing.JTextField note_admin;
    private javax.swing.JRadioButton orderItemN_admin;
    private javax.swing.JRadioButton orderItemY_admin;
    private javax.swing.ButtonGroup orderItem_admin;
    private javax.swing.JRadioButton orderListN_admin;
    private javax.swing.JRadioButton orderListY_admin;
    private javax.swing.ButtonGroup orderList_admin;
    private javax.swing.JRadioButton payRollN_admin;
    private javax.swing.JRadioButton payRollY_admin;
    private javax.swing.ButtonGroup payRoll_admin;
    private javax.swing.JRadioButton payableListN_admin;
    private javax.swing.JRadioButton payableListY_admin;
    private javax.swing.ButtonGroup payableList_admin;
    private javax.swing.JLabel picking;
    private javax.swing.JRadioButton pickingN_admin;
    private javax.swing.JRadioButton pickingY_admin;
    private javax.swing.ButtonGroup picking_admin;
    private javax.swing.JRadioButton productN_admin;
    private javax.swing.JRadioButton productY_admin;
    private javax.swing.ButtonGroup product_admin;
    private javax.swing.JRadioButton profitN_admin;
    private javax.swing.JRadioButton profitY_admin;
    private javax.swing.ButtonGroup profit_admin;
    private javax.swing.JRadioButton purchaseN_admin;
    private javax.swing.JRadioButton purchaseY_admin;
    private javax.swing.ButtonGroup purchase_admin;
    private javax.swing.JRadioButton salesN_admin;
    private javax.swing.JRadioButton salesY_admin;
    private javax.swing.ButtonGroup sales_admin;
    private javax.swing.JRadioButton vendorN_admin;
    private javax.swing.JRadioButton vendorY_admin;
    private javax.swing.ButtonGroup vendor_admin;
    private javax.swing.JRadioButton webNewsN_admin;
    private javax.swing.JRadioButton webNewsY_admin;
    // End of variables declaration                   
}
