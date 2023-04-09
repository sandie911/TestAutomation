package steps;

import com.hillel.core.driver.WebDriverFactory;
import org.openqa.selenium.WebDriver;

public class BaseUiTest {
    protected final WebDriver driver = WebDriverFactory.getDriver();
}
