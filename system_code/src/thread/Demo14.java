package thread;

/**
 * @ProjectName: Demo7.java
 * @Package: thread
 * @ClassName: Demo14
 * @author: Yxb
 * @Description:
 * @Date: 2024/5/30 20:09
 * @Version: 1.0
 */
//饿汉模式
class Singletion{
    private static volatile Singletion instance = new Singletion();

    public static Singletion getInstance() {
        return instance;
    }

    private Singletion(){

    }
}
public class Demo14 {
    public static void main(String[] args) {

    }
}