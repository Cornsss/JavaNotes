package Note.Thread.ThreadProject.Lock;

import java.util.concurrent.locks.Condition;

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
            try {
                res.getLock().lock();
                if(!res.isFlag()){
                    res.getCondition().await();
                }
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
                res.getCondition().signal();
            }catch (Exception e){
                //TODO
            }finally {
                res.getLock().unlock();
            }
        }
    }
}
