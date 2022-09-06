package Project.Any;
/**
 * topic:面试题 04.04. 检查平衡性
 * 实现一个函数，检查二叉树是否平衡。在这个问题中，平衡树的定义如下：任意一个节点，其两棵子树的高度差不超过 1。
 * 示例 1:
 * 给定二叉树 [3,9,20,null,null,15,7]
 *             3
 *           /   \
 *          9     20
 *        /  \    /  \
 *      null null 15   7
 *         返回 true 。
 */

public class IsBalanced_04_04 {
    public boolean isBalanced(TreeNode root) {
        if (root == null) {
            return true;
        }
        if (Math.abs(depth(root.left) - depth(root.right)) > 1) {
            return false;
        }
        return isBalanced(root.right) && isBalanced(root.left);
    }

    private int depth(TreeNode node) {
        if (node == null)
            return 0;
        return Math.max(depth(node.left), depth(node.right)) + 1;
    }


    public static void main(String[] args) {
        TreeNode root = new TreeNode(3);
        TreeNode node1 = new TreeNode(9);
        TreeNode node2 = new TreeNode(20);
        TreeNode node3 = new TreeNode(15);
        TreeNode node4 = new TreeNode(7);
        node2.left = node3;
        node2.left = node4;
        boolean flag = new IsBalanced_04_04().isBalanced(root);
        System.out.println(flag);

    }
}
