package 实现多线程的三种方式;

/*
继承Thread类

创建一个新的类，该类继承 Thread 类，然后创建一个该类的实例。
继承类必须重写 run() 方法，该方法是新线程的入口点。它也必须调用 start() 方法才能执行。
该方法尽管被列为一种多线程实现方式，但是本质上是实现了 Runnable 接口的一个实例。

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

public class TestThread {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ThreadDemo T1 = new ThreadDemo("Thread-小猫");
		T1.start();
		ThreadDemo T2 = new ThreadDemo("Thread-小狗");
		T2.start();
	}

}
