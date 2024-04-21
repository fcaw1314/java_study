package operation;

import book.Book;
import book.BookList;

import java.util.Scanner;

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
        Scanner scanner = new Scanner(System.in);
        String name = scanner.nextLine();
        int currrentSize = bookList.getUsedSize();
        for (int i = 0; i < currrentSize; i++) {
            Book book = bookList.getBook(i);
            if(book.getName().equals(name)){
                System.out.println("找到了这本书！信息如下：");
                System.out.println(book);
                return ;
            }
        }
        System.out.println("没有找到这本书！！");
    }
}