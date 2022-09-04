package HighFrequence.swordPointToOffer;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Queue;

/**
 * 面试题32 - I. 从上到下打印二叉树
 * 从上到下打印出二叉树的每个节点，同一层的节点按照从左到右的顺序打印。
 * 例如:
 * 给定二叉树: [3,9,20,null,null,15,7],
 * <p>
 *    3
 *   / \
 * 9   20
 *    /  \
 *   15   7
 * 返回：
 * [3,9,20,15,7]
 */
public class test32_1 {
    public int[] levelOrder(TreeNode root) {
        if(root == null) return new int[0];
        Queue<TreeNode> queue=new ArrayDeque<>();
        queue.add(root);
        ArrayList<Integer> list = new ArrayList<>();
        while(!queue.isEmpty()){
            TreeNode node=queue.poll();
            list.add(node.val);
            if(node.left != null){
                queue.add(node.left);
            }
            if(node.right != null){
                queue.add(node.right);
            }
        }
        int[] a=new int[list.size()];
        for (int i = 0; i < list.size(); i++) {
            a[i]=list.get(i);
        }
        return a;
    }


    public static void main (String[]args){
            TreeNode root = new TreeNode(3);
            TreeNode node1 = new TreeNode(9);
            TreeNode node2 = new TreeNode(20);
            TreeNode node3 = new TreeNode(15);
            TreeNode node4 = new TreeNode(7);
            root.left=node1;
            root.right=node2;
            node2.left = node3;
            node2.right = node4;
            int[] a = new test32_1().levelOrder(root);
            for (int x : a) {
                System.out.print(x + " ");
            }
        }
    }
