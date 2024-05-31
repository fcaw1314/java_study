package thread;

/**
 * @ProjectName: Demo7.java
 * @Package: thread
 * @ClassName: Demo15
 * @author: Yxb
 * @Description:
 * @Date: 2024/5/31 11:38
 * @Version: 1.0
 */
class SingletonLazy{
    private static volatile SingletonLazy instance = null;
    private static Object locker = new Object();

    public static SingletonLazy getInstance() {
        if (instance == null) {
            synchronized (locker) {
                if (instance == null) {
                    instance = new SingletonLazy();
                }
            }
        }
        return instance;
    }
    private SingletonLazy(){


    }
}

public class Demo15 {
    public static void main(String[] args) {

    }
}