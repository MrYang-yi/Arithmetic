package Sort;

/**
 * 本算法为选择排序  每次排序都把最小的数字放在前面
 * 思路：  1 记录需要 进行比较的数字的坐标和值 赋值给temp和index
 *        2 用记录的值去和后面的值进行比较 如果存在更小的值 立刻赋值给temp和index
 *        3 如果index最后不和i相等  交换两个数的位置
 */


public class Select {
    public static void selectSort(int a[]) {
        if(a==null) return ;
        int index;
        int temp;
        int i;
        int j;
        for (i = 0; i < a.length; i++) {
            index = i;
            temp = a[i];
            for (j = i + 1; j < a.length; j++) {
                if (temp > a[j]) {
                    index = j;
                    temp = a[j];
                }
            }
            if (index != i) {
                a[index] = a[i];
                a[i] = temp;
            }
        }

    }
    public static void main(String[] args) {
        int a[] = {3, 5, 7, 0, 2, 6, 4, 8, 9, 1};
        selectSort(a);
        for (int p : a) {
            System.out.print(p + " ");
        }
    }
}
