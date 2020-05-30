package LeetCode;

import java.util.HashMap;

/**
 * 编写代码，移除未排序链表中的重复节点。保留最开始出现的节点。
 *
 * 思路： 这里提供两种思路：
 *      1 遍历链表 把链表的每个值都放到HashMap中 如果有重复 就直接跳到下一个 注意控制空指针异常的条件就行
 *      2  利用双层while循环  后面的值要是与遍历的值相等就跳到下一个
 */
public class RemoveDuplicateNodes_02_01 {
    public ListNode removeDuplicateNodes(ListNode head) {
       HashMap<Integer, Integer> map = new HashMap<>();
        if (head == null) return null;
        ListNode dummyhead = new ListNode(0);
        ListNode low = dummyhead;
        dummyhead.next = head;
        low.next = head;
        while (head != null) {
            if (map.containsKey(head.val)) {
                if (head.next == null) {
                    low.next = null;
                    return dummyhead.next;
                }
                head = head.next;
                low.next = head;
            } else {
                map.put(head.val, head.val);
                head = head.next;
                low = low.next;
            }
        }
        return dummyhead.next;
/*        ListNode p = head;
        while (p != null) {
            ListNode q = p;
            while (q.next != null) {
                if (q.next.val == p.val)
                    q.next = q.next.next;
                else
                    q = q.next;
            }
            p = p.next;
        }
        return head;*/
    }

    public static void main(String[] args) {
        ListNode node1 = new ListNode(1);
        ListNode node2 = new ListNode(2);
        ListNode node3 = new ListNode(3);
        ListNode node4 = new ListNode(5);
        ListNode node5 = new ListNode(3);
        ListNode node6 = new ListNode(4);
        ListNode node7 = new ListNode(2);
        ListNode node8 = new ListNode(1);
        node1.next = node2;
        node2.next = node3;
        node3.next = node4;
        node4.next = node5;
        node5.next = node6;
        node6.next = node7;
        node7.next = node8;
        ListNode l1 = node1;
        ListNode l2 = new RemoveDuplicateNodes_02_01().removeDuplicateNodes(l1);
        while (l2 != null) {
            System.out.print(l2.val + " ");
            l2 = l2.next;
        }
    }
}
