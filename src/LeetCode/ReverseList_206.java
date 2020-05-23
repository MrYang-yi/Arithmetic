package LeetCode;

/**
 * topic: 反转链表
 * 反转一个单链表。
 * <p>
 * 示例:
 * 输入: 1->2->3->4->5->NULL
 * 输出: 5->4->3->2->1->NULL
 */
public class ReverseList_206 {
    public ListNode reverseList(ListNode head) {
            ListNode curr=head;
            ListNode prev=null;
            while(curr!=null){
                ListNode temp=curr.next;
                curr.next=prev;
                prev=curr;
                curr=temp;
            }
            return prev;
       //------------递归实现单链表反转
        /*if (head == null || head.next == null) {
            return head;
        }
        ListNode p1 = head.next;
        ListNode p2 = reverseList(p1);
        p1.next = head;
        head.next = null;
        return p2;*/

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
        ListNode l2 = new ReverseList_206().reverseList(l1);
        while (l2 != null) {
            System.out.print(l2.val + " ");
            l2 = l2.next;
        }

    }
}
