package LeetCode;

/**
 * 24. 两两交换链表中的节点
 * 给定一个链表，两两交换其中相邻的节点，并返回交换后的链表。
 * 你不能只是单纯的改变节点内部的值，而是需要实际的进行节点交换。
 * 示例:
 * 给定 1->2->3->4, 你应该返回 2->1->4->3.
 */
public class SwapPairs_24 {
    public ListNode swapPairs(ListNode head) {
        if(head == null || head.next == null){
            return head;
        }
        ListNode fast = head.next;
        head.next = swapPairs(fast.next);
        fast.next = head;
        return fast;
/*        ListNode dummyhead = new ListNode(0);
        dummyhead.next = head;
        ListNode temp = dummyhead;
        while (temp.next != null && temp.next.next != null) {
            ListNode start = temp.next;
            ListNode end = temp.next.next;
            temp.next = end;
            start.next = end.next;
            end.next = start;
            temp = start;
        }
        return dummyhead.next;*/
    }


    public static void main(String[] args) {
        ListNode node1 = new ListNode(1);
        ListNode node2 = new ListNode(2);
        ListNode node3 = new ListNode(3);
        ListNode node4 = new ListNode(4);
        node1.next = node2;
        node2.next = node3;
        node3.next = node4;
        ListNode l1 = node1;
        ListNode l2 = new SwapPairs_24().swapPairs(l1);
        while (l2 != null) {
            System.out.print(l2.val + " ");
            l2 = l2.next;
        }

    }
}
