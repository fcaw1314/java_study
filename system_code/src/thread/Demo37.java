package thread;

import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.TimerTask;

// 通过 implements 或者持有 成员变量 都是可以的.
class MyTimerTask implements Comparable<MyTimerTask> {
    private Runnable runnable;
    // 啥时候要去执行. 此处的 time 不是 delay, 而是 ms 级别的时间戳. (绝对时间)
    private long time;

    public MyTimerTask(Runnable runnable, long delay) {
        this.runnable = runnable;
        // 手动换算一下时间.
        this.time = System.currentTimeMillis() + delay;
    }

    public void run() {
        runnable.run();
    }

    public long getTime() {
        return time;
    }

    @Override
    public int compareTo(MyTimerTask o) {
        // 按照时间来进行比较. 期望最终构造出的是小堆.
        return (int) (this.time - o.time);
        // return (int) (o.time - this.time);
    }
}

class MyTimer {
    private PriorityQueue<MyTimerTask> taskQueue = new PriorityQueue<>();

    // 也可以直接使用 this 作为锁对象.
    private Object locker = new Object();

    public MyTimer() {
        // 这个线程负责不停的扫描上述的队列队首元素, 来确定是否要执行任务.
        Thread t = new Thread(() -> {
            try {
                while (true) {
                    synchronized (locker) {
                        if (taskQueue.size() == 0) {
                            locker.wait();
                        }
                        MyTimerTask task = taskQueue.peek();
                        long curTime = System.currentTimeMillis();
                        if (curTime >= task.getTime()) {
                            // 时间到了, 要执行任务
                            task.run();
                            taskQueue.poll();
                        } else {
                            // 时间没到.
                            locker.wait(task.getTime() - curTime);
                        }
                    }
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });
        t.start();
    }

    public void schedule(Runnable runnable, long delay) {
        synchronized (locker) {
            MyTimerTask task = new MyTimerTask(runnable, delay);
            taskQueue.offer(task);
            locker.notify();
        }
    }
}

public class Demo37 {
    public static void main(String[] args) {
        MyTimer myTimer = new MyTimer();
        myTimer.schedule(new Runnable() {
            @Override
            public void run() {
                System.out.println("hello 3000");
            }
        }, 3000);
        myTimer.schedule(new Runnable() {
            @Override
            public void run() {
                System.out.println("hello 2000");
            }
        }, 2000);
        myTimer.schedule(new Runnable() {
            @Override
            public void run() {
                System.out.println("hello 1000");
            }
        }, 1000);
    }
}