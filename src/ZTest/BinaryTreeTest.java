package ZTest;

import Three_Tree.BinaryTree;
import sun.misc.Queue;

import java.security.Key;

public class BinaryTreeTest {
    public static void main(String[] args) throws InterruptedException {
//        testBinaryTree();
        testPreErgodic();
    }

    public static void testBinaryTree(){
        BinaryTree<Integer,String> tree = new BinaryTree<>();
        tree.delete(2);
        System.out.println("空树删除：" + tree.size());
        tree.put(1,"Tracy");
        tree.put(2,"Kobe");
        tree.put(3,"James");
        System.out.println("现有的元素的个数：" + tree.size());
        String first = tree.get(3);
        System.out.println("第一个元素为：" + first);
        tree.delete(2);
        System.out.println("删除后的元素的个数：" + tree.size());
        System.out.println("最小键：" + tree.getMinKey());
        System.out.println("最大键：" + tree.getMaxKey());
    }

    public static void testPreErgodic() throws InterruptedException {
        BinaryTree<String,String> tree = new BinaryTree<>();
        tree.put("E","5");
        tree.put("B","2");
        tree.put("G","7");
        tree.put("A","1");
        tree.put("D","4");
        tree.put("F","6");
        tree.put("H","8");
        tree.put("C","3");
        System.out.println("tree size====" + tree.size());
        Queue<String> result = tree.midErgodic();
        for (int i=0;i<tree.size();i++){
            String key = result.dequeue();
            System.out.println("key==="+key+",value==="+tree.get(key));
        }
    }
}
