package HighFrequence.limit;

//令牌桶算法:根据限流大小，定速往令牌桶里放令牌,如果令牌数量满了，超过令牌桶容量的限制，那就丢弃,
//系统在接受到一个用户请求时，都会先去令牌桶要一个令牌。如果拿到令牌，那么就处理这个请求的业务逻辑
//如果拿不到令牌，就直接拒绝这个请求
public class TokenBucketRateLimiter implements RateLimiter {
    // 令牌桶的容量
    private final long capacity;
    // 令牌发放速率
    private final long generatedPerSecond;
    // 最后一个令牌发放的时间
    private long lastTokenTime = System.currentTimeMillis();
    // 当前令牌数量
    private long currentTokens;

    public TokenBucketRateLimiter(long capacity, long generatedPerSecond) {
        this.capacity = capacity;
        this.generatedPerSecond = generatedPerSecond;
    }

    @Override
    public synchronized boolean tryAcquire() {
        /*
          计算当前令牌的数量
          请求时间在最后令牌产生的时间相差大于等于1s
          1.重新计算令牌桶中的令牌数量
          2. 将最后一个令牌发放时间重置为当前时间
         */
        long now = System.currentTimeMillis();
        if (now - lastTokenTime >= 1000) {
            long newPermits = (now - lastTokenTime) / 1000 * generatedPerSecond;
            currentTokens = Math.min(currentTokens + newPermits, capacity);
            lastTokenTime = now;
        }
        if (currentTokens > 0) {
            currentTokens--;
            return true;
        }
        return false;
    }
}