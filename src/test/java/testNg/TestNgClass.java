package testNg;
import com.hillel.core.data.DataProviderMethods;
import com.hillel.page.BlogPage;
import com.hillel.page.HomePage;
import org.junit.jupiter.api.Assertions;
import org.testng.Assert;
import org.testng.annotations.Test;

public class TestNgClass extends BaseTest{

    @Test
    public void testNgCourseCategories() {
        HomePage homePage = new HomePage(driver);
        homePage.open();

        Assert.assertEquals(homePage.getCourseCategories().size(), 7,"Incorrect number of course");
    }
    @Test(dataProvider = "provideStringsForCommonNews", dataProviderClass = DataProviderMethods.class)
    public void testNgCommonNews(String xpath, int expected) {
        HomePage homePage = new HomePage(driver);
        BlogPage blogPage = new BlogPage(driver);
        homePage.open();
        homePage.navigateToBlog();
        blogPage.navigateToBlogPublications(xpath);
        Assertions.assertEquals(expected, blogPage.getCommonNewsSize(), "");
    }

    }

