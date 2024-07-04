package thread;


import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;

/**
 * @author yxb
 * @version 1.0
 * @description:
 * @date 2024/6/27 11:53
 */

//写一个简单的线程池
class MyThreadPool {
    private BlockingQueue<Runnable> queue = new ArrayBlockingQueue<>(1000);
    private int maxPoolSize = 0;
    private List<Thread> threadList = new ArrayList<>();

    //初始化线程池
    public MyThreadPool(int corePoolSize, int maxPoolSize) {
        this.maxPoolSize = maxPoolSize;
        //创建若干个线程
        for (int i = 0; i < corePoolSize; i++) {
            Thread thread = new Thread(() -> {
                try {
                    while (true) {
                        Runnable runnable = queue.take();
                        runnable.run();
                    }
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            });
            thread.start();
            threadList.add(thread);
        }
    }

    //把任务添加到线程池中
    void submit(Runnable runnable) throws InterruptedException {
        //此处进行判定,判定当前的元素个数,是否较长
        //如果队列的元素较长,说明已有的线程,不太能处理过来了,创建新的线程即可
        //如果队列不是很长,没必要创建新的线程
        queue.put(runnable);

        //这里的阈值,是随便想的
        if (queue.size() >= 500 && threadList.size() < maxPoolSize) {
            //创建新的线程即可
            Thread thread = new Thread(() -> {
                try {
                    while (true) {
                        Runnable task = queue.take();
                        task.run();
                    }
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            });
            thread.start();
        }
    }
}


public class Demo35 {
    public static void main(String[] args) throws InterruptedException {
        MyThreadPool myThreadPool = new MyThreadPool(5, 20);
        for (int i = 0; i < 10000; i++) {
            int id = i;
            myThreadPool.submit(new Runnable() {
                @Override
                public void run() {
                    System.out.println("hello " + id + "," + Thread.currentThread().getName());
                }
            });
        }
    }
}
