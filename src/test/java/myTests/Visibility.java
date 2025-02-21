package myTests;

import base.TestsBase;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.*;

import static org.junit.jupiter.api.Assertions.assertFalse;

public class Visibility extends TestsBase {

    @Test
    public void testVisibilityOfButtons() {
        clickLink("Visibility");

        WebElement hideButton = driver.findElement(By.id("hideButton"));
        hideButton.click(); // Click to hide buttons

        // Check visibility for each button based on the criteria
        assertFalse(isElementVisible("removedButton"), "Removed button is still visible.");
        assertFalse(isElementVisible("zeroWidthButton"), "Zero-width button is still visible.");
        assertFalse(isElementVisible("overlappedButton"), "Overlapped button is still visible.");
        assertFalse(isElementVisible("transparentButton"), "Opacity 0 button is still visible.");
        assertFalse(isElementVisible("invisibleButton"), "Visibility:hidden button is still visible.");
        assertFalse(isElementVisible("notdisplayedButton"), "Display:none button is still visible.");
        assertFalse(isElementVisible("offscreenButton"), "Offscreen button is still visible.");
    }

    /**
     * Determines if an element is truly visible.
     */
    private boolean isElementVisible(String locator) {
        try {
            WebElement element = driver.findElement(By.id(locator));

            // 1. If element is removed from the DOM, catch exception
            if (element == null) return false;

            // 2. If element is not displayed, return false
            if (!element.isDisplayed()) return false;

            // 3. If element has zero width or height, return false
            Dimension size = element.getSize();
            if (size.getWidth() == 0 || size.getHeight() == 0) return false;

            // 4. If element is covered by another, use JavaScript to check
            if (isCoveredByAnotherElement(element)) return false;

            // 5. If element has opacity:0, visibility:hidden, display:none, return false
            String opacity = element.getCssValue("opacity");
            String visibility = element.getCssValue("visibility");
            String display = element.getCssValue("display");
            if ("0".equals(opacity) || "hidden".equals(visibility) || "none".equals(display)) return false;

            // 6. If element is moved offscreen, return false
            Point location = element.getLocation();
            Dimension screenSize = driver.manage().window().getSize();
            if (location.getX() < 0 || location.getY() < 0 || location.getX() > screenSize.getWidth() || location.getY() > screenSize.getHeight()) {
                return false;
            }

            return true; // Element is visible
        } catch (NoSuchElementException | StaleElementReferenceException e) {
            return false; // Element is removed from the DOM or became stale
        }
    }

    /**
     * Checks if an element is covered by another element.
     */
    private boolean isCoveredByAnotherElement(WebElement element) {
        JavascriptExecutor js = (JavascriptExecutor) driver;
        String script = "return document.elementFromPoint(arguments[0], arguments[1])";
        Point location = element.getLocation();
        WebElement topElement = (WebElement) js.executeScript(script, location.getX(), location.getY());

        return topElement != null && !topElement.equals(element);
    }
}
