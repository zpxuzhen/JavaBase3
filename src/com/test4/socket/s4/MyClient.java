/**
 * �ͻ����������֮��ͨ����������ͨ
 * ��������֤�û���������ķ�ʽ��xml��ã��������ö�����
 * --�����ϴ���һ������ ��Ҫ�� implements java.io.Serializable
 */
package com.test4.socket.s4;

import java.net.*;
import java.io.*;

public class MyClient implements java.io.Serializable{

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		MyClient mc=new MyClient();
	}
	
	public MyClient()
	{
		try {
			Socket s=new Socket("127.0.0.1",3456);
			//ͨ��ObjectOutputStream�����������Ͷ���
			ObjectOutputStream oos=new ObjectOutputStream(s.getOutputStream());
			User u=new User();
			u.setName("ɣ��");
			u.setPass("123");
			oos.writeObject(u);
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		
		
	}
}
