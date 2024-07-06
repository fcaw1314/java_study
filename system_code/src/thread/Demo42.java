package thread;

import java.util.concurrent.Semaphore;

/**
 * @author yxb
 * @version 1.0
 * @description:
 * @date 2024/7/5 20:57
 */
public class Demo42 {
    public static void main(String[] args) throws InterruptedException {
        //4个可用资源
        Semaphore semaphore = new Semaphore(4);
        semaphore.acquire();
        System.out.println("P操作");
        semaphore.acquire();
        System.out.println("P操作");
        semaphore.acquire();
        System.out.println("P操作");
        semaphore.acquire();
        System.out.println("P操作");
        semaphore.acquire();
        System.out.println("P操作");


        semaphore.release();
    }
}
