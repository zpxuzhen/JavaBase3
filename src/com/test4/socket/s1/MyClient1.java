/**
 * ����һ���ͻ��˳��򣬿������ӷ�������
 */
package com.test4.socket.s1;

import java.net.*;
import java.io.*;

public class MyClient1 {

	public static void main(String[] args) {
		MyClient1 mcl=new MyClient1();
	}
	
	public MyClient1()
	{
		try {
			//Socket,��������ĳ���������ˣ�127.0.0.1��ʾ��������Ip  9999��ʾ�˿ں�
			Socket s=new Socket("127.0.0.1", 9999);
			
			//���s���ӳɹ��� �Ϳ��Է����ݸ�������
			//����ͨ��pw ��sд����  true��ʾˢ����
			PrintWriter pw=new PrintWriter(s.getOutputStream(),true);
			 
			pw.println("��������ǿͻ���");
			
			
			
			
			InputStreamReader isr=new InputStreamReader(s.getInputStream());
			BufferedReader br=new BufferedReader (isr);
			//�ж�ȡ
			String response=br.readLine();
			
			System.out.println("�ͻ����Ѿ��յ���"+response);
			
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		
	}

}
