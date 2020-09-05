package Note.Thread;

/**
 * NO.5 voliate的演示类
 *
 * 1.多线程的三大特性：原子性、可见性、有序性(通过notify、wait等方法实现)
 *
 * java内存模型（重要！！！注意区分java内存结构）
 * 1.内存模型决定两个线程之间是否可见
 * 2.java内存模型会有一个主内存，在各自的线程中会有一个本地内存
 *   当主内存中的全局变量出现变化时会刷新到线程中的本地内存中
 *
 * voliate 保证线程的可见性，但不保证原子性，即不保证安全性。
 */
class ThreadVoliate implements Runnable{
    public volatile boolean flag = true;//不加volatile关键字时会导致程序一直运行，是因为主内存更新后的变量没有刷新到线程的本地内存中
    @Override
    public void run() {
        System.out.println("voliate 线程开始执行-----");
        while (flag){

        }
        System.out.println("voliate 线程执行结束--------------");
    }

}

public class Demo5 {
    public static void main(String[] args) throws InterruptedException {
        ThreadVoliate thread = new ThreadVoliate();
        Thread t1 = new Thread(thread,"voliate测试线程");
        t1.start();
        Thread.sleep(4000);
        thread.flag =false;//主线程修改共享全局变量为false
        System.out.println("flag修改为"+thread.flag);
    }
}
