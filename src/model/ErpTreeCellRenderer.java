package model;
import java.awt.Component;
import java.awt.Font;
import java.net.URL;

import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JTree;
import javax.swing.tree.DefaultMutableTreeNode;
import javax.swing.tree.TreeCellRenderer;

public class ErpTreeCellRenderer implements TreeCellRenderer {

	private JLabel label;

	public ErpTreeCellRenderer() {
		label = new JLabel();
		label.setFont(new Font("微軟正黑體", Font.PLAIN, 18));
	}

	public Component getTreeCellRendererComponent(JTree tree, Object value, boolean selected, boolean expanded,
			boolean leaf, int row, boolean hasFocus) {
		Object o = ((DefaultMutableTreeNode) value).getUserObject();
		if (o instanceof TreeIcon) {
			TreeIcon icon = (TreeIcon) o;
			URL imageUrl = getClass().getResource(icon.getIconPath());
			if (imageUrl != null) {
				label.setIcon(new ImageIcon(imageUrl));
			}
			label.setText(icon.getNodeName());
			if(expanded == true){
				URL imageUrl_Expanded = getClass().getResource("/icon/profit.png");
				label.setIcon(new ImageIcon(imageUrl_Expanded));
			}
			else{
				label.setIcon(new ImageIcon(imageUrl));
			}
		} else {
			label.setIcon(null);
			label.setText("" + value);
		}
		return label;
	}
}
