package HighFrequence.Hot100.leetcode.editor.cn;

import java.util.HashMap;
import java.util.Map;

/**
 * 滑动窗口
 */
//最小覆盖子串
public class lc76_MinimumWindowSubstring {
    Map<Character, Integer> tmap = new HashMap<>();
    Map<Character, Integer> smap = new HashMap<>();

    public String minWindow(String s, String t) {
        for (char ch : t.toCharArray()) {
            tmap.put(ch, tmap.getOrDefault(ch, 0) + 1);
        }
        int l = 0;
        int r = -1;
        int len = Integer.MAX_VALUE;
        int ansL = -1;
        int ansR = -1;
        while (r < s.length()) {
            if (++r < s.length() && tmap.containsKey(s.charAt(r))) {
                smap.put(s.charAt(r), smap.getOrDefault(s.charAt(r), 0) + 1);
            }
            while (check() && l <= r) {
                if (r - l + 1 < len) {
                    len = r - l + 1;
                    ansL = l;
                    ansR = l + len;
                }
                if (tmap.containsKey(s.charAt(l))) {
                    smap.put(s.charAt(l), smap.getOrDefault(s.charAt(l), 0) - 1);
                }
                ++l;
            }
        }
        return ansL == -1 ? "" : s.substring(ansL, ansR);
    }

    //检查 如果相同的key，smap的value比tmap的value小，return false,说明大的字符串少东西了
    public boolean check() {
        for (Map.Entry<Character, Integer> entry : tmap.entrySet()) {
            Character key = entry.getKey();
            Integer value = entry.getValue();
            if (smap.getOrDefault(key, 0) < value) {
                return false;
            }
        }
        return true;
    }
}