package test;

import singleinstance.SinglePattern;

public class SinglePatternTest {
    public static void main(String[] args) {
        SinglePattern single1 = SinglePattern.getInstance();
        SinglePattern single2 = SinglePattern.getInstance();
        System.out.println(single1==single2);
    }
}
