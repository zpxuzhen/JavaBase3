package com.test1.thread;

/**
 * ��ʾ���ͨ��Thread�������߳�
 * @author xuzhen
 *
 */
public class Test1 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//����һ��Cat����
		Cat cat = new Cat();
		//�����߳�,�ᵼ��run��������
		cat.start();
		
	}

}

class Cat extends Thread{
	
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