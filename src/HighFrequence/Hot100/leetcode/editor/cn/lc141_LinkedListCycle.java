package HighFrequence.Hot100.leetcode.editor.cn;

public class lc141_LinkedListCycle {
    public static void main(String[] args) {
        Solution solution = new lc141_LinkedListCycle().new Solution();
        ListNode node1 = new ListNode(3);
        ListNode node2 = new ListNode(2);
        ListNode node3 = new ListNode(0);
        ListNode node4 = new ListNode(4);
        node1.next = node2;
        node2.next = node3;
        node3.next = node4;
        node4.next = node2;
        System.out.println(solution.hasCycle(node1));

    }

    /**
     * 出现环时，快指针会追上慢指针，判断是否会再次相遇即可
     */
    //环形链表
    public class Solution {
        public boolean hasCycle(ListNode head) {
            if (head == null || head.next == null) {
                return false;
            }
            ListNode slow = head;
            ListNode fast = head;
            while (fast != null && fast.next != null) {
                slow = slow.next;
                fast = fast.next.next;
                if (slow == fast) {
                    return true;
                }
            }
            return false;
        }
    }
}