package ZTest;

import One_SequenceList.LinkList;
import One_SequenceList.Node;
import com.sun.xml.internal.ws.policy.EffectiveAlternativeSelector;

public class LinklistTest {
    public static void main(String[] args) {
        testNode();
//        testLinkList();
    }

    /**
     * 测试结点类
     */
    private static void testNode(){
        Node<String> node1 = new Node<String>("Tracy",null);
        Node<String> node2 = new Node<String>("Kobe",null);
        Node<String> node3 = new Node<String>("James",null);
        Node<String> node4 = new Node<String>("Livingston",null);
        Node<String> node5 = new Node<String>("Curry",null);
        Node<String> node6 = new Node<String>("Carter",null);

        node1.next = node2;
        node2.next =node3;
        node3.next = node4;
        node4.next = node5;
        node5.next = node6;
        //制造有环链表
        node6.next =node3;
//        LinkList.DoublePointFindMid(node1);
        System.out.println("单链表是否有环测试：=================================");
        boolean isCircle = LinkList.DoublePointIsCircle(node1);
        System.out.println(isCircle);
        if(isCircle){
            System.out.println("单链表有环入口的测试：=================================");
            String entrance = LinkList.DoublePointCircleEntrance(node1);
            System.out.println(entrance);
        }
    }

    /**
     * 测试单向链表
     */
    private  static void testLinkList(){
        LinkList<String> linkList = new LinkList<String>();
        linkList.insert("Tracy");
        linkList.insert("James");
        linkList.insert("Kobe");
        linkList.insert("livingston");
        linkList.insert("curry");
        linkList.insert("Kobe");
        linkList.insert("curry");
        System.out.println("初始化的链表长度为：=========="+linkList.size());
        for (Object string:linkList) {
            System.out.println(string);
        }
        System.out.println("=============================");
        String remove = linkList.remove(3);
        System.out.println("删除的元素是：=========" + remove);
        for (Object string:linkList) {
            System.out.println(string);
        }
        System.out.println("链表长度为：====" +linkList.size());
        String target = linkList.get(4);
        System.out.println("获取的指定元素是：======" +target);
        System.out.println("查找的指定元素第一次出现在：" + linkList.indexOf("curry"));
        System.out.println("反转元素测试：=================================");
        linkList.reverse();
        for (Object string:linkList) {
            System.out.println(string);
        }
    }

}
