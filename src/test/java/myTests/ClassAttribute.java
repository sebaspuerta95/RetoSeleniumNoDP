package myTests;

import base.TestsBase;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class ClassAttribute extends TestsBase {

    private By primaryButton = By.xpath("//button[contains(@class, 'btn-primary')]");

    @Test
    public void testClassAttribute(){
        clickLink("Class Attribute");
        wait.until(ExpectedConditions.visibilityOf(driver.findElement(primaryButton)));
        driver.findElement(primaryButton).click();
        assertEquals("Primary button pressed", driver.switchTo().alert().getText(),
                "Incorrect button message");
        driver.switchTo().alert().accept();
    }

}
