package com.test1.thread;

/**
 * 演示如何通过Thread来开发线程
 * @author xuzhen
 *
 */
public class Test1 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//创建一个Cat对象
		Cat cat = new Cat();
		//启动线程,会导致run函数运行
		cat.start();
		
	}

}

class Cat extends Thread{
	
	int times=0;
	//重写run函数
	public void run(){
		while(true){
			//休眠一秒,1000ms
			//sleep会让线程进入到Blocked状态，并释放资源
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			times++;
			System.out.println("hello world!"+times);
			if(times == 10)
			{
				//退出线程
				break;
			}
		}
	}
}
