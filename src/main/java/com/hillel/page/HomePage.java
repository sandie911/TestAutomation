package com.hillel.page;

import com.hillel.core.CommonMethods;
import com.hillel.util.ConfigProvider;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;
import java.util.stream.Collectors;

import static com.hillel.util.WaitUtils.waitUntilElementIsClickable;
import static com.hillel.util.WaitUtils.waitUntilElementIsVisible;

public class HomePage extends BasePage {
    CommonMethods commonMethods = new CommonMethods();
    @FindBy(xpath = "//div[@class='section-content']")
    private String title;
    private String testingBtn = "//a[@href='https://ithillel.ua/courses/testing']";

    @FindBy(xpath = "//nav/ul/li[4]/a[contains(@href, '/blog.ithillel.ua')]")
    private WebElement blog;


    @FindBy(xpath = "//ul[@class='block-course-cats_list']/li")
    private List<WebElement> courseCategories;



    public HomePage(WebDriver driver){
        super(driver);
        PageFactory.initElements(driver, this);
    }
    public List<WebElement> getCourseCategories() {
        return courseCategories;
    }

    @Override
    public void open() {
        super.driver.get(ConfigProvider.BASE_URL);
        ensureOpened();
    }

    @Override
    public void ensureOpened() {


    }
    public void navigateToQA(){
        commonMethods.NavigateTo("//section[2]//li[3]//a[contains(@href,'ithillel.ua/courses/qa-automation')]");
    }
    public void navigateToProgramming(){
        commonMethods.NavigateToProgramming("//a[contains(@href,'ithillel.ua/courses/programming')]");
    }

    public void navigateToBlog()
    {
        waitUntilElementIsClickable(driver, blog);
        blog.click();

    }
}
