/**
 * �ͻ����������֮��ͨ����������ͨ
 * ��������֤�û���������ķ�ʽ��xml��ã��������ö�����
 * --�����ϴ���һ��������Ҫ�� implements java.io.Serializable
 */
package com.test4.socket.s4;

public class User implements java.io.Serializable{

	private String name;
	private String pass;
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getPass() {
		return pass;
	}
	public void setPass(String pass) {
		this.pass = pass;
	}


}
