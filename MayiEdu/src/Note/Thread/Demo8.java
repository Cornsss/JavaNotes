package Note.Thread;

/**
 * ThreadLocal
 * 提问：三个不同的线程同时生成订单号，如何实现线程间的变量独立？
 */

class ResNumber{
    public static int count = 0;
    public static ThreadLocal<Integer> threadLocal = new ThreadLocal<Integer>(){
        protected Integer initalValue(){
            return 0;
        };
    };

    public Integer getNumber(){
        count = threadLocal.get()+1;
        threadLocal.set(count);
        return  count;
    }
}

class ResThread implements Runnable{

//    private int count = 0;

    //start ThreadLocal优化版本
    private ResNumber resNumber;

    public ResThread(ResNumber resNumber){
        this.resNumber = resNumber;
    }
    //end

    @Override
    public void run() {
        for (int i =0;i < 10;i++){
            System.out.println(Thread.currentThread().getName()+":"+resNumber.getNumber());
//            System.out.println(Thread.currentThread().getName()+":"+(count++));
        }
    }
}

public class Demo8 {
    public static void main(String[] args) {
        //三个线程共享同一个变量
//        ResThread res = new ResThread();
//        Thread t1 = new Thread(res,"线程①");
//        Thread t2 = new Thread(res,"线程②");
//        Thread t3 = new Thread(res,"线程③");
        //end

        //三个线程独立，线程有独立的变量
//        ResThread res1 = new ResThread();
//        ResThread res2 = new ResThread();
//        ResThread res3 = new ResThread();
//        Thread t1 = new Thread(res1,"线程①");
//        Thread t2 = new Thread(res2,"线程②");
//        Thread t3 = new Thread(res3,"线程③");
        //end

        //三个线程独立，线程有独立的变量(优化版本，在ResThread类中结合ThreadLocal)
        ResNumber resNumber = new ResNumber();
        ResThread res = new ResThread(resNumber);
        Thread t1 = new Thread(res,"线程①");
        Thread t2 = new Thread(res,"线程②");
        Thread t3 = new Thread(res,"线程③");
        //end

        t1.start();
        t2.start();
        t3.start();
    }
}
