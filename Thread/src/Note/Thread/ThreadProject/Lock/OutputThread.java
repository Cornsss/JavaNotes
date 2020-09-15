package Note.Thread.ThreadProject.Lock;

import java.util.concurrent.locks.Condition;

public class OutputThread implements Runnable{
    Res res;
    public OutputThread(Res res){
        this.res =res;
    }
    @Override
    public void run() {
        while(true){
            try {
                res.getLock().lock();
                if(res.isFlag()){
                    try {
                        res.getCondition().await();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
                System.out.println(Thread.currentThread().getName()+":"+res.getUserName()+":"+res.getGender());
                res.setFlag(true);
                res.getCondition().signal();
            }catch (Exception e){
                //TODO
            }finally {
                res.getLock().unlock();
            }
        }
    }
}
