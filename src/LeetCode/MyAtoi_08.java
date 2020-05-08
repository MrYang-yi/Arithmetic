package LeetCode;

import sun.misc.Cleaner;

/**
 * topic:字符串转化为整数
 */
public class MyAtoi_08 {
    public static int myAtoi(String str) {
        String s = str.trim();
        if (s == null || str == "") {
            return 0;
        }
        int flag = 1;
        int i = 0;
        if (s.charAt(i) == '+') {
            i++;
        } else if (s.charAt(i) == '-') {
            flag = -1;
            i++;
        }
        long result = 0;
        while (i < s.length() && Character.isDigit(s.charAt(i))) {
            result = result * 10 + (s.charAt(i) - '0');
            if (result * flag > Integer.MAX_VALUE) {
                return Integer.MAX_VALUE;
            } else {
                if (result * flag < Integer.MIN_VALUE) {
                    return Integer.MIN_VALUE;
                }
            }
            i++;
        }
        return (int) result * flag;
    }

    public static void main(String[] args) {
        //int p1 = myAtoi("words and 987");
        //int p2 = myAtoi("4193 with words");
        //int p3 = myAtoi("-91283472332");
        //int p4 = myAtoi("3.14159");
        int p5 = myAtoi("");
        //System.out.println(p1);
        //System.out.println(p2);
        //System.out.println(p3);
        //System.out.println(p4);
        System.out.println(p5);

    }

}

