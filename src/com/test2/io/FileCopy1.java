package com.test2.io;
/**
 * 文件拷贝(二进制)
 * 
 */
import java.io.*;
public class FileCopy1 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//思路   先把图片读入到内存---->再写入某个文件
		//因为是二进制文件，因此只能用  字节流完成
		FileInputStream f1 = null;
		FileOutputStream f2 = null;
		
		try {
			f1 = new FileInputStream("D:/bb.txt");
			f2 = new FileOutputStream("D:/aa.txt");
			byte buf[] = new byte[1024];
			int n = 0;
			//循环读取
			while((n = f1.read(buf)) != -1){
				//输出到指定文件
				f2.write(buf,0,n);
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			try {
				f1.close();
				f2.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
	}

}
