package thread;

import java.util.concurrent.CountDownLatch;

/**
 * @author yxb
 * @version 1.0
 * @description:
 * @date 2024/7/5 21:26
 */
public class Demo44 {
    public static void main(String[] args) throws InterruptedException {
        CountDownLatch latch = new CountDownLatch(10);
        for (int i = 0; i < 10; i++) {
            int id = i;
            Thread t1 = new Thread(()->{
                System.out.println("线程启动" + id);
                try {
                    Thread.sleep(3000);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
                System.out.println("线程结束" + id);
                latch.countDown();
            });
            t1.start();
        }
        //通过await等待所有的线程调用
        latch.await();
        System.out.println("所有线程结束");
    }
}
