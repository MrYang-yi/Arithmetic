package Project.Array;


import java.util.ArrayList;
import java.util.List;

/**
 * 算法：如何计算两个有序数组的交集
 * 思路： 1 二路归并法 如下所示
 *       2 顺序遍历法 顺序遍历两个数组，放入哈希表中，对元素进行计数 若为2 则为交集
 *       3 散列法 遍历其中一个数组 然后放入散列表中，然后遍历另一个数组，同时对建立的散列表查询 若存在则为交集
 *       接下来会演示第二和第三种思路（这两种思路 大同小异 主要还是引用HashMap）
 */

public class Intersection {
    public static List<Integer> Intersection(int a[], int b[]) {
        List<Integer> list = new ArrayList<Integer>();
        int i = 0;
        int j = 0;
        while (i < a.length && j < b.length) {
            if (a[i] == b[j]) {
                list.add(a[i]);
                i++;
                j++;
            } else if (a[i] > b[j]) {
                j++;
            } else if (a[i] < b[j]) {
                i++;
            }
        }
        return list;
    }

    public static void main(String[] args) {
        int a[] = {0, 1, 2, 3, 4};
        int b[] = {1, 3, 5, 7, 9};
        List<Integer> list = Intersection(a, b);
        for (int p : list) {
            System.out.print(p + " ");
        }
    }
}
