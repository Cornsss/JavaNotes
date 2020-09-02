package One_SequenceList;

public class Node<T> {
    public Node next;
    public T item;
    public Node(T item,Node next) {
        this.next = next;
        this.item = item;
    }
}
