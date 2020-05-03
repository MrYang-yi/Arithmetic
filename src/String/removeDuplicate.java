package String;
/**
 * 算法：刪除重复的字符
 *
 */

import java.util.ArrayList;
import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.List;
public class removeDuplicate {
    public static void removeDuplicate(String str) {
        HashSet<Character> set = new HashSet<Character>();
        for (int i = 0; i < str.length(); i++) {
            set.add(str.charAt(i));
        }
        for (Character s : set) {
            System.out.print(new StringBuilder(String.valueOf(s)).append("").toString());
            // System.out.print(s+""); 少用加号 字符串拼接的底层就是利用Stringbuilder的append方法
        }
    }
    public static void main(String[] args) {
        String str = "abcaabcdfssc";
        removeDuplicate(str);
    }
}
