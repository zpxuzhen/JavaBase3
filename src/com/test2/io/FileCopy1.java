package com.test2.io;
/**
 * �ļ�����(������)
 * 
 */
import java.io.*;
public class FileCopy1 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//˼·   �Ȱ�ͼƬ���뵽�ڴ�---->��д��ĳ���ļ�
		//��Ϊ�Ƕ������ļ������ֻ����  �ֽ������
		FileInputStream f1 = null;
		FileOutputStream f2 = null;
		
		try {
			f1 = new FileInputStream("D:/bb.txt");
			f2 = new FileOutputStream("D:/aa.txt");
			byte buf[] = new byte[1024];
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
