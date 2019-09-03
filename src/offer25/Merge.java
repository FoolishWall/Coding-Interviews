package offer25;

/**
 * @author wall
 * @data 2019/9/4 1:15
 **/
//链表的数据结构
class ListNode{
    int value;
    ListNode next;

    ListNode(int value){
        this.value = value;
    }
}
public class Merge {
    //测试
    public static void main(String[] args) {
        //构建链表
        ListNode pHead1 = new ListNode(1);
        ListNode temp = pHead1;
        for (int i = 3; i <= 7; i+=2){
            temp.next = new ListNode(i);
            temp = temp.next;
        }

        ListNode pHead2 = new ListNode(2);
        ListNode temp2 = pHead2;
        for (int i = 4; i <= 8; i+=2){
            temp2.next = new ListNode(i);
            temp2 = temp2.next;
        }
        //合并两个排序的链表
        ListNode pHead = merge_solution(pHead1,pHead2);

        while (pHead!=null){
            System.out.print(pHead.value+" ");
            pHead = pHead.next;
        }
    }
    private static ListNode merge_solution(ListNode pHead1,ListNode pHead2){
        if (pHead1 == null){
            return pHead2;
        }
        if (pHead2 == null){
            return pHead1;
        }
        ListNode pHead;
        if (pHead1.value < pHead2.value) {
            pHead = pHead1;
            pHead.next = merge_solution(pHead1.next,pHead2);
        }else {
            pHead = pHead2;
            pHead.next = merge_solution(pHead1,pHead2.next);
        }
        return pHead;
    }
}
