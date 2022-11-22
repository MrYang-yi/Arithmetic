package HighFrequence.Hot100.leetcode.editor.cn;

import java.util.PriorityQueue;

public class lc215_KthLargestElementInAnArray {
    public static void main(String[] args) {
        Solution solution = new lc215_KthLargestElementInAnArray().new Solution();
        System.out.println(solution.findKthLargest(new int[]{3, 2, 1, 5, 6, 4}, 2));
    }

    /**
     * 时间复杂度：O(Nlog K)，空间复杂度：O(K)
     * 遍历数据 O(N)，堆内元素调整 O(logK)
     */
    //数组中的第K个最大元素
    class Solution {
        public int findKthLargest(int[] nums, int k) {
            PriorityQueue<Integer> priorityQueue = new PriorityQueue<>(nums.length, (a, b) -> a - b);
            for (int num : nums) {
                priorityQueue.add(num);
            }
            for (int i = k; i < nums.length; i++) {
                priorityQueue.poll();
            }
            return priorityQueue.poll();
        }
    }
}