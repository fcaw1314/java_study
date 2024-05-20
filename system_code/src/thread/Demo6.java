package thread;

import java.util.Random;

/**
 * @ProjectName: system_code
 * @Package: thread
 * @ClassName: Demo6
 * @author: Yxb
 * @Description:
 * @Date: 2024/5/19 8:51
 * @Version: 1.0
 */
public class Demo6 {
    public static void main(String[] args) throws InterruptedException {
        int[] arr = new int[10000000];
        Random random = new Random();
        for(int i = 0 ; i<arr.length;i++){
            arr[i] =random.nextInt(100);
        }
        //第一个线程，返回偶数之和。
        Thread t1 = new Thread(()->{
            int temp = 0;
            for (int i = 0; i < arr.length; i+=2) {
                temp += arr[i];
            }
            System.out.println("线程1：" + temp);
        });
        //第二个线程，放回奇数之和。
        Thread t2 = new Thread(()->{
            int temp = 0;
            for (int i = 1; i < arr.length; i+=2) {
                temp += arr[i];
            }
            System.out.println("线程1：" + temp);
        });
        t1.start();
        t1.join();
        t2.start();
        t2.join();

       // System.out.println("总和"+sum);//打印所有奇数偶数下标的和
    }
}