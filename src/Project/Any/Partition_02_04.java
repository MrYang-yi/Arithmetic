package Project.Any;

import java.util.ArrayList;
import java.util.Comparator;

/**
 *
 * 编写程序以 x 为基准分割链表，使得所有小于 x 的节点排在大于或等于 x 的节点之前。
 * 如果链表中包含 x，x 只需出现在小于 x 的元素之后(如下所示)。分割元素 x 只需处于“右半部分”即可，
 * 其不需要被置于左右两部分之间。
 *
 *
 *
 *  总结:这道题的题意是有歧义的 下面共有三周种解答均能通过leetcode
 *       简单介绍 未注释解法的思路  先将所有链表的值放入ArrayList
 *                list.sort() 重写Comparator方法
 *                最后重新构造一个链表 将值依次放进链表
 */
public class Partition_02_04 {
    public ListNode partition(ListNode head, int x) {
 /*      if (head == null) return null;
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode prev = head;
        head = head.next;
        while (head != null) {
            if (head.val < x) {
                prev.next = head.next;
                head.next = dummy.next;
                dummy.next = head;
                head = prev.next;
            } else {
                prev = prev.next;
                head = head.next;
            }
        }
        return dummy.next;*/
       ArrayList<Integer> list = new ArrayList<>();
        int count = 0;
        //除了与x相等的元素，先排序
        while (head != null) {
            int val = head.val;
/*            if (val == x) {
                count++;
                head = head.next;
                continue;
            }*/
            list.add(val);
            head = head.next;
        }
        list.sort(new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return o1 - o2;
            }
        });
        //与x相等的放在最后
        while (count > 0) {
            list.add(x);
            count--;
        }
        //构造结果
        ListNode pre = new ListNode(0);
        ListNode cur = pre;
        for (int val : list) {
            ListNode node = new ListNode(val);
            cur.next = node;
            cur = cur.next;
        }
        return pre.next;

    }


    public static void main(String[] args) {
        ListNode node1 = new ListNode(3);
        ListNode node2 = new ListNode(5);
        ListNode node3 = new ListNode(8);
        ListNode node4 = new ListNode(5);
        ListNode node5 = new ListNode(10);
        ListNode node6 = new ListNode(2);
        ListNode node7 = new ListNode(1);
        node1.next = node2;
        node2.next = node3;
        node3.next = node4;
        node4.next = node5;
        node5.next = node6;
        node6.next = node7;
        ListNode l1 = node1;
        ListNode l2 = new Partition_02_04().partition(l1, 5);
        while (l2 != null) {
            System.out.print(l2.val + " ");
            l2 = l2.next;
        }

    }
}
