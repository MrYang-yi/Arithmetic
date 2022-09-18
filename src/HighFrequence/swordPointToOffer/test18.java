package LeetCode.editor.cn.HighFrequence.swordPointToOffer;

/**
 * 面试题18. 删除链表的节点
 * 给定单向链表的头指针和一个要删除的节点的值，定义一个函数删除该节点。
 * 返回删除后的链表的头节点。
 * 注意：此题对比原题有改动
 * <p>
 * 示例 1:
 * 输入: head = [4,5,1,9], val = 5
 * 输出: [4,1,9]
 * 解释: 给定你链表中值为 5 的第二个节点，那么在调用了你的函数之后，该链表应变为 4 -> 1 -> 9.
 * <p>
 * 示例 2:
 * 输入: head = [4,5,1,9], val = 1
 * 输出: [4,5,9]
 * 解释: 给定你链表中值为 1 的第三个节点，那么在调用了你的函数之后，该链表应变为 4 -> 5 -> 9.
 */
public class test18 {
    public ListNode deleteNode(ListNode head, int val) {
        ListNode dummyhead = new ListNode(0);
        dummyhead.next = head;
        ListNode slow = dummyhead;
        while (head.val != val) {
            head = head.next;
            slow = slow.next;
        }
        slow.next = slow.next.next;
        return dummyhead.next;
    }

    public static void main(String[] args) {
        ListNode node1 = new ListNode(4);
        ListNode node2 = new ListNode(5);
        ListNode node3 = new ListNode(1);
        ListNode node4 = new ListNode(9);
        node1.next = node2;
        node2.next = node3;
        node3.next = node4;
        ListNode l1 = node1;
        ListNode l2 = new test18().deleteNode(l1, 1);
        while (l2 != null) {
            System.out.print(l2.val + " ");
            l2 = l2.next;
        }
    }
}
