package HighFrequence.Hot100.leetcode.editor.cn;


import java.util.ArrayList;
import java.util.List;

public class lc234_PalindromeLinkedList {
    public static void main(String[] args) {
        Solution solution = new lc234_PalindromeLinkedList().new Solution();
        System.out.println(solution.isPalindrome(ListNodeUtils.getListNodeByArray(new int[]{1, 2, 3, 2, 1})));
    }

    //回文链表
    class Solution {
        public boolean isPalindrome(ListNode head) {
            List<Integer> list = new ArrayList<>();
            while (head != null) {
                list.add(head.val);
                head = head.next;
            }
            int left = 0;
            int right = list.size() - 1;
            while (left <= right) {
                if (!list.get(left).equals(list.get(right))) {
                    return false;
                }
                left++;
                right--;
            }
            return true;
        }
    }
}

