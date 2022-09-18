package HighFrequence.Hot100.leetcode.editor.cn;

public class lc19_RemoveNthNodeFromEndOfList {
    public static void main(String[] args) {
        Solution solution = new lc19_RemoveNthNodeFromEndOfList().new Solution();
        ListNode l1 = ListNodeUtils.getListNodeByArray(new int[]{1, 2, 3, 4, 5});
        ListNodeUtils.sout(solution.removeNthFromEnd(l1, 2));
    }

//leetcode submit region begin(Prohibit modification and deletion)

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
        public ListNode removeNthFromEnd(ListNode head, int n) {
            ListNode dummyhead = new ListNode(-1);
            ListNode fast = dummyhead;
            ListNode slow = dummyhead;
            dummyhead.next = head;
            for (int i = 0; i < n + 1; i++) { //当相差n个节点时，快指针多走一格，为n+1
                fast = fast.next;
            }
            while (fast != null) {
                slow = slow.next;
                fast = fast.next;
            }
            slow.next = slow.next.next;
            return dummyhead.next;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}