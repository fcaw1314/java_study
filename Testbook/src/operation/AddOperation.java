package operation;

import book.Book;
import book.BookList;

import java.util.Scanner;

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
        Scanner scanner = new Scanner(System.in);

        System.out.println("请输入你要添加的书名：");
        String name = scanner.nextLine();

        System.out.println("请输入的作者");
        String author = scanner.nextLine();

        System.out.println("请输入类型：");
        String type = scanner.nextLine();

        System.out.println("请输入价格：");
        int price = scanner.nextInt();


        Book book = new Book(name,author,price,type);

        //检查数组当中 有没有这本书

        int currentSize = bookList.getUsedSize();
        for (int i = 0; i < currentSize; i++) {
            Book book1 = bookList.getBook(i);
            if(book1.getName().equals(name)){
                System.out.println("有这本书，不进行存放");
                return;
            }
        }
        if(currentSize == bookList.getBooks().length){
            System.out.println("书架满了");
        }else {
            bookList.setBook(currentSize,book);
            bookList.setUsedSize(currentSize+1);
        }


    }
}