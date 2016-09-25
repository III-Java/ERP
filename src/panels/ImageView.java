package panels;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JLabel;


public class ImageView extends javax.swing.JFrame {
	
	private String path;
	private static File imgFile;
	private static BufferedImage image;
	
    
    public ImageView(String path) {
        initComponents();
        this.path = path;
        imgFile = new File(path);
        showImg();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">                          
    private void initComponents() {

    	 jScrollPane1 = new javax.swing.JScrollPane();
         lbImage = new javax.swing.JLabel();
         btnClose = new javax.swing.JButton();

         setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
         setTitle("檢視選擇的圖片");
         setPreferredSize(new java.awt.Dimension(800, 600));

         jScrollPane1.setViewportView(lbImage);

         btnClose.setText("關閉視窗");
         btnClose.addActionListener(new java.awt.event.ActionListener() {
             public void actionPerformed(java.awt.event.ActionEvent evt) {
                 btnCloseActionPerformed(evt);
             }
         });

         javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
         getContentPane().setLayout(layout);
         layout.setHorizontalGroup(
             layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
             .addGroup(layout.createSequentialGroup()
                 .addContainerGap()
                 .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 780, Short.MAX_VALUE)
                 .addContainerGap())
             .addGroup(layout.createSequentialGroup()
                 .addGap(303, 303, 303)
                 .addComponent(btnClose, javax.swing.GroupLayout.PREFERRED_SIZE, 163, javax.swing.GroupLayout.PREFERRED_SIZE)
                 .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
         );
         layout.setVerticalGroup(
             layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
             .addGroup(layout.createSequentialGroup()
                 .addContainerGap()
                 .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 486, javax.swing.GroupLayout.PREFERRED_SIZE)
                 .addGap(18, 18, 18)
                 .addComponent(btnClose, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                 .addContainerGap(18, Short.MAX_VALUE))
         );

         pack();
    }                   

    private void btnCloseActionPerformed(java.awt.event.ActionEvent evt) {                                         
    	dispose();
    }
    
    protected void showImg(){
    	try {
			image = ImageIO.read(imgFile);
			lbImage.setIcon(new ImageIcon(image));
		} catch (IOException e) {
			System.out.println(e.toString());
		}
    }  
    
    private javax.swing.JButton btnClose;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel lbImage;                
}
