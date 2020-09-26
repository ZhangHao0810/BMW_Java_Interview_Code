package 线程同步;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/** 
 * @author ZhangHao: 
 * @date 创建时间:2020-9-20 16:16:40  
 * @version 1.0 
  	对静态方法(类) 加锁.  Java拿到的是 类对象的锁. 类对象所关联的监视器对象起作用.
*/
public class SynchDemo2 {

//	给类加锁.
	public static synchronized void put1() {
		System.out.println("put1 get lock , 在我没有释放锁之前,其他线程无法执行.");

		for (int i = 0; i < 20; i++) {
			System.out.println("put1 : " + i);
		}
	}

	public static synchronized void put2() {
		System.out.println("put2 get lock , 在我没有释放锁之前,其他线程无法执行.");

		for (int i = 0; i < 20; i++) {
			System.out.println("put2 : " + i);
		}
	}
	
	public static void main(String[] args) {
		final SynchDemo2 sy1 = new SynchDemo2();
		
		final SynchDemo2 sy2 = new SynchDemo2();
		
		Runnable r1 = new Runnable() {
			
			@Override
			public void run() {
				sy1.put1();
			}
		};
		
		Runnable r2 = new Runnable() {
			
			@Override
			public void run() {
				sy2.put2();
			}
		};
//		创建线程池.
		ExecutorService executorService = Executors.newFixedThreadPool(2);
		
		executorService.execute(r2);
		executorService.execute(r1);
	}

}
