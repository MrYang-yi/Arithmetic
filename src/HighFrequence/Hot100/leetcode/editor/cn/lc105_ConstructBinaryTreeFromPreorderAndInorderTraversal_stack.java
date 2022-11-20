package HighFrequence.Hot100.leetcode.editor.cn;

import java.util.Stack;

public class lc105_ConstructBinaryTreeFromPreorderAndInorderTraversal_stack {
    public static void main(String[] args) {
        Solution solution = new lc105_ConstructBinaryTreeFromPreorderAndInorderTraversal_stack().new Solution();
        //此处忽略，直接提交即可
    }

    //从前序与中序遍历序列构造二叉树
    class Solution {
        public TreeNode buildTree(int[] preorder, int[] inorder) {
            if (preorder == null || preorder.length == 0) {
                return null;
            }
            TreeNode root = new TreeNode(preorder[0]);  //取出前序遍历的第一个节点，根节点
            int length = preorder.length;    //前序遍历的长度
            Stack<TreeNode> stack = new Stack<>();
            stack.push(root);   //  把根节点放入栈中
            int inorderIndex = 0; //中序遍历0开始
            for (int i = 1; i < length; i++) {
                int preorderVal = preorder[i];  //遍历得到前序遍历每个值
                TreeNode node = stack.peek(); //返回栈顶元素
                if (node.val != inorder[inorderIndex]) {   // 栈顶元素的值  ！= 中序遍历的值
                    node.left = new TreeNode(preorderVal);   //栈顶元素的左节点 == 中序遍历的值
                    stack.push(node.left);             //左节点放进 栈
                } else {           // 这一步非常关键 就是找出它的右节点
                    while (!stack.isEmpty() && stack.peek().val == inorder[inorderIndex]) {
                        node = stack.pop();
                        inorderIndex++;
                    }
                    node.right = new TreeNode(preorderVal);
                    stack.push(node.right);
                }
            }
            return root;
        }
    }
}