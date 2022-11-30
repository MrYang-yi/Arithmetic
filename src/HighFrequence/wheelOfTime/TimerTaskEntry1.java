package HighFrequence.traceBack.wheelOfTime;


import java.util.TimerTask;

/**
 * 存储任务的容器entry
 */
class TimerTaskEntry1 {
    private TimerTask timerTask;
    private long expireMs;
    TimerTaskList2 timedTaskList;
    TimerTaskEntry1 next;
    TimerTaskEntry1 prev;

    public long getExpireMs() {
        return expireMs;
    }

    public void setExpireMs(long expireMs) {
        this.expireMs = expireMs;
    }

    public TimerTaskEntry1(TimerTask timedTask, long expireMs) {
        this.timerTask = timedTask;
        this.expireMs = expireMs;
        this.next = null;
        this.prev = null;
    }

    void remove() {
        TimerTaskList2 currentList = timedTaskList;
        while (currentList != null) {
            currentList.remove(this);
            currentList = timedTaskList;
        }
    }

}
