package Sort;

/**
 * 本算法为插入排序  对前两个排序 对前三个排序 对前四个排序
 * 思路： 1 因为从第二个数开始排序所以从i=1开始遍历
 *       2 记录下遍历值的坐标和值
 *       3 while如果前面的值比后面的值大 把更大的值赋给下一个坐标 注意循环停止的条件：>1并且前面的值 >后面的值
 *       4 此时i的值 已经是排序中最小值的坐标了  把temp赋值给这个j对应的a[j]
 */
public class insert {
    public static void insertSort(int a[]) {
        if(a==null) return ;
        for (int i = 1; i < a.length; i++) {
            int temp = a[i];
            int j = i;
            while (j >= 1 && a[j - 1] > temp) {
                a[j] = a[j - 1];
                j--;
            }
            a[j] = temp;
        }
    }
    public static void main(String[] args) {
        int a[] = {3, 5, 7, 0, 2, 6, 4, 8, 9, 1};
        insertSort(a);
        for (int p : a) {
            System.out.print(p + " ");
        }
    }

}
