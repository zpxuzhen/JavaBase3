package com.test2.io;

/**
 * 功能：File类的基本用法
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
	//1.创建文件
	private static void test1() {
		
		File f = new File("d:/bb.txt");
		if(f.exists()){
			System.out.println("文件已存在！");
		}else{
			//可以创建
			try {
				f.createNewFile();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			System.out.println("创建成功！");
		}		
	}
	
	//2.获取文件信息
	private static void test2() {
		//创建一个文件对象
		File f = new File("d:/bb.txt");
		//得到文件的路径
		System.out.println("文件路径："+f.getPath());
		//得到文件的大小
		System.out.println("文件大小："+f.length());
		//
		System.out.println("可读："+f.canRead()+",可写："+f.canWrite());		
	}
	
	//3.创建文件夹
	private static void test3() {
		
		File f = new File("d:/ff");
		if(f.isDirectory()){
			System.out.println("该文件夹已存在");
		}else{
			//创建
			f.mkdir();
			System.out.println("文件夹创建成功");
		}
		
	}
	
	//4.列出一个文件夹下面的所有文件
	private static void test4() {
		
		File f = new File("d:/");
		if(f.isDirectory()){
			File lists[] = f.listFiles();
			for(int i=0;i<lists.length;i++){
				System.out.println("文件名："+lists[i].getName());
			}
		}		
	}
}
