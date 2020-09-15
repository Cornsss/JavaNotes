package Note.Thread.ThreadProject.Lock;

import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.locks.ReentrantLock;

public class TestThread {
    public static void main(String[] args) {
        Res res = new Res();
        res.setLock(new ReentrantLock());
        res.setCondition(res.getLock().newCondition());
        InputThread input = new InputThread(res);
        OutputThread output = new OutputThread(res);
        Thread t1 = new Thread(input,"生产者线程----");
        Thread t2 = new Thread(output,"消费者线程----");
        t1.start();
        t2.start();
        AtomicInteger atomicInteger = new AtomicInteger();
        atomicInteger.incrementAndGet();
    }
}
