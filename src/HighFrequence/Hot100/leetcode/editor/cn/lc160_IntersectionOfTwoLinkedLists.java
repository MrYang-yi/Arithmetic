package HighFrequence.Hot100.leetcode.editor.cn;

public class lc160_IntersectionOfTwoLinkedLists {
    public static void main(String[] args) {
        Solution solution = new lc160_IntersectionOfTwoLinkedLists().new Solution();
        ListNode common = ListNodeUtils.getListNodeByArray(new int[]{3, 4, 5});
        ListNode l1 = new ListNode(1);
        ListNode node1 = new ListNode(2);
        l1.next = node1;
        node1.next = common;
        ListNode l2 = new ListNode(7);
        ListNode node2 = new ListNode(8);
        ListNode node3 = new ListNode(9);
        l2.next = node2;
        node2.next = node3;
        node3.next = common;

        ListNodeUtils.sout(solution.getIntersectionNode(l1, l2));
    }


/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */
    /**
     * 假设A :1 2 3 4 5
     * 假设B :7 8 9 3 4 5
     * A+B链: 1 2 3 4 5 7 8 9 3 4 5
     * B+A链: 7 8 9 3 4 5 1 2 3 4 5
     * 所以必有相交点
     */

    public class Solution {
        public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
            if (headA == null || headB == null) {
                return null;
            }
            ListNode l1 = headA;
            ListNode l2 = headB;
            while (l1 != l2) {
                l1 = l1 == null ? headB : l1.next;
                l2 = l2 == null ? headA : l2.next;
            }
            return l1;
        }
    }


}