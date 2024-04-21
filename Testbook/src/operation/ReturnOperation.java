package operation;

import book.Book;
import book.BookList;

import java.util.Scanner;

/**
 * @ProjectName: Testbook
 * @Package: operation
 * @ClassName: ReturnOperation
 * @author: Yxb
 * @Description:
 * @Date: 2024/4/20 15:07
 * @Version: 1.0
 */
public class ReturnOperation implements IOPeration{

    @Override
    public void work(BookList bookList) {
        System.out.println("归还图书");
        Scanner scanner = new Scanner(System.in);
        System.out.println("输入你想要归还的书名");
        String name = scanner.nextLine();
        int currentSize = bookList.getUsedSize();
        for (int i = 0; i < currentSize; i++) {
            Book book = bookList.getBook(i);
            if(book.getName().equals(name)){
                book.setBorrowed(false);
                System.out.println("归还成功");
                System.out.println(book);
                return;
            }
        }
        System.out.println("你归还的图书不存在");
    }


}