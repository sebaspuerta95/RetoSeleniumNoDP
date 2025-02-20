package myTests;

import base.TestsBase;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class VerifyText extends TestsBase {

    @Test
    public void testVerifyText(){
        clickLink("Verify Text");

        WebElement textBox = driver.findElement(By.xpath("//span[contains(normalize-space(.), 'Welcome') and contains(normalize-space(.), 'UserName!')]"));

        assertEquals("Welcome UserName!", textBox.getText(), "The text doesn't match.");

    }

}
