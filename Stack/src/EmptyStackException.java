/**
 * @ProjectName: Stack
 * @Package: PACKAGE_NAME
 * @ClassName: EmptyStackException
 * @author: Yxb
 * @Description:
 * @Date: 2024/5/3 19:09
 * @Version: 1.0
 */
public class EmptyStackException extends RuntimeException{
    public EmptyStackException() {
    }

    public EmptyStackException(String message) {
        super(message);
    }
}