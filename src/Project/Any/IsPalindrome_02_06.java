package Project.Any;

import java.util.ArrayList;
import java.util.List;

/**
 * topic: 回文链表
 * 编写一个函数，检查输入的链表是否是回文的
 * 。
 * 输入： 1->2
 * 输出： false
 * <p>
 * 输入： 1->2->2->1
 * 输出： true
 * 思路： 这里要注意 最后list.get()==list.get  这里返回的是Integer  所以涉及一个拆箱问题 直接拆箱成int就可以了
 */
public class IsPalindrome_02_06 {
    public boolean isPalindrome(ListNode head) {
        if (head == null) return true;
        ArrayList<Integer> list = new ArrayList<>();
        while (head != null) {
            list.add(head.val);
            head = head.next;
        }
        int len = list.size();
        if (len % 2 != 0)
            return Palindrome(len / 2, len / 2, list);
        else
            return Palindrome(len / 2 - 1, len / 2, list);
    }

    public boolean Palindrome(int a, int b, List list) {
        int len = list.size();
        while (a >= 0 && b <= len) {
            if ((int)list.get(a) != (int)list.get(b)) {
                return false;
            }
            a--;
            b++;
        }
        return true;
    }

    public static void main(String[] args) {
        ListNode node1 = new ListNode(1);
        ListNode node2 = new ListNode(2);
        ListNode node3 = new ListNode(2);
        ListNode node4 = new ListNode(1);
        node1.next = node2;
        node2.next = node3;
        node3.next = node4;
        ListNode l1 = node1;
        boolean flag = new IsPalindrome_02_06().isPalindrome(l1);
        System.out.println(flag);
    }
}
