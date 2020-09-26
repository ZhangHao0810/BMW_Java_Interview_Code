package 线程同步;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * @author ZhangHao:
 * @date 创建时间:2020-9-20 19:31:54
 * @version 1.0 这个真的很好, 要再敲一下, 才能发现问题.
 * 
 *        我的版本要比老师给的例子要好很多. 
 */
public class 生产者消费者2 {

//	产品个数
	private int product;
	private int product_max = 100;

//	生产函数
//	synchronized  make sure one thread run on this method fully.  一个线程只要获取这个方法, 就会把这个方法跑完才会关闭.
//	如果 不加synchronize的话, 就多个线程随机跑, 互相之间会有影响.
	public synchronized void produce() throws InterruptedException {
		while (true) {
			if (this.product < product_max) {
				this.product += 2;
				System.out.println("库存数量:" + product);
//			这里唤醒必须在等待之前, 不然两个都等待了, 没法唤醒了.notify() 只是唤醒单个线程, 不能唤醒其他的.
				notifyAll();
//			想要每个线程只一次生成一个库存,就要wait();但是不能老wait把, 需要其他线程用notifyAll帮着解开这个线程.
				wait();
			}

			if (this.product >= product_max) {
				System.out.println("库存已满,请消费");
//		这里如果库存满了, 是需要等着人家来消费的, 但是消费线程其实是被上一次消费行为最后给阻塞的, 所以这里要notifyAll, 开启消费线程 开始消费.
				notifyAll(); 
//				要注意， notifyAll（）的同时，自己也是被激活的， 
//				激活的线程会一直执行synchronize方法，直到结束 这里while(true) 结束不了,会一直报库存已满 所以需要wait();
				wait();
			}
		}

	}

//	消费函数
	public synchronized void consume() throws InterruptedException {
		while (true) {
			if (this.product >= 1) {
				this.product--;
				System.out.println("已经消耗一个商品," + "还有库存:" + product);
//			这里唤醒必须在等待之前, 不然两个都等待了, 没法唤醒了.notify() 只是唤醒单个线程, 不能唤醒其他的.
				notifyAll();
//			想要每个线程只一次消费一个库存,就要wait();但是不能老wait把, 需要其他线程用notifyAll帮着解开这个线程.
				wait();
			}
			if (this.product < 1) {
				System.out.println("库存不足,请生产");
//				激活生产线程
				notifyAll();
				wait();
			}
		}
	}

	public static void main(String[] args) {
//		每一个对象,都有一个对象监视器, demo对象的对象监视器管着阻塞还是激活这个对象的线程. 
		生产者消费者2 demo = new 生产者消费者2();

		Runnable produce = new Runnable() {

			@Override
			public void run() {
				// TODO Auto-generated method stub

				try {
					demo.produce();
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}

			}
		};

		Runnable consume = new Runnable() {

			@Override
			public void run() {
				// TODO Auto-generated method stub

				try {
					demo.consume();
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}

			}
		};

//		创建线程池.
		ExecutorService executorService = Executors.newFixedThreadPool(2);

		executorService.execute(produce);
		executorService.execute(consume);

	}

}
