package HighFrequence.Hot100.leetcode.editor.cn;

public class lc543_DiameterOfBinaryTree {
    public static void main(String[] args) {
        Solution solution = new lc543_DiameterOfBinaryTree().new Solution();
        TreeNode root = new TreeNode(1);
        TreeNode node1 = new TreeNode(2);
        TreeNode node2 = new TreeNode(4);
        TreeNode node3 = new TreeNode(5);
        TreeNode node4 = new TreeNode(6);
        root.left = node1;
        root.right = node4;
        node1.left = node2;
        node1.right = node3;
        System.out.println(solution.diameterOfBinaryTree(root));
    }

    class Solution {
        int ans;
        public int diameterOfBinaryTree(TreeNode root) {
            ans = 1;
            depth(root);
            return ans - 1;
        }

        public int depth(TreeNode node) {
            if (node == null) {
                return 0; // 访问到空节点了，返回0
            }
            int L = depth(node.left); // 左儿子为根的子树的深度
            int R = depth(node.right); // 右儿子为根的子树的深度
            ans = Math.max(ans, L + R + 1); // 计算d_node即L+R+1 并更新ans
            return Math.max(L, R) + 1; // 返回该节点为根的子树的深度
        }
    }
}