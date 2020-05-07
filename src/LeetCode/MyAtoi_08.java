package LeetCode;

/**
 * topic:字符串转化为整数
 *
 */
public class MyAtoi_08 {
    public static int myAtoi(String str) {
        if (str == null || str.length() == 0) {
            return 0;
        }
        str = str.trim();
        int i = 0;
        int flag = 1;
        int a = 0;
        int res = 0;
        int n = str.length();
        while (i < n && Character.isDigit(str.charAt(i)) || str.charAt(i) == ' '
                || str.charAt(i) == '+' || str.charAt(i) == '-') {
            if (str.charAt(i) == ' ' || str.charAt(i) == '+') {
                i++;
                continue;
            }
            if (str.charAt(i) == '-') {
                flag = -1;
                i++;
                continue;
            }
            a = str.charAt(i) - '0';
            if (res > Integer.MAX_VALUE / 10) {
                return flag > 0 ? Integer.MAX_VALUE : Integer.MIN_VALUE;
            }
            res = res * 10 + a;
            i++;
        }
        return flag > 0 ? res : -res;
    }

    public static void main(String[] args) {
        //int p1 = myAtoi("words and 987");
        //int p2 = myAtoi("4193 with words");
        //int p3 = myAtoi("-91283472332");
        //int p4 = myAtoi("3.14159");
        int p5 = myAtoi("");
        // System.out.println(p1);
        // System.out.println(p2);
        //System.out.println(p3);
        //System.out.println(p4);
        System.out.println(p5);

    }

}

