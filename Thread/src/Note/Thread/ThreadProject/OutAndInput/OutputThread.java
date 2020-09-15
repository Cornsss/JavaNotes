package Note.Thread.ThreadProject.OutAndInput;

public class OutputThread implements Runnable{
    Res res;

    public OutputThread(Res res){
        this.res =res;
    }
    @Override
    public void run() {
        while(true){
            synchronized (res){
                //start add 添加flag使得生产者生产完毕后消费者才能消费
                //    flag=true 生产者生产，消费者等待
                //    flag=false 生产者等待，消费者消费
                if(res.isFlag()){
                    try {
                        res.wait();//线程等待并释放锁资源
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
                //end add
                System.out.println(Thread.currentThread().getName()+":"+res.getUserName()+":"+res.getGender());
                res.setFlag(true);
                res.notify();
            }
        }
    }
}
