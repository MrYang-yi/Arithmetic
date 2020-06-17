package Sword_Point_To_Offer;

import java.util.Stack;

/**
 * 面试题30. 包含min函数的栈
 * 定义栈的数据结构，请在该类型中实现一个能够得到栈的最小元素的 min 函数在该栈中，调用 min、push 及 pop 的时间复杂度都是 O(1)。
 * 示例:
 * MinStack minStack = new MinStack();
 * minStack.push(-2);
 * minStack.push(0);
 * minStack.push(-3);
 * minStack.min();   --> 返回 -3.
 * minStack.pop();
 * minStack.top();      --> 返回 0.
 * minStack.min();   --> 返回 -2.
 *
 *
 * 思路：借用辅助栈保持当前状态的最小值，碰到 Integer 慎用 ==  切记！！！
 *       出栈时要注意  A是必须出栈的  那B呢？ 如果当前的最小值已经不是B的栈顶元素了 就应该出栈
 *       就是相当于A出栈的元素和B相等
 */
public class test30 {

    Stack<Integer> A;
    Stack<Integer> B;

    /**
     * initialize your data structure here.
     */
    public test30() {
        A = new Stack<>();
        B = new Stack<>();
    }

    public void push(int x) {
        A.push(x);
        if (B.size() == 0 || x <= B.peek()) {
            B.push(x);
        }
    }

    public void pop() {
        if (A.peek().equals(B.peek())) {
            B.pop();
        }
        A.pop();
    }

    public int top() {
        return A.peek();
    }

    public int min() {
        return B.peek();
    }

    public static void main(String[] args) {
        test30 p = new test30();
        p.push(-2);
        p.push(0);
        p.push(-3);
        int a = p.min();
        p.pop();
        int b = p.top();
        int c = p.min();
        System.out.println(a);
        System.out.println(b);
        System.out.println(c);
    }

}
