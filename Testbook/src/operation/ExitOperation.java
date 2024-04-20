package operation;

import book.BookList;

/**
 * @ProjectName: Testbook
 * @Package: operation
 * @ClassName: ExitOperation
 * @author: Yxb
 * @Description:
 * @Date: 2024/4/20 15:06
 * @Version: 1.0
 */
public class ExitOperation implements IOPeration{
    @Override
    public void work(BookList bookList) {
        System.out.println("退出系统");
    }
}