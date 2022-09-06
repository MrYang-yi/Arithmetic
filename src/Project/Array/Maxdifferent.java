package Project.Array;

/**
 * 算法：求数对之差的最大值（通俗说 就是数组中左边的数减去右边的数的最大值）
 *      1 暴力求解 2 动态规划
 *
 */
public class Maxdifferent {
    public static void Maxdifferent(int a[]) {
        if (a == null || a.length <= 1) return;
        int max = 0;
        for (int i = 0; i < a.length; i++) {
            for (int j = i + 1; j < a.length; j++) {
                if (a[i] - a[j] > max) {
                    max = a[i] - a[j];
                }
            }
        }
        System.out.println(max);
    }

    public static void main(String[] args) {
        int a[] = {1, 4, 17, 3, 2, 9};
        Maxdifferent(a);
    }
}
