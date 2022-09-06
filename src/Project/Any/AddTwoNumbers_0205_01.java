package Project.Any;

/**
 * topic:链表求和
 * 示例：
 * 输入：(7 -> 1 -> 6) + (5 -> 9 -> 2)，即617 + 295
 * 输出：2 -> 1 -> 9，即912
 *  0205_01 返回912 0205_02返回链表
 *
 * 进阶：假设这些数位是正向存放的，请再做一遍。
 * 示例：
 * 输入：(6 -> 1 -> 7) + (2 -> 9 -> 5)，即617 + 295
 * 输出：9 -> 1 -> 2，即912
 * 0205_03 返回912 0205_04返回链表
 */
public class AddTwoNumbers_0205_01 {
    public int addTwoNumbers(ListNode l1, ListNode l2) {
        int sum = 0;
        int k = 0;
        int add = 0; //进位
        ListNode dummyhead=new ListNode(0);

        while (l1 != null || l2 != null) {
            int a = l1.val;
            int b = l2.val;
            if (l1 == null) {
                sum = sum * 10 + b;
                l2 = l2.next;
            }
            if (l2 == null) {
                sum = sum * 10 + a;
                l1 = l1.next;
            }

            if (a + b + add - 10 >= 0) {
                k = a + b + add - 10;
                add = 1;

            } else {
                k = a + b + add;
                add = 0;
            }
            sum = sum * 10 + k;
            l1=l1.next;
            l2=l2.next;
            k = 0;
        }
        return Integer.parseInt(new StringBuilder(""+sum).reverse().toString());
    }

    public static void main(String[] args) {
        ListNode node1 = new ListNode(7);
        ListNode node2 = new ListNode(1);
        ListNode node3 = new ListNode(6);
        node1.setNext(node2);
        node2.setNext(node3);
        ListNode node4 = new ListNode(5);
        ListNode node5 = new ListNode(9);
        ListNode node6 = new ListNode(2);
        node4.setNext(node5);
        node5.setNext(node6);
        ListNode l1 = node1;
        ListNode l2 = node4;
        int a = new AddTwoNumbers_0205_01().addTwoNumbers(l1, l2);
        System.out.println(a);

    }
}
