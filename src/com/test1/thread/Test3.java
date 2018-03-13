package com.test1.thread;

/**
 * 
 * @author xuzhen
 * �����߳�ͬʱ���еİ���
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
//��ӡ
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
			//����һ��,1000ms
			//sleep�����߳̽��뵽Blocked״̬�����ͷ���Դ
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			times++;
			System.out.println("����һ���̣߳����������"+times+"��hello world!");
			if(times == n)
			{
				//�˳��߳�
				break;
			}
		}
	}
	
}
//����ѧ��
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
			System.out.println("ǰ"+times+"���="+res);
			if(times==n)
			{
				System.out.println("�������"+res);
				break;
			}
		}
	}
	
}