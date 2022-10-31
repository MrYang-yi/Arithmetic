package HighFrequence.Hot100.leetcode.editor.cn;

import java.util.Stack;

public class lc98_ValidateBinarySearchTree {
    public static void main(String[] args) {
        Solution solution = new lc98_ValidateBinarySearchTree().new Solution();
        //此题直接解答即可
    }

    //验证二叉搜索树
    class Solution {
        public boolean isValidBST(TreeNode root) {
            Stack<TreeNode> stack = new Stack<>();
            double inorder = -Double.MAX_VALUE;
            while (!stack.isEmpty() || root != null) {
                while (root != null) {
                    stack.push(root);
                    root = root.left;
                }
                root = stack.pop();
                // 如果中序遍历得到的节点的值小于等于前一个 inorder，说明不是二叉搜索树
                if (root.val <= inorder) {
                    return false;
                }
                inorder = root.val;
                root = root.right;
            }
            return true;
        }
    }
}