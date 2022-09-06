package LeetCode.editor.cn.HighFrequence.swordPointToOffer;


/**
 * 剑指 Offer 52. 两个链表的第一个公共节点
 * 输入两个链表，找出它们的第一个公共节点。
 */
public class test52 {
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        int len1 = getLength(headA);
        int len2 = getLength(headB);
        int k = Math.abs(len1 - len2);
        while (k > 0) {
            if (len1 > len2 && headA !=null) {
                headA = headA.next;
                k--;
            } else if(len1 < len2&& headB !=null) {
                headB = headB.next;
                k--;
            }
        }
        while (headA != null) {
            if(headA == headB) return headA;
            headA = headA.next;
            headB = headB.next;
        }
       return null;
    }

    private int getLength(ListNode root) {
        int count = 0;
        while (root != null) {
            root = root.next;
            count++;
        }
        return count;
    }

    public static void main(String[] args) {
        ListNode node1 = new ListNode(0);
        ListNode node2 = new ListNode(9);
        ListNode node3 = new ListNode(1);
        ListNode node4 = new ListNode(2);
        ListNode node5 = new ListNode(4);
        ListNode node6 = new ListNode(3);
        node1.next = node2;
        node2.next = node3;
        node3.next = node4;
        node4.next = node5;
        node6.next = node4;
        ListNode l1 = node1;
        ListNode l2 = node6;
        ListNode l3 = new test52().getIntersectionNode(l1, l2);
        while (l3 != null) {
            System.out.print(l3.val + " ");
            l3 = l3.next;
        }

    }
}
