/**
 * ���ǵ�һ���������˳���
 * ������9999�˿ڼ�����
 * ���Խ��ܴӿͻ��˷��͵�����
 * ----��˫��
 */

package com.test4.socket.s1;

import java.io.*;
import java.net.*;

public class MyServer1 {

	public static void main(String[] args) {
		MyServer1 msl=new MyServer1();
	}
	
	public MyServer1()
	{
		try {
			//��9999�Ŷ˿ڼ���
			ServerSocket ss=new ServerSocket(9999);
			System.out.println("���Ƿ������������ڼ���");
			//�ȴ������ͻ������ӣ��ú����᷵��һ��Socket����
			Socket s=ss.accept();
			
			//Ҫ��ȡs�д��ݵ�����
			InputStreamReader isr=new InputStreamReader(s.getInputStream());
			BufferedReader br=new BufferedReader (isr);
			//�ж�ȡ
			String info=br.readLine();
			
			System.out.println("�������Ѿ��յ���"+info);
			
			PrintWriter pw=new PrintWriter(s.getOutputStream(), true);
			
			pw.println("��������Ƿ�����");
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}

}
