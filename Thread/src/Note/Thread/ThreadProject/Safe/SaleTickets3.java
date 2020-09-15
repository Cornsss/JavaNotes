package Note.Thread.ThreadProject.Safe;

/**
 * 模拟抢火车票演示用同步函数解决线程安全问题
 * 验证同步函数用的是this锁
 * 方法：
 * 一个线程使用同步代码块(this明锁),
 * 另一个线程使用同步函数。
 */
class SaleTicketsThread3 implements Runnable{

    private int ticketCount = 100;
    private Object oj = new Object();
    public boolean flag = true;
    @Override
    public void run() {
        if(flag){
            while (ticketCount > 0){
                try {
                    Thread.sleep(50);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                sale();
            }
        }else {
            synchronized (this){
                while (ticketCount > 0) {
                    try {
                        Thread.sleep(50);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    if (ticketCount > 0) {
                        System.out.println(Thread.currentThread().getName() + "正在售出第" + (100 - ticketCount + 1) + "张票");
                        ticketCount--;
                    }
                }
            }
        }
    }

    public synchronized void sale(){
        if(ticketCount > 0){
            System.out.println(Thread.currentThread().getName() + "正在售出第"+(100-ticketCount+1)+"张票");
            ticketCount--;
        }
    }
}

public class SaleTickets3{
    public static void main(String[] args) throws InterruptedException {
        SaleTicketsThread3 thread = new SaleTicketsThread3();
        Thread t1 = new Thread(thread,"售票窗口①");
        Thread t2 = new Thread(thread,"售票窗口②");
        t1.start();
        Thread.sleep(50);
        thread.flag =false;
        t2.start();
    }
}
