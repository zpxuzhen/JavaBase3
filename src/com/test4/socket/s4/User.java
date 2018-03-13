/**
 * 客户端与服务器之间通过对象流沟通
 * 真正的验证用户名和密码的方式是xml最好，现在先用对象流
 * --网络上传输一个对象需要加 implements java.io.Serializable
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
