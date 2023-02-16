import com.hillel.core.CommonMethods;
import com.hillel.core.driver.WebDriverFactory;
import com.hillel.page.HomePage;
import com.hillel.page.QAAutomation;
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
        HomePage homePage = new HomePage(driver);
        QAAutomation qaAutomation = new QAAutomation();
        homePage.navigateToQA();
        qaAutomation.waitFor();
        qaAutomation.backToHomePage();
        homePage.navigateToProgramming();
        driver.quit();
    }

}