package ʵ�ֶ��̵߳����ַ�ʽ;

/*
�̳�Thread��

����һ���µ��࣬����̳� Thread �࣬Ȼ�󴴽�һ�������ʵ����
�̳��������д run() �������÷��������̵߳���ڵ㡣��Ҳ������� start() ��������ִ�С�
�÷������ܱ���Ϊһ�ֶ��߳�ʵ�ַ�ʽ�����Ǳ�������ʵ���� Runnable �ӿڵ�һ��ʵ����

*/

class ThreadDemo extends Thread {
	private Thread t;
	private String threadName;

	ThreadDemo(String threadName) {
		this.threadName = threadName;
		System.out.println("Creating " + threadName);
	}

	public void run() {
		System.out.println("Running " + threadName);

		try {
			for (int i = 4; i > 0; i++) {
				System.out.println("Thread: " + threadName + ", " + i);
				// ���߳�˯��һ��
				Thread.sleep(50);
			}
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			System.out.println("Thread " + threadName + " interrupted.");
		}
		System.out.println("Thread " + threadName + " exiting.");
	}

	public void start() {
		System.out.println("Starting " + threadName);
		if (t == null) {
			t = new Thread(this, threadName);
			t.start();
		}
	}
}

public class TestThread {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ThreadDemo T1 = new ThreadDemo("Thread-Сè");
		T1.start();
		ThreadDemo T2 = new ThreadDemo("Thread-С��");
		T2.start();
	}

}
