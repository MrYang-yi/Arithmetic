package LeetCode;

/**
 * topic: 奇偶链表
 * 给定一个单链表，把所有的奇数节点和偶数节点分别排在一起。
 * 请注意，这里的奇数节点和偶数节点指的是节点编号的奇偶性，而不是节点的值的奇偶性。
 * <p>
 * 请尝试使用原地算法完成。你的算法的空间复杂度应为 O(1)，时间复杂度应为 O(nodes)，nodes 为节点总数。
 * <p>
 * 输入: 1->2->3->4->5->6->7->8->9 NULL
 * 输出: 1->3->5->7->9->2->4->6->8 NULL
 * <p>
 * 输入: 2->1->3->5->6->4->7->NULL
 * 输出: 2->3->6->7->1->5->4->NULL
 * <p>
 * 应当保持奇数节点和偶数节点的相对顺序。
 * 链表的第一个节点视为奇数节点，第二个节点视为偶数节点，以此类推
 */
public class OddEvenList_328 {
    public ListNode p1p2List(ListNode head) {
        if (head == null) return null;
        ListNode p1 = head;
        ListNode p2 = head.next;
        ListNode p3 = p2;
        while (p2 != null && p2.next != null) {
            p1.next = p1.next.next;
            p2.next = p2.next.next;
            p1 = p1.next;
            p2 = p2.next;
        }
        p1.next = p3;
        return head;
    }

    public static void main(String[] args) {
        ListNode node1 = new ListNode(1);
        ListNode node2 = new ListNode(2);
        ListNode node3 = new ListNode(3);
        ListNode node4 = new ListNode(4);
        ListNode node5 = new ListNode(5);
        node1.setNext(node2);
        node2.setNext(node3);
        node3.setNext(node4);
        node4.setNext(node5);
        ListNode l1 = node1;
        ListNode l2 = new OddEvenList_328().p1p2List(l1);
        while (l2 != null) {
            System.out.print(l2.val + " ");
            l2 = l2.next;
        }
    }

}
