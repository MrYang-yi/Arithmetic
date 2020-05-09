package LeetCode;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;

/**
 * topic:总持续时间可被 60 整除的歌曲
 * 在歌曲列表中，第 i 首歌曲的持续时间为 time[i] 秒。
 * 返回其总持续时间（以秒为单位）可被 60 整除的歌曲对的数量。
 * 形式上，我们希望索引的数字 i 和 j 满足  i < j 且有 (time[i] + time[j]) % 60 == 0。
 * 输入：[30,20,150,100,40]
 * 输出：3
 * 解释：这三对的总持续时间可被 60 整数：
 * (time[0] = 30, time[2] = 150): 总持续时间 180
 * (time[1] = 20, time[3] = 100): 总持续时间 120
 * (time[1] = 20, time[4] = 40): 总持续时间 60
 * <p>
 * 输入：[60,60,60]
 * 输出：3
 * 解释：所有三对的总持续时间都是 120，可以被 60 整数。
 */
public class numPairsDivisibleBy60_1010 {
    public int numPairsDivisibleBy60(int[] time) {
        if (time == null || time.length <= 1) {
            return 0;
        }
        HashMap<Integer, Integer> map = new HashMap<>();
        int count = 0;
        for (int x : time) {
            int remainder = x % 60;
            if (map.containsKey(remainder)) {
                //count++;  这里为什么不用count++呢 因为当前面有两个数重合时 其实能匹配两次 +2 而实际上只加1 就会报错
                // 总结：利用HashMap存储时  如果需要和前面多个数进行多次匹配 不能用变量++ 而应该利用HashMap的value
                count += map.get(remainder);
            }
            if (remainder == 0) {
                map.put(0, map.getOrDefault(0, 0) + 1);
            } else {
                map.put(60 - remainder, map.getOrDefault(60 - remainder,0) + 1);
            }
        }
        return count;
    }


    public static void main(String[] args) {
        //int[] a = {30, 20, 150, 100, 40};
        int[] b = {60, 60, 60, 60};
        //int[] c={418,204,77,278,239,457,284,263,372,279,476,416,360,18};
        //System.out.println(new numPairsDivisibleBy60_1010().numPairsDivisibleBy60(a));
        System.out.println(new numPairsDivisibleBy60_1010().numPairsDivisibleBy60(b));
        //System.out.println(new numPairsDivisibleBy60_1010().numPairsDivisibleBy60(c));
    }
}
