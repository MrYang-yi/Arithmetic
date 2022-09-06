package Project.Sort;

/**
 * 本算法为冒泡排序
 */
public class bubbling {

    public static void bubblingSort(int a[]) {
        if (a == null) return;
        for (int i = 0; i < a.length; i++) {
            for (int j = i + 1; j < a.length; j++) {
                if (a[i] > a[j]) {
                    int temp = a[i];
                    a[i] = a[j];
                    a[j] = temp;
                }
            }
        }

    }

    public static void main(String[] args) {
        int a[] = {3, 5, 7, 0, 2, 6, 4, 8, 9, 1};
        bubblingSort(a);
        for (int p : a) {
            System.out.print(p + " ");
        }
    }
}
