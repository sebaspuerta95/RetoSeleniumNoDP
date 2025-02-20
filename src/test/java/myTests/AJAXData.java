package myTests;

import base.TestsBase;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;

import java.time.Duration;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class AJAXData extends TestsBase {

    private By ajaxButton = By.id("ajaxButton");
    private By successBox = By.cssSelector("p[class='bg-success']");

    @Test
    public void testAjaxData(){
        clickLink("AJAX Data");
        driver.findElement(ajaxButton).click();

        FluentWait fluentWait = new FluentWait(driver)
                .withTimeout(Duration.ofSeconds(20))
                        .pollingEvery(Duration.ofSeconds(5))
                                .ignoring(NoSuchElementException.class)
                                        .withMessage("The web element wasn't found.");
        fluentWait.until(ExpectedConditions.visibilityOfElementLocated(successBox));

        assertEquals("Data loaded with AJAX get request.", driver.findElement(successBox).getText()
                , "The data was not loaded with AJAX get request.");

    }

}
