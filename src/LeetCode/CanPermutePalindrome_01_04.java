package LeetCode;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

/**
 * topic:面试题 01.04. 回文排列
 * <p>
 * 给定一个字符串，编写一个函数判定其是否为某个回文串的排列之一。
 * 回文串是指正反两个方向都一样的单词或短语。排列是指字母的重新排列。
 * 回文串不一定是字典当中的单词。
 */
public class CanPermutePalindrome_01_04 {
    public boolean canPermutePalindrome(String s) {
        if (s == null || s.length() == 1) return true;
        HashMap<Character, Integer> map = new HashMap<>();
        for (int i = 0; i < s.length(); i++) {
            if (map.containsKey(s.charAt(i))) {
                map.put(s.charAt(i), map.get(s.charAt(i)) + 1);
            }else{
                map.put(s.charAt(i), 1);
            }
        }
        Iterator iterator = map.entrySet().iterator();
        int count = 0;
        while (iterator.hasNext()) {
            Map.Entry entry = (Map.Entry) iterator.next();
            char key = (char) entry.getKey();
            Integer value = (Integer) entry.getValue();
            if (value % 2 != 0) {
                count++;
            }
        }
        return count > 1 ? false : true;
    }

    public static void main(String[] args) {
        boolean flag = new CanPermutePalindrome_01_04().canPermutePalindrome("tactcoa");
        System.out.println(flag);
    }
}
