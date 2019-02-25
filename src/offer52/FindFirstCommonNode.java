package offer52;

/**
 * @author wall
 * @date 2019/2/23  15:11
 * @description 两个链表的第一个公共节点
 * 特点：两个有公共节点而部分重合的链表，其拓扑形状为一个Y。
 * 知识迁移：树中两个节点的最低公共祖先。
 */
//单链表的数据结构
class Node<T> {
    private T value;
    private Node<T> next;
    //构造函数
    Node(T value,Node<T> next){
        this.value = value;
        this.next = next;
    }

    T getValue(){
        return value;
    }

    Node<T> next(){
        return next;
    }
}
public class FindFirstCommonNode {
    //测试
    public static void main(String[] args) {
        //单链表1
        Node<Integer> node = new Node<>(3,null);
        Node<Integer> node1 = new Node<>(8,node);
        Node<Integer> node2 = new Node<>(9,node1);
        Node<Integer> node3 = new Node<>(2,node2);
        Node<Integer> headNode4 = new Node<>(6,node3);
        //单链表2
        Node<Integer> node0 = new Node<>(3,null);
        Node<Integer> node5 = new Node<>(8,node0);
        Node<Integer> node6 = new Node<>(0,node5);
        Node<Integer> headNode7 = new Node<>(1,node6);
        //6->2->9->8
        //1->0->8->3
        System.out.println(findFirstCommonNode_mysolution(headNode4,headNode7));
    }

    private static int findFirstCommonNode_mysolution(Node n1, Node n2) {
        //分别遍历两个链表，利用辅助内存（栈）保存遍历的值，
        //比较两个栈的栈顶节点是否相同，直到找到最后一个相同的节点。


        //方法的改进
        //分别遍历两个链表求出两个链表的长度，求其差值。
        //在同时遍历两个链表的时候，先遍历较长链表差值步数，再同步遍历。
        int nLength1 = getNodeLength(n1);
        int nLength2 = getNodeLength(n2);

        //先遍历较长链表差值步数
        for (int i = 0; i < Math.abs(nLength1 - nLength2); i++) {
            if (nLength1 > nLength2)
                n1 = n1.next();
            else
                n2 = n2.next();
        }

        //同步遍历两个链表
        while (n1 != null && n2 != null) {
            if (n1.getValue() == n2.getValue())
                return (int) n1.getValue();
            n1 = n1.next();
            n2 = n2.next();
        }
        return 0;
    }

    //求链表的长度
    private static int getNodeLength(Node node) {
        int length = 0;
        while (node != null) {
            length++;
            node = node.next();
        }
        return length;
    }
}
