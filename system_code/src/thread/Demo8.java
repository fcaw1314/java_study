package thread;

/**
 * @ProjectName: Demo7.java
 * @Package: thread
 * @ClassName: Demo8
 * @author: Yxb
 * @Description:
 * @Date: 2024/5/27 20:44
 * @Version: 1.0
 */

class Counter{
    private int count = 0;

    public synchronized void add(){
        count++;
    }

    public int get() {
        return count;
    }
}
public class Demo8 {

    public static void main(String[] args) throws InterruptedException {
        Counter counter = new Counter();
        Thread t1 = new Thread(()->{
            for (int i = 0; i < 50000; i++) {
                counter.add();
            }
        });

        Thread t2 = new Thread(()->{
            for (int i = 0; i < 50000; i++) {
                counter.add();
            }
        });
        t1.start();
        t2.start();
        t1.join();
        t2.join();
        System.out.println("count = " + counter.get());
    }
}