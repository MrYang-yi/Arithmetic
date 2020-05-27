package LeetCode;

import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * 23. 合并K个排序链表
 * 合并 k 个排序链表，返回合并后的排序链表。请分析和描述算法的复杂度。
 * 输入:
 * [
 * 1->4->5,
 * 1->3->4,
 * 2->6
 * ]
 * 输出: 1->1->2->3->4->4->5->6
 */
public class MergeKLists_23 {
    public ListNode mergeKLists(ListNode[] lists) {
        ListNode dummyhead = new ListNode(0);
        ListNode head = dummyhead;
        PriorityQueue<ListNode> priorityQueue = new PriorityQueue<>(new Comparator<ListNode>() {
            @Override
            public int compare(ListNode o1, ListNode o2) {
                return o1.val - o2.val;
            }
        });
        for (ListNode l : lists) {
            if (l != null) {
                priorityQueue.add(l);
            }
        }
        while (!priorityQueue.isEmpty()) {
            ListNode curr = priorityQueue.poll();
            head.next = curr;
            head = head.next;
            if (curr.next != null) {
                priorityQueue.add(curr.next);
            }
        }

        return dummyhead.next;
    }

    public static void main(String[] args) {
        ListNode node1 = new ListNode(1);
        ListNode node2 = new ListNode(4);
        ListNode node3 = new ListNode(5);
        node1.setNext(node2);
        node2.setNext(node3);
        ListNode l1 = node1;

        ListNode node4 = new ListNode(1);
        ListNode node5 = new ListNode(3);
        ListNode node6 = new ListNode(4);
        node4.setNext(node5);
        node5.setNext(node6);
        ListNode l2 = node4;

        ListNode node7 = new ListNode(2);
        ListNode node8 = new ListNode(6);
        node7.setNext(node8);
        ListNode l3 = node7;
        ListNode[] lists = {l1, l2, l3};
        ListNode l4 = new MergeKLists_23().mergeKLists(lists);
        while (l4 != null) {
            System.out.print(l4.val + " ");
            l4 = l4.next;
        }

    }

}
