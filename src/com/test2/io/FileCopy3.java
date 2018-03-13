package com.test2.io;
/**
 * �ļ�����(�����ַ���)
 * Ϊ�����Ч�ʣ����뻺���ַ���
 * ���԰��ж�ȡ���ܷ��㣩,ֱ�Ӳ���String
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
			//�ȴ���FileReader����Ȼ��������ΪBufferedReader
			f1=new FileReader("D:/bb.txt");
			b1=new BufferedReader(f1);
			//�ȴ���FileWriter����Ȼ��������ΪBufferedWriter
			f2=new FileWriter("D:/dd.txt");
			b2=new BufferedWriter(f2);
			String s = "";
			//ѭ����ȡ�����ж�ȡ
			while((s = b1.readLine()) != null){
				System.out.println(s);
				//���������,readLine�����س����У��Լ�����
				b2.write(s+"\r\n");
				b2.flush();//������仰��д�����ļ�
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
