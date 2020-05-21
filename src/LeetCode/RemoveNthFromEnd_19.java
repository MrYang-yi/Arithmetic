package LeetCode;

/**
 * topic:删除链表的倒数第N个节点
 * 给定一个链表: 1->2->3->4->5, 和 n = 2.
 * <p>
 * 当删除了倒数第二个节点后，链表变为 1->2->3->5.
 * <p>
 * <p>
思路：使用两个指针  保持n+1个节点的距离（这里有一个坑：因为最后肯定会用到second.next=second.next.next 在这里我们假设有5个节点，
要删除倒数第二个节点就是第4个节点  最后时刻的状态应该是second位于第3个节点 而first刚好位于最后一个节点的下一个节点 空结点中断while循环）
 */


public class RemoveNthFromEnd_19 {
    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode first = dummy;
        ListNode second = dummy;
        for (int i = 0; i < n+1; i++) {
            first = first.next;
        }
        while (first != null) {
            first = first.next;
            second = second.next;
        }
        second.next = second.next.next;
        return dummy.next;

        //-------------------------------------


/*        ListNode dummyhead=new ListNode(0);
        dummyhead.next=head;
        ListNode first=head;
        int length=0;
        while(first!=null){
            first= first.next;
            length++;
        }
        first=dummyhead; //first重回头节点
        length-=n;
        while(length>0){
            first=first.next;
            length--;
        }
        first.next=first.next.next;
        return dummyhead.next;*/
    }



    public static void main(String[] args) {
        ListNode node1 = new ListNode(1);
        ListNode node2 = new ListNode(2);
        ListNode node3 = new ListNode(3);
        ListNode node4 = new ListNode(4);
        ListNode node5 = new ListNode(5);
        node1.setNext(node2);
        node2.setNext(node3);
        node3.setNext(node4);
        node4.setNext(node5);
        ListNode l1 = node1;
        ListNode l2 = new RemoveNthFromEnd_19().removeNthFromEnd(l1, 2);
        while (l2 != null) {
            System.out.print(l2.val + " ");
            l2 = l2.next;
        }
    }
}
