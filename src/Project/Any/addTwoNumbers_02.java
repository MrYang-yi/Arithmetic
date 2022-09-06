package Project.Any;

/**
 * topic:链表和
 * 给出两个 非空 的链表用来表示两个非负的整数。其中，它们各自的位数是按照 逆序 的方式存储的，并且它们的每个节点只能存储一位数字。
 * 如果，我们将这两个数相加起来，则会返回一个新的链表来表示它们的和。
 * 您可以假设除了数字 0 之外，这两个数都不会以 0 开头。
 * <p>
 * 示例：
 * 输入：(2 -> 4 -> 3) + (5 -> 6 -> 4)
 * 输出：7 -> 0 -> 8
 * 原因：342 + 465 = 807
 */
class ListNode {
    int val;
    ListNode next;

    ListNode(int x) {
        val = x;
    }

    public void setVal(int val) {
        this.val = val;
    }

    public void setNext(ListNode next) {
        this.next = next;
    }
}

class addTwoNumbers {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode dummyhead = new ListNode(0);
        ListNode head = dummyhead;
        int add = 0;
        while (l1 != null || l2 != null || add != 0) {
            if (l1 != null) {
                add += l1.val;
                l1 = l1.next;
            }
            if (l2 != null) {
                add += l2.val;
                l2 = l2.next;
            }
            dummyhead.next = new ListNode(add % 10);
            dummyhead = dummyhead.next;
            add /= 10;
        }
        return head.next;
    }

    public static void main(String[] args) {
        ListNode node1 = new ListNode(2);
        ListNode node2 = new ListNode(4);
        ListNode node3 = new ListNode(3);
        node1.setNext(node2);
        node2.setNext(node3);
        ListNode l1 = node1;
        ListNode node4 = new ListNode(5);
        ListNode node5 = new ListNode(6);
        ListNode node6 = new ListNode(4);
        node4.setNext(node5);
        node5.setNext(node6);
        ListNode l2 = node4;
        ListNode l3 = new addTwoNumbers().addTwoNumbers(l1, l2);
        while (l3 != null) {
            System.out.print(l3.val + " ");
            l3 = l3.next;
        }
    }
}
