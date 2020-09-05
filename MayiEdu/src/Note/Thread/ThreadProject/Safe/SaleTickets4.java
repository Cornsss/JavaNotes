package Note.Thread.ThreadProject.Safe;

/**
 * 线程死锁的演示代码
 */
class SaleTicketsThread4 implements Runnable{

    private int ticketCount = 100;
    private Object oj = new Object();
    public boolean flag = true;
    @Override
    public void run() {
        if(flag){
            while (true){
                sale();//此处先拿到this锁，再拿到oj锁才能执行
            }
        }else {
            synchronized (oj){
                while (true) {
                    sale();//此处先拿到oj锁，再拿到this锁才能执行
                }
            }
        }
    }

    public synchronized void sale(){
        synchronized (oj){
            try {
                Thread.sleep(50);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            if(ticketCount > 0){
                System.out.println(Thread.currentThread().getName() + "正在售出第"+(100-ticketCount+1)+"张票");
                ticketCount--;
            }
        }
    }
}

public class SaleTickets4{
    public static void main(String[] args) throws InterruptedException {
        SaleTicketsThread4 thread = new SaleTicketsThread4();
        Thread t1 = new Thread(thread,"售票窗口①");
        Thread t2 = new Thread(thread,"售票窗口②");
        t1.start();
        Thread.sleep(50);
        thread.flag =false;
        t2.start();
    }
}
