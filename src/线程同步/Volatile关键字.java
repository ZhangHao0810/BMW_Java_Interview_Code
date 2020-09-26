package �߳�ͬ��;

/** 
 * @author ZhangHao: 
 * @date ����ʱ��:2020-9-20 20:27:03  
 * @version 1.0 
 
*/

/**
 * �����߳�
 */
 class MybanRunnable  implements Runnable {
	private Bank bank;

	public MybanRunnable(Bank bank) {
		this.bank = bank;
	}

	@Override
	public void run() {
		for (int i = 0; i < 10; i++) {
			bank.save(100);
			System.out.println("�˻������---" + bank.getAccount());
		}
	}

}
 public class Volatile�ؼ���{
	 	public static void main(String[] args) {
		Bank bank =new Bank();
		bank.userThread();
		
	}
 }

/**
 * ���д��ʵ��
 */
class Bank {
	private volatile int account = 0;

	public int getAccount() {
		return account;
	}

	// ���ڴ˷�������ԭ�Ӳ������������̰߳�ȫ�ģ����ǲ����˷���ʱ��
	// account��ǿ��ȥˢ�»���
	public void save(int money) {
		account += money;
	}

	public void userThread() {
		Bank bank = new Bank();
		MybanRunnable my1 = new MybanRunnable(bank);
		System.out.println("�߳�1����");
		Thread th1 = new Thread(my1);
		th1.start();
		System.out.println("�߳�2����");
		Thread th2 = new Thread(my1);
		th2.start();
	}
}
