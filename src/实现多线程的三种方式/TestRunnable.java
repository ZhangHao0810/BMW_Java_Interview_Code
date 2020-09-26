package ʵ�ֶ��̵߳����ַ�ʽ;

class RunnableDeao implements Runnable {
	private Thread t;
	private String threadName;

	RunnableDeao(String name) {
		threadName = name;
		System.out.println("Creating " + threadName);
	}

	@Override
	public void run() {
		System.out.println("Running " + threadName);

		try {
			for (int i = 100; i > 0; i--) {
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

public class TestRunnable{
	
	public static void main(String[] args) {
		RunnableDeao r1 = new RunnableDeao("Thread-Сè");
		r1.start();
		RunnableDeao r2 = new RunnableDeao("Thread-С��");
		r2.start();
	}

}
