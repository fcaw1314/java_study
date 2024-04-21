package operation;

import book.Book;
import book.BookList;

import java.util.Scanner;

/**
 * @ProjectName: Testbook
 * @Package: operation
 * @ClassName: DelOperation
 * @author: Yxb
 * @Description:
 * @Date: 2024/4/20 15:06
 * @Version: 1.0
 */
public class DelOperation implements IOPeration {
    @Override
    public void work(BookList bookList) {
        System.out.println("删除图书");

        //1.找到这本书
        Scanner scanner = new Scanner(System.in);
        System.out.println("输入你想要删除书的名字");
        String name = scanner.nextLine();

        int pos = -1;

        int currentSize = bookList.getUsedSize();
        int i = 0;
        for (; i < currentSize; i++) {
            Book book = bookList.getBook(i);
            if (book.getName().equals(name)) {
                pos = i;
                break;
            }
        }
        if (i == currentSize) {
            System.out.println("没有你要删除的图书！");
        }
        //开始删除
        int j = pos;
        for (; j < currentSize - 1; j++) {
            //[j] = [j+1]
            Book book = bookList.getBook(j + 1);
            bookList.setBook(j, book);
        }
        bookList.setBook(j, null);
        bookList.setUsedSize(currentSize - 1);

    }
}