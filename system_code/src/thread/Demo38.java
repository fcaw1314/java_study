package thread;

import java.util.concurrent.atomic.AtomicInteger;

/**
 * @author yxb
 * @version 1.0
 * @description:
 * @date 2024/7/4 20:41
 */
public class Demo38 {
    private static AtomicInteger count = new AtomicInteger(0);

    public static void main(String[] args) throws InterruptedException {
        Thread t1 = new Thread(() -> {
            for (int i = 0; i < 5000; i++) {
                //count++
                count.getAndIncrement();
//              // ++count;
//                count.incrementAndGet();
//                // count--;
//                count.getAndDecrement();
//                // --count;
//                count.decrementAndGet();
//                // count += 10
//                count.getAndAdd(10);
            }
        });
        Thread t2 = new Thread(() -> {
            for (int i = 0; i < 5000; i++) {
                //count++
                count.getAndIncrement();
            }
        });
        t1.start();
        t2.start();
        t1.join();
        t2.join();
        System.out.println("count = " + count);
    }
}
