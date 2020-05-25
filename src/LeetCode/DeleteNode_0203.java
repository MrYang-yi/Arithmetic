package LeetCode;

/**
 * 实现一种算法，删除单向链表中间的某个节点（即不是第一个或最后一个节点），假定你只能访问该节点。
 * <p>
 * 示例：
 * 输入：单向链表a->b->c->d->e->f中的节点c
 * 结果：不返回任何数据，但该链表变为a->b->d->e->f
 *
 *
 * 总结：一开始没有认真审题 以为是给定链表删除中间节点  而实际题目是给定某节点 并删除它！！！
 *      一定要记住一点 就是只能访问该节点 所以思路就是把下一个节点的值赋给当前的节点 巧妙！
 *      例如  1 -> 2 -> 3 -> 4 -> 5 -> 6
 *      赋值  2 -> 2 -> 3 -> 4 -> 5 -> 6  此时删除第二个结点 2
 *           2 ->       3 -> 4 -> 5 -> 6
 *           间接完成了删除该节点
 *
 *          为了清晰显示 所以返回类型从void 变成ListNode 方便在控制台输出
 */
public class DeleteNode_0203 {
    public ListNode deleteNode(ListNode node) {
        node.val = node.next.val;
        node.next = node.next.next;
        return node;
    }

    public static void main(String[] args) {
        ListNode node1 = new ListNode(7);
        ListNode node2 = new ListNode(2);
        ListNode node3 = new ListNode(3);
        ListNode node4 = new ListNode(4);
        ListNode node5 = new ListNode(5);
        ListNode node6 = new ListNode(6);
        node1.setNext(node2);
        node2.setNext(node3);
        node3.setNext(node4);
        node4.setNext(node5);
        node5.setNext(node6);
        ListNode l1 = node1;
        ListNode l2 = new DeleteNode_0203().deleteNode(l1);
        while (l2 != null) {
            System.out.print(l2.val + " ");
            l2 = l2.next;
        }
    }
}
