package com.test2.io;

/**
 * ��ʾFileInputStream���ʹ��
 * 
 */
import java.io.*;

public class FileRead {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		FileInputStream fis = null;
		File f = new File("D:/bb.txt");
		
		try {
			//��ΪFileû�ж�д�Ĺ��ܣ�������Ҫʹ��InputStream��
			fis=new FileInputStream(f);
			//����һ���ֽ����飬�൱�ڻ���
			byte [] bytes = new byte[1024];
			int n = 0;//�õ�ʵ�ʶ�ȡ���� �ֽ���
			//ѭ����ȡ
			while((n=fis.read(bytes)) != -1){
				//���ֽ�ת��String
				String s = new String(bytes,0,n);
				System.out.println(s);
			}
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			//һ��Ҫ��finally�йر��ļ���
			try {
				fis.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}

}
