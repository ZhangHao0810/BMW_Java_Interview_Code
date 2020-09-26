package 线程同步;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * @author ZhangHao:
 * @date 创建时间:2020-9-20 19:09:40
 * @version 1.0
 * 
 */
public class 生产者消费者wait_notify_notifyAll {

//	产品个数
	private int product;
	private int product_max = 100;

//	生产函数
	public synchronized void produce() {
		if (this.product >= product_max) {
			try {
				System.out.println("库存满了");
//				线程等待. 进入阻塞状态.
				wait();
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			return;
		}
		product++;

		System.out.println("已经存在:" + product + "商品了");
//唤醒所有要用这个方法的线程.
		notifyAll();

	}

//	消费函数
	public synchronized void consume() {
		if (this.product <= 0) {
			try {
				System.out.println("无库存,请生产");
//				线程等待. 进入阻塞状态.
				wait();
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

		}
		product--;

		System.out.println("已经消耗一个商品," + "还有库存:" + product);

//		唤醒所有要用这个方法的线程.
		notifyAll();

	}

	public static void main(String[] args) {
		生产者消费者wait_notify_notifyAll demo = new 生产者消费者wait_notify_notifyAll();

		Runnable produce = new Runnable() {

			@Override
			public void run() {
				// TODO Auto-generated method stub

				demo.produce();

			}
		};

		Runnable consume = new Runnable() {

			@Override
			public void run() {
				// TODO Auto-generated method stub

				demo.consume();

			}
		};

//		创建线程池.
		ExecutorService executorService = Executors.newFixedThreadPool(2);

		executorService.execute(produce);
		executorService.execute(consume);

	}

}
