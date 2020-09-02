package ZTest;

import One_SequenceList.TwoWayLinkList;

public class TwowayLinkListTest {
    public static void main(String[] args) {
        TwoWayLinkList<String> list = new TwoWayLinkList<String>();
        list.insert("Tracy");
        list.insert("James");
        list.insert("Kobe");
        list.insert("livingston");
        list.insert("curry");
        list.insert("Kobe");
        list.insert("curry");
        System.out.println("当前指定位置元素为：" + list.get(2));
        System.out.println("当前双向链表长度为：======" + list.size());
        System.out.println("当前删除的元素为：======" + list.remove(1));
        System.out.println("当前双向链表长度为：======" + list.size());
        for (Object string:list) {
            System.out.println(string);
        }
        System.out.println("当前第一个元素为：" );
    }
}
