/**
 * ���ܣ���һ���������ˣ� ��9999�˿��ϼ���
 * ����ͨ������̨�����͸��ͻ��˵���Ϣ
 * --��˫��
 */
package com.test4.socket.s2;
import java.net.*;
import java.io.*;
public class MyServer2 {

	public static void main(String[] args)
	{
		MyServer2 ms2=new MyServer2();
	}
	public MyServer2()
	{
		try {
			//��9999�˿��ϼ���
			System.out.println("��������9999������������");
			ServerSocket ss=new ServerSocket(9999);
			//�ȴ�����
			Socket s=ss.accept();
			//�Ƚ��ܿͻ��˷�������Ϣ
			
			InputStreamReader isr=new InputStreamReader(s.getInputStream());
			BufferedReader br=new BufferedReader(isr);
			
			//��������д����
			PrintWriter pw=new PrintWriter(s.getOutputStream(), true);
			
			//���մӿ���̨�������Ϣ
			InputStreamReader isr2=new InputStreamReader(System.in);
			BufferedReader br2=new BufferedReader(isr2);
			
			while(true)
			{
				String infoFromClient=br.readLine();
				System.out.println("�ͻ�����"+infoFromClient);
				
				if(infoFromClient.equals("bye"))
				{
					System.out.println("�˳�");
					s.close();
					break;
				}
				
				//���ִӿ��ƶ�̨���͵���Ϣ
				System.out.println("��������ϣ���Կͻ���˵�Ļ�");
				String response=br2.readLine();
				//�Ѵӿ���̨���ܵ���Ϣ���͵��ͻ���
				pw.println(response);
				
				
			}
			
			
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		
	}
}
