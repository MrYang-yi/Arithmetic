package HighFrequence.Hot100.leetcode.editor.cn;

import java.util.*;

/**
 *          1
 *       2     3
 *     4   5  6
 *   7  8
 *
 */
public class lc145_BinaryTreePostorderTraversal_stack {
    public static void main(String[] args) {
        Solution solution = new lc145_BinaryTreePostorderTraversal_stack().new Solution();
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
        System.out.println(solution.postorderTraversal(node1));
    }

    // 二叉树的后序遍历
    class Solution {
        public List<Integer> postorderTraversal(TreeNode root) {
            List<Integer> list = new ArrayList<>();
            Stack<TreeNode> stack = new Stack<>();
            TreeNode prev = null;
            while (root != null || !stack.isEmpty()) {
                while (root != null) {
                    stack.push(root);
                    root = root.left;
                }
                root = stack.pop();
                if (root.right == null || root.right == prev) {
                    list.add(root.val);
                    prev = root;
                    root = null;
                } else {         //如果右节点不为空 root（中间的）节点重新入栈
                    stack.push(root);
                    root = root.right;
                }
            }
            return list;
        }
    }


}