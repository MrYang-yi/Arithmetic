package Project.Any;

/**
 * topic: 最长回文子串
 * 给定一个字符串 s，找到 s 中最长的回文子串。你可以假设 s 的最大长度为 1000。
 * <p>
 * 输入: "babad"
 * 输出: "bab"
 * 注意: "aba" 也是一个有效答案。
 * <p>
 * 输入: "cbbd"
 * 输出: "bb"
 */
public class LongestPalindrome_05 {
    public static String longestPalindrome(String s) {
        if (s == null || s.length() < 1) return "";
        int start = 0;
        int end = 0;
        for (int i = 0; i < s.length(); i++) {
            int len1 = King(s, i, i);
            int len2 = King(s, i, i + 1);
            int len = Math.max(len1, len2);
            if (len > (end - start)) {
                start = i - (len - 1) / 2;
                end = i + len / 2;
            }

        }
        return s.substring(start, end+1);
    }

    private static int King(String s, int left, int right) {
        while (left >= 0 && right < s.length() && s.charAt(left) == s.charAt(right)) {
            left--;
            right++;
        }
        return right - left -1;
    }

    public static void main(String[] args) {
        String s1 = "babad";
        String s2 = "cbbd";
        String p1 = longestPalindrome(s1);
        String p2 = longestPalindrome(s2);
        System.out.println(p1);
        System.out.println(p2);

    }
}
