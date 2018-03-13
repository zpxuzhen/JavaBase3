/**
 * 客户端
 * ---全双工
 */
package com.test4.socket.s3;
import javax.swing.*;
import java.awt.event.*;
import java.io.*;
import java.net.*;
public class MyClient3 extends JFrame implements ActionListener, KeyListener{

	JTextArea jta=null;
	JTextField jtf=null;
	JButton jb=null;
	JScrollPane jsp=null;
	JPanel jp1=null;
	PrintWriter pw=null;
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		MyClient3 ms=new MyClient3();
	}
	
	public MyClient3()
	{
		jta=new JTextArea();
		jsp=new JScrollPane(jta);
		jtf=new JTextField(10);
		jtf.addKeyListener(this);
		jb=new JButton("发送");
		jb.addActionListener(this);
		
		jp1=new JPanel();
		jp1.add(jtf);
		jp1.add(jb);
		this.add(jsp,"Center");
		this.add(jp1, "South");
		this.setTitle("qq简易聊天，客户端");
		this.setSize(300,200);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
//		this.addWindowListener(new WindowAdapter() {
//			@Override
//			public void windowClosing(WindowEvent e) {
//				// TODO Auto-generated method stub
//				super.windowClosing(e);
//				System.out.println("关闭连接");
//				try {
//					s.close();
//				} catch (IOException e1) {
//					// TODO Auto-generated catch block
//					e1.printStackTrace();
//				}
//			}
//		});
		this.setVisible(true);
		
		try {
			Socket s=new Socket("127.0.0.1", 9999);
			
			InputStreamReader isr=new InputStreamReader(s.getInputStream());
			BufferedReader br=new BufferedReader(isr);
			
			pw=new PrintWriter(s.getOutputStream(), true);
			while(true)
			{
				//不停的读从服务器发来的信息
				String info=br.readLine();
				jta.append("服务器对客户端说"+info+"\r\n");
			}
			
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
	}

	public void actionPerformed(ActionEvent arg0) {
		// TODO Auto-generated method stub
		if(arg0.getSource()==jb)
		{
			sendMsg();
		}
	}

	public void keyTyped(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}

	public void keyPressed(KeyEvent e) {
		// TODO Auto-generated method stub
		//按Ctrl+回车 发送消息
		if(e.getKeyChar() == KeyEvent.VK_ENTER && e.isControlDown()){
//			System.out.println("发送");
			sendMsg();
		}
	}

	public void keyReleased(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}
	
	//发送消息的函数
		public  void sendMsg(){
			//把服务器jtf写的内容发送给客户端
			String info=this.jtf.getText();
			//清空发送框的内容
			this.jtf.setText("");
			//显示在面板上
			this.jta.append("服务器对客户端说： "+info+"\r\n");
			//发送
			this.pw.println(info);
		}

}
