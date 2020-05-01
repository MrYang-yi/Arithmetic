package Array;

import java.util.HashMap;

public class Intersection3 {
    public static void  Intersection(int a[],int b[]) {
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < a.length; i++) {
            map.put(a[i], 1);
        }
        for (int j = 0; j < b.length; j++) {
            if(map.containsKey(b[j])){
                System.out.print(b[j]+" ");
            }
        }
    }
    public static void main(String[] args) {
        int a[] = {0, 1, 2, 3, 4};
        int b[] = {1, 3, 5, 7, 9};
        Intersection(a,b);
    }
}
