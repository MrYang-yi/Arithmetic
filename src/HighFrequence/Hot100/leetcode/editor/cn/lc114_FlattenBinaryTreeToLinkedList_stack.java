package HighFrequence.Hot100.leetcode.editor.cn;

import java.util.Stack;

public class lc114_FlattenBinaryTreeToLinkedList_stack {
    public static void main(String[] args) {
        Solution solution = new lc114_FlattenBinaryTreeToLinkedList_stack().new Solution();
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

    //二叉树展开为链表
    class Solution {
        public void flatten(TreeNode root) {
            if (root == null) {
                return;
            }
            Stack<TreeNode> stack = new Stack<>();
            stack.push(root);
            TreeNode prev = null;
            while (!stack.isEmpty()) {
                TreeNode curr = stack.pop();
                if (prev != null) {
                    prev.left = null;
                    prev.right = curr;
                }
                TreeNode left = curr.left;
                TreeNode right = curr.right;
                if (right != null) {
                    stack.push(right);
                }
                if (left != null) {
                    stack.push(left);
                }
                prev = curr;
            }
        }
    }
}