package �߳�ͬ��;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * @author ZhangHao:
 * @date ����ʱ��:2020-9-20 19:09:40
 * @version 1.0
 * 
 */
public class ������������wait_notify_notifyAll {

//	��Ʒ����
	private int product;
	private int product_max = 100;

//	��������
	public synchronized void produce() {
		if (this.product >= product_max) {
			try {
				System.out.println("�������");
//				�̵߳ȴ�. ��������״̬.
				wait();
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			return;
		}
		product++;

		System.out.println("�Ѿ�����:" + product + "��Ʒ��");
//��������Ҫ������������߳�.
		notifyAll();

	}

//	���Ѻ���
	public synchronized void consume() {
		if (this.product <= 0) {
			try {
				System.out.println("�޿��,������");
//				�̵߳ȴ�. ��������״̬.
				wait();
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

		}
		product--;

		System.out.println("�Ѿ�����һ����Ʒ," + "���п��:" + product);

//		��������Ҫ������������߳�.
		notifyAll();

	}

	public static void main(String[] args) {
		������������wait_notify_notifyAll demo = new ������������wait_notify_notifyAll();

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

//		�����̳߳�.
		ExecutorService executorService = Executors.newFixedThreadPool(2);

		executorService.execute(produce);
		executorService.execute(consume);

	}

}
