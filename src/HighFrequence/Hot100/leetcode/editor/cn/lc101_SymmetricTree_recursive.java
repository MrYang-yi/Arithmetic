package HighFrequence.Hot100.leetcode.editor.cn;

public class lc101_SymmetricTree_recursive {
    public static void main(String[] args) {
        Solution solution = new lc101_SymmetricTree_recursive().new Solution();
        TreeNode root = new TreeNode(1);
        TreeNode node1 = new TreeNode(2);
        TreeNode node2 = new TreeNode(3);
        TreeNode node3 = new TreeNode(4);
        TreeNode node4 = new TreeNode(2);
        TreeNode node5 = new TreeNode(4);
        TreeNode node6 = new TreeNode(3);
        root.left = node1;
        root.right = node4;
        node1.left = node2;
        node1.right = node3;
        node4.left = node5;
        node4.right = node6;
        System.out.println(solution.isSymmetric(root));


    }

    class Solution {
        public boolean isSymmetric(TreeNode root) {
            return check(root, root);
        }

        private boolean check(TreeNode p, TreeNode q) {
            if (p == null && q == null) {
                return true;
            }
            if (p == null || q == null) {
                return false;
            }
            return p.val == q.val && check(p.left, q.right) && check(p.right, q.left);
        }
    }

}