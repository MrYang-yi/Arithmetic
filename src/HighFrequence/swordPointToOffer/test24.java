package LeetCode.editor.cn.HighFrequence.swordPointToOffer;

/**
 * 面试题24. 反转链表
 * 定义一个函数，输入一个链表的头节点，反转该链表并输出反转后链表的头节点。
 * 示例:
 * 输入: 1->2->3->4->5->NULL
 * 输出: 5->4->3->2->1->NULL
 *
 * 反转链表最精简版
 */
public class test24 {
    public ListNode reverseList(ListNode head) {
        if(head == null) return head;
        ListNode prev = null;
        while (head != null) {
            ListNode curr = head.next;
            head.next = prev;
            prev = head;
            head = curr;
        }
        return prev;
    }


    public static void main(String[] args) {
        ListNode node1 = new ListNode(1);
        ListNode node2 = new ListNode(2);
        ListNode node3 = new ListNode(3);
        ListNode node4 = new ListNode(4);
        ListNode node5 = new ListNode(5);
        ListNode node6 = new ListNode(6);
        ListNode node7 = new ListNode(7);
        node1.next = node2;
        node2.next = node3;
        node3.next = node4;
        node4.next = node5;
        node5.next = node6;
        node6.next = node7;
        ListNode l1 = node1;
        ListNode l2 = new test24().reverseList(l1);
        while (l2 != null) {
            System.out.print(l2.val + " ");
            l2 = l2.next;
        }
    }
}
