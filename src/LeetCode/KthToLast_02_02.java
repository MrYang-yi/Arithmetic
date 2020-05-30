package LeetCode;

/**
 * topic:面试题 02.02. 返回倒数第 k 个节点
 * <p>
 * 实现一种算法，找出单向链表中倒数第 k 个节点。返回该节点的值。
 * 输入： 1->2->3->4->5 和 k = 2
 * 输出： 4
 */
public class KthToLast_02_02 {
    public int kthToLast(ListNode head, int k) {
        if (head == null) return Integer.MAX_VALUE;
        ListNode fast = head;
        ListNode low = head;
        for (int i = 0; i < k; i++) {
            fast = fast.next;
        }
        while (fast != null) {
            fast = fast.next;
            low = low.next;
        }
        return low.val;
    }

    public static void main(String[] args) {
        ListNode node1 = new ListNode(1);
        ListNode node2 = new ListNode(2);
        ListNode node3 = new ListNode(3);
        ListNode node4 = new ListNode(4);
        ListNode node5 = new ListNode(5);
        node1.next = node2;
        node2.next = node3;
        node3.next = node4;
        node4.next = node5;
        ListNode l1 = node1;
        int p = new KthToLast_02_02().kthToLast(l1, 2);
        System.out.println(p);
    }
}
