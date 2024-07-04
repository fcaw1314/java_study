package thread;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * @author yxb
 * @version 1.0
 * @description:
 * @date 2024/6/27 11:52
 */
public class Demo34 {
    public static void main(String[] args) {
        // 创建一个最普通的线程池.
        // 能够根据任务的数目, 自动进行线程扩容.
        // ExecutorService service = Executors.newCachedThreadPool();
        ExecutorService service = Executors.newFixedThreadPool(10);

        for (int i = 0; i < 10000; i++) {
            int id = i;
            service.submit(new Runnable() {
                @Override
                public void run() {
                    System.out.println("hello " + id + ", " + Thread.currentThread().getName());
                }
            });
        }

//        // 创建固定线程数目的线程池.
//        Executors.newFixedThreadPool(4);
//        // 创建一个只包含单个线程的线程池.
//        Executors.newSingleThreadExecutor();
//        // 创建一个固定线程个数, 但是任务延时执行的线程池.
//        Executors.newScheduledThreadPool(4);
    }
}
