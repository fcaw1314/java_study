package common;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.time.Duration;

/**
 * @author yxb
 * @version 1.0
 * @description:
 * @date 2024/8/2 23:41
 */
public class Utils {

    public static WebDriver driver;

    public static WebDriver createDriver(){
        if(driver == null){
            WebDriverManager.chromedriver().setup();
            ChromeOptions options = new ChromeOptions();
            //允许访问所以的链接
            options.addArguments("--remote-allow-origins=*");

            driver = new ChromeDriver(options);

            //隐士等待
            driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(2));
        }
        return driver;
    }

    public Utils(String url) {
        //调用driver对象
        driver = createDriver();
        //访问url
        driver.get(url);
    }

    //进阶版本的屏幕截图
    public void getScreenShot(String str) throws IOException {
        //  ./src/test/image/
        //                  /2024-7-31/
        //                             test01-153255114.png
        //                             test01-153255456.png
        //屏幕截图
        SimpleDateFormat sim1 = new SimpleDateFormat("yyyy-MM-dd");
        SimpleDateFormat sim2 = new SimpleDateFormat("HHmmssSS");

        String dirTime = sim1.format(System.currentTimeMillis());
        String fileTime = sim2.format(System.currentTimeMillis());

        //./src/test/image/2024-7-31/test01-153255.png
        String filename = "./src/test/image/" + dirTime + "/" + str + "-" + fileTime + ".png";

        File srcFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
        //srcFile放到指定位置
        FileUtils.copyFile(srcFile, new File(filename));
    }
}
