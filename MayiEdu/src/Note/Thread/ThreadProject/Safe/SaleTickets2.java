package Note.Thread.ThreadProject.Safe;

/**
 * 模拟抢火车票演示用同步代码块解决线程安全问题
 * synchronized
 */
class SaleTicketsThread2 implements Runnable{

    private int ticketCount = 100;
    private Object oj = new Object();
    @Override
    public void run() {
        while (ticketCount > 0){
            try {
                Thread.sleep(20);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            synchronized (oj){
                if(ticketCount > 0){
                    System.out.println(Thread.currentThread().getName() + "正在售出第"+(100-ticketCount+1)+"张票");
                    ticketCount--;
                }
            }
        }
    }
}

public class SaleTickets2{
    public static void main(String[] args) {
        SaleTicketsThread2 thread = new SaleTicketsThread2();
        Thread t1 = new Thread(thread,"售票窗口①");
        Thread t2 = new Thread(thread,"售票窗口②");
        t1.start();
        t2.start();
    }
}
