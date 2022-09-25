package HighFrequence.Hot100.leetcode.editor.cn;

public class lc226_InvertBinaryTree {
    public static void main(String[] args) {
        Solution solution = new lc226_InvertBinaryTree().new Solution();
        TreeNode root = new TreeNode(4);
        TreeNode node1 = new TreeNode(2);
        TreeNode node2 = new TreeNode(1);
        TreeNode node3 = new TreeNode(3);
        TreeNode node4 = new TreeNode(7);
        TreeNode node5 = new TreeNode(6);
        TreeNode node6 = new TreeNode(9);
        root.left = node1;
        node1.left = node2;
        node1.right = node3;
        node4.left = node5;
        node4.right = node6;
        TreeNodeUtils.sout(solution.invertTree(root));

    }

    class Solution {
        public TreeNode invertTree(TreeNode root) {
            if (root == null) {
                return null;
            }
            TreeNode left = invertTree(root.left);
            TreeNode right = invertTree(root.right);
            root.left = right;
            root.right = left;
            return root;
        }
    }

}