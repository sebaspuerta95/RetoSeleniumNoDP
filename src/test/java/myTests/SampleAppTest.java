package myTests;

import base.TestsBase;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebElement;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.*;

public class SampleAppTest extends TestsBase {

    private By loginStatusTag = By.xpath("//label[@id='loginstatus']");
    private By usernameField = By.xpath("//input[@type='text']");
    private By passField = By.xpath("//input[@type='password']");
    private By button = By.xpath("//button[@id='login']");

    /**
     * This test reloads the page only once.
     */
    @Test
    public void testSampleApp(){
        clickLink("Sample App");

        String usernameId = driver.findElement(usernameField).getAttribute("id");
        String passwordId = driver.findElement(passField).getAttribute("id");

        driver.navigate().refresh();

        String newUsernameId = driver.findElement(usernameField).getAttribute("id");
        String newPasswordId = driver.findElement(passField).getAttribute("id");

        assertFalse(usernameId.equals(newUsernameId), "The ID of the username field didn't change dynamically.");
        assertFalse(passwordId.equals(newPasswordId), "The ID of the password field didn't change dynamically.");

    }

    /**
     * This test is designed to be able to reload the page multiple time.
     */
    @Test
    public void testSameAppMultipleLoads(){
        clickLink("Sample App");

        List<String> listOfUserIDs = new ArrayList<>();
        List<String> listOfPassIDs = new ArrayList<>();

        for (int i=0; i < 5; i++) {
            try {
                String usernameId = driver.findElement(usernameField).getAttribute("id");
                String passwordId = driver.findElement(passField).getAttribute("id");

                listOfUserIDs.add(usernameId);
                listOfPassIDs.add(passwordId);

                driver.navigate().refresh();

            } catch (StaleElementReferenceException e) {
                System.out.println("Page not reloaded properly, element became stale.");
            }
        }

        Set<String> newListOfUserIDs = new HashSet<>(listOfUserIDs);
        Set<String> newListOfPassIDs = new HashSet<>(listOfPassIDs);

        assertEquals(newListOfUserIDs.size(), listOfUserIDs.size(), "The IDs of the usernames aren't dynamically changing.");
        assertEquals(newListOfPassIDs.size(), listOfPassIDs.size(), "The IDs if the passwords aren't dynamically changing.");

    }

}
