package One_SequenceList;

import java.util.Iterator;

public class TwoWayLinkList<T> implements Iterable{
    private int length;
    private NodeTwoway first;
    private NodeTwoway last;
    public TwoWayLinkList(){
        this.first = new NodeTwoway(null,null,null);
        this.last = null;
        this.length = 0;
    }
    /**
     * 返回链表长度
     * @return
     */
    public int size(){
        return length;
    }

    /**
     * 清空链表
     * @return
     */
    public void clear(){
        this.first = null;
        this.last = null;
        this.length = 0;
    }
    /**
     * 插入元素
     */
    public void insert(T t){
        //1.当链表为空时：
        if(this.isEmpty()){
            NodeTwoway node = new NodeTwoway(t,first,null);
            this.first.next =node;
            this.last = node;
        }else {
            //2.当链表不为空时：
            NodeTwoway node = new NodeTwoway(t,last,null);
            this.last.next = node;
            this.last=node;
        }
        this.length ++;
    }
    /**
     * 在指定位置插入元素
     */
    public void insert(int target,T t){
        NodeTwoway pre = first;
        for (int i =0;i<target;i++){
            pre=pre.next;
        }
        //当前结点
        NodeTwoway curr = pre.next;
        //使前一个结点的下一个结点是新结点
        pre.next = new NodeTwoway(t,pre,curr);
        //使当前结点的前一个结点是新结点
        curr.pre = new NodeTwoway(t,pre,curr);
        this.length++;
    }
    /**
     * 删除指定位置元素
     */
    public T remove(int target){
        //找到指定位置的前一个结点
        NodeTwoway pre = first;
        for(int i =0;i<target;i++){
            pre = pre.next;
        }
        //找到当前位置的结点
        NodeTwoway curr = pre.next;
        //使前一个结点的下一个结点指向当前结点指向的结点
        pre.next = curr.next;
        //使当前结点指向的下一个结点的前一个结点指向指定位置结点的前一个结点
        curr.pre = pre;
        this.length--;
        return (T) curr.item;
    }
    /**
     * 获取指定位置元素(获取的值总是期望值的前一个元素)
     */
    public T get(int target){
        NodeTwoway node = first;
        for (int i =0;i<target;i++){
            node = node.next;
        }
        return (T) node.item;
    }
    /**
     * 判断链表是否为空
     */
    public boolean isEmpty(){
        return length==0;
    }
    /**
     * 返回首次出现元素的索引
     */
    public int indexOf(T t){
        return 0;
    }

    @Override
    public Iterator iterator() {
        return new TIterator();
    }

    private class TIterator implements Iterator{

        private NodeTwoway n;
        public TIterator(){
            this.n = first;
        }
        @Override
        public boolean hasNext() {
            return n.next !=null;
        }

        @Override
        public Object next() {
            n=n.next;
            return n.item;
        }
    }
}
