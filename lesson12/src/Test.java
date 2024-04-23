/**
 * @ProjectName: lesson12
 * @Package: PACKAGE_NAME
 * @ClassName: Test
 * @author: Yxb
 * @Description:
 * @Date: 2024/4/21 16:40
 * @Version: 1.0
 */
public class Test {
    public static int func(){
        try {
            int[] array = null;
            System.out.println(array.length);
        }catch (NullPointerException e){
            System.out.println("捕获到了一个空指针异常");
        }finally {
            System.out.println("这里执行了finnal ");
        }
        return 100;
    }
    public static void main(String[] args) {
        System.out.println(func());
    }
}