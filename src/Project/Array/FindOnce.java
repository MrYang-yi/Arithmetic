package Project.Array;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

/**
 * 算法：找出数组中重复次数最多的数
 *   利用HashMap可以求出 数组中重复最多次数 最少次数 重复了多少次 唯一重复的数等等问题
 *
 */
public class FindOnce {
    public static void FindOnce(int a[]) {
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < a.length; i++) {
            if (map.containsKey(a[i])) {
                map.put(a[i], map.get(a[i]) + 1);
            } else {
                map.put(a[i], 1);
            }
        }
        int maxValue=0;
        int maxKey=0;
        Iterator iterator = map.entrySet().iterator();
        while (iterator.hasNext()) {
            Map.Entry entry = (Map.Entry) iterator.next();
            int key = (int) entry.getKey();
            int value = (int) entry.getValue();
            /*if (map.get(key) == 3) {
                System.out.println(key);
            }*/
            if(value>maxValue){
                maxValue=value;
                maxKey=key;
            }
        }
        System.out.println(maxKey);

    }

    public static void main(String[] args) {
        int a[] = {1, 2, 3, 2, 4, 3, 5, 4, 1,6,6,6,6};
        FindOnce(a);

    }
}
