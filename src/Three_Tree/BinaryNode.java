package Three_Tree;

public class BinaryNode<Key,Value> {
    public BinaryNode left;
    public BinaryNode right;
    public Key key;
    public Value value;

    public BinaryNode(BinaryNode left, BinaryNode right, Key key, Value value) {
        this.left = left;
        this.right = right;
        this.key = key;
        this.value = value;
    }
}
