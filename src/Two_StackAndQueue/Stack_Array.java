package Two_StackAndQueue;

import java.util.Iterator;
import java.util.Objects;

public class Stack_Array<T> implements Iterable<T>{
    public int length;//栈的长度
    public T[] eles;//存储元素的容器

    public Stack_Array(){
        this.length = 0;
        this.eles = (T[]) new Object[5];//初始化栈
    }

    public int size(){
        return length;
    }

    /**
     * 出栈，返回数组的最后一个
     * @return
     */
    public T pop(){
        T t = null;
        if(this.length!=0){
            t= eles[this.length-1];
            this.length--;
        }
        return t;
    }

    /**
     * 压栈：在数组最后添加元素
     */
    public void push(T ele){
        //先判断数组的长度是否超过当前长度
        if(this.length == eles.length)
            resize(eles.length*2);
        //在数组最后添加元素
        eles[length]=ele;
        length++;
    }

    /**
     * 判断栈是否为空
     * @return
     */
    public boolean isEmpty(){
        return length == 0;
    }

    /**
     * 数组扩容
     * @return
     */
    public void resize(int newSize){
        //定义临时数组存储元素
        T[] tmp = eles;
        this.eles = (T[]) new Object[newSize];
        for (int i = 0; i < tmp.length; i++) {
            eles[i] = tmp[i];
        }
    }

    @Override
    public Iterator<T> iterator() {
        return new SInterable();
    }

    public class SInterable implements Iterator{
        int cursor;
        public SInterable(){
            this.cursor = 0;
        }
        @Override
        public boolean hasNext() {
            return length > cursor;
        }

        @Override
        public Object next() {
            return pop();
        }
    }
}
