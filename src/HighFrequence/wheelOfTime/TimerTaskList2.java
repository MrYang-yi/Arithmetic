package HighFrequence.traceBack.wheelOfTime;

import java.util.concurrent.Delayed;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicLong;

/**
 * 1.存储任务的环形链表
 */
class TimerTaskList2 implements Delayed {
    //TimerTaskList 环形链表使用一个虚拟根节点root
    private TimerTaskEntry1 root = new TimerTaskEntry1(null, -1);

    {
        root.next = root;
        root.prev = root;
    }

    //bucket的过期时间
    private AtomicLong expiration = new AtomicLong(-1L);

    //设置bucket的过期时间,设置成功返回true
    boolean setExpiration(long expirationMs) {
        return expiration.getAndSet(expirationMs) != expirationMs;
    }

    public boolean addTask(TimerTaskEntry1 entry) {
        boolean done = false;
        while (!done) {
            //如果TimerTaskEntry已经在别的list中就先移除,同步代码块外面移除,避免死锁,一直到成功为止
            entry.remove();
            synchronized (this) {
                if (entry.timedTaskList == null) {
                    //加到链表的末尾
                    TimerTaskEntry1 tail = root.prev;
                    entry.prev = tail;
                    entry.next = root;
                    tail.next = entry;
                    root.prev = entry;
                    done = true;
                }
            }
        }
        return true;
    }

    //从 TimedTaskList 移除指定的 timerTaskEntry
    public void remove(TimerTaskEntry1 entry) {
        entry.next.prev = entry.prev;
        entry.prev.next = entry.next;
        entry.next = null;
        entry.prev = null;
        entry.timedTaskList = null;
    }

    @Override
    public long getDelay(TimeUnit unit) {
        return Math.max(0, unit.convert(expiration.get() - System.currentTimeMillis(), TimeUnit.MILLISECONDS));
    }

    @Override
    public int compareTo(Delayed o) {
        if (o instanceof TimerTaskList2) {
            return Long.compare(expiration.get(), ((TimerTaskList2) o).expiration.get());
        }
        return 0;
    }
}
