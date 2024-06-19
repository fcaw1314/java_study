package thread;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;

/**
 * @author yxb
 * @version 1.0
 * @description:
 * @date 2024/6/16 20:38
 */
public class Demo29 {
    public static void main(String[] args) throws InterruptedException {
        BlockingQueue<String> queue = new ArrayBlockingQueue<>(100);
        queue.put("aaa");
        String elem = queue.take();
        System.out.println("elem = " +elem);
        elem = queue.take();
        System.out.println("elem = " +elem);

    }
}
