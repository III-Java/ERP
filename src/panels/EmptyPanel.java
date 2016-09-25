package panels;

import java.awt.Graphics;
import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.LinkedList;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.table.DefaultTableModel;

public class EmptyPanel extends javax.swing.JPanel {

	private Connection con;
	private String[] billboardFields = { "公告日期", "內容"};
	private LinkedList<String[]> data;
	private myTableModel tableModel;
	ImageIcon newIcon;
	BufferedImage BIMG;

	
	public EmptyPanel(Connection con) {
		this.con = con;
		initComponents();
		data = new LinkedList<>();
		
		try {
			BIMG = ImageIO.read(Login.class.getResource("/panelBG.jpg"));
			newIcon = new ImageIcon(new ImageIcon(BIMG).getImage().getScaledInstance(980, 470, Image.SCALE_DEFAULT));
	
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	private void initComponents() {
		jPanel1 = new javax.swing.JPanel(){
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
		jScrollPane1 = new javax.swing.JScrollPane();
		tbBillboard = new javax.swing.JTable();
		
		jPanel1.setMaximumSize(new java.awt.Dimension(980, 470));
        jPanel1.setMinimumSize(new java.awt.Dimension(980, 470));
        jPanel1.setPreferredSize(new java.awt.Dimension(980, 470));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());
        
        jScrollPane1.setFont(new java.awt.Font("微軟正黑體", 0, 15)); // NOI18N
        jScrollPane1.setOpaque(false);

		tbBillboard.getTableHeader().setReorderingAllowed(false);
		tbBillboard.setRowHeight(30);
		tbBillboard.setFont(new java.awt.Font("微軟正黑體", 0, 18)); // NOI18N
		tbBillboard
				.setModel(new javax.swing.table.DefaultTableModel(
						new Object[][] { { null, null, null, null }, { null, null, null, null },
								{ null, null, null, null }, { null, null, null, null } },
						new String[] { "Title 1", "Title 2", "Title 3", "Title 4" }));
		
		jScrollPane1.setViewportView(tbBillboard);
		  jPanel1.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(15, 13, 951, 444));

	        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
	        this.setLayout(layout);
	        layout.setHorizontalGroup(
	            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
	            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
	        );
	        layout.setVerticalGroup(
	            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
	            .addGroup(layout.createSequentialGroup()
	                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
	                .addGap(0, 0, Short.MAX_VALUE))
	        );
	}// </editor-fold>

	protected void getBillboardContent() {
		data.clear();
		try {
			PreparedStatement pstmt = con.prepareStatement("SELECT issueDate,announce,deadline FROM billboard");
			ResultSet rs = pstmt.executeQuery();
			while (rs.next()) {
				String[] row = new String[3];
				row[0] = rs.getString("issueDate");
				row[1] = rs.getString("announce");
				row[2] = rs.getString("deadline");
				data.add(row);
			}
		} catch (SQLException ee) {
			System.out.println(ee.toString());
		}
	}
	
	protected void checkPublish(){
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy/MM/dd");
		try{
			Date today = new Date();
			for(int i =0; i <data.size(); i++){
				String[] thisData = data.get(i);
				Date parseDate =sdf.parse(thisData[2]);
				if(parseDate.before(today)){
					data.remove(i);
				}
			}
		}
		catch(Exception ee){
			System.out.println(ee.toString());
		}
		tableModel = new myTableModel(billboardFields);
		tbBillboard.setModel(tableModel);
		tableModel.fireTableDataChanged();
	}

	class myTableModel extends DefaultTableModel {
		public myTableModel(String[] fields) {
			super(fields, 0);
		}

		@Override
		public int getRowCount() {
			return data.size();
		}

		@Override
		public int getColumnCount() {
			return billboardFields.length;
		}

		@Override
		public void fireTableCellUpdated(int row, int column) {
			super.fireTableCellUpdated(row, column);
		}

		@Override
		public void setValueAt(Object aValue, int rowIndex, int columnIndex) {

		}

		@Override
		public Object getValueAt(int rowIndex, int columnIndex) {
			try {// 9/4加try catch避免IndexOutOfBoundsException Index: 0, Size: 0
				return data.get(rowIndex)[columnIndex];
			} catch (Exception e) {
				return "";
			}
		}

		@Override
		public boolean isCellEditable(int row, int col) {
			return false;

		}

	}
	
	private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tbBillboard;
}
