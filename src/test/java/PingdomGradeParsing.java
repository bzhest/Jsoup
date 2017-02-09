import java.io.IOException;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;


public class PingdomGradeParsing extends WebDriverBase {

    public  static WebDriver driver;
    public static void main(String[] args) throws IOException {
        Document doc = Jsoup.connect("http://tools.pingdom.com").get();
        InputSiteInPingdom("#urlinput", "www.kenworthnorthwest.com/");
        driver.findElement(By.cssSelector(".button.button-big.button-green.button-starttest")).click();
        WebElement performanceGradeGroup = driver.findElements(By.cssSelector(".rbc-summary-info-value")).get(0);
        String letter = performanceGradeGroup.getCssValue("span");
        System.out.println(letter);
        /*Elements inputElements = loginform.getElementsByTag("input");
        for (Element inputElement : inputElements) {
            String key = inputElement.attr("name");
            String value = inputElement.attr("value");
            System.out.println("Param name: "+key+" \nParam value: "+value);
        }*/

        /*Document doc = Jsoup.connect("http://www.jsoup.org/").get();
        Elements links = doc.select("a");
        for (Element link:links){
            System.out.println(link.attr("abs:href"));
        }*/
    }

    public static void InputSiteInPingdom(String selector, String website) {
        driver.findElement(By.cssSelector(selector)).clear();
        driver.findElement(By.cssSelector(selector)).sendKeys(website);
    }
}