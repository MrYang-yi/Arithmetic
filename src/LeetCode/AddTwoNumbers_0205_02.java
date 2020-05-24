package LeetCode;

/**
 * topic:链表求和
 * 示例：
 * 输入：(7 -> 1 -> 6) + (5 -> 9 -> 2)，即617 + 295
 * 输出：2 -> 1 -> 9，即912
 * 0205_01 返回912 0205_02返回链表
 * <p>
 * 进阶：假设这些数位是正向存放的，请再做一遍。
 * 示例：
 * 输入：(6 -> 1 -> 7) + (2 -> 9 -> 5)，即617 + 295
 * 输出：9 -> 1 -> 2，即912
 * (这里不做演示） 最差思路 先写一个链表反转的方法 resverse 如下
 *
 *
 * 总结：当碰上链表和问题  while里面的内嵌循环 不能以为  空（null）  进行设置
 *      因为这样设置就不能确定下一位数字的大小 sum=add+ l1.val + l2.val 这一步会造成空指针异常
 *      如果再进行判断 步骤繁多 没必要
 *
 *      所以while里的内嵌循环 应设置不为空 这样就可以避免空指针异常
 */
public class AddTwoNumbers_0205_02 {
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

/*   此方法将链表反转
    public ListNode reverse(ListNode l1) {
        ListNode prev = null;
        ListNode curr = l1;
        while (curr != null) {
            ListNode temp = curr.next;
            curr.next = prev;
            prev = curr;
            curr = temp;
        }
        return prev;
    }*/

    public static void main(String[] args) {
        ListNode node1 = new ListNode(2);
        ListNode node2 = new ListNode(4);
        ListNode node3 = new ListNode(3);
        node1.setNext(node2);
        node2.setNext(node3);
        ListNode node4 = new ListNode(5);
        ListNode node5 = new ListNode(6);
        ListNode node6 = new ListNode(4);
        node4.setNext(node5);
        node5.setNext(node6);
        ListNode l1 = node1;
        ListNode l2 = node4;
        ListNode l3 = new addTwoNumbers().addTwoNumbers(l1, l2);
        while (l3 != null) {
            System.out.print(l3.val + " ");
            l3 = l3.next;
        }
    }
}
