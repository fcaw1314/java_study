package operation;

import book.BookList;

/**
 * @ProjectName: Testbook
 * @Package: operation
 * @ClassName: FindOperation
 * @author: Yxb
 * @Description:
 * @Date: 2024/4/20 15:05
 * @Version: 1.0
 */
public class FindOperation implements IOPeration{
    @Override
    public void work(BookList bookList) {
        System.out.println("查找图书");
    }
}