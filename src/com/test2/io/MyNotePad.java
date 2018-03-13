package com.test2.io;
/*
 * �ҵļ��±�(����+����)
 * 
 */

import java.io.*;
import java.awt.*;
import java.awt.event.*;

import javax.swing.*;

public class MyNotePad extends JFrame implements ActionListener{

	//������Ҫ�����
	JTextArea jta=null;
	JScrollPane jsp=null;
	//�˵���
	JMenuBar jmb=null;
	//��һJMenu
	JMenu jm1=null;
	//����JMenuItem
	JMenuItem jmi1=null;
	JMenuItem jmi2=null;
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		MyNotePad np = new MyNotePad();
	}
	
	//���캯��
	public MyNotePad(){
		//���������ı����
		jta=new JTextArea();
		//����
		jsp = new JScrollPane(jta);
		//�����˵���
		jmb=new JMenuBar();
		jm1=new JMenu("�ļ�");

		//�������Ƿ�
		jm1.setMnemonic('F');
		jmi1=new JMenuItem("��",new ImageIcon("images/new.png"));
		
		//ע�����
		jmi1.addActionListener(this);
		jmi1.setActionCommand("open");
		
		jmi2=new JMenuItem("����");
		
		//ע�����
		jmi2.addActionListener(this);
		jmi2.setActionCommand("save");
		
		//����
		this.setJMenuBar(jmb);
		//��jm1����jmb
		jmb.add(jm1);
		//��item����Menu
		jm1.add(jmi1);
		jm1.add(jmi2);
		
		//���뵽JFrame
		this.add(jsp);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setSize(400, 300);
		this.setVisible(true);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		//�ж��ĸ��˵���ѡ��
		//��
		if(e.getActionCommand().equals("open")){
			//System.out.println("open");
			//JFileChooser  �ļ�ѡ�����
			JFileChooser jfc1=new JFileChooser();
			//��������
			jfc1.setDialogTitle("��ѡ���ļ�...");
			//nullʹ��Ĭ�Ϸ�ʽ
			jfc1.showOpenDialog(null);
			//��ʾ
			jfc1.setVisible(true);
			//ѡ�е����ĸ��ļ��ľ���·��
			String filename=jfc1.getSelectedFile().getAbsolutePath();
			//System.out.println(filename);
			//read
			BufferedReader b1=null;
			FileReader f1 = null;
			try {
				//�ȴ���FileReader����Ȼ��������ΪBufferedReader
				f1=new FileReader(filename);
				b1=new BufferedReader(f1);
				String s = "";
				String allCon="";
				//ѭ����ȡ�����ж�ȡ
				while((s = b1.readLine()) != null){
					//System.out.println(s);
					//�õ����е��ַ���
					allCon+=s+"\r\n";									
				}
				//��ʾ������
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
		//����	
		if(e.getActionCommand().equals("save")){
			//���ֱ���Ի���
			JFileChooser jfc2=new JFileChooser();
			jfc2.setDialogTitle("���Ϊ...");
			jfc2.showSaveDialog(null);
			jfc2.setVisible(true);
			
			//�õ��û������·��
			String filename=jfc2.getSelectedFile().getAbsolutePath();
			//write
			BufferedWriter b2=null;
			FileWriter f2 = null;
			try {
				//�ȴ���FileWriter����Ȼ��������ΪBufferedWriter
				f2=new FileWriter(filename);
				b2=new BufferedWriter(f2);		
				b2.write(this.jta.getText());
				b2.flush();//������仰��д�����ļ�
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
