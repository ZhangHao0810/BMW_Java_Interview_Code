package ʵ�ֶ��̵߳����ַ�ʽ;


public class TestRunnable2 implements Runnable{
   // ʵ�� Runnable�ӿ� �е�run��������
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
       // �����߳�
       Thread dog = new Thread(runn,"С��");
       Thread cat = new Thread(runn,"Сè");
       // �����߳�
       dog.start();
       cat.start();
   }
}