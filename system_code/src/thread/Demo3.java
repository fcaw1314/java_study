package thread;

/**
 * @author yxb
 * @version 1.0
 * @description:
 * @date 2024/5/14 16:03
 */
public class Demo3 {
    public static void main(String[] args) {
        //
        Thread t = new Thread(()-> {
            System.out.println("Hello main");
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        });
        //设置后台进程
        t.setDaemon(true);
        t.start();
    }
}
