package Project.Any;

import java.util.HashMap;

/**
 * topic； 罗马数字转整数
 * 和12题相似
 * <p>
 * 输入: "LVIII"
 * 输出: 58
 * 解释: L = 50, V= 5, III = 3.
 * <p>
 * 示例 5:
 * 输入: "MCMXCIV"
 * 输出: 1994
 * 解释: M = 1000, CM = 900, XC = 90, IV = 4.
 */
public class RomanToInt_13 {
    public int romanToInt(String s) {
        HashMap<String, Integer> map = new HashMap<>();
        map.put("I", 1);
        map.put("IV", 4);
        map.put("IX", 9);
        map.put("V", 5);
        map.put("X", 10);
        map.put("XL", 40);
        map.put("XC", 90);
        map.put("L", 50);
        map.put("C", 100);
        map.put("CD", 400);
        map.put("CM", 900);
        map.put("D", 500);
        map.put("M", 1000);

        int r = 0;
        String two = "";
        String one = "";
        for (int i = 0; i < s.length(); i++) {

            if (i + 2 > s.length()) {
                two = s.substring(i);
            } else {
                two = s.substring(i, i + 2);
            }

            one = s.substring(i, i + 1);
            if (map.containsKey(two)) {
                r += map.get(two);
                i += 1;
            } else {
                r += map.get(one);
            }

        }
        return r;
    }

    public static void main(String[] args) {
        int p = new RomanToInt_13().romanToInt("MCMXCIV");
        System.out.println(p);
    }
}
