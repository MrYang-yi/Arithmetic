package Project.Array;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

/**
 * 接上文
 * 顺序遍历法计算两个有序数组的交集
 *
 */
public class Intersection2 {
    public static void  Intersection(int a[],int b[]){
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < a.length; i++) {
            map.put(a[i],1);
        }
        for (int j = 0; j < b.length; j++) {
            if(map.containsKey(b[j])){
                map.put(b[j],map.get(b[j])+1);
            }else{
                map.put(b[j],1);
            }
        }

            Iterator iterator= map.entrySet().iterator();
            while(iterator.hasNext()){
                Map.Entry entry=(Map.Entry)iterator.next();
                int key=(int)entry.getKey();
                int value=(int)entry.getValue();
                if(map.get(key)==2){
                    System.out.print(key+" ");
                }
            }

    }
    public static void main(String[] args) {
        int a[] = {0, 1, 2, 3, 4};
        int b[] = {1, 3, 5, 7, 9};
        Intersection(a, b);
    }
}
