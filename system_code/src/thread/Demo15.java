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
    // 声明，并用volatile修饰，保证在多线程环境下的有序性
    private volatile static SingletonLazy instance = null;
    private static Object locker = new Object();
    // 私有构造方法
    private SingletonLazy () {}
    // 对外提供一个获取实例的方法，
    private static SingletonLazy getInstance() {
        // 使用双重if检查, 降低锁竞争的频率
        if (instance == null) {
            // instance没有被实例化才去加锁
            synchronized (locker) {
                // 获取到锁后再检查一遍，确认instance没有被实例化后去真正的实例化
                if (instance == null) {
                    instance = new SingletonLazy();
                }
            }
        }
        return instance;
    }
}

public class Demo15 {
    public static void main(String[] args) {

    }
}