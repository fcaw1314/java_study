package thread;

import java.util.concurrent.Semaphore;

/**
 * @author yxb
 * @version 1.0
 * @description:
 * @date 2024/7/5 21:10
 */
public class Demo43 {

    private static int count = 0;

    public static void main(String[] args) throws InterruptedException {
        Semaphore semaphore = new Semaphore(1);

        Thread t1 = new Thread(() -> {
            try {
                for (int i = 0; i < 50000; i++) {
                    semaphore.acquire();
                    count++;
                    semaphore.release();
                }
            } catch (Exception e) {
                throw new RuntimeException(e);
            }
        });
        Thread t2 = new Thread(() -> {
            try {
                for (int i = 0; i < 50000; i++) {
                    semaphore.acquire();
                    count++;
                    semaphore.release();
                }
            } catch (Exception e) {
                throw new RuntimeException(e);
            }
        });
        t1.start();
        t2.start();
        t1.join();
        t2.join();
        System.out.println("count = " + count);
    }
}
