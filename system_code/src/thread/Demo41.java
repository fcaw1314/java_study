package thread;

import java.util.concurrent.locks.ReentrantLock;

/**
 * @author yxb
 * @version 1.0
 * @description:
 * @date 2024/7/5 20:49
 */
public class Demo41 {
    public static void main(String[] args) {
        //公平锁
        ReentrantLock locker = new ReentrantLock(true);
        try {
            //加锁
            locker.lock();
        }finally {
            //解锁
            locker.unlock();
        }



    }
}
