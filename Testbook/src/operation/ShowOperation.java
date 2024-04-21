package operation;

import book.Book;
import book.BookList;

/**
 * @ProjectName: Testbook
 * @Package: operation
 * @ClassName: ShowOperation
 * @author: Yxb
 * @Description:
 * @Date: 2024/4/20 15:06
 * @Version: 1.0
 */
public class ShowOperation implements IOPeration{
    @Override
    public void work(BookList bookList) {
        System.out.println("显示图书");
        for (int i = 0; i < bookList.getUsedSize(); i++) {
            Book book = bookList.getBook(i);
            System.out.println(book);
        }
    }
}