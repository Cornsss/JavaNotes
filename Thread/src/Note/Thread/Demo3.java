package Note.Thread;

/**
 * 面试题：
 * 现在有T1、T2、T3三个线程，你怎样保证T2在T1执行完后执行，T3在T2执行完后执行
 */
public class Demo3 {
    public static void main(String[] args) {
        method1();
    }
    public static void method1(){
        Thread t1 = new Thread(new Runnable() {
            @Override
            public void run() {
                for (int i = 0; i < 30; i++) {
                    System.out.println(Thread.currentThread().getName() + "---i:" + i);
                }
            }
        });
        Thread t2 = new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    t1.join();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                for (int i = 0; i < 30; i++) {
                    System.out.println(Thread.currentThread().getName() + "---i:" + i);
                }
            }
        });
        Thread t3 = new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    t2.join();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                for (int i = 0; i < 30; i++) {
                    System.out.println(Thread.currentThread().getName() + "---i:" + i);
                }
            }
        });
        t1.start();
        t2.start();
        t3.start();
    }
}
