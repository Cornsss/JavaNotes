package Note.Concurrent;

import java.util.concurrent.CountDownLatch;

/**
 * CountDownLatch实例代码（本质就是计数器）
 */
public class CountDownLatchDemo {

    public static void main(String[] args) {
        CountDownLatch countDownLatch = new CountDownLatch(2);
        new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.println(Thread.currentThread().getName()+":线程执行。。。");
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                countDownLatch.countDown();
            }
        }).start();
        new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.println(Thread.currentThread().getName()+":线程执行。。。");
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                countDownLatch.countDown();
            }
        }).start();
        //想要在上面两个线程执行完毕后再执行主线程怎么办？
        try {
            countDownLatch.await();//设定的初始值为2，如果值不为0的话会一直阻塞
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("主线程执行。。。");
    }
}
