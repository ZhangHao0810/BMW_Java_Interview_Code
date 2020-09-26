package 线程同步;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * @author ZhangHao:
 * @date 创建时间:2020-9-20 19:00:55
 * @version 1.0
 * 	加了 Synchronized 块, put1 和put2单独执行, 不加的话, 会交替执行.
 * 	保证获得对象锁的线程执行的是原子性的操作.
 */

public class SynchDemo3 {

	private Object lock;

	public SynchDemo3() {
		lock = new Object();
	}

//	给类加锁.
	public void put1() {
		synchronized (this.lock) {
			System.out.println("put1 get lock , 在我没有释放锁之前,其他线程无法执行.");

			for (int i = 0; i < 20; i++) {
				System.out.println("put1 : " + i);
			}
		}

	}

	public void put2() {
		synchronized (this.lock) {
			System.out.println("put2 get lock , 在我没有释放锁之前,其他线程无法执行.");

			for (int i = 0; i < 20; i++) {
				System.out.println("put2 : " + i);
			}
		}

	}

	public static void main(String[] args) {
		final SynchDemo2 sy = new SynchDemo2();

		Runnable r1 = new Runnable() {

			@Override
			public void run() {
				sy.put1();
			}
		};

		Runnable r2 = new Runnable() {

			@Override
			public void run() {
				sy.put2();
			}
		};
//		创建线程池.
		ExecutorService executorService = Executors.newFixedThreadPool(2);

		executorService.execute(r1);
		executorService.execute(r2);
	}

}
