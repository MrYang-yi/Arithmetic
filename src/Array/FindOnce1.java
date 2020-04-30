package Array;

/**
 * 算法 ：用递归求出整数数组最大元素
 */
public class FindOnce1 {
   public static int  FindMax(int a[]){
       int  max=a[0];
       for (int i = 1; i < a.length; i++) {
           max=Math.max(max,a[i]);
       }
       return max;

   }
    public static void main(String[] args) {
           int a[]={0,16,2,3,4,5,10,7,8,9};
           int p= FindMax(a);
           System.out.println(p);
    }
}
