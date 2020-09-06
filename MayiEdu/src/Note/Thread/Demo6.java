package Note.Thread;

import java.util.concurrent.atomic.AtomicInteger;

/**
 * NO.6 voliate不能保证线程安全性的演示类以及使用并发包的AtomicInteger原子类保证线程安全
 *
 */
public class Demo6 extends Thread{

//    private int count = 0;//此时每个线程运行完后的count都是1000，因为此时的count是每个线程的局部变量
//    private static int count = 0;//此时是共享的全部变量，但此处不可以保证线程安全问题
//    private volatile static int count = 0;//加了volatile依然不能保证安全问题，会出现count无法到达100000的问题

    //以下用jdk1.5并发包中的AtomicInteger原子类来实现,虽不能保证过程中的每个线程都使得count达到100的倍数，但可以保证最终结果正确
    private static AtomicInteger count = new AtomicInteger(0);

    public static void main(String[] args) throws InterruptedException {
        Demo6[] threadArr = new Demo6[10];
        for(int i = 0;i< 10;i++){
            threadArr[i] = new Demo6();
        }
        for(int i = 0;i< 10;i++){
            threadArr[i].start();
        }
    }

    @Override
    public void run() {
        for (int i = 0 ;i < 1000;i++){
//            count+=100;
            count.incrementAndGet();
        }
        System.out.println(Thread.currentThread().getName()+"----"+count.get());
    }
}
