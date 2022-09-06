package LeetCode.editor.cn.HighFrequence.Hot100.leetcode.editor.cn;

public class ListNodeUtils {

    public static ListNode getListNodeByArray(int[] arr) {
        if (arr == null || arr.length == 0) {
            throw new IllegalArgumentException("array cannot empty");
        }
        ListNode dummyHead = new ListNode(-1);
        ListNode cur = dummyHead;
        for (int i = 0; i < arr.length; i++) {
            cur.next = new ListNode(arr[i]);
            cur = cur.next;
        }
        return dummyHead.next;
    }

    public static void sout(ListNode l1) {
        while (l1 != null) {
            System.out.print(l1.val + " ");
            l1 = l1.next;
        }
    }
}
