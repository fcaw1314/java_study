package thread;

import java.util.jar.JarOutputStream;

/**
 * @ProjectName: system_code
 * @Package: thread
 * @ClassName: Demo1
 * @author: Yxb
 * @Description:
 * @Date: 2024/5/12 16:09
 * @Version: 1.0
 */
class MyThread extends Thread{
    @Override
    public void run() {
        //System.out.println("Hello Thread!!");
        while(true){
            System.out.println("Hello Thread!!");
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
    }
}

public class Demo1 {
    public static void main(String[] args) {
        Thread t = new MyThread();
        t.start();
        while(true){
            System.out.println("Hello main!!!");
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }

        }

    }
}