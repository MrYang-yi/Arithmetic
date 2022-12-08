package HighFrequence.limit;

import java.util.LinkedList;
import java.util.Queue;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

//漏桶算法：往漏桶中以任意速率流入水，以固定的速率流出水。当水超过桶的容量时，会被溢出，也就是被丢弃。因为桶容量是不变的，保证了整体的速率
public class LeakyBucketRateLimiter implements RateLimiter {
    // 桶的容量
    private final int capacity;
    // 漏出的速率
    private final int permitsPerSecond;
    // 剩余水量
    private long leftWater;
    // 上次注入水的时间
    private long timeStamp = System.currentTimeMillis();

    public LeakyBucketRateLimiter(int capacity, int permitsPerSecond) {
        this.capacity = capacity;
        this.permitsPerSecond = permitsPerSecond;
    }

    @Override
    public synchronized boolean tryAcquire() {
        // 计算剩余水量
        long now = System.currentTimeMillis();
        long timeGap = (now - timeStamp) / 1000;
        leftWater = Math.max(0, leftWater - timeGap * permitsPerSecond);
        timeStamp = now;
        // 如果未满，则放行；否则限流
        if (leftWater < capacity) {
            leftWater += 1;
            return true;
        }
        return false;
    }

    public static void main(String[] args) throws InterruptedException {
        ScheduledExecutorService scheduledExecutorService = Executors.newSingleThreadScheduledExecutor();
        ExecutorService singleThread = Executors.newSingleThreadExecutor();

        LeakyBucketRateLimiter rateLimiter = new LeakyBucketRateLimiter(20, 20);
        // 存储流量的队列
        Queue<Integer> queue = new LinkedList<>();
        // 模拟请求  不确定速率注水
        singleThread.execute(() -> {
            int count = 0;
            while (true) {
                count++;
                boolean flag = rateLimiter.tryAcquire();
                if (flag) {
                    queue.offer(count);
                    System.out.println(count + "--------流量被放行--------");
                } else {
                    System.out.println(count + "流量被限制");
                }
                try {
                    Thread.sleep((long) (Math.random() * 1000));
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });

        // 模拟处理请求 固定速率漏水
        scheduledExecutorService.scheduleAtFixedRate(() -> {
            if (!queue.isEmpty()) {
                System.out.println(queue.poll() + "被处理");
            }
        }, 0, 100, TimeUnit.MILLISECONDS);

        // 保证主线程不会退出
        while (true) {
            Thread.sleep(10000);
        }
    }
}
