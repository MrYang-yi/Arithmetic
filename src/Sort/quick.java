package Sort;

/**
 * 本算法为快速排序
 * 思路： 1先定义一个基数 即a[0]
 *       2 从左边开始找 比base大的数 从右边找比base小的
 *       3 找到这两个数 互换值（）  直到循环结束
 *       4 基数和最左边的a[left] 互换
 *       5 对左右两个分支再进行递归快速排序 重复执行上述过程
 *
 */
public class quick {
    public static void quickSort(int a[], int left, int right) {
        if (left > right||a==null) {
            return;
        }
              // base中存放基准数
        int base = a[left];
        int i = left, j = right;
        while (i != j) {
            // 顺序很重要，先从右边开始往左找，直到找到比base值小的数
            while (a[j] >= base && i < j) {
                j--;
            }
            // 再从左往右边找，直到找到比base值大的数
            while (a[i] <= base && i < j) {
                i++;
            }
            // 上面的循环结束表示找到了位置或者(i>=j)了，交换两个数在数组中的位置
            if (i < j) {
                int tmp = a[i];
                a[i] = a[j];
                a[j] = tmp;
            }
        }

        // 将基准数放到中间的位置（基准数归位）
        a[left] = a[i];
        a[i] = base;


        // 递归，继续向基准的左右两边执行和上面同样的操作
        // i的索引处为上面已确定好的基准值的位置，无需再处理
        quickSort(a, left, i - 1);
        quickSort(a, i + 1, right);
    }

    public static void main(String[] args) {
        int a[] = {3, 5, 7, 0, 2, 6, 4, 8, 9, 1, 10};
        quickSort(a, 0, a.length - 1);
        for (int p : a) {
            System.out.print(p + " ");
        }
    }


}
