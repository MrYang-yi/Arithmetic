package Project.Any;

/**
 * topic: 合并两个有序链表
 * 将两个升序链表合并为一个新的升序链表并返回。新链表是通过拼接给定的两个链表的所有节点组成的。 
 * <p>
 * 示例：
 * 输入：1->2->4, 1->3->4
 * 输出：1->1->2->3->4->4
 */
public class MergeTwoLists_21 {
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        ListNode dummyhead = new ListNode(0);
        ListNode p = dummyhead;
        while (l1 != null || l2 != null) {
            if (l1 == null) {
                p.next = l2;
                return dummyhead.next;
            }
            if (l2 == null) {
                p.next = l1;
                return dummyhead.next;
            }
            if (l1.val < l2.val) {
                p.next = l1;
                l1 = l1.next;
                p = p.next;
            } else {
                p.next = l2;
                l2 = l2.next;
                p = p.next;
            }
        }
        return dummyhead.next;
    }

    public static void main(String[] args) {
        ListNode node1 = new ListNode(1);
        ListNode node2 = new ListNode(2);
        ListNode node3 = new ListNode(4);
        node1.setNext(node2);
        node2.setNext(node3);
        ListNode l1 = node1;
        ListNode node4 = new ListNode(1);
        ListNode node5 = new ListNode(3);
        ListNode node6 = new ListNode(4);
        node4.setNext(node5);
        node5.setNext(node6);
        ListNode l2 = node4;
        ListNode l3 = new MergeTwoLists_21().mergeTwoLists(l1, l2);
        while (l3 != null) {
            System.out.print(l3.val + " ");
            l3 = l3.next;
        }

    }
}
