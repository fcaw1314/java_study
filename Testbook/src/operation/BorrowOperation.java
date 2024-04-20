package operation;

import book.BookList;

/**
 * @ProjectName: Testbook
 * @Package: operation
 * @ClassName: BorrowOperation
 * @author: Yxb
 * @Description:
 * @Date: 2024/4/20 15:07
 * @Version: 1.0
 */
public class BorrowOperation implements IOPeration{
    @Override
    public void work(BookList bookList) {
        System.out.println("借阅图书");
    }
}