package Sword_Point_To_Offer;

/*
 */

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

/**
 * 面试题07. 重建二叉树
 * 输入某二叉树的前序遍历和中序遍历的结果，请重建该二叉树。假设输入的前序遍历和中序遍历的结果中都不含重复的数字。
 * 例如，给出
 * 前序遍历 preorder = [3,9,20,15,7]
 * 中序遍历 inorder = [9,3,15,20,7]
 * 返回如下的二叉树：
 *  3
 * / \
 * 9  20
 *   /  \
 * 15   7
 *
 * 补一个知识点：当中序的遍历的第一个值不等于前序遍历的值
 *              就说明前序遍历的结点都是树的左节点 要是等于前序遍历的结点怎么找右节点呢？
 *              就是把前序遍历的值往回退 而中序遍历继续往后遍历 直到它们两个相等 就证明这是它的右节点
 *              这个过程就要借助栈来实现了
 */
class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    public void setLeft(TreeNode left) {
        this.left = left;
    }

    public void setRight(TreeNode right) {
        this.right = right;
    }

    TreeNode(int x) {
        val = x;
    }
}

public class test07 {
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        if (preorder == null || preorder.length == 0) {
            return null;
        }
        TreeNode root = new TreeNode(preorder[0]);  //取出前序遍历的第一个节点，根节点
        int length = preorder.length;    //前序遍历的长度
        Stack<TreeNode> stack = new Stack<TreeNode>();
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

    public static void main(String[] args) {
        TreeNode root = new test07().buildTree(new int[]{3, 9, 8, 5, 4, 10, 20, 15, 7}, new int[]{4, 5, 8, 10, 9, 3, 15, 20, 7});
        ArrayList<Integer> list = new ArrayList<>();
        Queue<TreeNode> q = new LinkedList<>();
        q.add(root);
        while (!q.isEmpty()) {
            TreeNode nowNode = q.peek();
            q.poll();
            list.add(nowNode.val);
            if (nowNode.left != null) {
                q.add(nowNode.left);
            }
            if (nowNode.right != null) {
                q.add(nowNode.right);
            }
        }
        System.out.println(list);
    }

}