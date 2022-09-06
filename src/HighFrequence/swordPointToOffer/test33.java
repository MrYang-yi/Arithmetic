package LeetCode.editor.cn.HighFrequence.swordPointToOffer;

/**
 * 面试题33. 二叉搜索树的后序遍历序列
 * 输入一个整数数组，判断该数组是不是某二叉搜索树的后序遍历结果。如果是则返回 true，否则返回 false。假设输入的数组的任意两个数字都互不相同。
 * 参考以下这颗二叉搜索树：
 *      5
 *     / \
 *    2   6
 *   / \
 *  1   3
 * 示例 1：
 * 输入: [1,6,3,2,5]
 * 输出: false
 *
 * 示例 2：
 * 输入: [1,3,2,6,5]
 * 输出: true
 */
public class test33 {
    public boolean verifyPostorder(int[] postorder) {
            return recur(postorder, 0, postorder.length - 1);
        }
        boolean recur(int[] postorder, int i, int j) {
            if(i >= j) return true;
            int p = i;
            while(postorder[p] < postorder[j]) p++;
            int m = p;
            while(postorder[p] > postorder[j]) p++;
            return p == j && recur(postorder, i, m - 1) && recur(postorder, m, j - 1);
    }
    public static void main(String[] args) {
        TreeNode root = new TreeNode(5);
        TreeNode node1 = new TreeNode(2);
        TreeNode node2 = new TreeNode(6);
        TreeNode node3 = new TreeNode(1);
        TreeNode node4 = new TreeNode(3);
        root.left = node1;
        root.right = node2;
        node1.left = node3;
        node1.right = node4;
        boolean flag=new test33().verifyPostorder(new int[]{1,6,3,2,5});
        boolean flag1=new test33().verifyPostorder(new int[]{1,3,2,6,5});
        System.out.println(flag);
        System.out.println(flag1);
    }
}
