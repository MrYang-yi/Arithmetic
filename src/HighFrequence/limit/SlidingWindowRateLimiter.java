package HighFrequence.limit;

import java.time.LocalDateTime;
import java.time.ZoneOffset;
import java.util.Iterator;
import java.util.Map;
import java.util.TreeMap;

//滑动窗口限流算法
public class SlidingWindowRateLimiter implements RateLimiter {
    // 每分钟限制的请求数
    private final long permitsPerMinute;

    // 计数器，k为当前窗口的开始时间值秒，value为当前窗口的计数
    private final TreeMap<Long, Integer> counters;

    public SlidingWindowRateLimiter(long permitsPerMinute) {
        this.permitsPerMinute = permitsPerMinute;
        this.counters = new TreeMap<>();
    }

    @Override
    public synchronized boolean tryAcquire() {
        // 获取当前时间所在的子窗口值；10s一个窗口
        long currentWindowTime = LocalDateTime.now().toEpochSecond(ZoneOffset.UTC) / 10 * 10;
        // 获取当前窗口的请求总量
        int currentWindowCount = getCurrentWindowCount(currentWindowTime);
        if (currentWindowCount >= permitsPerMinute) {
            return false;
        }
        // 计数器加一
        counters.merge(currentWindowTime, 1, Integer::sum);
        return true;
    }

    /**
     * 获取当前窗口的所有请求数（并删除所有无效的子窗口计数器）
     *
     * @param currentWindowTime 当前子窗口时间
     * @return 当前窗口中的计数
     */
    private int getCurrentWindowCount(long currentWindowTime) {
        // 计算出窗口的开始位置时间
        long startTime = currentWindowTime - 50;
        int result = 0;
        // 遍历当前存储的计数器，删除无效的子窗口计数器，并累加当前窗口中的所有计数器之后
        Iterator<Map.Entry<Long, Integer>> entryIterator = counters.entrySet().iterator();
        while (entryIterator.hasNext()) {
            Map.Entry<Long, Integer> entry = entryIterator.next();
            if (entry.getKey() < startTime) {
                entryIterator.remove();
            } else {
                result += entry.getValue();
            }
        }
        return result;
    }
}
