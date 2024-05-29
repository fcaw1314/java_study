package thread;

import java.util.Scanner;

/**
 * @ProjectName: Demo7.java
 * @Package: thread
 * @ClassName: Demo12
 * @author: Yxb
 * @Description:
 * @Date: 2024/5/28 15:47
 * @Version: 1.0
 */
public class Demo12 {
    public static int count = 0;
    public static void main(String[] args) {
        Thread t1 = new Thread(()->{
            while(count == 0){
                ; //
                //System.out.println("t1");
            }
            System.out.println("t1 线程结束了");
        });

        Thread t2 = new Thread(()->{
            Scanner scanner = new Scanner(System.in);
            System.out.println("请输入一个整数：");
            count = scanner.nextInt();
        });
        t1.start();
        t2.start();
    }
}