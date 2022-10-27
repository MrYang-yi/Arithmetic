package HighFrequence.Hot100.leetcode.editor.cn;

import java.util.*;

/**
 *          1
 *       2     3
 *     4   5  6
 *   7  8
 *
 */
public class lc94_BinaryTreeInorderTraversal_stack {
    public static void main(String[] args) {
        Solution solution = new lc94_BinaryTreeInorderTraversal_stack().new Solution();
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
        System.out.println(solution.inorderTraversal(node1));
    }

    //二叉树的中序遍历
    class Solution {
        public List<Integer> inorderTraversal(TreeNode root) {
            List<Integer> list = new ArrayList<>();
            Stack<TreeNode> stack = new Stack<>();
            while(root != null || !stack.isEmpty()){
                while(root != null){   //遍历到底部的左节点
                    stack.push(root);
                    root = root.left;
                }
                root =stack.pop(); //这里通过出栈 可以做一次root位置的调整
                list.add(root.val);
                root =root.right;
            }
            return list;
        }
    }
}