package com.test1.thread;

/**
 * 
 * @author xuzhen
 * 两个线程同时运行的案例
 *
 */
public class Test3 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Pig p = new Pig(10);
		Bird b = new Bird(10);
		Thread t1 = new Thread(p);
		Thread t2 = new Thread(b);
		t1.start();
		t2.start();
	}

}
//打印
class Pig implements Runnable{
	
	int n=0;
	int times=0;
	public Pig(int n) {
		this.n = n;
	}
	@Override
	public void run() {
		// TODO Auto-generated method stub
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
			System.out.println("我是一个线程，正在输出第"+times+"个hello world!");
			if(times == n)
			{
				//退出线程
				break;
			}
		}
	}
	
}
//算数学题
class Bird implements Runnable{

	int n = 0;
	int res = 0;
	int times = 0;
	public Bird(int n) {
		this.n = n;
	}
	@Override
	public void run() {
		// TODO Auto-generated method stub
		while(true){
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			res +=(++times);
			System.out.println("前"+times+"项和="+res);
			if(times==n)
			{
				System.out.println("最后结果是"+res);
				break;
			}
		}
	}
	
}