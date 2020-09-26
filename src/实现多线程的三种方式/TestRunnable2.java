package 实现多线程的三种方式;


public class TestRunnable2 implements Runnable{
   // 实现 Runnable接口 中的run（）方法
   @Override
   public void run() {
       int times = 5;
       for(int i=0; i<times; i++) {
           System.out.println(Thread.currentThread().getName());
           try {
               Thread.sleep(100);
           }
           catch(InterruptedException ie){
               ie.printStackTrace();
           }
       }
   }
   public static void  main(String args[]) {
       TestRunnable2 runn = new TestRunnable2();
       // 创建线程
       Thread dog = new Thread(runn,"小狗");
       Thread cat = new Thread(runn,"小猫");
       // 启动线程
       dog.start();
       cat.start();
   }
}