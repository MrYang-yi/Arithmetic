package HighFrequence.Hot100.leetcode.editor.cn;

import java.util.Arrays;

public class lc56_MergeIntervals {
    public static void main(String[] args) {
        Solution solution = new lc56_MergeIntervals().new Solution();
        int[][] merge = solution.merge(new int[][]{{1, 3}, {6, 9}, {2, 5}});
        for (int[] rows : merge) {
            for (int row : rows) {
                System.out.print(row + " ");
            }
            System.out.println();
        }
    }

    /**
     * 如果结果数组是空的，或者当前区间的起始位置 > 结果数组中最后区间的终止位置
     * 则不合并，直接将当前区间加入结果数组。
     * 反之将当前区间合并至结果数组的最后区间
     */
    class Solution {
        public int[][] merge(int[][] intervals) {
            Arrays.sort(intervals, (v1, v2) -> v1[0] - v2[0]);
            int[][] res = new int[intervals.length][2];
            int index = -1;
            for (int[] interval : intervals) {
                if (index == -1 || interval[0] > res[index][1]) {
                    res[++index] = interval;
                } else {
                    res[index][1] = Math.max(res[index][1], interval[1]);
                }
            }
            return Arrays.copyOf(res, index + 1);
        }
    }
}