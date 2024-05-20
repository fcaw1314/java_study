package thread;

/**
 * @ProjectName: system_code
 * @Package: thread
 * @ClassName: Demo7
 * @author: Yxb
 * @Description:
 * @Date: 2024/5/19 9:41
 * @Version: 1.0
 */
public class Demo7 {
    public static void main(String[] args) throws InterruptedException {
        for (int i = 0; i < 20; i++) {
            int tmp = i;
            Thread t = new Thread(()->{
                System.out.println(tmp);
            });
            t.start();
            t.join();
        }

        System.out.println("ok");
    }
}