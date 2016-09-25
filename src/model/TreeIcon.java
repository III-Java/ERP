package model;

public class TreeIcon {
	private String nodeName;
	private String iconPath;
	
	public TreeIcon(String nodeName,String iconPath){
		this.nodeName = nodeName;
		this.iconPath = iconPath;
	}
	public String getNodeName() {
		return nodeName;
	}
	public void setNodeName(String nodeName) {
		this.nodeName = nodeName;
	}
	public String getIconPath() {
		return iconPath;
	}
	public void setIconPath(String iconPath) {
		this.iconPath = iconPath;
	}
	@Override
	public String toString() {
		return nodeName ;
	}
	
}
