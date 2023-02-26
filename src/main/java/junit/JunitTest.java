package junit;

import com.hillel.page.HomePage;
import org.junit.jupiter.api.Assertions;
import com.hillel.page.BlogPage;
import java.util.stream.Stream;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

public class JunitTest extends BaseTest {
    @ParameterizedTest
    @MethodSource("provideStringsForCommonNews")
    public void firstJunitTest(String xpath, int expected) {
        HomePage homePage = new HomePage(driver);
        BlogPage blogPage = new BlogPage(driver);
        homePage.open();
        homePage.navigateToBlog();
        blogPage.navigateToBlogPublications(xpath);
        Assertions.assertEquals(expected, blogPage.getCommonNewsSize(), "");
    }

    private static Stream<Arguments> provideStringsForCommonNews() {
        return Stream.of(
                Arguments.of("gamedev", 5),
                Arguments.of("frontend", 9),
                Arguments.of("qa", 9)
        );
    }
}
