package steps;

import com.hillel.util.WaitUtils;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

public class CertificateProjectSteps extends BaseUiTest {
    @Given("I open {} page")
    public void goToCertificatePage(String p) {
        String site = "https://certificate.ithillel.ua/";
        driver.navigate().to(site);
    }

    @When("I entered the invalid data {string} in the field {string}")
    public void i_entered_the_invalid_data_in_the_field(String data, String field) {
        // Write code here that turns the phrase above into concrete actions
        driver.findElement(By.xpath("//input[@class='input -text certificate-check_input']"))
                .sendKeys(data);
        driver.findElement(By.xpath("//button[@class='btn btn-submit -submit certificate-check_submit']")).click();
    }
    @Then("Then the output should be {string}")
    public void then_the_output_should_be(String output) throws InterruptedException {
        // Write code here that turns the phrase above into concrete actions
        WebElement element = driver.findElement(By.xpath("//p[@class='certificate-check_message']"));
        WaitUtils.waitUntilElementIsVisible(driver, element);
        String message = element.getText();
        Assert.assertEquals(message, output);

    }

}
