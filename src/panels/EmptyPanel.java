package panels;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.LinkedList;
import javax.swing.table.DefaultTableModel;

public class EmptyPanel extends javax.swing.JPanel {

	private Connection con;
	private String[] billboardFields = { "公告日期", "內容"};
	private LinkedList<String[]> data;
	private myTableModel tableModel;
	public EmptyPanel(Connection con) {
		this.con = con;
		initComponents();
		data = new LinkedList<>();
	}

	private void initComponents() {

		jScrollPane1 = new javax.swing.JScrollPane();
		tbBillboard = new javax.swing.JTable();

		setPreferredSize(new java.awt.Dimension(980, 470));
		setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());
		tbBillboard.getTableHeader().setReorderingAllowed(false);
		tbBillboard.setRowHeight(30);
		tbBillboard.setFont(new java.awt.Font("微軟正黑體", 0, 18)); // NOI18N
		tbBillboard
				.setModel(new javax.swing.table.DefaultTableModel(
						new Object[][] { { null, null, null, null }, { null, null, null, null },
								{ null, null, null, null }, { null, null, null, null } },
						new String[] { "Title 1", "Title 2", "Title 3", "Title 4" }));
		
		jScrollPane1.setViewportView(tbBillboard);
		add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(15, 13, 951, 444));

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
	
	private javax.swing.JScrollPane jScrollPane1;
	private javax.swing.JTable tbBillboard;
}
