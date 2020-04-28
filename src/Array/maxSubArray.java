package Array;

/**
 * 算法：找出子数组（连续的n个数组成）的和的最大值
 * 思路：每个数字都有作为子数组开头的可能 但是负数不可能作为子数组的开头
 *      这种方法属于暴力解法中较快的  接下来还会提供优化过的动态规划解决此问
 */
public class maxSubArray {
    public static  int maxSubArray(int a[]){
        int Maxsum=Integer.MIN_VALUE;
        for (int i = 0; i < a.length; i++) {
            if(a[i]<0){
                continue;
            }else{
                int sum=0;
                for(int j=i;j<a.length;j++){
                    sum+=a[j];
                    if(Maxsum<sum){
                        Maxsum=sum;
                    }
                }
           }
        }
        return Maxsum;
    }
    public static void main(String[] args) {
        int a[]={-1,4,-3,6,-7,4,8,15,-7,6};
        int sum=maxSubArray(a);
        System.out.println(sum);

    }
}
