/**
 * 
 */
package com.test4.socket.s2;
import java.net.*;
import java.io.*;
public class MyClient2 {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		MyClient2 my2=new MyClient2();
	}
	
	public MyClient2()
	{
		try {
			//���ӷ�����
			Socket s=new Socket("127.0.0.1", 9999);
			
			PrintWriter pw=new PrintWriter(s.getOutputStream(), true);
			
			InputStreamReader isr=new InputStreamReader(System.in);
			BufferedReader br=new BufferedReader(isr);
			
			InputStreamReader isr2=new InputStreamReader(s.getInputStream());
			BufferedReader br2=new BufferedReader(isr2);
			
			while(true)
			{
				System.out.print("����������Է�����˵�Ļ�");
				//�ͻ��˴ӿ���̨����
				String info=br.readLine();
				//Ȼ���͸�������
				pw.println(info);
				//�˳��Ի�
				if(info.equals("bye"))
				{
					System.out.println("�Ի�����");
					s.close();
					break;
				}
				
				//���ܴӷ����������Ļ�
				String res=br2.readLine();
				
				System.out.println("������˵"+res);
				
			}
			
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
	
		
	}
}
