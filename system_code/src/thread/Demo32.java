package thread;

/**
 * @author yxb
 * @version 1.0
 * @description:
 * @date 2024/6/23 10:11
 */
public class Demo32 {
    public static void main(String[] args) {
        Thread t1 = new Thread(() -> {
           int count = 0;
           while(true){
               count++;
           }
        });
        t1.start();
    }
}
