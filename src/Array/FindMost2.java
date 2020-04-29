package Array;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

/**
 * 接上一题 找出数组元素重复最多的数
 * 引入Map映射表
 */
public class FindMost2 {
    public static int findMostFrequence(int a[]) {
        Map<Integer, Integer> map = new HashMap<Integer, Integer>();
        for (int i = 0; i < a.length; i++) {
            if (map.containsKey(a[i])) {
                map.put(a[i], map.get(a[i]) + 1);
            } else {
                map.put(a[i], 1);
            }
        }
        int maxValue = 0;
        int maxIndex = 0;
        Iterator iterator = map.entrySet().iterator();
        while (iterator.hasNext()) {
            Map.Entry entry = (Map.Entry) iterator.next();
            int key = (int) entry.getKey();
            int value = (int) entry.getValue();
            if (value > maxValue) {
                maxIndex = key;
                maxValue = value;
            }
        }
        return maxIndex;
    }

    public static void main(String[] args) {
        int a[] = {1, 5, 4, 3, 4, 4, 5, 4, 5, 5, 6, 6, 6, 6, 6,7,7,7,7,7,7,7,7,7,7,7};
        int p = findMostFrequence(a);
        System.out.println(p);
    }
}
