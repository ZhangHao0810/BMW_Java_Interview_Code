package �߳�ͬ��;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * @author ZhangHao:
 * @date ����ʱ��:2020-9-20 19:00:55
 * @version 1.0
 * 	���� Synchronized ��, put1 ��put2����ִ��, ���ӵĻ�, �ύ��ִ��.
 * 	��֤��ö��������߳�ִ�е���ԭ���ԵĲ���.
 */

public class SynchDemo3 {

	private Object lock;

	public SynchDemo3() {
		lock = new Object();
	}

//	�������.
	public void put1() {
		synchronized (this.lock) {
			System.out.println("put1 get lock , ����û���ͷ���֮ǰ,�����߳��޷�ִ��.");

			for (int i = 0; i < 20; i++) {
				System.out.println("put1 : " + i);
			}
		}

	}

	public void put2() {
		synchronized (this.lock) {
			System.out.println("put2 get lock , ����û���ͷ���֮ǰ,�����߳��޷�ִ��.");

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
//		�����̳߳�.
		ExecutorService executorService = Executors.newFixedThreadPool(2);

		executorService.execute(r1);
		executorService.execute(r2);
	}

}
