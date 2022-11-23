package HighFrequence.Hot100.leetcode.editor.cn;

public class lc287_FindTheDuplicateNumber {
    public static void main(String[] args) {
        Solution solution = new lc287_FindTheDuplicateNumber().new Solution();
        System.out.println(solution.findDuplicate(new int[]{1, 3, 4, 2, 2}));
    }
    /**
     * 空间复杂度为1 所以不能用hashmap或者set等额外的数据结构
     * 将数组下标 n 和数 nums[n] 建立一个映射关系
     * 0>1,1>3,2>4,3>2,4>2
     * 即可组成链表 0->1->3->2->4->2->4->2
     * <p>
     * 142 题中慢指针走一步 slow = slow.next ==> 本题 slow = nums[slow]
     * 142 题中快指针走两步 fast = fast.next.next ==> 本题 fast = nums[nums[fast]]
     */
    //寻找重复数
    class Solution {
        public int findDuplicate(int[] nums) {
            int slow = 0;
            int fast = 0;
            slow = nums[slow];
            fast = nums[nums[fast]];
            while (slow != fast) {
                slow = nums[slow];
                fast = nums[nums[fast]];
            }
            int pre1 = 0;
            int pre2 = slow;
            while (pre1 != pre2) {
                pre1 = nums[pre1];
                pre2 = nums[pre2];
            }
            return pre1;
        }
    }
}