package thread;

/**
 * @ProjectName: system_code
 * @Package: thread
 * @ClassName: Demo5
 * @author: Yxb
 * @Description:
 * @Date: 2024/5/18 21:23
 * @Version: 1.0
 */
public class Demo5 {
    public static int count = 0;

    public static void main(String[] args) throws InterruptedException {
        Object locker = new Object();

        Thread t1 = new Thread(() -> {
            for (int i = 0; i < 50000; i++) {
                //加锁操作
                synchronized(locker){
                    count++;
                }
            }
        });
        Thread t2 = new Thread(() -> {
            for (int i = 0; i < 50000; i++) {
                synchronized(locker) {
                    count++;
                }
            }
        });
        t1.start();
        t1.join();
        t2.start();
        t2.join();
        System.out.println("count = " + count);
    }
}