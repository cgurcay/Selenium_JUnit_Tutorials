package tests.Junit_Framework;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import utilities.TestBase_Each;

public class c18_explicitlyWaits extends TestBase_Each {

    @Test
    public void explicitlyWaitTest() {

        // 1 - Go to https://the-internet.herokuapp.com/dynamic_controls
        driver.get("https://the-internet.herokuapp.com/dynamic_controls");

        // 2 - Check if textbox is disabled
        WebElement textElement = driver.findElement(By.xpath("//input[@type='text']"));

        Assertions.assertFalse(textElement.isEnabled());

        // 3 - Press Enable button and wait until button is enabled
        driver.findElement(By.xpath("//button[.='Enable']"))
                .click();

        // 4 - Check if textbox is enabled
        wait.until(ExpectedConditions.elementToBeClickable(textElement));

        Assertions.assertTrue(textElement.isEnabled());

        // 5 - Check the text message "It's enabled!"
        String expectedStr = "It's enabled!";
        String actualStr = driver.findElement(By.id("message")).getText();

        Assertions.assertEquals(expectedStr, actualStr);

    }

}
