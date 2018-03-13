package com.test2.io;
/**
 * 文件拷贝(缓冲字符流)
 * 为了提高效率，引入缓冲字符流
 * 可以按行读取（很方便）,直接操作String
 */
import java.io.*;

public class FileCopy3 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		BufferedReader b1=null;
		FileReader f1 = null;
		BufferedWriter b2=null;
		FileWriter f2 = null;
		try {
			//先创建FileReader对象，然后在升级为BufferedReader
			f1=new FileReader("D:/bb.txt");
			b1=new BufferedReader(f1);
			//先创建FileWriter对象，然后在升级为BufferedWriter
			f2=new FileWriter("D:/dd.txt");
			b2=new BufferedWriter(f2);
			String s = "";
			//循环读取，按行读取
			while((s = b1.readLine()) != null){
				System.out.println(s);
				//输出到磁盘,readLine不带回车换行，自己加上
				b2.write(s+"\r\n");
				b2.flush();//不加这句话，写不进文件
			}
		} catch (IOException e) {
			// TODO: handle exception
			e.printStackTrace();
		}finally{
			try {
				b2.close();
				f2.close();
				b1.close();
				f1.close();
			} catch (IOException e2) {
				// TODO: handle exception
				e2.printStackTrace();
			}
		}
	}

}
