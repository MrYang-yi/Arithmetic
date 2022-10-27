package HighFrequence.Hot100.leetcode.editor.cn;

public class lc617_MergeTwoBinaryTrees {
    public static void main(String[] args) {
        Solution solution = new lc617_MergeTwoBinaryTrees().new Solution();
        //此题忽略 直接提交即可
    }

    //合并二叉树
    class Solution {
        public TreeNode mergeTrees(TreeNode root1, TreeNode root2) {
            if (root1 == null) {
                return root2;
            }
            if (root2 == null) {
                return root1;
            }
            TreeNode merged = new TreeNode(root1.val + root2.val);
            merged.left = mergeTrees(root1.left, root2.left);
            merged.right = mergeTrees(root1.right, root2.right);
            return merged;
        }
    }
}