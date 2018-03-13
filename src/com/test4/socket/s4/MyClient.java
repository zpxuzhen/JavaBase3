/**
 * 客户端与服务器之间通过对象流沟通
 * 真正的验证用户名和密码的方式是xml最好，现在先用对象流
 * --网络上传输一个对象 需要加 implements java.io.Serializable
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
			//通过ObjectOutputStream给服务器传送对象
			ObjectOutputStream oos=new ObjectOutputStream(s.getOutputStream());
			User u=new User();
			u.setName("桑阳");
			u.setPass("123");
			oos.writeObject(u);
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		
		
	}
}
