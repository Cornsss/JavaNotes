package singleinstance;

public class SinglePattern {

    private static SinglePattern single;

    private SinglePattern(){ }

    public static SinglePattern getInstance(){
        if(single==null){
            single = new SinglePattern();
        }
        return single;
    }
}
