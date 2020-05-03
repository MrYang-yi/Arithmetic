package Array;

/**
 * 算法：如何求解三元组距离最小
 * 思路：靠自己领悟 哈哈哈
 */
public class TripleDistance2 {
    public static int TripleDistance(int a[],int b[],int c[]){
         int i=0;   //i的初始下标
         int j=0;   //j的初始下标
         int k=0;   //k的初始下标
         int minDistance=Integer.MAX_VALUE; //最小距离
         int min=0; //记录三个数中的最小值
         while (true){
              minDistance=Maxnum(Math.abs(a[i]-b[j]),Math.abs(a[i]-c[k]),Math.abs(b[j]-c[k]));
                 min=Minnum(a[i],b[j],c[k]);
                 if(min==a[i]){
                     if(++i>=a.length)
                         break;
                 }else if(min==b[j]){
                     if(++j>=b.length)
                         break;
                 }else{
                     if(++k>=c.length)
                         break;
                 }
         }
     return minDistance;
    }
    public static int Maxnum(int a, int b, int c) {
        int max = a > b ? a : b;
        max = max > c ? max : c;
        return max;
    }
    public static int Minnum(int a, int b, int c) {
        int min = a > b ? b : a;
        min = min > c ? c : min;
        return min;
    }
    public static void main(String[] args) {
        int a[] = {3,4,5,7};
        int b[] = {10, 12, 14, 16, 17};
        int c[] = {20, 21, 23, 24, 37, 30};
        int p = TripleDistance(a, b, c);
        System.out.println(p);
    }
}
