package singleinstance;

public class SinglePatternDoubleCheck {
    private volatile static SinglePatternDoubleCheck uniqueSingleton;

    private SinglePatternDoubleCheck() {
    }

    public SinglePatternDoubleCheck getInstance() {
        if (null == uniqueSingleton) {
            synchronized (SinglePatternDoubleCheck.class) {
                if (null == uniqueSingleton) {
                    uniqueSingleton = new SinglePatternDoubleCheck();
                }
            }
        }
        return uniqueSingleton;
    }
}
