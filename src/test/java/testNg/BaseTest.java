package testNg;

import com.hillel.core.driver.WebDriverFactory;
import lombok.extern.log4j.Log4j2;
import org.openqa.selenium.WebDriver;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;

import java.lang.reflect.Method;

@Log4j2
public class BaseTest {
    protected static WebDriver driver;

    @BeforeTest
    public static void beforeClass() {
        driver = WebDriverFactory.getDriver();
    }

    @BeforeMethod
    public void testStartedLog(Method method){
        log.info(String.format("Test %s started", method.getName()));
    }
    @AfterMethod
    public void testFinishedLog(ITestResult result) {
        log.info(String.format("Test %s finished with result %s", result.getName(), result.isSuccess() ? "SUCCESS" : "FAIL"));
    }
    @AfterTest
    public static void afterClass() {
        driver.quit();
    }
}

