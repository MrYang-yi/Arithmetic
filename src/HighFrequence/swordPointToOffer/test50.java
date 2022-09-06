package LeetCode.editor.cn.HighFrequence.swordPointToOffer;

import java.util.LinkedHashMap;
import java.util.Map;

/**
 * 剑指 Offer 50. 第一个只出现一次的字符
 * 在字符串 s 中找出第一个只出现一次的字符。如果没有，返回一个单空格。 s 只包含小写字母。
 * 示例:
 * s = "abaccdeff"
 * 返回 "b"
 *
 * s = ""
 * 返回 " "
 *
 * 这里可以用bool值来放进map 形式map.put(s.charAt(i),!map.containsKey(s.charAt(i)))
 */
public class test50 {
    public char firstUniqChar(String s) {
        LinkedHashMap<Character,Integer> map=new LinkedHashMap<>();
        for (int i = 0; i < s.length(); i++) {
            if(map.containsKey(s.charAt(i))){
                map.put(s.charAt(i),map.get(s.charAt(i))+1);
            }else{
                map.put(s.charAt(i),1);
            }
        }
        for(Map.Entry<Character,Integer> linkedhashMap:map.entrySet()){
            if(linkedhashMap.getValue() == 1) return linkedhashMap.getKey();
        }
        return ' ';
    }

    public static void main(String[] args) {
        char a = new test50().firstUniqChar("abaccdeff");
        System.out.println(a);

    }
}
