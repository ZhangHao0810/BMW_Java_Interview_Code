package 线程同步;

/** 
 * @author ZhangHao: 
 * @date 创建时间:2020-9-20 20:27:03  
 * @version 1.0 
 
*/

/**
 * 创建线程
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
			System.out.println("账户余额是---" + bank.getAccount());
		}
	}

}
 public class Volatile关键字{
	 	public static void main(String[] args) {
		Bank bank =new Bank();
		bank.userThread();
		
	}
 }

/**
 * 银行存款实例
 */
class Bank {
	private volatile int account = 0;

	public int getAccount() {
		return account;
	}

	// 由于此方法不是原子操作，并不是线程安全的，但是操作此方法时候，
	// account会强制去刷新缓存
	public void save(int money) {
		account += money;
	}

	public void userThread() {
		Bank bank = new Bank();
		MybanRunnable my1 = new MybanRunnable(bank);
		System.out.println("线程1启动");
		Thread th1 = new Thread(my1);
		th1.start();
		System.out.println("线程2启动");
		Thread th2 = new Thread(my1);
		th2.start();
	}
}
