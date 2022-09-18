package Project.linkedList;

import java.util.HashSet;
import java.util.Set;

/**
 * 一个链表，利用Set存储
 */
public class lc142_LinkedListCycleIi_Set {
        public ListNode detectCycle(ListNode head) {
            if (head == null) {
                return null;
            }
            Set<ListNode> set = new HashSet<>();
            while (head != null) {
                if (set.contains(head)) {
                    return head;
                }
                set.add(head);
                head = head.next;
            }
            return null;
        }
}