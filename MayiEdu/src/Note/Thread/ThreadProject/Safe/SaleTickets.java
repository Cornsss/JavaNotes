package Note.Thread.ThreadProject.Safe;

/**
 * 模拟抢火车票演示线程安全问题
 * 该程序目前存在安全问题：
 * ....
 * 售票窗口①正在售出第95张票
 * 售票窗口②正在售出第96张票
 * 售票窗口①正在售出第97张票
 * 售票窗口②正在售出第98张票
 * 售票窗口①正在售出第99张票
 * 售票窗口②正在售出第100张票
 * 售票窗口①正在售出第101张票
 */
class SaleTicketsThread implements Runnable{

    private int ticketCount = 100;

    @Override
    public void run() {
        while (ticketCount > 0){
            try {
                Thread.sleep(20);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println(Thread.currentThread().getName() + "正在售出第"+(100-ticketCount+1)+"张票");
            ticketCount--;
        }
    }
}
public class SaleTickets{
    public static void main(String[] args) {
        SaleTicketsThread thread = new SaleTicketsThread();
        Thread t1 = new Thread(thread,"售票窗口①");
        Thread t2 = new Thread(thread,"售票窗口②");
        t1.start();
        t2.start();
    }
}
