package myTests;

import base.TestsBase;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import static org.junit.jupiter.api.Assertions.*;

public class SampleAppTest extends TestsBase {

    private By loginStatusTag = By.xpath("//label[@id='loginstatus']");
    private By usernameField = By.xpath("//input[@type='text']");
    private By passField = By.xpath("//input[@type='password']");
    private By button = By.xpath("//button[@id='login']");

    @Test
    public void testSampleApp(){
        clickLink("Sample App");

        String usernameId = driver.findElement(usernameField).getAttribute("id");
        String passwordId = driver.findElement(passField).getAttribute("id");

        driver.navigate().refresh();

        String newUsernameId = driver.findElement(usernameField).getAttribute("id");
        String newPasswordId = driver.findElement(passField).getAttribute("id");

        assertFalse(usernameId.equals(newUsernameId), "The ID of the username field didn't change dynamically.");
        assertFalse(passwordId.equals(newPasswordId), "The ID of the password field didn't change dynamically.");

    }

}
