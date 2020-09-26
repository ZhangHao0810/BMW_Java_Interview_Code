package �߳�ͬ��;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * @author ZhangHao:
 * @date ����ʱ��:2020-9-20 19:31:54
 * @version 1.0 �����ĺܺ�, Ҫ����һ��, ���ܷ�������.
 * 
 *        �ҵİ汾Ҫ����ʦ��������Ҫ�úܶ�. 
 */
public class ������������2 {

//	��Ʒ����
	private int product;
	private int product_max = 100;

//	��������
//	synchronized  make sure one thread run on this method fully.  һ���߳�ֻҪ��ȡ�������, �ͻ�������������Ż�ر�.
//	��� ����synchronize�Ļ�, �Ͷ���߳������, ����֮�����Ӱ��.
	public synchronized void produce() throws InterruptedException {
		while (true) {
			if (this.product < product_max) {
				this.product += 2;
				System.out.println("�������:" + product);
//			���﻽�ѱ����ڵȴ�֮ǰ, ��Ȼ�������ȴ���, û��������.notify() ֻ�ǻ��ѵ����߳�, ���ܻ���������.
				notifyAll();
//			��Ҫÿ���߳�ֻһ������һ�����,��Ҫwait();���ǲ�����wait��, ��Ҫ�����߳���notifyAll���Ž⿪����߳�.
				wait();
			}

			if (this.product >= product_max) {
				System.out.println("�������,������");
//		��������������, ����Ҫ�����˼������ѵ�, ���������߳���ʵ�Ǳ���һ��������Ϊ����������, ��������ҪnotifyAll, ���������߳� ��ʼ����.
				notifyAll(); 
//				Ҫע�⣬ notifyAll������ͬʱ���Լ�Ҳ�Ǳ�����ģ� 
//				������̻߳�һֱִ��synchronize������ֱ������ ����while(true) ��������,��һֱ��������� ������Ҫwait();
				wait();
			}
		}

	}

//	���Ѻ���
	public synchronized void consume() throws InterruptedException {
		while (true) {
			if (this.product >= 1) {
				this.product--;
				System.out.println("�Ѿ�����һ����Ʒ," + "���п��:" + product);
//			���﻽�ѱ����ڵȴ�֮ǰ, ��Ȼ�������ȴ���, û��������.notify() ֻ�ǻ��ѵ����߳�, ���ܻ���������.
				notifyAll();
//			��Ҫÿ���߳�ֻһ������һ�����,��Ҫwait();���ǲ�����wait��, ��Ҫ�����߳���notifyAll���Ž⿪����߳�.
				wait();
			}
			if (this.product < 1) {
				System.out.println("��治��,������");
//				���������߳�
				notifyAll();
				wait();
			}
		}
	}

	public static void main(String[] args) {
//		ÿһ������,����һ�����������, demo����Ķ�������������������Ǽ������������߳�. 
		������������2 demo = new ������������2();

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

//		�����̳߳�.
		ExecutorService executorService = Executors.newFixedThreadPool(2);

		executorService.execute(produce);
		executorService.execute(consume);

	}

}
