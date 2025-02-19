package myTests;

import base.TestsBase;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class DynamicID extends TestsBase {

    private By button = By.xpath("//button[contains(., 'Button')]");

    @Test
    public void testDynamicId(){
        clickLink("Dynamic ID");
        wait.until(ExpectedConditions.visibilityOf(driver.findElement(button)));
        assertEquals("Button with Dynamic ID", driver.findElement(button).getText(), "The text of the button doesn't match.");
    }

}
