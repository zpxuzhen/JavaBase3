package com.test2.io;

/**
 * ���ܣ�File��Ļ����÷�
 * @author xuzhen
 *
 */

import java.io.*;

public class FileInfo {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		
		test1();
//		test2();
//		test3();
//		test4();
	}
	//1.�����ļ�
	private static void test1() {
		
		File f = new File("d:/bb.txt");
		if(f.exists()){
			System.out.println("�ļ��Ѵ��ڣ�");
		}else{
			//���Դ���
			try {
				f.createNewFile();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			System.out.println("�����ɹ���");
		}		
	}
	
	//2.��ȡ�ļ���Ϣ
	private static void test2() {
		//����һ���ļ�����
		File f = new File("d:/bb.txt");
		//�õ��ļ���·��
		System.out.println("�ļ�·����"+f.getPath());
		//�õ��ļ��Ĵ�С
		System.out.println("�ļ���С��"+f.length());
		//
		System.out.println("�ɶ���"+f.canRead()+",��д��"+f.canWrite());		
	}
	
	//3.�����ļ���
	private static void test3() {
		
		File f = new File("d:/ff");
		if(f.isDirectory()){
			System.out.println("���ļ����Ѵ���");
		}else{
			//����
			f.mkdir();
			System.out.println("�ļ��д����ɹ�");
		}
		
	}
	
	//4.�г�һ���ļ�������������ļ�
	private static void test4() {
		
		File f = new File("d:/");
		if(f.isDirectory()){
			File lists[] = f.listFiles();
			for(int i=0;i<lists.length;i++){
				System.out.println("�ļ�����"+lists[i].getName());
			}
		}		
	}
}
