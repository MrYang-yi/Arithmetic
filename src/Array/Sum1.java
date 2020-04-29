package Array;
/**
 * 算法：接上文：利用HashMap 求出数组两两相加等于20的组合种数
 *
 */

import java.util.HashMap;

public class Sum1 {
    public static void findSum(int a[], int k) {
        HashMap<Integer, Integer> map = new HashMap<>();
        int i;
        for (i = 0; i < a.length; i++) {
            if (map.containsKey(k - a[i])) {
                System.out.println(a[i] + " " + map.get(k - a[i]));
            } else {
                map.put(a[i], a[i]);
            }
        }
    }
    public static void main(String[] args) {
        int a[] = {1, 7, 17, 2, 6, 3, 14};
        findSum(a, 20);
    }
}
