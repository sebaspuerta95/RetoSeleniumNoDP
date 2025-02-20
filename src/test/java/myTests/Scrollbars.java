package myTests;

import base.TestsBase;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class Scrollbars extends TestsBase {

    @Test
    public void testScrollbars(){
        clickLink("Scrollbars");

        WebElement hiddenButton = driver.findElement(By.xpath("//button[@id]"));

        String script = "arguments[0].scrollIntoView();";
        ((JavascriptExecutor) driver).executeScript(script, hiddenButton);

        assertTrue(hiddenButton.isDisplayed(), "Button should be visible after scrolling");

    }

}
