package HighFrequence.Hot100.leetcode.editor.cn;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class lc102_BinaryTreeLevelOrderTraversal {
    public static void main(String[] args) {
        Solution solution = new lc102_BinaryTreeLevelOrderTraversal().new Solution();
        //此处忽略，直接提交即可
    }

    class Solution {
        public List<List<Integer>> levelOrder(TreeNode root) {
            List<List<Integer>> list = new ArrayList<>();
            if(root == null){
                return null;
            }
            Queue<TreeNode> queue = new LinkedList<>();
            queue.add(root);
            while(!queue.isEmpty()){
                List<Integer> level = new ArrayList<>();
                int size = queue.size();
                for (int i = 1; i < size; i++) {
                    TreeNode node = queue.poll();
                    level.add(node.val);
                    if(node.left != null){
                       queue.add(node.left);
                    }
                    if(node.right != null){
                        queue.add(node.right);
                    }
                    list.add(level);
                }
            }
            return list;
        }
    }
}