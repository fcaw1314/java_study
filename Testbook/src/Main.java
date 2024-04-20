import book.BookList;
import user.AdminUser;
import user.NormalUser;
import user.User;

import java.util.Scanner;

/**
 * @ProjectName: Testbook
 * @Package: PACKAGE_NAME
 * @ClassName: Main
 * @author: Yxb
 * @Description:
 * @Date: 2024/4/20 15:23
 * @Version: 1.0
 */
public class Main {

    public static User login() {
        System.out.println("请输入你的姓名");
        Scanner scanner = new Scanner(System.in);
        String name = scanner.nextLine();
        System.out.println("请输入你的 身份， 1：管理员  2：普通用户");
        int choice = scanner.nextInt();

        if (choice == 1) {
            //管理员
            return new AdminUser(name);
        } else {
            //普通用户
            return new NormalUser(name);
        }
    }

    public static void main(String[] args) {
        BookList bookList = new BookList();
        User user = login();
        while (true) {
            int choice = user.menu();
            System.out.println("choice : " + choice);

            //根据choice   的选择   来决定调用的是哪个方法

            user.doOperation(choice, bookList);
        }
    }
}