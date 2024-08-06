package tests;

import common.Utils;
import org.openqa.selenium.By;

import java.io.IOException;

/**
 * @author yxb
 * @version 1.0
 * @description:
 * @date 2024/8/3 8:32
 */
public class ListPage extends Utils {

    public static String url = "http://8.137.19.140:9090/blog_list.html";

    public ListPage() {
        super(url);
    }

    //未登录状态下---访问列表页
    //注意前面登陆用例下,登陆状态已经保存下来了
    //方法一:
    public void ListNoLogin() throws IOException {
        //保证未登录状态下
        driver.findElement(By.cssSelector("body > div.nav > a:nth-child(6)")).click();
//        driver.get(url);

        String expect = driver.getTitle();
        assert expect.equals("博客登陆页");
        getScreenShot(getClass().getName());

        driver.quit();
    }

    public void ListByLogin(){
        //登陆状态

    }

}
