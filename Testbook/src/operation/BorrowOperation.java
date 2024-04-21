package operation;

import book.Book;
import book.BookList;

import java.util.Scanner;

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
        //1.你要借哪本书
        Scanner scanner = new Scanner(System.in);
        System.out.println("输入你想要借的书名");
        String name = scanner.nextLine();
        int currentSize = bookList.getUsedSize();
        for (int i = 0; i < currentSize; i++) {
            Book book = bookList.getBook(i);
            if(book.getName().equals(name)){
                book.setBorrowed(true);
                System.out.println("借阅成功");
                System.out.println(book);
                return;
            }
        }
        System.out.println("你借阅的图书不存在");
    }

}