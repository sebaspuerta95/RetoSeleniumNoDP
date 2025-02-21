package myTests;

import base.TestsBase;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class NonBreakingSpace extends TestsBase {

    @Test
    public void testNonBreakingSpace(){
        clickLink("Non-Breaking Space");

        WebElement button = driver.findElement(By.xpath("//button[contains(normalize-space(.), 'My') and contains(normalize-space(.), 'Button')]"));

        assertEquals("My Button", button.getText(), "The text of the button is not correct.");

    }

}
