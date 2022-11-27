package HighFrequence.Hot100.leetcode.editor.cn;

//和为 K 的子数组
public class lc538_ConvertBstToGreaterTree {
    int sum = 0;

    public TreeNode convertBST(TreeNode root) {
        if (root != null) {
            convertBST(root.right);
            sum += root.val;
            root.val = sum;
            convertBST(root.left);
        }
        return root;
    }
}

// Morris遍历
//public TreeNode convertBST(TreeNode root) {
//    int sum = 0;
//    TreeNode node = root;
//
//    while (node != null) {
//        if (node.right == null) {
//            sum += node.val;
//            node.val = sum;
//            node = node.left;
//        } else {
//            TreeNode tree = getSuccess(node);
//            if (tree.left == null) {
//                tree.left = node;
//                node = node.right;
//            } else {
//                tree.left = null;
//                sum += node.val;
//                node.val = sum;
//                node = node.left;
//            }
//        }
//    }
//    return root;
//}
//    public TreeNode getSuccess(TreeNode node) {
//        TreeNode success = node.right;
//        while (success.left != null && success.left != node) {
//            success = success.left;
//        }
//        return success;
//    }
//}