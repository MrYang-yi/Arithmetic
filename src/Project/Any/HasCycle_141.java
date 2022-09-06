package Project.Any;

/**
 * 给定一个链表，判断链表中是否有环。
 * 为了表示给定链表中的环，我们使用整数 pos 来表示链表尾连接到链表中的位置（索引从 0 开始）。
 * 如果 pos 是 -1，则在该链表中没有环。
 * <p>
 * 示例 1：
 * 输入：head = [3,2,0,-4], pos = 1
 * 输出：true
 * 解释：链表中有一个环，其尾部连接到第二个节点。
 * 具体示例 最好去leetcode官网查看
 * <p>
 * 思路1 : 利用Hash表解题 把ListNode类型放入Hash表 遍历链表 如果再次遇到 就是存在环
 * 思路2 :  利用快慢指针（双指针） 满指针速度为1 快指针速度为2
 * 假设非环长为N 环长为K 慢指针到环节点时间为N 而此时快指针已经进入环N的距离 假设环比较大 K>N
 * 此时两者相距 K—N  所以快指针追上慢指针的时间为 K-N/2-1 即为K-N
 */
public class HasCycle_141 {
    public boolean hasCycle(ListNode head) {
/*        Set<ListNode> set = new HashSet<>();
        while (head != null) {
            if (set.contains(head)) {
                return true;
            } else {
                set.add(head);
                head = head.next;
            }
        }
        return false;*/
        if (head == null || head.next == null) {
            return false;
        }
        ListNode low = head;
        ListNode fast = head.next;
        while (low != fast) {
            if (fast == null || fast.next == null) {
                return false;
            }
            low = low.next;
            fast = fast.next.next;
        }
        return true;
    }

    public static void main(String[] args) {
        ListNode node1 = new ListNode(1);
        ListNode node2 = new ListNode(2);
        ListNode node3 = new ListNode(3);
        ListNode node4 = new ListNode(4);
        node1.setNext(node2);
        node2.setNext(node3);
        node3.setNext(node4);
        node4.setNext(node2);
        ListNode l1 = node1;
        boolean flag = new HasCycle_141().hasCycle(l1);
        System.out.println(flag);
    }
}
