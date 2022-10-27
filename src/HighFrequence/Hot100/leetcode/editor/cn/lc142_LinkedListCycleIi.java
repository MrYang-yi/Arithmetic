package HighFrequence.Hot100.leetcode.editor.cn;

import java.util.HashSet;
import java.util.Set;

public class lc142_LinkedListCycleIi {
    public static void main(String[] args) {
        Solution solution = new lc142_LinkedListCycleIi().new Solution();
        ListNode node1 = new ListNode(3);
        ListNode node2 = new ListNode(2);
        ListNode node3 = new ListNode(0);
        ListNode node4 = new ListNode(4);
        node1.next = node2;
        node2.next = node3;
        node3.next = node4;
        node4.next = node2;
        System.out.println(solution.detectCycle(node1).val);

    }

    //环形链表 II
    public class Solution {
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
}