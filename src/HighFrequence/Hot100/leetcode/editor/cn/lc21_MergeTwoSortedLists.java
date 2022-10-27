package HighFrequence.Hot100.leetcode.editor.cn;

public class lc21_MergeTwoSortedLists {
    public static void main(String[] args) {
        Solution solution = new lc21_MergeTwoSortedLists().new Solution();
        ListNode l1 = ListNodeUtils.getListNodeByArray(new int[]{1, 2, 4});
        ListNode l2 = ListNodeUtils.getListNodeByArray(new int[]{1, 3, 4});
        ListNode l3 = solution.mergeTwoLists(l1, l2);
        ListNodeUtils.sout(l3);
    }

    //合并两个有序链表
    class Solution {
        public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
            ListNode dummyHead = new ListNode(-1);
            ListNode cur = dummyHead;
            while (l1 != null || l2 != null) {
                if (l1 == null) {
                    cur.next = l2;
                    return dummyHead.next;
                }
                if (l2 == null) {
                    cur.next = l1;
                    return dummyHead.next;
                }
                if (l1.val <= l2.val) {
                    cur.next = l1;
                    l1 = l1.next;
                    cur = cur.next;
                } else {
                    cur.next = l2;
                    l2 = l2.next;
                    cur = cur.next;
                }
            }
            return dummyHead.next;
        }
    }
}