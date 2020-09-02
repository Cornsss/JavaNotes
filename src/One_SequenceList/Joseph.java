package One_SequenceList;

/**
 * 41个人构成圆报数，报到3的倍数退出，求最后留下的两个人的编号。
 */
public class Joseph {
    public static void main(String[] args) {
        //1.创建循环链表
        Node<Integer> first = null;
        Node<Integer> pre = null;
        for (int i = 1; i <= 41; i++) {
            if (i==1){
                first = new Node<Integer>(i,null);
                pre = first;
                continue;
            }
            Node<Integer> newNode = new Node<Integer>(i,null);
            pre.next = newNode;
            pre = newNode;
            if (i==41)
                pre.next = first;
        }

        //2.遍历链表
        int count = 0;
        Node<Integer> node = first;
        Node<Integer> tmp = null;
        while(node != node.next) {
            count++;
            if (count == 3) {
                //删除当前节点并重置计数器
                tmp.next = node.next;
                System.out.print(node.item + ",");
                count = 0;
                node = node.next;
            } else {
                tmp = node;
                node = node.next;
            }
        }
        //打印最后一个元素
        System.out.print(node.item);
    }
}
