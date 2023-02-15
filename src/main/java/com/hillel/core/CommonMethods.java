package com.hillel.core;


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
    public void NavigateTo(String path) {
    WebElement coursesTesting = driver.findElement(By.xpath(path));
    waitUntilElementIsClickable(driver, coursesTesting);
    coursesTesting.click();

    }
    public void WaitFor(String path){
        WebElement coursesPageTitle = driver.findElement(By.xpath(path));
        waitUntilTextToBePresentInElement(driver,coursesPageTitle);
      }
    public void BackToHomePage(String path){
      WebElement basePage = driver.findElement(By.xpath(path));
      waitUntilPresenceOfElementLocated(driver, basePage);
      basePage.click();
    }
    public void NavigateToProgramming(String path) {
        WebElement programming = driver.findElement(By.xpath(path));
        waitUntilTextToBePresentInElementAndClickable(driver, programming,"Програмування");
        programming.click();

    }
}
