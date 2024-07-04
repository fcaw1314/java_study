package thread;

import java.util.Timer;
import java.util.TimerTask;

/**
 * @author yxb
 * @version 1.0
 * @description:
 * @date 2024/6/30 14:18
 */
public class Demo36 {
    public static void main(String[] args) {
        Timer timer = new Timer();

        timer.schedule(new TimerTask() {
            @Override
            public void run() {
                System.out.println("Hello 3000");
            }
        },3000);

        timer.schedule(new TimerTask() {
            @Override
            public void run() {
                System.out.println("Hello 2000");
            }
        },2000);

        timer.schedule(new TimerTask() {
            @Override
            public void run() {
                System.out.println("Hello 1000");
            }
        },1000);
    }
}
