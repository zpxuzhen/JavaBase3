package com.test2.io;
/**
 * �ļ�����(�ַ���)
 */
import java.io.*;

public class FileCopy2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		FileReader f1 = null;
		FileWriter f2 = null;
		
		try {
			f1 = new FileReader("D:/bb.txt");
			f2 = new FileWriter("D:/cc.txt");
			//�ַ�������char�ַ�������
			char buf[] = new char[1024];
			int n = 0;
			//ѭ����ȡ
			while((n = f1.read(buf)) != -1){
				//�����ָ���ļ�
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
