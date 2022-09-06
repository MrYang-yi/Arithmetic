package Project.Any;

import java.util.*;

/**
 * topic: 两数之和 IV - 输入 BST
 * 输入:
 * 5
 * / \
 * 3   6
 * / \   \
 * 2   4   7
 * <p>
 * Target = 9
 * <p>
 * 输出: True
 */
class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode(int x) {
        val = x;
    }

    public void setVal(int val) {
        this.val = val;
    }

    public void setLeft(TreeNode left) {
        this.left = left;
    }

    public void setRight(TreeNode right) {
        this.right = right;
    }
}

public class TwoSum_653 {
    Set<Integer> set = new HashSet<>();

    public boolean findTarget(TreeNode root, int k) {
        if (root == null)
            return false;
        if (set.contains(k - root.val))
            return true;
        set.add(root.val);
        return findTarget(root.left, k) || findTarget(root.right, k);

    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(5);
        TreeNode left1 = new TreeNode(3);
        TreeNode right2 = new TreeNode(6);
        root.setLeft(left1);
        root.setRight(right2);
        TreeNode left11 = new TreeNode(2);
        TreeNode right12 = new TreeNode(4);
        TreeNode right22 = new TreeNode(7);
        left1.setLeft(left11);
        left1.setRight(right12);
        right2.setRight(right22);

        boolean flag = new TwoSum_653().findTarget(root, 9);
        System.out.println(flag);
    }
}
