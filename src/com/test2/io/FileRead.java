package com.test2.io;

/**
 * 演示FileInputStream类的使用
 * 
 */
import java.io.*;

public class FileRead {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		FileInputStream fis = null;
		File f = new File("D:/bb.txt");
		
		try {
			//因为File没有读写的功能，所以需要使用InputStream流
			fis=new FileInputStream(f);
			//定义一个字节数组，相当于缓存
			byte [] bytes = new byte[1024];
			int n = 0;//得到实际读取到的 字节数
			//循环读取
			while((n=fis.read(bytes)) != -1){
				//把字节转成String
				String s = new String(bytes,0,n);
				System.out.println(s);
			}
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			//一定要在finally中关闭文件流
			try {
				fis.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}

}
