import tests.ListPage;
import tests.LoginPage;

import java.io.IOException;

/**
 * @author yxb
 * @version 1.0
 * @description:
 * @date 2024/8/3 8:37
 */
public class RunTests {
    public static void main(String[] args) throws InterruptedException, IOException {
        LoginPage login = new LoginPage();
        login.loginPageRight();
        login.LoginSuc();
        login.LoginFail();

        ListPage listPage = new ListPage();
        listPage.ListNoLogin();
    }
}
