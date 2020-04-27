package binary;

import java.util.Scanner;

/**
 *  算法：输入两个整数 m n 计算需要改变m的二进制表示中的多少位才能得到n
 *       例如 10的二进制为 1010 13的二进制为1101 需要改变3位数字才能从10变为13
 *  思路：求两个数的 异或运算  统计其结果中的1的个数
 *      异或运算的特点：如果两个数不相同 结果为1  所以只要计算1的个数就知道有多少位不同
 *
 */
public class transfer {
     public  static int num(int m,int n){
         int c=m^n;
         int count=0;//
         while(c>0){
             c=c&(c-1);
             count++;
         }
         return count;
     }

    public static void main(String[] args) {
         Scanner sc=new Scanner(System.in);
         int m=sc.nextInt();
         int n=sc.nextInt();
         int p=num(m,n);
        System.out.println(p);

    }
}
