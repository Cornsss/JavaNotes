package Note.Thread;

/**
 * 守护线程当进程不存在或主线程停止，守护线程也会被停止。
 * 使用setDaemon(true)方法设置为守护线程
 */
public class Demo1 {

    public static void main(String[] args) {
        Thread thread = new Thread(new Runnable() {
            @Override
            public void run() {
                while (true) {
                    try {
                        Thread.sleep(100);
                    } catch (Exception e) {
                        // TODO: handle exception
                    }
                    System.out.println("我是子线程...");
                }
            }
        });
        thread.setDaemon(false);//设置为守护线程
        thread.start();
        for (int i = 0; i < 10; i++) {
            try {
                Thread.sleep(100);
            } catch (Exception e) {

            }
            System.out.println("我是主线程");
        }
        System.out.println("主线程执行完毕!");
    }

}

