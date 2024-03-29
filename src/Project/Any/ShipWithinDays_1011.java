package Project.Any;

/**
 * topic: 在 D 天内送达包裹的能力
 * 传送带上的包裹必须在 D 天内从一个港口运送到另一个港口。
 * 传送带上的第 i 个包裹的重量为 weights[i]。每一天，我们都会按给出
 * 重量的顺序往传送带上装载包裹。我们装载的重量不会超过船的最大运载重量。
 * 返回能在 D 天内将传送带上的所有包裹送达的船的最低运载能力。
 * 输入：weights = [1,2,3,4,5,6,7,8,9,10], D = 5
 * 输出：15
 * 解释：
 * 船舶最低载重 15 就能够在 5 天内送达所有包裹，如下所示：
 * 第 1 天：1, 2, 3, 4, 5
 * 第 2 天：6, 7
 * 第 3 天：8
 * 第 4 天：9
 * 第 5 天：10
 * <p>
 * 请注意，货物必须按照给定的顺序装运，因此使用载重能力为 14 的船舶并将包装分成 (2, 3, 4, 5), (1, 6, 7), (8), (9), (10) 是不允许的。
 * 示例 2：
 * <p>
 * 输入：weights = [3,2,2,4,1,4], D = 3
 * 输出：6
 * 解释：
 * 船舶最低载重 6 就能够在 3 天内送达所有包裹，如下所示：
 * 第 1 天：3, 2
 * 第 2 天：2, 4
 * 第 3 天：1, 4
 * 示例 3：
 * <p>
 * 输入：weights = [1,2,3,1,1], D = 4
 * 输出：3
 * 解释：
 * 第 1 天：1
 * 第 2 天：2
 * 第 3 天：3
 * 第 4 天：1, 1
 */
public class ShipWithinDays_1011 {

    public int shipWithinDays(int[] weights, int D) {
/*        int lo = 0, hi = Integer.MAX_VALUE;
        while (lo < hi) {
            int mid = lo + (hi - lo) / 2;
            if (canShip(weights, D, mid)) {
                hi = mid;
            } else {
                lo = mid + 1;
            }
        }
        return lo;
    }

    private boolean canShip(int[] weights, int D, int K) {
        int cur = K; // cur 表示当前船的可用承载量
        for (int weight : weights) {
            if (weight > K) return false;
            if (cur < weight) {
                cur = K;
                D--;
            }
            cur -= weight;
        }
        return D > 0; // 能否在D天内运完*/

        int min = 0;
        int max = Integer.MAX_VALUE;

        while (min < max) {
            int mid = min + (max - min) / 2;
            if (canShip(weights, D, mid)) {
                max = mid;
            } else {
                min = mid + 1;
            }
        }
        return min;
    }

    public static Boolean canShip(int[] weights, int D, int k) {
        int curr = k;//船当前的最大承载量

        for (int x : weights) {
            if (x > k) return false;
            if (x > curr) {
                curr = k;  //使当前承载量恢复到原来的值
                D--;     //天数-1  进行下一天的判断
            }
            curr -= x;
        }
        return D > 0;
    }


    public static void main(String[] args) {
        int[] a = {3, 2, 2, 4, 1, 4};
        //int[] b = {1, 2, 3, 1, 1};
        System.out.println(new ShipWithinDays_1011().shipWithinDays(a, 3));
        // System.out.println(new ShipWithinDays_1011().shipWithinDays(b, 4));
    }
}
