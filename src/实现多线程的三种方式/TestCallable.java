package ʵ�ֶ��̵߳����ַ�ʽ;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.FutureTask;

//
/**
 * Callable ͨ������̳߳�����.    �������ó���������, �κ�ʱ�򶼻ᰴ��˳��ִ��.
 * @author ZhangHao
 */
public class TestCallable {

	public static void main(String[] args) {
//		����һ�����������̳߳� 3 ��ʾ��3���̵߳��̳߳�.
		ExecutorService service = Executors.newFixedThreadPool(3);

		FutureTask<String> futureTask01 = new FutureTask<String>(new Callable<String>() {

			@Override
			public String call() throws Exception {
				// TODO Auto-generated method stub
				return "Hello";
			}
		});

		FutureTask<String> futureTask02 = new FutureTask<String>(new Callable<String>() {

			@Override
			public String call() throws Exception {
				// TODO Auto-generated method stub
				return "Word";
			}
		});

		service.submit(futureTask01);
		service.submit(futureTask02);

		try {
			System.out.println(futureTask01.get());
			System.out.println(futureTask02.get());
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ExecutionException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
