package One_SequenceList;

import java.util.Iterator;

/**
 * 手动实现线性表-顺序表
 * @author tracy
 * @param <T>
 *
 */
public class SequeceList<T> implements Iterable<T>{

    private int N;//数组长度
    private T[] eles;

    @SuppressWarnings("unchecked")
    /**
     * 此处初始化时犯错误了：误把初始化的长度=数组的长度出现空指针
     * @param capacity
     */
    public SequeceList(int capacity) {
        this.eles = (T[]) new Object[capacity];
        this.N = 0;
    }

    /**
     * 返回数组长度
     * @return
     */
    public int length(){
        return N;
    }

    /**
     * 在数组末尾添加元素并返回数组
     */
    public void add(T ele){
        if(N==eles.length)
            resize(2*eles.length);
        eles[N++] = ele;
    };

    /**
     * 在数组指定位置添加元素(此方法会使得最后一个元素缺失)
     */
    public void add(int target,T ele){
        if(N==eles.length)
            resize(2*eles.length);
        for (int i = N; i > target; i--) {
            eles[i] = eles[i-1];
        }
        eles[target]=ele;
        N++;
    };

    /**
     * 获取指定位置的元素
     * @param target
     * @return
     */
    public T getIndexOf(int target){
        return eles[target];
    }

    /**
     * 删除指定位置的元素
     * @param target
     */
    public void delete(int target){
        for (int i = target; i < N-1; i++) {
            eles[i] = eles[i+1];
        }
        N=N-1;
        if(N < eles.length/4)
            resize(eles.length/2);
    }

    /**
     * 判断线性表是否为空
     * @return
     */
    public boolean isEmpty(){
        return N==0;
    }

    /**
     * 清空线性表
     */
    public void clear(){
        this.N=0;
    }


    /**
     * 遍历线性表
     */
    @Override
    public Iterator<T> iterator() {
        // TODO Auto-generated method stub
        return new SIterable();
    }

    private class SIterable implements Iterator{
        private int cursor;//指针
        public SIterable(){
            this.cursor = 0;
        }
        @Override
        public boolean hasNext() {
            return cursor < N;
        }

        @Override
        public Object next() {
            return eles[cursor++];
        }
    }

    /**
     * 线性表容量变化
     */
    private void resize(int capacity){
        //定义一个临时数组
        T[] temp = eles;
        //创建新数组，用于复制原数组
        eles = (T[]) new Object[capacity];
        for(int i = 0; i < N; i++){
            eles[i] =  temp[i];
        }
    }
}
