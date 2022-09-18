package Project.linkedList;

/**
 * 出现环时，快指针会追上慢指针，判断是否会再次相遇即可
 */
public class lc141_LinkedListCycle_doublePointer {
        public boolean hasCycle(ListNode head) {
            if (head == null || head.next == null) {
                return false;
            }
            ListNode slow = head;
            ListNode fast = head.next;
            while (slow != fast) {
                if (fast == null || fast.next == null) {
                    return false;
                }
                slow = slow.next;
                fast = fast.next.next;
            }
            return true;
        }
}