package HighFrequence.Hot100.leetcode.editor.cn;

public class lc86_PartitionList {
    public static void main(String[] args) {
        Solution solution = new lc86_PartitionList().new Solution();
        ListNodeUtils.sout(solution.partition(ListNodeUtils.getListNodeByArray(new int[]{1, 4, 3, 2, 5, 2}), 3));
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
    class Solution {
        public ListNode partition(ListNode head, int x) {
            if (head == null) {
                return null;
            }
            ListNode dummyHead1 = new ListNode(-1);
            ListNode dummyHead2 = new ListNode(-1);
            ListNode p1 = dummyHead1;
            ListNode p2 = dummyHead2;
            while (head != null) {
                if (head.val < x) {
                    p1.next = head;
                    p1 = p1.next;
                } else {
                    p2.next = head;
                    p2 = p2.next;
                }
                head = head.next;
            }
            p2.next = null;
            p1.next = dummyHead2.next;
            return dummyHead1.next;
        }
    }


}