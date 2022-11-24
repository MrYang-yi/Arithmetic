package HighFrequence.Hot100.leetcode.editor.cn;

import java.util.HashMap;
import java.util.Map;

/**
 * ff(o) 表示选择 o 节点的情况下，o 节点的子树上被选择的节点的最大权值和；
 * gg(o) 表示不选择 o 节点的情况下，o 节点的子树上被选择的节点的最大权值和；l 和 r 代表 o 的左右孩子
 */
// 打家劫舍 III
public class lc337_HouseRobberIii {
    Map<TreeNode, Integer> ff = new HashMap<>();
    Map<TreeNode, Integer> gg = new HashMap<>();

    public int rob(TreeNode root) {
        dfs(root);
        return Math.max(ff.getOrDefault(root, 0), gg.getOrDefault(root, 0));
    }

    public void dfs(TreeNode node) {
        if (node == null) {
            return;
        }
        dfs(node.left);
        dfs(node.right);
        ff.put(node, node.val + gg.getOrDefault(node.left, 0) + gg.getOrDefault(node.right, 0));
        gg.put(node, Math.max(ff.getOrDefault(node.left, 0), gg.getOrDefault(node.left, 0)) + Math.max(ff.getOrDefault(node.right, 0), gg.getOrDefault(node.right, 0)));
    }
}

//不用hash表
//public int rob(TreeNode root) {
//    int[] rootStatus = dfs(root);
//    return Math.max(rootStatus[0], rootStatus[1]);
//}
//
//    public int[] dfs(TreeNode node) {
//        if (node == null) {
//            return new int[]{0, 0};
//        }
//        int[] l = dfs(node.left);
//        int[] r = dfs(node.right);
//        int selected = node.val + l[1] + r[1];
//        int notSelected = Math.max(l[0], l[1]) + Math.max(r[0], r[1]);
//        return new int[]{selected, notSelected};
//    }
