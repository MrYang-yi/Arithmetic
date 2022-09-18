package HighFrequence.Hot100.leetcode.editor.cn;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class lc23_MergeKSortedLists_valueComparator {
    public static void main(String[] args) {
        Solution solution = new lc23_MergeKSortedLists_valueComparator().new Solution();
        ListNode l1 = ListNodeUtils.getListNodeByArray(new int[]{1, 4, 5});
        ListNode l2 = ListNodeUtils.getListNodeByArray(new int[]{1, 3, 4});
        ListNode l3 = ListNodeUtils.getListNodeByArray(new int[]{2, 6});
        ListNode[] list = new ListNode[]{l1, l2, l3};
        ListNodeUtils.sout(solution.mergeKLists(list));
    }

//leetcode submit region begin(Prohibit modification and deletion)
/**
 * 实现一个排序的内部类
 * 把K个ListNode 加进List中
 * 对List实现排序
 * 创造一个新链表，遍历加入即可
 */
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
        public ListNode mergeKLists(ListNode[] lists) {
            if (lists == null || lists.length == 0) {
                return null;
            }
            List<ListNode> list = new ArrayList<>();
            for (int i = 0; i < lists.length; i++) {
                while (lists[i] != null) {
                    list.add(lists[i]);
                    lists[i] = lists[i].next;
                }
            }
            ValueComparator valueComparator = new ValueComparator();
            Collections.sort(list, valueComparator);
            ListNode dummyHead = new ListNode(-1);
            ListNode cur = dummyHead;
            for (ListNode node : list) {
                cur.next = new ListNode(node.val);
                cur = cur.next;
            }
            return dummyHead.next;
        }

        private class ValueComparator implements Comparator<ListNode> {
            @Override
            public int compare(ListNode o1, ListNode o2) {
                return o1.val - o2.val;
            }
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}
