package LeetCode.editor.cn.HighFrequence.swordPointToOffer;

import java.util.Stack;

/**
 * 面试题31. 栈的压入、弹出序列
 * 输入两个整数序列，第一个序列表示栈的压入顺序，请判断第二个序列是否为该栈的弹出顺序。
 * 假设压入栈的所有数字均不相等。例如，序列 {1,2,3,4,5} 是某栈的压栈序列，序列 {4,5,3,2,1}
 * 是该压栈序列对应的一个弹出序列，但 {4,3,5,1,2} 就不可能是该压栈序列的弹出序列。
 * 示例 1：
 * 输入：pushed = [1,2,3,4,5], popped = [4,5,3,2,1]
 * 输出：true
 * 解释：我们可以按以下顺序执行：
 * push(1), push(2), push(3), push(4), pop() -> 4,
 * push(5), pop() -> 5, pop() -> 3, pop() -> 2, pop() -> 1
 * <p>
 * 示例 2：
 * 输入：pushed = [1,2,3,4,5], popped = [4,3,5,1,2]
 * 输出：false
 * 解释：1 不能在 2 之前弹出。
 *
 */
public class test31 {
    public boolean validateStackSequences(int[] pushed, int[] popped) {
        Stack<Integer> A = new Stack<>();
        int j = 0;
        for (int i = 0; i < pushed.length; i++) {
            A.push(pushed[i]);
            while (j < pushed.length && !A.isEmpty() && (A.peek() == popped[j])) {
                j++;
                A.pop();
            }
        }
        return A.isEmpty();
    }

    public static void main(String[] args) {
        boolean flag = new test31().validateStackSequences(new int[]{1, 0}, new int[]{1, 0});
        System.out.println(flag);
    }
}
