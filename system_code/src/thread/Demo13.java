package thread;

/**
 * @ProjectName: Demo7.java
 * @Package: thread
 * @ClassName: Demo13
 * @author: Yxb
 * @Description:
 * @Date: 2024/5/29 15:30
 * @Version: 1.0
 */
public class Demo13 {
    public static void main1(String[] args) throws InterruptedException {
        Object locker = new Object();

        Thread a = new Thread(()->{
            synchronized (locker){
                try {
                    locker.wait();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println("a");
            }
        });

        Thread b = new Thread(()->{
            synchronized (locker){
                try {
                    locker.wait();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println("b");
            }
        });

        Thread c = new Thread(()->{
            synchronized (locker) {
                locker.notifyAll();
                System.out.println("c");
            }
        });

        a.start();
        Thread.sleep(300);
        b.start();
        c.start();
    }
    public static void main(String[] args) throws InterruptedException {
        // 创建三个线程
        Thread tc = new Thread(() -> {
            // 打印c
            System.out.print(Thread.currentThread().getName() + " ");
        }, "c");

        Thread tb = new Thread(() -> {
            try {
                // 等待c 执行完成
                tc.join();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            // 打印b
            System.out.print(Thread.currentThread().getName() + " ");
        }, "b");

        Thread ta = new Thread(() -> {
            try {
                // 等待b 执行完成
                tb.join();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            // 打印a
            System.out.print(Thread.currentThread().getName() + " ");
        }, "a");

        // 需要让他们同时启动，并按 c，b，a的顺序打印
        ta.start();
        tb.start();
        tc.start();
    }
}