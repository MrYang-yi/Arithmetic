package LeetCode.editor.cn.HighFrequence.swordPointToOffer;

import java.util.Stack;

/**
 * 面试题06. 从尾到头打印链表
 * 输入一个链表的头节点，从尾到头反过来返回每个节点的值（用数组返回）。
 * <p>
 * 示例 1：
 * 输入：head = [1,3,2]
 * 输出：[2,3,1]
 *
 * 总结： 小心使用stack.size 因为在栈取出元素后 stack.size() 是会减小的 而不是不变的！ 是个坑
 *
 *
 */
class ListNode {
    int val;
    ListNode next;

    public ListNode(int x) {
        val = x;
    }

    public void setVal(int val) {
        this.val = val;
    }

    public void setNext(ListNode next) {
        this.next = next;
    }
}

public class test06 {
    public int[] reversePrint(ListNode head) {
        Stack<ListNode> stack = new Stack<>();
        while (head != null) {
            stack.push(head);
            head = head.next;
        }
        int[] a = new int[stack.size()];
        int n = stack.size();
        for (int i = 0; i < n; i++) {
            a[i] = stack.pop().val;
        }
        return a;
    }

    public static void main(String[] args) {
        ListNode node1 = new ListNode(1);
        ListNode node2 = new ListNode(3);
        ListNode node3 = new ListNode(2);
        node1.next = node2;
        node2.next = node3;
        ListNode l1 = node1;
        int[] a = new test06().reversePrint(l1);
        for (int x : a) {
            System.out.print(x + " ");
        }
    }

}
