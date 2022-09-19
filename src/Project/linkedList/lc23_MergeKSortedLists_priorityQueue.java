package Project.linkedList;

import java.util.PriorityQueue;

public class lc23_MergeKSortedLists_priorityQueue {
    public ListNode mergeKLists(ListNode[] lists) {
        if (lists == null || lists.length == 0) {
            return null;
        }
        PriorityQueue<ListNode> priorityQueue = new PriorityQueue<>(lists.length, (a, b) -> a.val - b.val);
        ListNode dummyHead = new ListNode(-1);
        ListNode cur = dummyHead;
        for (ListNode head : lists) {
            if (head != null) {
                priorityQueue.add(head);
            }
        }
        while (!priorityQueue.isEmpty()) {
            ListNode p = priorityQueue.poll();
            cur.next = p;
            cur = cur.next;
            if (p.next != null) {
                priorityQueue.add(p.next);
            }
        }
        return dummyHead.next;
    }
}
