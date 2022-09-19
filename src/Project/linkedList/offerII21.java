package Project.linkedList;

public class offerII21 {
        public ListNode removeNthFromEnd(ListNode head, int n) {
            ListNode dummyhead = new ListNode(-1);
            ListNode fast = dummyhead;
            ListNode slow = dummyhead;
            dummyhead.next = head;
            for (int i = 0; i < n + 1; i++) { //当相差n个节点时，快指针多走一格，为n+1
                fast = fast.next;
            }
            while (fast != null) {
                slow = slow.next;
                fast = fast.next;
            }
            slow.next = slow.next.next;
            return dummyhead.next;
        }
}
