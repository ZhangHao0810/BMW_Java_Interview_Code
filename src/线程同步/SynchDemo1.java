package �߳�ͬ��;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * @author ZhangHao:
 * @date ����ʱ��:2020-9-20 16:03:47
 * @version 1.0
 *  	�ԷǾ�̬��������.
 */

public class SynchDemo1 {
	
//	ֻ�е� synchronized �������߿�ִ�����֮��, �������̲߳Ż�ִ��.
	public synchronized void put1() {
		System.out.println("put1 get lock , ����û���ͷ���֮ǰ,�����߳��޷�ִ��.");

		for (int i = 0; i < 20; i++) {
			System.out.println("put1 : " + i);
		}
	}

	public synchronized void put2() {
		System.out.println("put2 get lock , ����û���ͷ���֮ǰ,�����߳��޷�ִ��.");

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
//		�����̳߳�.
		ExecutorService executorService = Executors.newFixedThreadPool(2);
		
		executorService.execute(r1);
		executorService.execute(r2);
	}


}
