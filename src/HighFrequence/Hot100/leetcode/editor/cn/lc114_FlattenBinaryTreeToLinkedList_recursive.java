package HighFrequence.Hot100.leetcode.editor.cn;

import java.util.ArrayList;
import java.util.List;

public class lc114_FlattenBinaryTreeToLinkedList_recursive {
    public static void main(String[] args) {
        Solution solution = new lc114_FlattenBinaryTreeToLinkedList_recursive().new Solution();
        TreeNode node1 = new TreeNode(1);
        TreeNode node2 = new TreeNode(2);
        TreeNode node3 = new TreeNode(3);
        TreeNode node4 = new TreeNode(4);
        TreeNode node5 = new TreeNode(5);
        TreeNode node6 = new TreeNode(6);
        node1.left = node2;
        node2.left = node3;
        node2.right = node4;
        node1.right = node5;
        node5.right = node6;
        solution.flatten(node1);

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
        public void flatten(TreeNode root) {
            List<TreeNode> list = new ArrayList<TreeNode>();
            preorderTraversal(root, list);
            int size = list.size();
            for (int i = 1; i < size; i++) {
                TreeNode prev = list.get(i - 1);
                prev.left = null;
                TreeNode curr = list.get(i);
                prev.right = curr;
            }
        }

        public void preorderTraversal(TreeNode root, List<TreeNode> list) {
            if (root != null) {
                list.add(root);
                preorderTraversal(root.left, list);
                preorderTraversal(root.right, list);
            }
        }

    }
}