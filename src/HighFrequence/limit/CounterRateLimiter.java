package HighFrequence.limit;

//固定窗口：首先维护一个计数器，将单位时间段当做一个窗口，计数器记录这个窗口接收请求的次数
public class CounterRateLimiter implements RateLimiter {
    // 每秒限制的请求数
    private final long permitsPerSecond;

    // 上一个窗口开始的时间
    private long timestamp = System.currentTimeMillis();

    // 计数器
    private int counter;

    public CounterRateLimiter(long permitsPerSecond) {
        this.permitsPerSecond = permitsPerSecond;
    }

    @Override
    public synchronized boolean tryAcquire() {
        long now = System.currentTimeMillis();
        // 窗口内请求数量小于阈值，更新计数放行，否则拒绝请求
        if (now - timestamp < 1000) {
            if (counter < permitsPerSecond) {
                counter++;
                return true;
            } else {
                return false;
            }
        }
        // 时间窗口过期，重置计数器和时间戳
        counter = 0;
        timestamp = now;
        return true;
    }
}
