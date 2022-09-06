package Project.Array;

/**
 * 算法：如何找出数组中重复元素最多的数 1 空间换时间的解法：比较耗内存 2利用Map映射表
 *   下面演示空间换时间解法 此方法不推荐
 *    下一题引入Map映射表（推荐）
 */
public class FindMost {
    public static int findMostFrequence(int a[]) {
        int n=a.length;
        int max=0;
        int index=0;
        int count[]=new int[n];
        for (int i = 0; i < count.length; i++) {
            count[a[i]]++;
        }
        int i=0;
        for ( i = 0; i < count.length; i++) {
            if(count[i]>max){
                index=i;
                max=count[i];
            }
        }

        return index;
    }

    public static void main(String[] args) {
        int a[] = {1, 5, 4, 3, 4, 4, 5, 4, 5, 5, 6, 6, 6, 6, 6};
        int p = findMostFrequence(a);
        System.out.println(p);
    }

}
