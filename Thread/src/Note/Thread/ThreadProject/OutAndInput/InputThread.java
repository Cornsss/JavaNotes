package Note.Thread.ThreadProject.OutAndInput;

/**
 * 生产者线程
 */
public class InputThread implements Runnable{
    Res res;

    public InputThread(Res res){
        this.res =res;
    }
    @Override
    public void run() {
        int count = 0;
        while(true){
            synchronized (res){
                //start add 添加flag使得生产者生产完毕后消费者才能消费
                //    flag=true 生产者生产，消费者等待
                //    flag=false 生产者等待，消费者消费
                if(!res.isFlag()){
                    try {
                        res.wait();//线程等待并释放锁资源
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
                //end add
                if(count==0){
                    res.setUserName("Tracy");
                    res.setGender("female");
                }else{
                    res.setUserName("Curry");
                    res.setGender("male");
                }
                count = (count+1)%2;
                System.out.println(Thread.currentThread().getName()+":"+res.getUserName()+":"+res.getGender());
                res.setFlag(false);
                res.notify();//唤醒线程并拿到锁资源
            }
        }
    }
}
