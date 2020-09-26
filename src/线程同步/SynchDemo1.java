package 线程同步;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * @author ZhangHao:
 * @date 创建时间:2020-9-20 16:03:47
 * @version 1.0
 *  	对非静态方法加锁.
 */

public class SynchDemo1 {
	
//	只有当 synchronized 方法或者块执行完毕之后, 其他的线程才会执行.
	public synchronized void put1() {
		System.out.println("put1 get lock , 在我没有释放锁之前,其他线程无法执行.");

		for (int i = 0; i < 20; i++) {
			System.out.println("put1 : " + i);
		}
	}

	public synchronized void put2() {
		System.out.println("put2 get lock , 在我没有释放锁之前,其他线程无法执行.");

		for (int i = 0; i < 20; i++) {
			System.out.println("put2 : " + i);
		}
	}
	
	public static void main(String[] args) {
		final SynchDemo1 sy = new SynchDemo1();
		
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
