package thread;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;

/**
 * @author yxb
 * @version 1.0
 * @description:
 * @date 2024/6/19 19:54
 */
public class Demo30 {
    public static void main(String[] args) {
        BlockingQueue<Integer> queue = new ArrayBlockingQueue<>(1000);

        //消费者
        Thread t1 = new Thread(() -> {
            try {
                while (true) {
                    Integer value = queue.take();
                    System.out.println("t1 消费: " + value);
                    //每隔1s生产一个元素
                    Thread.sleep(1000);
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });

        //生产者
        Thread t2 = new Thread(() -> {
            try {
                int count = 1;
                while (true) {
                    queue.put(count);
                    System.out.println("t2 生产了: " + count);
                    count++;

                }
            }catch (InterruptedException e) {
                e.printStackTrace();
            }
        });
        t1.start();
        t2.start();
    }
}
