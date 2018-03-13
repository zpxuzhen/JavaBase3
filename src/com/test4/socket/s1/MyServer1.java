/**
 * 这是第一个服务器端程序
 * 让他在9999端口监听，
 * 可以接受从客户端发送的数据
 * ----半双工
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
			//在9999号端口监听
			ServerSocket ss=new ServerSocket(9999);
			System.out.println("我是服务器，我正在监听");
			//等待摸个客户来连接，该函数会返回一个Socket连接
			Socket s=ss.accept();
			
			//要读取s中传递的数据
			InputStreamReader isr=new InputStreamReader(s.getInputStream());
			BufferedReader br=new BufferedReader (isr);
			//行读取
			String info=br.readLine();
			
			System.out.println("服务器已经收到，"+info);
			
			PrintWriter pw=new PrintWriter(s.getOutputStream(), true);
			
			pw.println("你好吗，我是服务器");
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}

}
