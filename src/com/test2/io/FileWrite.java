package com.test2.io;
/**
 * 演示FileOutputStream类的使用
 * 
 */
import java.io.*;

public class FileWrite {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		File f = new File("D:/bb.txt");
		//字节流输出
		FileOutputStream fos = null;
		
		try {
			//如何文件不存在，会直接创建，如果存在会覆盖，所以，有必要还是判断一下
			fos = new FileOutputStream(f);
			String s1 = new String("Java1 Hello World!\r\n");//回车换行
			String s2 = new String("Java2 Hello World!");
			//如何把String-->byte
			fos.write(s1.getBytes());
			fos.write(s2.getBytes());
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			try {
				fos.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}

}
