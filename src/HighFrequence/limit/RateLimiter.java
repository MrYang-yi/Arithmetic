package HighFrequence.limit;

public interface RateLimiter {
    /**
     * 判断请求是否能够通过
     * @return 能通过返回true否则false
     */
    boolean tryAcquire();
}
