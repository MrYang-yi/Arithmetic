package HighFrequence.Hot100.leetcode.editor.cn;

import java.util.*;

public class lc23_MergeKSortedLists_priorityQueue {
    public static void main(String[] args) {
        Solution solution = new lc23_MergeKSortedLists_priorityQueue().new Solution();
        ListNode l1 = ListNodeUtils.getListNodeByArray(new int[]{1, 4, 5});
        ListNode l2 = ListNodeUtils.getListNodeByArray(new int[]{1, 3, 4});
        ListNode l3 = ListNodeUtils.getListNodeByArray(new int[]{2, 6});
        ListNode[] list = new ListNode[]{l1, l2, l3};
        ListNodeUtils.sout(solution.mergeKLists(list));
    }

    /**
     * 最小堆，优先队列
     */
    //合并K个升序链表
    class Solution {
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
}
