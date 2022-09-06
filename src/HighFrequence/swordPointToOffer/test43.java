package LeetCode.editor.cn.HighFrequence.swordPointToOffer;

/**
 * 剑指 Offer 43. 1～n整数中1出现的次数
 * 输入一个整数 n ，求1～n这n个整数的十进制表示中1出现的次数。
 * 例如，输入12，1～12这些整数中包含1 的数字有1、10、11和12，1一共出现了5次。
 * 示例 1：
 * 输入：n = 12
 * 输出：5
 * <p>
 * 示例 2：
 * 输入：n = 13
 * 输出：6
 * 思路1：  这里先确定一个思路： 例如
 *      1   2    3     4     5     6
 *                          hight  cur low
 *        digit=1  digit每次乘以10
 *        hight 和cur 每次左移一格
 *        low每次多占有一个数字 6，56，456
 *        cur=0  high × digit
 *        cur=1  high × digit + low + 1
 *        cur > 1  high × digit + digit
 *
 *
 *     思路2：例子如n=1234，high=1, pow=1000, last=234
 * 可以将数字范围分成两部分1~999和1000~1234
 * 1~999这个范围1的个数是f(pow-1)
 * 1000~1234这个范围1的个数需要分为两部分：
 * 千分位是1的个数：千分位为1的个数刚好就是234+1(last+1)，注意，这儿只看千分位，不看其他位
 * 其他位是1的个数：即是234中出现1的个数，为f(last)
 * 所以全部加起来是f(pow-1) + last + 1 + f(last);
 *
 * 例子如3234，high=3, pow=1000, last=234
 * 可以将数字范围分成两部分1~999，1000~1999，2000~2999和3000~3234
 * 1~999这个范围1的个数是f(pow-1)
 * 1000~1999这个范围1的个数需要分为两部分：
 * 千分位是1的个数：千分位为1的个数刚好就是pow，注意，这儿只看千分位，不看其他位
 * 其他位是1的个数：即是999中出现1的个数，为f(pow-1)
 * 2000~2999这个范围1的个数是f(pow-1)
 * 3000~3234这个范围1的个数是f(last)
 * 所以全部加起来是pow + high*f(pow-1) + f(last);
 *
 */
public class test43 {
    public int countDigitOne(int n) {
/*        int digit = 1;
        int res = 0;
        int high = n / 10;
        int cur = n % 10;
        int low = 0;
        while (high != 0 || cur != 0) {
            if (cur == 0) {
                res += high * digit;
            } else if (cur == 1) {
                res += high * digit + low + 1;
            } else {
                res += (high + 1) * digit;
            }
            low += cur * digit;
            cur = high % 10;
            high /= 10;
            digit *= 10;
        }
        return res;*/
            return f(n);
        }
        private int f(int n ) {
            if (n <= 0)
                return 0;
            String s = String.valueOf(n);
            int high = s.charAt(0) - '0';
            int pow = (int) Math.pow(10, s.length()-1);
            int last = n - high*pow;
            if (high == 1) {
                return f(pow-1) + last + 1 + f(last);
            } else {
                return pow + high*f(pow-1) + f(last);
            }

    }

    public static void main(String[] args) {
        int a = new test43().countDigitOne(13);
        System.out.println(a);
    }
}
