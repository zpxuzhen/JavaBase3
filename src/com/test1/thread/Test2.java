package com.test1.thread;
/**
 * ��ʾ���ͨ��Runnable�������߳�
 * @author xuzhen
 *
 */
public class Test2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//ע������
		Dog dog = new Dog();
		//����һ��Thread����
		Thread t = new Thread(dog);
		t.start();
	}

}

class Dog implements Runnable{

	
	int times=0;
	//��дrun����
	public void run(){
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
			System.out.println("hello world!"+times);
			if(times == 10)
			{
				//�˳��߳�
				break;
			}
		}
	}
}