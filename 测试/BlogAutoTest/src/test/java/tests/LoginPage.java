package tests;

import common.Utils;
import org.junit.jupiter.api.Timeout;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;

import java.io.IOException;

/**
 * @author yxb
 * @version 1.0
 * @description:
 * @date 2024/8/3 8:29
 */
public class LoginPage extends Utils {

    public static String url = "http://8.137.19.140:9090/blog_login.html";

    public LoginPage() {
        super(url);
    }

    public void loginPageRight() throws InterruptedException {
        //通过查看页面元素是否存在来检查页面加载成功与否
        driver.findElement(By.cssSelector("body > div.nav > a:nth-child(4)"));
        //登陆输入框
        driver.findElement(By.cssSelector("body > div.container-login > div > div:nth-child(2)"));
    }

    //检查登录功能---成功登录
    public void LoginSuc() throws IOException {
        //方法一:  通过clear保证输入框没有信息
        driver.findElement(By.cssSelector("#username")).clear();
        driver.findElement(By.cssSelector("#password")).clear();

        driver.findElement(By.cssSelector("#username")).sendKeys("zhangsan");
        driver.findElement(By.cssSelector("#password")).sendKeys("123456");
        driver.findElement(By.cssSelector("#submit")).click();
        //检查点击登陆之后是否登陆成功
        driver.findElement(By.cssSelector("body > div.container > div.right > div:nth-child(1) > a"));
        //页面标题来检查是否登陆成功
        String expect = driver.getTitle();
        assert expect.equals("博客列表页");

        getScreenShot(getClass().getName());
        driver.navigate().back();
    }

    //检查登陆功能---登陆失败
    public void LoginFail() throws InterruptedException, IOException {
        //方法一:  通过clear保证输入框没有信息
//        driver.findElement(By.cssSelector("#username")).clear();
//        driver.findElement(By.cssSelector("#password")).clear();

        //方法二: 通过刷新保证输入框没有文本
        driver.navigate().refresh();

        driver.findElement(By.cssSelector("#username")).sendKeys("zhangsan");
        driver.findElement(By.cssSelector("#password")).sendKeys("1234561111");
        driver.findElement(By.cssSelector("#submit")).click();

        //处理警告弹窗
        Thread.sleep(1000);
        Alert alert = driver.switchTo().alert();
        String res = alert.getText();
        alert.accept();

        getScreenShot(getClass().getName());

        assert res.equals("密码错误");

//        driver.quit();
    }
}
