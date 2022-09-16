package HighFrequence.Hot100.leetcode.editor.cn;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class TreeNodeUtils {
    public TreeNode getTreeNodeByArray(int[] nums) { //
        return dfs(nums, 0, nums.length - 1);
    }

    private TreeNode dfs(int[] nums, int start, int end) {
        return null;
    }

    public static void sout(TreeNode root) {
        List<Integer> list = new ArrayList<>();
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        while (!queue.isEmpty()) {
            TreeNode nowNode = queue.peek();
            queue.poll();
            list.add(nowNode.val);
            if (nowNode.left != null) {
                queue.add(nowNode.left);
            }
            if (nowNode.right != null) {
                queue.add(nowNode.right);
            }
        }
        System.out.println(list);
    }
}
