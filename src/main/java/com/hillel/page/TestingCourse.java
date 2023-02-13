package com.hillel.page;

import com.hillel.util.ConfigProvider;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import static com.hillel.util.WaitUtils.waitUntilElementIsVisible;

public class TestingCourse extends BasePage {
    @FindBy(xpath = "//span[@class='course-descriptor_course-text']")
    private String titleQA;
    private String courseTitlePath = "//span[@class='course-descriptor_course-text']";
    private String courseRatePath = "//span[@class='course-rating_average']";
    public TestingCourse(WebDriver driver){
        super(driver);
        PageFactory.initElements(driver, this);
    }

    public String getCourseTitle() {
        WebElement courseTitle = super.driver.findElement(By.xpath(courseTitlePath));
        return courseTitle.getText();
    }

    public String getCourseRate() {
        WebElement courseRate = super.driver.findElement(By.xpath(courseRatePath));
        return courseRate.getText();
    }
    @Override
    public void open() {
        super.driver.get(ConfigProvider.BASE_URL + "/courses/qa-automation");
        ensureOpened();
    }

    @Override
    public void ensureOpened() {
        WebElement logo = super.driver.findElement(By.xpath(titleQA));
        waitUntilElementIsVisible(super.driver, logo);

    }
}
