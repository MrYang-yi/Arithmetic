package Project.Any;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * 给定一个字符串 s 和一些长度相同的单词 words。找出 s 中恰好可以由 words 中所有单词串联形成的子串的起始位置。
 * 注意子串要与 words 中的单词完全匹配，中间不能有其他字符，但不需要考虑 words 中单词串联的顺序。
 
 * 示例 1：
 * 输入：
 * s = "barfoothefoobarman",
 * words = ["foo","bar"]
 * 输出：[0,9]
 * 解释：
 * 从索引 0 和 9 开始的子串分别是 "barfoo" 和 "foobar" 。
 * 输出的顺序不重要, [9,0] 也是有效答案。
 * 
 * 示例 2：
 * 输入：
 * s = "wordgoodgoodgoodbestword",
 * words = ["word","good","best","word"]
 * 输出：[]
 *
 *
 * 思路：总体上就是把words和s放进HashMap 然后用map.equals进行比较 如果相等 则可以把i加入list 细节如下
 *       1 计算出words中一个单词的长度 还有words单词的总长度
 *       2  把words的每个单词都放进HashMap，默认值只要保证两个map的取值相同就可以
 *       3 用一个for循环遍历 i 从0-12  截取和words总长度相等的字符串
 *       4 再对字符串进行一个遍历 截取每一个单词 注意此时的步长 应该是一个单词的长度
 *       5 把单词放进HashMap 保证放入的规则和上述相同即可
 *       6 最后比较两个map是否相等 如果两个map相等，就把i添加进list中
 */
public class FindSubstring_30<main> {
    public List<Integer> findSubstring(String s, String[] words) {
        List<Integer> list = new ArrayList<>();
        if (s == null || s.length() == 0 || words == null || words.length == 0) return list;

        int one_word = words[0].length();
        int word_num = words.length;
        int all_len = one_word * word_num;

        HashMap<String, Integer> map = new HashMap<>();
        for (String word : words) {
            map.put(word, map.getOrDefault(word, 0) + 1);
        }

        for (int i = 0; i < s.length() - all_len + 1; i++) {
            String tmp = s.substring(i, i + all_len);

            HashMap<String, Integer> map2 = new HashMap<>();
            for (int j = 0; j < all_len; j += one_word) {
                String w = tmp.substring(j, j + one_word);
                map2.put(w, map2.getOrDefault(w, 0) + 1);
            }

            if (map.equals(map2)) list.add(i);
        }
        return list;
    }

    public static void main(String[] args) {
        List list = new FindSubstring_30().findSubstring("barfoothefoobarman", new String[]{"foo", "bar"});
        System.out.println(list);

    }
}
