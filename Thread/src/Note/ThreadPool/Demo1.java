package Note.ThreadPool;


import java.util.concurrent.*;

/**
 * 线程池的4中创建方式
 * 1：可缓存的线程池：如果线程池长度超过处理需要，可灵活回收空闲线程，若无可回收，则新建线程。
 * 2.可固定长度的线程池：
 * 3.可定时启动的线程池
 * 4.单线程化的线程池：保证所有任务按照指定顺序(FIFO, LIFO, 优先级)执行
 *
 * 原理：
 * ThreadPoolExecutor
 * 参数：核心池大小、线程池大小、终止时间、等待时间
 *
 * 如何配置以上参数？
 * CPU密集:各线程响应速度快，线程数和CPU核数相同
 * IO密集:如果有大量的数据库操作、读写、阻塞等，就设置为：CPU*2
 */
public class Demo1 {
    public static void main(String[] args) {
        //可缓存的线程池创建
        ExecutorService newCachedThreadPool = Executors.newCachedThreadPool();
        for (int i = 0; i < 10; i++) {
            int temp = i;
//            temp = 3;//隐式final所以会报错
            newCachedThreadPool.execute(new Runnable() {
                @Override
                public void run() {
                    System.out.println(Thread.currentThread().getName()+":temp="+temp);
                }
            });
        }
        //创建一个定长线程池，可控制线程最大并发数，超出的线程会在队列中等待。
        ExecutorService newFixedThreadPool = Executors.newFixedThreadPool(5);
        for (int i = 0; i < 10; i++) {
            final int temp = i;
            newFixedThreadPool.execute(new Runnable() {

                @Override
                public void run() {
                    System.out.println(Thread.currentThread().getId() + ",i:" + temp);
                }
            });
        }
        //创建一个定长线程池，支持定时及周期性任务执行。
        ScheduledExecutorService newScheduledThreadPool = Executors.newScheduledThreadPool(5);
        for (int i = 0; i < 10; i++) {
            final int temp = i;
            newScheduledThreadPool.schedule(new Runnable() {
                public void run() {
                    System.out.println("i:" + temp);
                }
            }, 3, TimeUnit.SECONDS);
        }
        //创建一个单线程化的线程池，它只会用唯一的工作线程来执行任务，保证所有任务按照指定顺序(FIFO, LIFO, 优先级)执行。
        ExecutorService newSingleThreadExecutor = Executors.newSingleThreadExecutor();
        for (int i = 0; i < 10; i++) {
            final int index = i;
            newSingleThreadExecutor.execute(new Runnable() {

                @Override
                public void run() {
                    System.out.println("index:" + index);
                    try {
                        Thread.sleep(200);
                    } catch (Exception e) {
                        // TODO: handle exception
                    }
                }
            });
        }
    }
}
