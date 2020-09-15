package Note.Thread;

class JoinThread implements Runnable {
    public void run() {
        for (int i = 0; i < 30; i++) {
            System.out.println(Thread.currentThread().getName() + "---i:" + i);
        }
    }
}

public class Demo2 {
    public static void main(String[] args) {
        JoinThread joinThread = new JoinThread();
        Thread t1 = new Thread(joinThread);
        Thread t2 = new Thread(joinThread);
        t1.start();
        t2.start();
        try {
            //其他线程变为等待状态，等t1线程执行完成之后才能执行join方法。
            System.out.println("开始执行join方法-----------------");
            t1.join();
            System.out.println("结束执行join方法-----------------");
        } catch (Exception e) {

        }
        for (int i = 0; i < 100; i++) {
            System.out.println("main ---i:" + i);
        }
    }

}
