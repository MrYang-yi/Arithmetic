package Project.Array;

/**
 算法：如何求解三元组距离最小（已知3个升序数组a[l] b[m] c[n],三元组距离为Distance=max（|a[i]-b[j]|,|a[i]-c[k]|,|b[j]-c[k]|）)
 *   1 暴力求解（如下）
 *   2 最小距离法 见下文
 */
public class TripleDistance {
    public static int TripleDistance(int a[], int b[], int c[]) {
        int minTripleDistance = Maxnum(Math.abs(a[0] - b[0]), Math.abs(a[0] - c[0]), Math.abs(b[0] - c[0]));
        for (int i = 0; i < a.length; i++) {
            for (int j = 0; j < b.length; j++) {
                for (int k = 0; k < c.length; k++) {
                    int Distance = Maxnum(Math.abs(a[i] - b[j]), Math.abs(a[i] - c[k]), Math.abs(b[j] - c[k]));
                    if (minTripleDistance > Distance) {
                        minTripleDistance = Distance;
                    }
                }
            }
        }
        return minTripleDistance;
    }

    public static int Maxnum(int a, int b, int c) {
        int max = a > b ? a : b;
        max = max > c ? max : c;
        return max;
    }

    public static void main(String[] args) {
        int a[] = {3, 4, 5, 7};
        int b[] = {10, 12, 14, 16, 17};
        int c[] = {20, 21, 23, 24, 37, 30};
        int p = TripleDistance(a, b, c);
        System.out.println(p);
    }
}
