package thread;

/**
 * @ProjectName: Demo7.java
 * @Package: thread
 * @ClassName: Demo10
 * @author: Yxb
 * @Description:
 * @Date: 2024/5/28 10:14
 * @Version: 1.0
 */


public class Demo10 {
    public static void main(String[] args) throws InterruptedException {
        Object locker1 = new Object();
        Object locker2 = new Object();

        Thread t1 = new Thread(()->{
        synchronized(locker1) {
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            synchronized (locker2){
                System.out.println("t1获取了两把锁");
            }
        }
        });
        //产生死锁现象
        Thread t2 = new Thread(()->{
            synchronized (locker2){
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }

                 synchronized (locker1){
                    System.out.println("t2获取了两把锁");
                }
            }
        });
        t1.start();
        t2.start();
        t1.join();
        t2.join();
    }
}