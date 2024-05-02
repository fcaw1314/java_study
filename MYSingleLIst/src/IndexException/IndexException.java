package IndexException;

/**
 * @ProjectName: MYSingleLIst
 * @Package: IndexException
 * @ClassName: IndexException
 * @author: Yxb
 * @Description:
 * @Date: 2024/5/2 9:21
 * @Version: 1.0
 */
public class IndexException extends RuntimeException {
    public IndexException(){

    }
    public IndexException(String msg){
        super(msg);
    }
}