package Project.linkedList;


import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class lc23_MergeKSortedLists_valueComparator {
    public ListNode mergeKLists(ListNode[] lists) {
        if (lists == null || lists.length == 0) {
            return null;
        }
        List<ListNode> list = new ArrayList<>();
        ValueComparator valueComparator = new ValueComparator();
        for (int i = 0; i < lists.length; i++) {
            while (lists[i] != null) {
                list.add(lists[i]);
                lists[i] = lists[i].next;
            }
        }
        Collections.sort(list, valueComparator);
        ListNode dummyHead = new ListNode(-1);
        ListNode cur = dummyHead;
        for (ListNode listNode : list) {
            cur = new ListNode(listNode.val);
            cur = cur.next;
        }
        return dummyHead.next;
    }

    private class ValueComparator implements Comparator<ListNode> {
        @Override
        public int compare(ListNode o1, ListNode o2) {
            return o1.val - o2.val;
        }
    }
}
