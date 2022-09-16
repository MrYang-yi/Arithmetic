package HighFrequence.Hot100.leetcode.editor.cn;

import java.util.ArrayList;
import java.util.List;

/**
 *          1
 *       2     3
 *     4   5  6
 *   7  8
 *
 */
public class lc144_BinaryTreePreorderTraversal_recursive {
    public static void main(String[] args) {
        Solution solution = new lc144_BinaryTreePreorderTraversal_recursive().new Solution();
        TreeNode node1 = new TreeNode(1);
        TreeNode node2 = new TreeNode(2);
        TreeNode node3 = new TreeNode(3);
        TreeNode node4 = new TreeNode(4);
        TreeNode node5 = new TreeNode(5);
        TreeNode node6 = new TreeNode(6);
        TreeNode node7 = new TreeNode(7);
        TreeNode node8 = new TreeNode(8);
        node1.left = node2;
        node2.left = node4;
        node2.right = node5;
        node1.right = node3;
        node3.left = node6;
        node4.left = node7;
        node4.right = node8;
        System.out.println(solution.preorderTraversal(node1));
    }

//leetcode submit region begin(Prohibit modification and deletion)

    /**
     * Definition for a binary tree node.
     * public class TreeNode {
     * int val;
     * TreeNode left;
     * TreeNode right;
     * TreeNode() {}
     * TreeNode(int val) { this.val = val; }
     * TreeNode(int val, TreeNode left, TreeNode right) {
     * this.val = val;
     * this.left = left;
     * this.right = right;
     * }
     * }
     */
    class Solution {
        public List<Integer> preorderTraversal(TreeNode root) {
            List<Integer> list = new ArrayList<>();
            preorder(list, root);
            return list;
        }

        private void preorder(List<Integer> list, TreeNode root) {
            if (root == null) {
                return;
            }
            list.add(root.val);
            preorder(list, root.left);
            preorder(list, root.right);
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}