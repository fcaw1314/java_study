import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import java.util.List;

/**
 * @author yxb
 * @version 1.0
 * @description:
 * @date 2024/7/18 16:43
 */
public class FirstTest {
    WebDriver driver = null;

    void createDriver(){
        //1. 打开浏览器 使用驱动来打开
        WebDriverManager.chromedriver().setup();
        //增加浏览器配置：创建驱动对象要强制指定允许访问所有的链接
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--remote-allow-origins=*");

        driver = new ChromeDriver(options);
        driver.get("https://www.baidu.com");
    }

    //测试百度搜索关键词；迪丽热巴
    void test01() throws InterruptedException {

        createDriver();

        //2. 输入完整的网址：https://www.baidu.com

        Thread.sleep(3000);

        //3. 找到输入框，并输入关键词：迪丽热巴
        driver.findElement(By.cssSelector("#kw")).sendKeys("迪丽热巴");
        Thread.sleep(3000);

        //4. 找到百度一下按钮，并点击
        driver.findElement(By.cssSelector("#su")).click();
        Thread.sleep(3000);

        //5. 关闭浏览器
        driver.quit();
    }

    //元素的定位
    void test02() throws InterruptedException {
        //选择器
        createDriver();
        driver.findElement(By.cssSelector("#s-hotsearch-wrapper > div"));
        driver.findElement(By.xpath("//*[@id=\"s-hotsearch-wrapper\"]/div"));
        List<WebElement> ll = driver.findElements(By.cssSelector("#hotsearch-content-wrapper > li > a > span.title-content-title"));
        for (int i = 0; i < 6; i++) {
            //获取元素 Ele对应的文本信息
            System.out.println(ll.get(i).getText());
        }

        driver.quit();
    }

    //操作元素
    void test03() throws InterruptedException {
        createDriver();
//        WebElement ele = driver.findElement(By.cssSelector("#su"));
//        ele.click();

        //不可点击元素/隐藏元素
//        driver.findElement(By.cssSelector("#form > input[type=hidden]:nth-child(1)")).click();

//        WebElement ele = driver.findElement(By.cssSelector("#kw"));
//        ele.sendKeys("java110期和java111期");
//        Thread.sleep(2000);
//        ele.clear();
//        Thread.sleep(2000);
//        ele.sendKeys("杨晓波");
//        Thread.sleep(2000);

//        WebElement ele = driver.findElement(By.cssSelector("#hotsearch-content-wrapper > li:nth-child(2) > a > span.title-content-title"));
//        //获取元素对应的文本信息---第二个热搜
//        System.out.println(ele.getText());



        driver.quit();
    }
}


























