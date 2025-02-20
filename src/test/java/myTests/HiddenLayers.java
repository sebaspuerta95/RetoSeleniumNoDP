package myTests;

import base.TestsBase;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class HiddenLayers extends TestsBase {

    private By gButton = By.id("greenButton");
    private By bButton = By.id("blueButton");

    @Test
    public void testHiddenLayers() {
        clickLink("Hidden Layers");
        wait.until(ExpectedConditions.visibilityOf(driver.findElement(gButton)));
        WebElement greenButton = driver.findElement(gButton);

        assertTrue(greenButton.isDisplayed(), "The button is not available.");
        greenButton.click();

        WebElement blueButton = driver.findElement(bButton);
        assertTrue(blueButton.isDisplayed(), "El botón azul no está visible después del clic");

        boolean isGreenButtonClickable = false;
        try {
            greenButton.click();
            isGreenButtonClickable = true;
        } catch (Exception e) {
            isGreenButtonClickable = false;
            System.out.println("The button is no longer clickable.");
        }

        assertFalse(isGreenButtonClickable, "The green button is still clickable after the first click.");

    }

}
