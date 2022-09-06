package Project.Any;

import java.util.ArrayList;
import java.util.List;

/**
 * topic:Z 字形变换
 * 将一个给定字符串根据给定的行数，以从上往下、从左到右进行 Z 字形排列。
 * 比如输入字符串为 "LEETCODEISHIRING" 行数为 3 时，排列如下
 * L   C   I   R
 * E T O E S I I G
 * E   D   H   N
 * 输出 LCIRETOESIIGEDHN
 * <p>
 * 输入: s = "LEETCODEISHIRING", numRows = 4
 * 输出: "LDREOEIIECIHNTSG"
 * 解释:
 * L     D     R
 * E   O E   I I
 * E C   I H   N
 * T     S     G
 */
public class Convert_06 {
    public static String convert(String s, int numRows) {
        if (numRows == 1 || numRows >= s.length()) return s;
        List<StringBuilder> rows = new ArrayList<StringBuilder>();
        for (int i = 0; i < numRows; i++)
            rows.add(new StringBuilder());  //初始化
        int i = 0;
        int flag = -1;
        for (char c : s.toCharArray()) {
            rows.get(i).append(c);
            if (i == 0 || i == numRows - 1) {
                flag = -flag;//当在第一行或者最后一行开始换行
            }
            i += flag;
        }
        StringBuilder res = new StringBuilder();
        for (StringBuilder row : rows) res.append(row);
        return res.toString();

    }


    public static void main(String[] args) {
        String s = "LEETCODEISHIRING";
        int numRows = 4;
        String p = convert(s, numRows);
        System.out.println(p);
    }
}
