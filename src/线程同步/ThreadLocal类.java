package 线程同步;

/** 
 * @author ZhangHao: 
 * @date 创建时间:2020-9-20 20:38:00  
 * @version 1.0 
 
*/
public class ThreadLocal类 {
	  public static void main(String args[]){  
	        final Bank1 bank=new Bank1();  
	        
	        Thread tadd=new Thread(new Runnable() {  
	            @Override  
	            public void run() {  
	                // TODO Auto-generated method stub  
	                while(true){  
	                    try {  
	                        Thread.sleep(1000);  
	                    } catch (InterruptedException e) {  
	                        // TODO Auto-generated catch block  
	                        e.printStackTrace();  
	                    }  
	                    System.out.println("---------------------");  
	                    bank.addMoney(100);  
	                    bank.lookMoney();  
	                    System.out.println("---------------------");  
	                }  
	            }  
	        });  
	        
	        Thread tsub = new Thread(new Runnable() {  
	            @Override  
	            public void run() {  
	                // TODO Auto-generated method stub  
	                while(true){  
	                   // bank.subMoney(100);  
	                	 System.out.println("==========================");  
	                    bank.lookMoney();  
	                    System.out.println("==========================");  
	                    try {  
	                        Thread.sleep(1000);  
	                    } catch (InterruptedException e) {  
	                        // TODO Auto-generated catch block  
	                        e.printStackTrace();  
	                    }     
	                }  
	            }  
	        });  
	        
	        tsub.start();  
	        tadd.start();  
	    }  
}


class Bank1 {  
//	保存线程的独立变量 变量线程之间不共享.
    private static ThreadLocal<Integer> count = new ThreadLocal<Integer>(){  
        @Override  
        protected Integer initialValue() {  
            return 0;  
        }  
    };  
    // 存钱  
    public void addMoney(int money) {  
        count.set(count.get()+money);  
        System.out.println(System.currentTimeMillis() + "存进：" + money);  
    }  
    // 取钱  
    public void subMoney(int money) {  
        if (count.get() - money < 0) {  
            System.out.println("余额不足");  
            return;  
        }  
        count.set(count.get()- money);  
        System.out.println(+System.currentTimeMillis() + "取出：" + money);  
    }  
    // 查询  
    public void lookMoney() {  
        System.out.println("账户余额：" + count.get());  
    }  
}

