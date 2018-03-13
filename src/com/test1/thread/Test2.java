package com.test1.thread;
/**
 * 演示如何通过Runnable来开发线程
 * @author xuzhen
 *
 */
public class Test2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//注意启动
		Dog dog = new Dog();
		//创建一个Thread对象
		Thread t = new Thread(dog);
		t.start();
	}

}

class Dog implements Runnable{

	
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