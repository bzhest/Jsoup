

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.concurrent.TimeUnit;

import static org.testng.Assert.fail;

/**
 * Created by SYSTEM on 17.01.2017.
 */
public class WebDriverBase {

    public  WebDriver driver;
    public String baseUrl;
    public WebDriverWait wait;

    public StringBuffer verificationErrors = new StringBuffer();


    public WebDriverBase(){

        System.setProperty("webdriver.chrome.driver", "E://Selenium_Drivers/chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        //Подождать 30 сек появления какого-то элемента
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
        baseUrl = "http://www.solomia.andreyb.ixloo.com/";
        wait = new WebDriverWait(driver,15);
        driver.get("http://www.solomia.andreyb.ixloo.com/");

    }

    public void stop(){
        driver.quit();
        String verificationErrorString = verificationErrors.toString();
        if (!"".equals(verificationErrorString)) {
            fail(verificationErrorString);
        }
    }

    public WebDriver getDriver(){
        return driver;
    }
}
