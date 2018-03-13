/**
 * 客户端与服务器之间通过对象流沟通
 * 真正的验证用户名和密码的方式是xml最好，现在先用对象流
 * --网络上传输一个对象 需要加 implements java.io.Serializable
 */
package com.test4.socket.s4;

import java.net.*;
import java.io.*;

public class MyServer  implements java.io.Serializable{

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		MyServer ms=new MyServer();
	}
	
	public MyServer()
	{
		try {
			System.out.println("在3456端口监听，，");
			ServerSocket ss=new ServerSocket(3456);
			Socket s=ss.accept();
			//以对象流的形式读取
			ObjectInputStream ois=new ObjectInputStream(s.getInputStream());
			User u=(User)ois.readObject();
			
			//输出
			System.out.println(u.getName()+u.getPass());
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		
	}

}
