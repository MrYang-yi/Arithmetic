package Array;

/**
 *
 * 算法 :如何找出数组第二大的数
 */
public class SecondMax {
    public  static int SecondMax(int a[]){
        int max=a[0];
        int second=Integer.MIN_VALUE;
        for (int i = 0; i<a.length; i++) {
            if(a[i]>max){
                second=max;
                max=a[i];
            }else if(a[i]<max){
                if(a[i]>second){
                    second=a[i];
                }
            }
        }
        return second;
    }

    public static void main(String[] args) {
        int a[]={1,34,6,57,9,-3,35,89,4};
        int p=SecondMax(a);
        System.out.println(p);
    }
}
