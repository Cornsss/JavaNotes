package Thread_Netease;

public class Status_Terminated {
    public static void main(String[] args) throws InterruptedException {
        testInterupt();
    }

    //interupt方法终止线程：
    public static void testInterupt(){
        boolean flag = true;
        Thread thread1 = new Thread(new Runnable() {
            int temp = 0;
            @Override
            public void run() {
                System.out.println("thread1当前状态：" + Thread.currentThread().getState().toString());
                System.out.println("thread1 正在执行业务中");
                while (flag){
                    temp++;
                }
                System.out.println("thread1 业务执行完毕");
            }
        });
        thread1.start();
        try {
            //当线程处于Object.wait\sleep\join\wait的阻塞状态时，调用interupt才生效，抛出异常，在异常体中做自己的处理
            Thread.sleep(200);
            thread1.interrupt();
        } catch (InterruptedException e) {
            System.out.println("interupt方法进入异常======");
            e.printStackTrace();
        }

        System.out.println("thread1执行interupt后的当前状态：" + thread1.getState().toString());
    }

    //自定义标志位来终止线程
    public static void testCustom() throws InterruptedException{

    }
}
