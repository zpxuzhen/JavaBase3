package com.test7.screenShot;

import java.awt.AWTException;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.FlowLayout;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Rectangle;
import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionAdapter;
import java.awt.image.BufferedImage;
import java.awt.image.RescaleOp;
import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JToolBar;
import javax.swing.JWindow;
import javax.swing.filechooser.FileNameExtensionFilter;
import javax.swing.filechooser.FileSystemView;
public class ScreenShotTest2 {
 public static void main(String[] args) {

  EventQueue.invokeLater(new Runnable() { 
   @Override
   public void run() {
    try {
     ScreenShotWindow ssw=new ScreenShotWindow();
     ssw.setVisible(true);
    } catch (AWTException e) {
     e.printStackTrace();
    }
   }
  });
 }
}
/*
 * ��ͼ����
 */
class ScreenShotWindow extends JWindow
{ 
 private int orgx, orgy, endx, endy;
    private BufferedImage image=null;
    private BufferedImage tempImage=null;
    private BufferedImage saveImage=null;

    private ToolsWindow tools=null;

 public ScreenShotWindow() throws AWTException{
   //��ȡ��Ļ�ߴ�
   Dimension d = Toolkit.getDefaultToolkit().getScreenSize();
   this.setBounds(0, 0, d.width, d.height);

   //��ȡ��Ļ
   Robot robot = new Robot();
   image = robot.createScreenCapture(new Rectangle(0, 0, d.width,d.height));

   this.addMouseListener(new MouseAdapter() {
    @Override
   public void mousePressed(MouseEvent e) {
    //����ɿ�ʱ��¼���������꣬�����ز�������
             orgx = e.getX();
             orgy = e.getY();

             if(tools!=null){
              tools.setVisible(false);
             }
   }
   @Override
   public void mouseReleased(MouseEvent e) {
    //����ɿ�ʱ����ʾ��������
    if(tools==null){
     tools=new ToolsWindow(ScreenShotWindow.this,e.getX(),e.getY());
    }else{
     tools.setLocation(e.getX(),e.getY());
    }
    tools.setVisible(true);
    tools.toFront();
   }
  });

   this.addMouseMotionListener(new MouseMotionAdapter() {

   @Override
   public void mouseDragged(MouseEvent e) {
    //����϶�ʱ����¼���겢�ػ洰��
                endx = e.getX();
                endy = e.getY();

                //��ʱͼ�����ڻ�����Ļ���������Ļ��˸
                Image tempImage2=createImage(ScreenShotWindow.this.getWidth(),ScreenShotWindow.this.getHeight());
                Graphics g =tempImage2.getGraphics();
                g.drawImage(tempImage, 0, 0, null);
                int x = Math.min(orgx, endx);
                int y = Math.min(orgy, endy);
                int width = Math.abs(endx - orgx)+1;
                int height = Math.abs(endy - orgy)+1;
                // ����1��ֹwidth��height0
                g.setColor(Color.BLUE);
                g.drawRect(x-1, y-1, width+1, height+1);
                //��1��1���˷�ֹͼƬ���ο򸲸ǵ�
                saveImage = image.getSubimage(x, y, width, height);
                g.drawImage(saveImage, x, y, null);

                ScreenShotWindow.this.getGraphics().drawImage(tempImage2,0,0,ScreenShotWindow.this);
   }
  });
 }

    @Override
    public void paint(Graphics g) {
        RescaleOp ro = new RescaleOp(0.8f, 0, null);
        tempImage = ro.filter(image, null);
        g.drawImage(tempImage, 0, 0, this);
    }
    //����ͼ���ļ�
 public void saveImage() throws IOException {
  JFileChooser jfc=new JFileChooser();
  jfc.setDialogTitle("����");

  //�ļ����������û����˿�ѡ���ļ�
  FileNameExtensionFilter filter = new FileNameExtensionFilter("JPG", "jpg");
  jfc.setFileFilter(filter);

  //��ʼ��һ��Ĭ���ļ������ļ������ɵ������ϣ�
  SimpleDateFormat sdf = new SimpleDateFormat("yyyymmddHHmmss");
     String fileName = sdf.format(new Date());
     File filePath = FileSystemView.getFileSystemView().getHomeDirectory();
     File defaultFile = new File(filePath + File.separator + fileName + ".jpg");
     jfc.setSelectedFile(defaultFile);

  int flag = jfc.showSaveDialog(this);
  if(flag==JFileChooser.APPROVE_OPTION){
   File file=jfc.getSelectedFile();
   String path=file.getPath();
   //����ļ���׺�������û����������׺�������벻��ȷ�ĺ�׺
   if(!(path.endsWith(".jpg")||path.endsWith(".JPG"))){
    path+=".jpg";
   }
   //д���ļ�
   ImageIO.write(saveImage,"jpg",new File(path));
   System.exit(0);
  }
 }
}
/*
 * ��������
 */
class ToolsWindow extends JWindow
{
 private ScreenShotWindow parent;

 public ToolsWindow(ScreenShotWindow parent,int x,int y) {
  this.parent=parent;
  this.init();
  this.setLocation(x, y);
  this.pack();
  this.setVisible(true);
 }

 private void init(){

  this.setLayout(new BorderLayout());
  JToolBar toolBar=new JToolBar("Java ��ͼ");
  toolBar.setLayout(new FlowLayout());
  //���水ť
  JButton saveButton=new JButton(new ImageIcon("images/save.gif"));
  saveButton.setText("save");
  saveButton.setPreferredSize(new Dimension(50, 30));
  saveButton.addActionListener(new ActionListener() { 
   @Override
   public void actionPerformed(ActionEvent e) {
    try {
     parent.saveImage();
    } catch (IOException e1) {
     e1.printStackTrace();
    }
   }
  });
  toolBar.add(saveButton);

  //�رհ�ť
  JButton closeButton=new JButton(new ImageIcon("images/close.gif"));
  closeButton.setText("close");
  closeButton.setPreferredSize(new Dimension(50, 30));
  closeButton.addActionListener(new ActionListener() {
   @Override
   public void actionPerformed(ActionEvent e) {
    System.exit(0);
   }
  });
  toolBar.add(closeButton);

  this.add(toolBar,BorderLayout.CENTER);
 }
}