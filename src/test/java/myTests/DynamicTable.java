package myTests;

import base.TestsBase;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class DynamicTable extends TestsBase {

    @Test
    public void testDynamicTable(){
        clickLink("Dynamic Table");

        WebElement tableRow = driver.findElement(By.xpath("//div[@role='row'][span[text()='Chrome']]/span[contains(text(), '%')]"));
        WebElement yellowLabel = driver.findElement(By.xpath("//p[@class='bg-warning']"));

        assertTrue(yellowLabel.getText().contains(tableRow.getText()), "The yellow label doesn't match the expected Chrome CPU percentage.");

    }

}
