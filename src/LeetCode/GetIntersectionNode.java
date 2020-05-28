package LeetCode;

/**
 *
 * 面试题 02.07. 链表相交
 *
 * 给定两个（单向）链表，判定它们是否相交并返回交点。请注意相交的定义基于节点的引用，
 * 而不是基于节点的值。换句话说，如果一个链表的第k个节点与另一个链表的第j个节点是同一节点（引用完全相同），
 * 则这两个链表相交。
 *
 * 思路：这里提供两种思路
 * 1： 先计算两条链表长度 然后让长的链表先走（保证他们与 相交结点 有相同的距离再出发）
 *     遍历到某个节点 如果两条链表相等 返回该节点
 * 2：  这里给出一个巧妙思路：链表A+链表B 链表B+链表A 会发现它们末尾的相交的链表是重合的（666）
 */
public class GetIntersectionNode {
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
/*        if (headA == null || headB == null) {
            return null;
        }
        ListNode p1 = headA;
        ListNode p2 = headB;
        int len_A = 0;
        int len_B = 0;
        while (p1 != null) {
            ++len_A;
            p1 = p1.next;
        }
        while (p2 != null) {
            ++len_B;
            p2 = p2.next;
        }
        int len = Math.abs(len_A - len_B);
        for (int i = 0; i < len; i++) {
            if (len_A > len_B) {
                headA = headA.next;
            } else {
                headB = headB.next;
            }
        }
        while (headA != null && headB != null) {
            if (headA == headB) {   //这里比的是整个链表 而不是比一个ListNode节点
                return headA;
            }
            headA = headA.next;
            headB = headB.next;
        }
        return null;*/
        if (headA == null || headB == null)
            return null;
        ListNode h1 = headA, h2 = headB;
        while (h1 != h2) {
            h1 = h1 == null ? headB : h1.next;
            h2 = h2 == null ? headA : h2.next;
        }
        return h1;
    }

    public static void main(String[] args) {
        ListNode node1 = new ListNode(4);
        ListNode node2 = new ListNode(1);
        ListNode node3 = new ListNode(8);
        ListNode node4 = new ListNode(4);
        ListNode node5 = new ListNode(5);
        node1.setNext(node2);
        node2.setNext(node3);
        node3.setNext(node4);
        node4.setNext(node5);
        ListNode l1 = node1;
        ListNode node6 = new ListNode(5);
        ListNode node7 = new ListNode(0);
        ListNode node8 = new ListNode(1);
        ListNode node9 = new ListNode(8);
        ListNode node10 = new ListNode(4);
        ListNode node11 = new ListNode(5);
        node6.setNext(node7);
        node7.setNext(node8);
        node8.setNext(node9);
        node9.setNext(node10);
        node10.setNext(node11);
        ListNode l2 = node6;
        ListNode l3 = new GetIntersectionNode().getIntersectionNode(l1,l2);
        while (l3 != null) {
            System.out.print(l3.val + " ");
            l3 = l3.next;
        }
    }
}
