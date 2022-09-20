package Project.linkedList;

public class lc206_ReverseLinkedList {
    public ListNode reverseList(ListNode head) {
        if (head == null) {
            return null;
        }
        ListNode prev = null;
        ListNode cur = head;
        while (cur != null) {
            ListNode l1 = cur.next;
            cur.next = prev;
            prev = cur;
            cur = l1;
        }
        return prev;
    }
}
