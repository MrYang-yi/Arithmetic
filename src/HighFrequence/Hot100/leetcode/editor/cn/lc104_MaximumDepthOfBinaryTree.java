package HighFrequence.Hot100.leetcode.editor.cn;

public class lc104_MaximumDepthOfBinaryTree {
    public static void main(String[] args) {
        Solution solution = new lc104_MaximumDepthOfBinaryTree().new Solution();
        TreeNode root = new TreeNode(3);
        root.left = new TreeNode(9);
        TreeNode node1 = new TreeNode(20);
        TreeNode node2 = new TreeNode(15);
        TreeNode node3 = new TreeNode(7);
        root.right = node1;
        node1.left = node2;
        node1.right = node3;
        System.out.println(solution.maxDepth(root));
    }

    //二叉树的最大深度
    class Solution {
        public int maxDepth(TreeNode root) {
            if (root == null) {
                return 0;
            }
            int leftHeight = maxDepth(root.left);
            int rightHeight = maxDepth(root.right);
            int sum = Math.max(leftHeight, rightHeight) + 1;
            return sum;
        }
    }
}