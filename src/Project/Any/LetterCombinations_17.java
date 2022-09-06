package Project.Any;


import java.util.*;

/**
 * 电话号码的字母组合
 * <p>
 * 给定一个仅包含数字 2-9 的字符串，返回所有它能表示的字母组合。
 * 给出数字到字母的映射如下（与电话按键相同）。注意 1 不对应任何字母。
 * 输入："23"
 * 输出：["ad", "ae", "af", "bd", "be", "bf", "cd", "ce", "cf"].
 */
public class LetterCombinations_17 {
    String[] s = {" ", "*", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz"};
    List<String> list = new ArrayList<>();

    public List<String> letterCombinations(String digits) {
        if (digits == null || digits.length() == 0) {
            return new ArrayList<>();
        }
        cycle(digits, "", 0);
        return list;
    }

    public void cycle(String str, String letter, int index) {
        if (index == str.length()) {
            list.add(letter);
            return;
        }
        char c = str.charAt(index);
        int a = c - '0';
        String t = s[a];
        for (int i = 0; i < t.length(); i++) {
            cycle(str, letter + t.charAt(i), index + 1);
        }
    }


    public static void main(String[] args) {
        List<String> list = new LetterCombinations_17().letterCombinations("23");
        System.out.println(list);
    }
}
