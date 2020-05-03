package String;

/**
 * 算法：如何输出字符串的所有组合
 *
 */
public class CombineRecursive {
    public static void CombineRecursive(char []c,int begin,int len,StringBuffer sb){
        if(len==0){
            System.out.print(sb+" ");
            return ;
        }
        if(begin==c.length) {
            return;
        }
        sb.append(c[begin]);
        CombineRecursive(c,begin+1,len-1,sb);
        sb.deleteCharAt(sb.length()-1);
        CombineRecursive(c,begin+1,len,sb);
    }
    public static void main(String[] args) {
        String s="abc";
        char c[]=s.toCharArray();
        StringBuffer  sb=new StringBuffer("");
        for (int i = 1; i <= c.length; i++) {  //取1个字符 2个字符 3个........
            CombineRecursive(c,0,i,sb);
        }
    }
}
