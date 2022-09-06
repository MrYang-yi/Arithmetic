package Project.binary;

/**
 *  算法：判断一个数是否为2的n次方
 *  思路：如果一个数是2的n次方 二进制里只有1个1
 */
public class judge {
    public static boolean judge(int n){
        int m=n&(n-1);
        return m==0;
    }

    public static void main(String[] args) {
        boolean a=judge(6);
        boolean b=judge(8);
        System.out.println(a);
        System.out.println(b);

    }
}
