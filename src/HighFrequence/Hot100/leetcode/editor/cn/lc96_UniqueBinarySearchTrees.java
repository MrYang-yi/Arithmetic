package HighFrequence.Hot100.leetcode.editor.cn;

public class lc96_UniqueBinarySearchTrees {
    public static void main(String[] args) {
        Solution solution = new lc96_UniqueBinarySearchTrees().new Solution();
        System.out.println(solution.numTrees(3));
    }

    //不同的二叉搜索树
    class Solution {
        public int numTrees(int n) {
            int[] arr = new int[n + 1];
            arr[0] = 1;
            arr[1] = 1;

            for (int i = 2; i < n + 1; i++)
                for (int j = 1; j < i + 1; j++) {
                    arr[i] += arr[j - 1] * arr[i - j];
                }
            return arr[n];
        }
    }
}