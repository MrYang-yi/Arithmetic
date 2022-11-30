package HighFrequence.traceBack.wheelOfTime;


/**
 * 任务包装类(这里也可以将工作任务以线程变量的方式去传入)
 */
class TimerTask implements Runnable {
    /**
     * 延时时间
     */
    private long delayMs;
    /**
     * 任务所在的entry
     */
    private TimerTaskEntry1 timerTaskEntry;

    private String desc;

    public TimerTask(String desc, long delayMs) {
        this.desc = desc;
        this.delayMs = delayMs;
        this.timerTaskEntry = null;
    }

    public void setTimerTaskEntry(TimerTaskEntry1 entry) {
        this.timerTaskEntry = entry;
    }

    public TimerTaskEntry1 getTimerTaskEntry() {
        return timerTaskEntry;
    }

    @Override
    public void run() {
        System.out.println(desc);
    }
}
