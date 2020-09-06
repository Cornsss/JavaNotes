package Note.Thread.ThreadProject.OutAndInput;

public class TestThread {
    public static void main(String[] args) {
        Res res = new Res();
        InputThread input = new InputThread(res);
        OutputThread output = new OutputThread(res);
        Thread t1 = new Thread(input,"生产者线程----");
        Thread t2 = new Thread(output,"消费者线程----");
        t1.start();
        t2.start();
    }
}
