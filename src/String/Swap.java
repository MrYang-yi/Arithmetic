package String;

/**
 * 算法：实现字符串的反转（变形） 例如 how are you 变为 you are how
 * 思路：1 首先进行字符串的整体反转
 *      2 转为字符型数组 str.tocharArray（）
 *      3 for循环遍历 当遇到空格字符 进行反转（特别注意：最后一个单词后面没有空格字符，所以不会反转）
 */
public class Swap {
    public static void  swap(char[] ch,int start,int end){
          while(start<end){
              char a=ch[end];
              ch[end]=ch[start];
              ch[start]=a;
              start++;
              end--;
          }
    }
    public static String swapWords(String str){
        char c[]=str.toCharArray();
        swap(c,0,c.length-1);
        int start=0;
        for (int i = 0; i < c.length; i++) {
            if(c[i]==' '){
                swap(c,start,i-1);
                start=i+1;
            }
        }
        swap(c,start,c.length-1);
        return new String(c);
    }
    public static void main(String[] args) {
        String str="how are you";
        System.out.println(new Swap().swapWords(str));
    }
}
