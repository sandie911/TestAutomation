import com.hillel.core.driver.WebDriverFactory;
import com.hillel.util.ConfigProvider;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;



public class TestRunner {
    public static void main(String[] args){
       WebDriver driver = WebDriverFactory.getDriver();
        driver.get(ConfigProvider.BASE_URL);
        WebDriverWait wait= new WebDriverWait(driver, 10);
        WebElement coursesTesting = driver.findElement(By.xpath("//a[contains(@href,'ithillel.ua/courses/testing')]"));
        wait.until(ExpectedConditions.elementToBeClickable(coursesTesting));
        coursesTesting.click();
        WebElement coursesPageTitle = driver.findElement(By.className("block-profession_title"));
        wait.until(ExpectedConditions.textToBePresentInElement(coursesPageTitle,"Професія QA engineer"));
        driver.quit();
    }
}
