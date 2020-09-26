package 实现多线程的三种方式;

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
				// 让线程睡眠一会
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
		RunnableDeao r1 = new RunnableDeao("Thread-小猫");
		r1.start();
		RunnableDeao r2 = new RunnableDeao("Thread-小狗");
		r2.start();
	}

}
