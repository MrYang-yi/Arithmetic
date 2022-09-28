package HighFrequence.Hot100.leetcode.editor.cn;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class lc148_SortList {
    public static void main(String[] args) {
        Solution solution = new lc148_SortList().new Solution();
        ListNodeUtils.sout(solution.sortList(ListNodeUtils.getListNodeByArray(new int[]{4, 2, 1, 3})));
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
     * 也可以想lc23去实现一个内部针对ListNode的排序类
     */
    class Solution {
        public ListNode sortList(ListNode head) {
            if (head == null) {
                return null;
            }
            List<Integer> list = new ArrayList<>();
            while (head != null) {
                list.add(head.val);
                head = head.next;
            }
            Collections.sort(list);
            ListNode dummyHead = new ListNode(-1);
            ListNode cur = dummyHead;
            for (Integer val : list) {
                cur.next = new ListNode(val);
                cur = cur.next;
            }
            return dummyHead.next;
        }
    }


}