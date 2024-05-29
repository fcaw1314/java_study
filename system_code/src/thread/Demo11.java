package thread;

/**
 * @ProjectName: Demo7.java
 * @Package: thread
 * @ClassName: Demo11
 * @author: Yxb
 * @Description:
 * @Date: 2024/5/28 15:01
 * @Version: 1.0
 */
public class Demo11 {
    public static void main(String[] args) throws InterruptedException {
        Thread t1 = new Thread(()->{
            System.out.println("t1线程");

        });
        Thread t2 = new Thread(()->{
            System.out.println("t2线程");
        });
        t1.start();
        t2.start();
    }
}