package Note.Thread;

/**
 * 停止线程案例
 * 1.stop方法：存在线程安全问题，不建议使用。
 * 2.手动建立flag变量，在线程中逻辑结束时更改flag值来停止线程
 * 3.使用interupt方法停止线程
 *   当线程处于wait、sleep、join状态时抛出异常，需要人为的在异常中进行相应的处理
 */
public class Demo7 extends Thread{

    private static boolean flag = true;

    public static void main(String[] args) throws InterruptedException {
        Demo7 thread = new Demo7();
        thread.start();
        Thread.sleep(1000);

//        flag =false;
//        System.out.println("flag已经修改为----"+flag);

        thread.interrupt();
    }

    @Override
    public void run() {
        System.out.println("线程开始启动----");
        while (flag){
            try {
                Thread.sleep(1000);
                this.wait();
            } catch (InterruptedException e) {
                flag =false;
                System.out.println("flag已经修改为----"+flag);
            }
        }
        System.out.println("线程结束----");
    }
}
