package thread;

/**
 * @author yxb
 * @version 1.0
 * @description:
 * @date 2024/7/5 10:43
 */
public class Demo39 {
    private static int sum = 0;
    public static void main(String[] args) throws InterruptedException {
        //创建一个线程,实现1+2+3+....+1000
        Thread t1 = new Thread(new Runnable() {
            @Override
            public void run() {
                int result = 0;
                for (int i = 1; i <= 1000; i++) {
                    result += i;
                }
                //此处为了把result告知主线程,
                sum = result;
            }
        });
        t1.start();
        t1.join();
        System.out.println(sum);
    }
}
