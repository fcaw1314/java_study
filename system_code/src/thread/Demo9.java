package thread;

/**
 * @ProjectName: Demo7.java
 * @Package: thread
 * @ClassName: Demo9
 * @author: Yxb
 * @Description:
 * @Date: 2024/5/27 21:00
 * @Version: 1.0
 */
public class Demo9 {
    public static void main(String[] args) {
        Thread t = new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.println("1");
            }
        });
        t.start();
        System.out.println("2");
    }
}