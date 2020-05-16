package LeetCode;

/**
 * topic:最长公共前缀
 * 编写一个函数来查找字符串数组中的最长公共前缀。
 * 如果不存在公共前缀，返回空字符串 ""。
 * <p>
 * 输入: ["flower","flow","flight"]
 * 输出: "fl"
 * <p>
 * 输入: ["dog","racecar","car"]
 * 输出: ""
 * 解释: 输入不存在公共前缀。
 *
 *  思路：理解一个api  str.indexOf(string s)  s是否包含在str中会返回一个数 如果为0 则不包含
 *        抽取prefix=strs[0]作为公共比对部分  第一个和第二个比 找到相同部分prefix
 *        再用prefix和第三个 第四个比 每次都返回prefix
 *
 **/
public class LongestCommonPrefix_14 {
    public String longestCommonPrefix(String[] strs) {
        if (strs.length == 0) return "";
        String prefix = strs[0];
        for (int i = 1; i < strs.length; i++)
            while (strs[i].indexOf(prefix) != 0) {
                prefix = prefix.substring(0, prefix.length() - 1);
                if (prefix.isEmpty()) return "";
            }
        return prefix;
    }

    public static void main(String[] args) {
        String[] a = {"flower", "flow", "flight"};
        String[] b = {"dog", "racecar", "car"};
        String c = new LongestCommonPrefix_14().longestCommonPrefix(a);
        String d = new LongestCommonPrefix_14().longestCommonPrefix(b);
         System.out.println(c);
         System.out.println(d);
    }
}
