package com.test2.io;
/*
 * 我的记事本(界面+功能)
 * 
 */

import java.io.*;
import java.awt.*;
import java.awt.event.*;

import javax.swing.*;

public class MyNotePad extends JFrame implements ActionListener{

	//定义需要的组件
	JTextArea jta=null;
	JScrollPane jsp=null;
	//菜单条
	JMenuBar jmb=null;
	//第一JMenu
	JMenu jm1=null;
	//定义JMenuItem
	JMenuItem jmi1=null;
	JMenuItem jmi2=null;
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		MyNotePad np = new MyNotePad();
	}
	
	//构造函数
	public MyNotePad(){
		//创建多行文本组件
		jta=new JTextArea();
		//滚动
		jsp = new JScrollPane(jta);
		//创建菜单条
		jmb=new JMenuBar();
		jm1=new JMenu("文件");

		//设置助记符
		jm1.setMnemonic('F');
		jmi1=new JMenuItem("打开",new ImageIcon("images/new.png"));
		
		//注册监听
		jmi1.addActionListener(this);
		jmi1.setActionCommand("open");
		
		jmi2=new JMenuItem("保存");
		
		//注册监听
		jmi2.addActionListener(this);
		jmi2.setActionCommand("save");
		
		//加入
		this.setJMenuBar(jmb);
		//把jm1放入jmb
		jmb.add(jm1);
		//把item放入Menu
		jm1.add(jmi1);
		jm1.add(jmi2);
		
		//放入到JFrame
		this.add(jsp);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setSize(400, 300);
		this.setVisible(true);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		//判断哪个菜单被选中
		//打开
		if(e.getActionCommand().equals("open")){
			//System.out.println("open");
			//JFileChooser  文件选择组件
			JFileChooser jfc1=new JFileChooser();
			//设置名字
			jfc1.setDialogTitle("请选择文件...");
			//null使用默认方式
			jfc1.showOpenDialog(null);
			//显示
			jfc1.setVisible(true);
			//选中的是哪个文件的绝对路径
			String filename=jfc1.getSelectedFile().getAbsolutePath();
			//System.out.println(filename);
			//read
			BufferedReader b1=null;
			FileReader f1 = null;
			try {
				//先创建FileReader对象，然后在升级为BufferedReader
				f1=new FileReader(filename);
				b1=new BufferedReader(f1);
				String s = "";
				String allCon="";
				//循环读取，按行读取
				while((s = b1.readLine()) != null){
					//System.out.println(s);
					//得到所有的字符串
					allCon+=s+"\r\n";									
				}
				//显示到界面
				jta.setText(allCon);
			} catch (IOException e1) {
				// TODO: handle exception
				e1.printStackTrace();
			}finally{
				try {
					f1.close();
				} catch (IOException e2) {
					// TODO: handle exception
					e2.printStackTrace();
				}
			}
				
		}else 
		//保存	
		if(e.getActionCommand().equals("save")){
			//出现保存对话框
			JFileChooser jfc2=new JFileChooser();
			jfc2.setDialogTitle("另存为...");
			jfc2.showSaveDialog(null);
			jfc2.setVisible(true);
			
			//得到用户保存的路径
			String filename=jfc2.getSelectedFile().getAbsolutePath();
			//write
			BufferedWriter b2=null;
			FileWriter f2 = null;
			try {
				//先创建FileWriter对象，然后在升级为BufferedWriter
				f2=new FileWriter(filename);
				b2=new BufferedWriter(f2);		
				b2.write(this.jta.getText());
				b2.flush();//不加这句话，写不进文件
			} catch (IOException e1) {
				// TODO: handle exception
				e1.printStackTrace();
			}finally{
				try {
					f2.close();
				} catch (IOException e2) {
					// TODO: handle exception
					e2.printStackTrace();
				}
			}
		}
	}

}
