package HighFrequence.swordPointToOffer;

/**
 *
 * 面试题28. 对称的二叉树
 * 请实现一个函数，用来判断一棵二叉树是不是对称的。如果一棵二叉树和它的镜像一样，那么它是对称的。
 * 例如，二叉树 [1,2,2,3,4,4,3] 是对称的。
 *     1
 *    / \
 *   2   2
 *  / \ / \
 * 3  4 4  3
 * 但是下面这个 [1,2,2,null,3,null,3] 则不是镜像对称的:
 *     1
 *    / \
 *   2   2
 *    \   \
 *    3    3
 * 示例 1：
 * 输入：root = [1,2,2,3,4,4,3]
 * 输出：true
 */
public class test28 {
    public boolean isSymmetric(TreeNode root) {
        if(root == null){
            return true;
        }
        return recur(root.left,root.right);
    }
    public boolean recur(TreeNode L,TreeNode R){
        if(L == null && R == null){
            return true;
        }
        if(L == null || R == null || L.val != R.val ){
            return  false;
        }
        return recur(L.left,R.right)&&recur(L.right,R.left);
    }


    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        TreeNode node1 = new TreeNode(2);
        TreeNode node2 = new TreeNode(2);
        TreeNode node3 = new TreeNode(3);
        TreeNode node4 = new TreeNode(4);
        TreeNode node5 = new TreeNode(4);
        TreeNode node6 = new TreeNode(3);
        root.left = node1;
        root.right = node2;
        node1.left = node3;
        node1.right = node4;
        node2.left = node5;
        node2.right = node6;
        boolean flag=new test28().isSymmetric(root);
        System.out.println(flag);
    }
}
