package String;

/**
 * 算法：描述两个字符串是否由相同的字符组成（字母以及各个字母的数字是一样的）
 *  思路： 转为数组排序比较
 */

import java.util.Arrays;

public class Compare {
    public static void  Compare(String s1,String s2){
          char  c1[]=s1.toCharArray();
          char  c2[]=s2.toCharArray();
          Arrays.sort(c1);
          Arrays.sort(c2);
          s1=new String(c1);
          s2=new String(c2);
          if(s1.equals(s2)){
              System.out.println("equal");
          }else {
              System.out.println("not equal");
          }
    }
    public static void main(String[] args) {
        String s1="aaaabbc";
        String s2="abcbaaa";
        Compare(s1,s2);
        s2="abcbaab";
        Compare(s1,s2);
        String s="asdDAFsf";
    }
}
