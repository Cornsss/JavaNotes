package Note.Concurrent;

import java.util.concurrent.Semaphore;

/**
 * 10个人抢三个厕所位置的实例代码用于了解Semaphore信号量
 * 我们也可以创建计数为1的Semaphore，将其作为一种类似互斥锁的机制，
 * 这也叫二元信号量，表示两种互斥状态。
 */
public class SemaphoreDemo {
    public static void main(String[] args) {
        Semaphore semaphore = new Semaphore(3);//设定阈值，目前是三个厕所
        for(int i = 0;i < 10;i++){//模拟10个人上厕所
            new ThreadToilet(semaphore,"第"+i+"个人：").start();
        }
    }
}
class ThreadToilet extends Thread {
    Semaphore semaphore;
    private String name;
    public ThreadToilet(Semaphore semaphore,String name){
        this.name =name;
        this.semaphore = semaphore;
    }

    @Override
    public void run() {
        int availableCount = semaphore.availablePermits();
        if(availableCount > 0){
            System.out.println(name+"当前存在空的坑位。。。");
        }else {
            System.out.println(name+"当前坑位已满，请等待。。。");
        }
        try {
            semaphore.acquire();//线程获取资源
            System.out.println(name+"获得坑位,正在上厕所------------------");
            Thread.sleep(3000);//模拟上厕所时间
        }catch (Exception e){

        }finally {
            semaphore.release();//释放资源
            System.out.println(name+"上厕所完毕--------------------------");
        }
    }
}