package Project.Array;

/**
 * 算法： 动态规划求解  数对之差的最大值
 */
public class Maxdifferent2 {
    public static void  Maxdifferent(int a[]){
         if(a==null||a.length<=1) return ;
         int Maxdiffer=0;
         int max=0;
         for (int i = 0; i <a.length ; i++) {
             max=Math.max(max,a[i]);
             Maxdiffer=Math.max(Maxdiffer,max-a[i]);
        }
        System.out.println(Maxdiffer);
    }
    public static void main(String[] args) {
        int a[] = {1, 4, 17, 3, 2, 9};
        Maxdifferent(a);
    }
}
