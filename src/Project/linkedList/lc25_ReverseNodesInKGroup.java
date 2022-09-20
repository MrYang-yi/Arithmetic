package Project.linkedList;

public class lc25_ReverseNodesInKGroup {
    public ListNode reverseKGroup(ListNode head, int k) {
        if (head == null) {
            return null;
        }
        ListNode l1 = head;
        ListNode l2 = head;
        for (int i = 0; i < k; i++) {  //不足k个 不需要翻转
            if (l2 == null) {
                return head;
            }
            l2 = l2.next;
        }
        //反转前k个
        ListNode newHead = reverse(l1, l2);
        // 递归反转后续链表并连接
        l1.next = reverseKGroup(l2, k);
        return newHead;
    }

    private ListNode reverse(ListNode a, ListNode b) {
        ListNode prev = null;
        ListNode cur = a;
        while (cur != b) {
            ListNode l1 = cur.next;
            cur.next = prev;
            prev = cur;
            cur = l1;
        }
        return prev;
    }
}