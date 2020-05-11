package LeetCode;

/**
 * topic:子串能表示从 1 到 N 数字的二进制串
 * 给定一个二进制字符串 S（一个仅由若干 '0' 和 '1' 构成的字符串）和一个正整数 N，
 * 如果对于从 1 到 N 的每个整数 X，其二进制表示都是 S 的子串，就返回 true，否则返回 false。
 * 示例 1：
 * 输入：S = "0110", N = 3
 * 输出：true
 * <p>
 * 示例 2：
 * 输入：S = "0110", N = 4
 * 输出：false
 */
public class QueryString_1016 {
    public boolean queryString(String S, int N) {
        for (int i = 1; i <= N; i++) {
            if (!S.contains(Integer.toBinaryString(i)))
//介绍Integer的一个强大方法 Integer的toBinaryString方法 参数为一个整数 可以直接转为该整数的字符串
                
                return false;
        }
        return true;
    }

    public static void main(String[] args) {
        boolean flag1 = new QueryString_1016().queryString("0110", 3);
        boolean flag2 = new QueryString_1016().queryString("0110", 4);
        System.out.println(flag1);
        System.out.println(flag2);

    }
}
