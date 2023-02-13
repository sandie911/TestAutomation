package com.hillel.page;

import com.hillel.util.ConfigProvider;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import static com.hillel.util.WaitUtils.waitUntilElementIsVisible;

public class HomePage extends BasePage {
    @FindBy(xpath = "//div[@class='section-content']")
    private String title;
    private String testingBtn = "//a[@href='https://ithillel.ua/courses/testing']";

    public HomePage(WebDriver driver){
        super(driver);
        PageFactory.initElements(driver, this);
    }
    @Override
    public void open() {
        super.driver.get(ConfigProvider.BASE_URL);
        ensureOpened();
    }

    @Override
    public void ensureOpened() {
        WebElement logo = super.driver.findElement(By.xpath(title));
        waitUntilElementIsVisible(super.driver, logo);

    }


}
