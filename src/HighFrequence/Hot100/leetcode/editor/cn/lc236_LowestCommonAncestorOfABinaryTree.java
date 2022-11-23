package HighFrequence.Hot100.leetcode.editor.cn;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class lc236_LowestCommonAncestorOfABinaryTree {
    Map<Integer, TreeNode> map = new HashMap<>();
    Set<Integer> visited = new HashSet<>();

    /**
     * 哈希表存储所有节点的父节点
     */

    //二叉树的最近公共祖先
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        dfs(root);
        //把p节点的所有父节点都加进visited里
        while (p != null) {
            visited.add(p.val);
            p = map.get(p.val);
        }
        while (q != null) {
            if (visited.contains(q.val)) {
                return q;
            }
            q = map.get(q.val);
        }
        return null;
    }

    public void dfs(TreeNode root) {
        if (root.left != null) {
            map.put(root.left.val, root);
            dfs(root.left);
        }
        if (root.right != null) {
            map.put(root.right.val, root);
            dfs(root.right);
        }
    }
}
