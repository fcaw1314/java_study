package user;

import book.BookList;
import operation.IOPeration;

/**
 * @ProjectName: Testbook
 * @Package: user
 * @ClassName: User
 * @author: Yxb
 * @Description:
 * @Date: 2024/4/20 15:16
 * @Version: 1.0
 */
public abstract class User {

    protected String name;

    protected IOPeration[] ioPerations;

    public User(String name) {
        this.name = name;
    }

    public abstract int menu();

    public void doOperation(int choice, BookList bookList) {
        ioPerations[choice].work(bookList);
    }
}