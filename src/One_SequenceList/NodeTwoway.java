package One_SequenceList;

public class NodeTwoway<T> {
    public NodeTwoway next;
    public NodeTwoway pre;
    public T item;
    public NodeTwoway(T item, NodeTwoway pre,NodeTwoway next) {
        this.next = next;
        this.pre = pre;
        this.item = item;
    }
}
