package LeetCode;

/**
 *
 * 101. 对称二叉树
 * 给定一个二叉树，检查它是否是镜像对称的。
 * 例如，二叉树 [1,2,2,3,4,4,3] 是对称的。
 *
 *     1
 *    / \
 *   2   2
 *  / \ / \
 * 3  4 4  3
 *
 * 但是下面这个 [1,2,2,null,3,null,3] 则不是镜像对称的:
 *
 *     1
 *    / \
 *   2   2
 *    \   \
 *    3    3
 */
public class IsSymmetric {
    public boolean isSymmetric(TreeNode root) {
        return check(root, root);
    }

    public boolean check(TreeNode p, TreeNode q) {
        if (p == null && q == null) {
            return true;
        }
        if (p == null || q == null) {
            return false;
        }
        return p.val == q.val && check(p.left, q.right) && check(p.right, q.left);
    }

    public static void main(String[] args) {
        TreeNode root=new TreeNode(1);
        TreeNode node1=new TreeNode(2);
        TreeNode node2=new TreeNode(2);
        TreeNode node3=new TreeNode(3);
        TreeNode node4=new TreeNode(4);
        TreeNode node5=new TreeNode(4);
        TreeNode node6=new TreeNode(3);
        root.left=node1;
        root.right=node2;
        node1.left=node3;
        node1.right=node4;
        node2.left=node5;
        node2.right=node6;
        boolean flag=new IsSymmetric().isSymmetric(root);
        System.out.println(flag);

    }

}
