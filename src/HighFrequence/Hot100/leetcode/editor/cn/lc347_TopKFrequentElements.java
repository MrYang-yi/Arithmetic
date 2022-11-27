package HighFrequence.Hot100.leetcode.editor.cn;

import java.util.*;
import java.util.stream.Collectors;

public class lc347_TopKFrequentElements {
    public static void main(String[] args) {
        Solution solution = new lc347_TopKFrequentElements().new Solution();
        System.out.println(Arrays.stream(solution.topKFrequent(new int[]{1, 1, 1, 2, 2, 3}, 2)).boxed().collect(Collectors.toList()));
    }

    //前 K 个高频元素
    class Solution {
        public int[] topKFrequent(int[] nums, int k) {
            Map<Integer, Integer> map = new HashMap<>();
            for (int num : nums) {
                map.put(num, map.getOrDefault(num, 0) + 1);
            }
            // int[] 的第一个元素代表数组的值，第二个元素代表了该值出现的次数
            PriorityQueue<int[]> priorityQueue = new PriorityQueue<>((int[] m, int[] n) -> n[1] - m[1]);
            map.forEach((x, y) -> priorityQueue.add(new int[]{x, y}));
            int[] ret = new int[k];
            for (int i = 0; i < k; ++i) {
                ret[i] = priorityQueue.poll()[0];
            }
            return ret;
        }
    }
}