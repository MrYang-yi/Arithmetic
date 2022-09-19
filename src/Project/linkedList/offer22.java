package Project.linkedList;

public class offer22 {
    public ListNode getKthFromEnd(ListNode head, int k) {
        if (head == null) return null;
        ListNode slow = head;
        while (k > 0 && head != null) {
            head = head.next;
            k--;
        }
        while (head != null) {
            head = head.next;
            slow = slow.next;
        }
        return slow;
    }
}
