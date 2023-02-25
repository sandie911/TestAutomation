package com.hillel.core;
import com.hillel.page.HomePage;

import com.hillel.core.driver.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import static com.hillel.util.WaitUtils.waitUntilElementIsClickable;
import static com.hillel.util.WaitUtils.waitUntilTextToBePresentInElement;
import static com.hillel.util.WaitUtils.waitUntilPresenceOfElementLocated;
import static com.hillel.util.WaitUtils.waitUntilTextToBePresentInElementAndClickable;

public class CommonMethods  {
    WebDriver driver = WebDriverFactory.getDriver();

    public WebElement FindElementByPath (String path)
    {
        WebElement coursesTesting = driver.findElement(By.xpath(path));
        return coursesTesting;
    }

    public void NavigateTo(String path )
    {
    WebElement coursesTesting = FindElementByPath(path);
    waitUntilElementIsClickable(driver, coursesTesting);
    coursesTesting.click();

    }

    public void WaitFor(String path)
    {
        WebElement coursesPageTitle = FindElementByPath(path);
        waitUntilTextToBePresentInElement(driver,coursesPageTitle);
      }


    public void BackToHomePage(String path)
    {
      WebElement basePage = FindElementByPath(path);
      waitUntilPresenceOfElementLocated(driver, basePage);
      basePage.click();
    }

    public void NavigateToProgramming(String path)
    {
        WebElement programming = FindElementByPath(path);
        waitUntilTextToBePresentInElementAndClickable(driver, programming,"Програмування");
        programming.click();

    }

}
