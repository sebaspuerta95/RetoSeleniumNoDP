package myTests;

import base.TestsBase;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class TextInput extends TestsBase {

    @Test
    public void testTextInput(){
        clickLink("Text Input");

        WebElement inputFiled = driver.findElement(By.xpath("//input"));
        WebElement button = driver.findElement(By.xpath("//button[@id='updatingButton']"));

        String myText = "Hello World!";

        Actions actions = new Actions(driver);
        actions.moveToElement(inputFiled).click().sendKeys(myText).perform();

        actions.moveToElement(button).click().perform();

        assertEquals(myText, button.getText(), "The button text does not match.");

    }

}
