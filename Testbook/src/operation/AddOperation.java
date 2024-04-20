package operation;

import book.BookList;

/**
 * @ProjectName: Testbook
 * @Package: operation
 * @ClassName: AddOperation
 * @author: Yxb
 * @Description:
 * @Date: 2024/4/20 15:06
 * @Version: 1.0
 */
public class AddOperation implements IOPeration{

    @Override
    public void work(BookList bookList) {
        System.out.println("新增图书");
    }
}