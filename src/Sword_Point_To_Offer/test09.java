package Sword_Point_To_Offer;

import java.util.Stack;

/**
 * 面试题09. 用两个栈实现队列
 * 用两个栈实现一个队列。队列的声明如下，请实现它的两个函数 appendTail 和 deleteHead ，
 * 分别完成在队列尾部插入整数和在队列头部删除整数的功能。(若队列中没有元素，deleteHead 操作返回 -1 )
 * <p>
 * 思路：假设有stack1 stack2 怎么用先进后出实现先进先出
 *      把 1 放进stack1  stack1 有 1 个数  stack2 null
 *      再添加一个数 2  首先把stack1 的 1 压进stack2
 *      然后 把 2压进stack1 重新把stack2 的1 压进stack1
 *      现在stack1 就是底下为2  上面为1  进栈顺序  1 2 出栈顺序也是 1 2
 *      就完成了  先进先出
 */
public class test09 {
    Stack<Integer> stack1;
    Stack<Integer> stack2;
    int size;

    public test09() {
        stack1 = new Stack<Integer>();
        stack2 = new Stack<Integer>();
        size = 0;
    }

    public void appendTail(int value) {
        while (!stack1.isEmpty()) {
            stack2.push(stack1.pop());
        }
        stack1.push(value);
        while (!stack2.isEmpty()) {
            stack1.push(stack2.pop());
        }
        size++;
    }

    public int deleteHead() {
        if (size == 0) {
            return -1;
        }
        size--;
        return stack1.pop();
    }
}

