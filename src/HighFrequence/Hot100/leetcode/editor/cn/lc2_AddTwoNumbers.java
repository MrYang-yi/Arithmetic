package HighFrequence.Hot100.leetcode.editor.cn;


public class lc2_AddTwoNumbers {
    public static void main(String[] args) {
        Solution solution = new lc2_AddTwoNumbers().new Solution();
        ListNode l1 = ListNodeUtils.getListNodeByArray(new int[]{2, 4, 3});
        ListNode l2 = ListNodeUtils.getListNodeByArray(new int[]{5, 6, 4});
        ListNode l3 = solution.addTwoNumbers(l1, l2);
        ListNodeUtils.sout(l3);
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
        public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
            int add = 0;
            ListNode dummyHead = new ListNode(-1);
            ListNode cur = dummyHead;
            while (l1 != null || l2 != null || add != 0) {
                if (l1 != null) {
                    add += l1.val;
                    l1 = l1.next;
                }
                if (l2 != null) {
                    add += l2.val;
                    l2 = l2.next;
                }
                cur.next = new ListNode(add % 10);
                add /= 10;
                cur = cur.next;
            }
            return dummyHead.next;
        }
    }


}