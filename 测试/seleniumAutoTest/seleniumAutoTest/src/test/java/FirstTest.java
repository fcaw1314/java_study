import io.github.bonigarcia.wdm.WebDriverManager;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.List;
import java.util.Set;

/**
 * @author yxb
 * @version 1.0
 * @description:
 * @date 2024/7/18 16:43
 */
public class FirstTest {
    WebDriver driver = null;

    void createDriver() {
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

        //获取百度一下按钮上的文本
//        String txt = driver.findElement(By.cssSelector("#su")).getAttribute("value");
//        System.out.println("百度一下上的按钮文字是:" + txt);

//        String title = driver.getTitle();
//        String url = driver.getCurrentUrl();
//        System.out.println("title = " + title);
//        System.out.println("url = " + url);

        //设置窗口大小
//        driver.manage().window().minimize();//最小化
//        Thread.sleep(3000);
//
//        driver.manage().window().maximize();//最大化
//        Thread.sleep(3000);
//
//        driver.manage().window().fullscreen();//全屏
//        Thread.sleep(3000);
//
//        driver.manage().window().setSize(new Dimension(1624,724));//设置大小
//        Thread.sleep(3000);


//        System.out.println("跳转之后: "+ driver.getTitle());
//        //点击新闻
//        driver.findElement(By.cssSelector("#s-top-left > a:nth-child(1)")).click();
//        Thread.sleep(1000);
//
//        System.out.println("跳转之后: "+ driver.getTitle());
//        //测试百度新闻首页
//        driver.findElement(By.cssSelector("#headline-tabs > ul > li > a"));
//        Thread.sleep(3000);

        driver.quit();
    }

    //进阶版本的屏幕截图
    void getScreenShot(String str) throws IOException {
        //  ./src/test/image/
        //                  /2024-7-31/
        //                             test01-153255.png
        //                             test01-153256.png
        //屏幕截图
        SimpleDateFormat sim1 = new SimpleDateFormat("yyyy-MM-dd");
        SimpleDateFormat sim2 = new SimpleDateFormat("HHmmssSS");

        String dirTime = sim1.format(System.currentTimeMillis());
        String fileTime = sim2.format(System.currentTimeMillis());

        //./src/test/image/2024-7-31/test01-153255.png
        String filename = "./src/test/image/" + dirTime + "/" + str + "-" + fileTime + ".png";
        System.out.println("filename: " + filename);
        File srcFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
        //srcFile放到指定位置
        FileUtils.copyFile(srcFile, new File(filename));
    }

    void test04() throws InterruptedException, IOException {
        createDriver();
        //设置窗口大小
//        driver.manage().window().minimize();//最小化
//        Thread.sleep(3000);
//
//        driver.manage().window().maximize();//最大化
//        Thread.sleep(3000);
//
//        driver.manage().window().fullscreen();//全屏
//        Thread.sleep(3000);
//
//        driver.manage().window().setSize(new Dimension(1624,724));//设置大小
//        Thread.sleep(3000);


        //点击新闻
        getScreenShot(getClass().getName());

        driver.findElement(By.cssSelector("#s-top-left > a:nth-child(1)")).click();

        String curHandle = driver.getWindowHandle();

        Set<String> allHandle = driver.getWindowHandles();
//        Thread.sleep(3000);
        for (String handle : allHandle) {
            if (handle != curHandle) {
                //切换driver--百度新闻
                driver.switchTo().window(handle);
            }
        }
//        Thread.sleep(3000);

        //测试百度新闻首页
        //屏幕截图

        //屏幕截图
//        File srcFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
//        //srcFile放到指定位置
//        FileUtils.copyFile(srcFile, new File("my.png"));

        getScreenShot(getClass().getName());

        driver.findElement(By.cssSelector("#headline-tabs > ul > li > a"));
        driver.quit();
    }

    void test05() {
        createDriver();
        driver.findElement(By.cssSelector("#kw")).sendKeys("迪丽热巴");
        driver.findElement(By.cssSelector("su")).click();

//        driver.quit();
    }

    void test09() {
        createDriver();
        //隐式等待设置为5s，显⽰等待设置为10s，那么结果会是5+10=15s吗？
        SimpleDateFormat sim = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        System.out.println(sim.format(System.currentTimeMillis()));

        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        try {

            wait.until(ExpectedConditions.presenceOfElementLocated(By.cssSelector("#hotsearch-content-wrapper > li:nth-child(1) > a > span.title-content")));
        } catch (Exception e) {
            System.out.println("nosuelement!");
        }
        System.out.println(sim.format(System.currentTimeMillis()));
        driver.quit();
    }
}


























