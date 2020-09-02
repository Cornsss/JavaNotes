package One_SequenceList;

import java.util.Iterator;

public class LinkList<T> implements Iterable{

    private int length;
    private Node head;

    public LinkList(){
        this.head = new Node(null,null);
        this.length = 0;
    }

    public Node getHead() {
        return head;
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

    }
    /**
     * 插入元素
     */
    public void insert(T t){
        Node node = head;
        //获取最后一个元素
        while (node.next != null){
            node = node.next;
        }
        //在最后一个结点插入元素
        Node<Object> addNode = new Node<>(t,null);
        node.next = addNode;
        length ++;
    }
    /**
     * 在指定位置插入元素
     */
    public void insert(int target,T t){
        Node pre = head;
        Node currentNode = null;
        //检索到指定结点前一个结点
        for (int i =0;i<target-1;i++){
            pre = pre.next;
        }
        //检索指定结点
        currentNode = pre.next;
        //创建新结点
        Node addNode = new Node(t,currentNode);
        //前一个结点指向新结点
        pre.next = addNode;
        length ++;
    }
    /**
     * 删除指定位置元素
     */
    public T remove(int target){
        Node pre = head;
        //找到需要删除的前一个结点
        for (int i = 0;i <target-1;i++){
            pre = head.next;
        }
        Node currentNode = pre.next;
        pre.next = currentNode.next;
        length--;
        return (T) currentNode.item;
    }
    /**
     * 获取指定位置元素
     */
    public T get(int target){
        Node node = head;
        //检索到指定结点前一个结点
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
        Node node = head;
        for (int i =0;i<this.length;i++){
            node = node.next;
            if(node.item.equals(t)){
                return i;
            }
        }
        return -1;
    }

    @Override
    public Iterator iterator() {
        return new LInterator();
    }

    /**
     * 遍历元素
     */
    private class LInterator implements Iterator{
        Node node;
        public LInterator(){
            node = head;
        }
        @Override
        public boolean hasNext() {
            return node.next != null;
        }

        @Override
        public Object next() {
            node = node.next;
            return node.item;
        }
    }

    /**
     * 元素反转
     */
    public void reverse(){
        if (this.isEmpty()){
            return;
        }
        reverse(head.next);
    }

    public Node reverse(Node curr){
        if (curr.next == null){
            head.next = curr;
            return curr;
        }
        Node pre = reverse(curr.next);
        pre.next = curr;
        curr.next = null;
        return curr;
    }

    /**
     * 快慢指针
     */
    public static String DoublePointFindMid(Node<String> first){
        Node slow = first;
        Node fast = first;
        while (fast != null && fast.next != null){
            fast = fast.next.next;
            slow = slow.next;
        }
        return (String) slow.item;
    }

    /**
     * 单向链表是否有环问题
     */
    public static boolean DoublePointIsCircle(Node<String> node){
        Node slow = node;
        Node fast = node;
        while(fast !=null && fast.next != null){
            fast = fast.next.next;
            slow = slow.next;
            if(fast == slow)
                return true;
        }
        return false;
    }

    /**
     * 有环链表的入口问题
     */
    public static String DoublePointCircleEntrance(Node<String> node){
        Node slow = node;
        Node fast = node;
        Node temp = null;
        while(fast !=null && fast.next != null){
            fast = fast.next.next;
            slow = slow.next;
            if(fast == slow){
                temp = node;
                continue;
            }
            if (temp!=null){
                temp = temp.next;
                if (temp.equals(slow))
                    break;
            }
        }
        return (String) temp.item;
    }
}
