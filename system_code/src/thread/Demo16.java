package thread;

/**
 * @ProjectName: Demo7.java
 * @Package: thread
 * @ClassName: Demo16
 * @author: Yxb
 * @Description:
 * @Date: 2024/5/31 11:54
 * @Version: 1.0
 */
public class Demo16 {
//    private static volatile int COUNTER = 0;
//    private static volatile Object locker = new Object();
//
//    public static void main(String[] args) {
//        // 创建三个线程，并指定线程名，每个线程名分别用A,B,C表示
//        Thread t1 = new Thread(() -> {
//            // 循环10次
//            for (int i = 0; i < 10; i++) {
//                // 执行的代码加锁
//                synchronized (locker) {
//                    // 每次唤醒后都重新判断是否满足条件// 每条线程判断的条件不一样，注意线程t1,t2
//                    while (COUNTER % 3 != 0) {
//                        try {
//                            // 不满足输出条件时，主动等待并释放锁
//                            locker.wait();
//                        } catch (InterruptedException e) {
//                            e.printStackTrace();
//                        }
//                    }
//                }
//                // 满足输出条件，打印线程名，每条线程打印的内容不同
//                System.out.print(Thread.currentThread().getName());
//                // 累加计数
//                COUNTER++;
//                // 唤醒其他线程
//                locker.notifyAll();
//            }
//        }, "A");
//
//        Thread t2 = new Thread(() -> {
//            for (int i = 0; i < 10; i++) {
//                synchronized (locker) {
//                    while (COUNTER % 3 != 1) {
//                        try {
//                            locker.wait();
//                        } catch (InterruptedException e) {
//                            e.printStackTrace();
//                        }
//                    }
//                    System.out.print(Thread.currentThread().getName());
//                    COUNTER++;
//                    locker.notifyAll();
//                }
//            }
//        }, "B");
//
//        Thread t3 = new Thread(() -> {
//            for (int i = 0; i < 10; i++) {
//                synchronized (locker) {
//                    while (COUNTER % 3 != 2) {
//                        try {
//                            locker.wait();
//                        } catch (InterruptedException e) {
//                            e.printStackTrace();
//                        }
//                    }
//
//                    // 换行打印
//                    System.out.println(Thread.currentThread().getName());
//                    COUNTER++;
//                    locker.notifyAll();
//                }
//            }
//        }, "C");
//
//        // 启动线程
//        t1.start();
//        t2.start();
//        t3.start();
//    }

    private static Object locker1 = new Object();
    private static Object locker2 = new Object();
    private static Object locker3 = new Object();

    public static void main(String[] args) throws InterruptedException {
        Thread t1 = new Thread(() -> {
            try {
                for (int i = 0; i < 10; i++) {
                    synchronized (locker1) {
                        locker1.wait();
                    }
                    System.out.print("A");
                    synchronized (locker2) {
                        locker2.notify();
                    }
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });

        Thread t2 = new Thread(() -> {
            try {
                for (int i = 0; i < 10; i++) {
                    synchronized (locker2) {
                        locker2.wait();
                    }
                    System.out.print("B");
                    synchronized (locker3) {
                        locker3.notify();
                    }
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });

        Thread t3 = new Thread(() -> {
            try {
                for (int i = 0; i < 10; i++) {
                    synchronized (locker3) {
                        locker3.wait();
                    }
                    System.out.println("C");
                    synchronized (locker1) {
                        locker1.notify();
                    }
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });
        t1.start();
        t2.start();
        t3.start();

        Thread.sleep(1000);

        // 从线程 t1 启动
        synchronized (locker1) {
            locker1.notify();
        }
    }
}
