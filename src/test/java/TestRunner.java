import com.hillel.core.CommonMethods;
import com.hillel.core.driver.WebDriverFactory;
import com.hillel.util.ConfigProvider;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import static com.hillel.util.WaitUtils.waitUntilElementIsClickable;
import static com.hillel.util.WaitUtils.waitUntilTextToBePresentInElement;



public class TestRunner {

    public static void main(String[] args){
       WebDriver driver = WebDriverFactory.getDriver();
        driver.get(ConfigProvider.BASE_URL);
        CommonMethods commonMethods = new CommonMethods();
        commonMethods.NavigateTo("//div[2]/div/ul/li[1]/div/ul/li[3]/a[contains(@href,'ithillel.ua/courses/qa-automation')]");
        commonMethods.WaitFor("//span[@class='course-descriptor_course-text']");
        commonMethods.BackToHomePage("//a[@class='site-logo-link']");
        commonMethods.NavigateToProgramming("//a[contains(@href,'ithillel.ua/courses/programming')]");
        driver.quit();
    }

}