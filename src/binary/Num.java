package binary;

/**
 *  算法：计算一个数的二进制中1的个数
 *  思路：一个数与它本身减一 做 与 运算 最右边的1就会变成0
 */
public class Num {
    public static int binary(int n){
        int count=0;
        while(n>0){
            n=n&(n-1);
            count++;
        }
        return  count;

    }

    public static void main(String[] args) {
        int a=  binary(6);
        int b=  binary(8);
        System.out.println(a);
        System.out.println(b);
    }

}
