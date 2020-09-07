package Note.Concurrent;

import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;

/**
 * 多个线程同时执行时，想在中间等待所有线程同时到达时，再继续执行后面的代码
 */
public class CyclicBarrierDemo {
    public static void main(String[] args) {
        CyclicBarrier cyclicBarrier = new CyclicBarrier(5);
        for (int i =0;i < 5;i++){
            new MyThread(cyclicBarrier).start();
        }
    }
}
class MyThread extends Thread{
    CyclicBarrier cyclicBarrier;
    public MyThread(CyclicBarrier cyclicBarrier){
        this.cyclicBarrier = cyclicBarrier;
    }
    @Override
    public void run() {
        System.out.println(Thread.currentThread().getName()+":开始执行-----------");
        try {
            Thread.sleep(3000);
            System.out.println(Thread.currentThread().getName()+":执行中-------");
            cyclicBarrier.await();
            System.out.println(Thread.currentThread().getName()+":执行结束-----------");
        } catch (InterruptedException | BrokenBarrierException e) {
            e.printStackTrace();
        }
    }
}
