package �߳�ͬ��;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/** 
 * @author ZhangHao: 
 * @date ����ʱ��:2020-9-20 16:16:40  
 * @version 1.0 
  	�Ծ�̬����(��) ����.  Java�õ����� ��������. ������������ļ���������������.
*/
public class SynchDemo2 {

//	�������.
	public static synchronized void put1() {
		System.out.println("put1 get lock , ����û���ͷ���֮ǰ,�����߳��޷�ִ��.");

		for (int i = 0; i < 20; i++) {
			System.out.println("put1 : " + i);
		}
	}

	public static synchronized void put2() {
		System.out.println("put2 get lock , ����û���ͷ���֮ǰ,�����߳��޷�ִ��.");

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
//		�����̳߳�.
		ExecutorService executorService = Executors.newFixedThreadPool(2);
		
		executorService.execute(r2);
		executorService.execute(r1);
	}

}
