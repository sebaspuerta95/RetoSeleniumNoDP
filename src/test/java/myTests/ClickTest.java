package myTests;

import base.TestsBase;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class ClickTest extends TestsBase {

    @Test
    public void testClick(){
        clickLink("Click");

        WebElement button = driver.findElement(By.id("badButton"));
        Actions actions = new Actions(driver);
        actions.moveToElement(button).click().perform();actions.moveToElement(button).click().perform();

        assertEquals("btn btn-success", button.getAttribute("class"), "The class is incorrect.");

    }

}
