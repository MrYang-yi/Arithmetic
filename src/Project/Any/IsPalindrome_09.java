package Project.Any;

/**
 * 9. topic:回文数
 * 判断一个整数是否是回文数。回文数是指正序（从左向右）和倒序（从右向左）读都是一样的整数。
 * <p>
 * 示例 1:
 * 输入: 121
 * 输出: true
 * <p>
 * 示例 2:
 * 输入: -121
 * 输出: false
 * 解释: 从左向右读, 为 -121 。 从右向左读, 为 121- 。因此它不是一个回文数。
 * <p>
 * 示例 3:
 * 输入: 10
 * 输出: false
 * 解释: 从右向左读, 为 01 。因此它不是一个回文数。
 */
public class IsPalindrome_09 {
    public boolean isPalindrome(int x) {
        String s = "" + x;
        int n = s.length();
        int i;
        int j;
        if (n % 2 != 0) {
            i = n / 2;
            j = n / 2;
            while (i >= 0) {
                if (s.charAt(i) != s.charAt(j)) {
                    return false;
                }
                i--;
                j++;
            }
        } else {
            i = n / 2 - 1;
            j = n / 2;
            while (i >= 0) {
                if (s.charAt(i) != s.charAt(j)) {
                    return false;
                }
                i--;
                j++;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        boolean flag1 = new IsPalindrome_09().isPalindrome(121);
        boolean flag2 = new IsPalindrome_09().isPalindrome(-121);
        boolean flag3 = new IsPalindrome_09().isPalindrome(10);
        System.out.println(flag1);
        System.out.println(flag2);
        System.out.println(flag3);
    }
}
