package com.test2.io;
/**
 * ��ʾFileOutputStream���ʹ��
 * 
 */
import java.io.*;

public class FileWrite {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		File f = new File("D:/bb.txt");
		//�ֽ������
		FileOutputStream fos = null;
		
		try {
			//����ļ������ڣ���ֱ�Ӵ�����������ڻḲ�ǣ����ԣ��б�Ҫ�����ж�һ��
			fos = new FileOutputStream(f);
			String s1 = new String("Java1 Hello World!\r\n");//�س�����
			String s2 = new String("Java2 Hello World!");
			//��ΰ�String-->byte
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
