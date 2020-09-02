package ZTest;

import Two_StackAndQueue.Stack_Array;

public class StackTest {
    public static void main(String[] args) {
        initStackArray();//以数组为底层的栈测试
    }

    /**
     * 以数组为底层的栈测试
     */
    public static void initStackArray(){
        Stack_Array<String> stack = new Stack_Array<String>();
        System.out.println("栈是否为空：" + stack.isEmpty());
        stack.push("1.Tracy");
        stack.push("2.Kobe");
        stack.push("3.James");
        stack.push("4.LivingSton");
        stack.push("5.Jordon");
        stack.push("6.Athony");
        stack.push("7.Lin");
        System.out.println("栈是否为空：" + stack.isEmpty());
        System.out.println("栈的长度：" + stack.length);
        System.out.println("出栈元素：" + stack.pop());
        System.out.println("遍历元素=======================");
        for (String ele:stack ) {
            System.out.print(ele + ",");
        }
    }
}
