package thread;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;

/**
 * @author yxb
 * @version 1.0
 * @description:
 * @date 2024/7/5 20:37
 */
public class Demo40 {
    public static void main(String[] args) throws InterruptedException, ExecutionException {
        Callable<Integer> callable = new Callable<Integer>() {
            @Override
            public Integer call() throws Exception {
                int result = 0;
                for (int i = 0; i <= 1000; i++) {
                    result += i;
                }
                return result;
            }
        };
        //创建线程,把callable搭载到线程内部执行
        FutureTask<Integer> futureTask = new FutureTask<>(callable);
        Thread t1 = new Thread(futureTask);
        t1.start();
        t1.join();
        System.out.println(futureTask.get());
    }
}
