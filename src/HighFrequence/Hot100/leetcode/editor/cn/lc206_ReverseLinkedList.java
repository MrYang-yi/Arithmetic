package HighFrequence.Hot100.leetcode.editor.cn;

public class lc206_ReverseLinkedList {
    public static void main(String[] args) {
        Solution solution = new lc206_ReverseLinkedList().new Solution();
        ListNode l1 = ListNodeUtils.getListNodeByArray(new int[]{1, 2, 3, 4, 5});
        ListNodeUtils.sout(solution.reverseList(l1));
    }



    /**
     * Definition for singly-linked list.
     * public class ListNode {
     * int val;
     * ListNode next;
     * ListNode() {}
     * ListNode(int val) { this.val = val; }
     * ListNode(int val, ListNode next) { this.val = val; this.next = next; }
     * }
     */
    /**
     * 1 - 2 - 3 - 4 -5
     * <p>
     * 第一步  cur.next = prev
     * 1(cur) - 2(l1) -3 - 4 - 5
     * |
     * prev
     * <p>
     * 第二步  prev上移 cur右移
     * 1(prev) - 2(l1,cur) -3 - 4 -5
     */
    class Solution {
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
}

