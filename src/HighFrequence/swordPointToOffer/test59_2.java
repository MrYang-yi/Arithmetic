package HighFrequence.swordPointToOffer;

import java.util.LinkedList;
import java.util.Queue;

/**
 * 剑指 Offer 59 - II. 队列的最大值
 * 请定义一个队列并实现函数 linkedlist_value 得到队列里的最大值，要求函数linkedlist_value、push_back 和 pop_front 的均摊时间复杂度都是O(1)。
 * 若队列为空，pop_front 和 linkedlist_value 需要返回 -1
 * 示例 1：
 * 输入:
 * ["linkedlistQueue","push_back","push_back","linkedlist_value","pop_front","linkedlist_value"]
 * [[],[1],[2],[],[],[]]
 * 输出: [null,null,null,2,1,2]
 * <p>
 * 示例 2：
 * 输入:
 * ["linkedlistQueue","pop_front","linkedlist_value"]
 * [[],[],[]]
 * 输出: [null,-1,-1]
 */
public class test59_2 {
    Queue<Integer> queue;
    LinkedList<Integer> linkedlist;

    public test59_2() {
        queue = new LinkedList<>();
        linkedlist = new LinkedList<>();//LinkedList是双端链表
    }

    public int max_value() {
        return linkedlist.size() == 0 ? -1 : linkedlist.getFirst();
    }

    public void push_back(int value) {
        queue.add(value);
        while (linkedlist.size() != 0 && linkedlist.getLast() < value) {//注意：这里第二个判断条件不能带等号，即linkedlist中对于当前queue中的具有相同值的元素会全部存储，而不是存储最近的那个。
            linkedlist.removeLast();
        }
        linkedlist.add(value);
    }

    public int pop_front() {
        if (linkedlist.size() != 0 && queue.peek().equals(linkedlist.getFirst()))//Integer类型的值的比较不能直接使用==
            linkedlist.removeFirst();
        return queue.size() == 0 ? -1 : queue.poll();
    }
}
