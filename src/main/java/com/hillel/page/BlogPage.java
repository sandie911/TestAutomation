package com.hillel.page;


import com.hillel.util.ConfigProvider;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import java.util.List;
import static com.hillel.util.WaitUtils.waitUntilElementIsClickable;

public class BlogPage extends BasePage {


    @FindBy(xpath ="//ul[@class='posts_list post-list']/li")
    private List<WebElement> commonNews;


    public BlogPage(WebDriver driver){
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

    }
    public void navigateToBlogPublications(String publicationName)
    {
        String xpath = String.format("//section[2]//li//a[contains(@href, '/publications/%s')]", publicationName);
        WebElement link = driver.findElement(By.xpath(xpath));
        waitUntilElementIsClickable(driver, link);
        link.click();
    }
    public int getCommonNewsSize(){
        return commonNews.size();
    }
}
