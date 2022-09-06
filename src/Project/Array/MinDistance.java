package Project.Array;

/**
 * 算法：如何求出数组中两个元素的最小值  例如{1，2，3，4} 1和4的距离为2
 *
 */

public class MinDistance {
    public static int MinDistance(int a[],int n1,int n2){
        if (a==null){
            return Integer.MIN_VALUE;
        }
        int n1_index=-1;
        int n2_index=-1;
        int min_distance=Integer.MIN_VALUE;
        for (int i = 0; i < a.length; i++) {
            if(a[i]==n1){
                n1_index=i;
            }else if(a[i]==n2){
                n2_index=i;
            }
            if(n1_index>=0&&n2_index>=0){
                min_distance=Math.abs(n2_index-n1_index)-1;
            }
            if(min_distance>0){
                min_distance=Math.min(Math.abs(n2_index-n1_index)-1,min_distance);
            }
        }
     return min_distance;
    }
    public static void main(String[] args) {
        int a[]={4,5,6,4,7,4,6,4,7,8,5,6,4,3,10,8};
        System.out.println(MinDistance(a,4,8));
    }
}
