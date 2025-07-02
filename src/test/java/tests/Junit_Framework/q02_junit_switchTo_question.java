package tests.Junit_Framework;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import utilities.ReusableMethods;
import utilities.TestBase_Each;

public class q02_junit_switchTo_question extends TestBase_Each {

    @Test
    public void switchToTest() {
        //● Go to https://the-internet.herokuapp.com/windows
        driver.get("https://the-internet.herokuapp.com/windows");

        // Click elemental selenium link
        driver.findElement(By.xpath("//a[.='Elemental Selenium']"))
                .click();

        // Check if Title in the new window is "Elemental Selenium"
        // ReusableMethods.switchToNextWindow(driver);
        // ReusableMethods.switchToViaUrl(driver, "https://the-internet.herokuapp.com/windows/new");
        ReusableMethods.switchToViaTitle(driver, "Home | Elemental Selenium");

        String expectedTitle = "Home | Elemental Selenium";
        String actualTitle = driver.getTitle();

        Assertions.assertEquals(expectedTitle, actualTitle);

        // Go back to first window
        ReusableMethods.switchToNextWindow(driver);

        // Check if "Opening a new window" string is visible
        String expectedStrH3 = "Opening a new window";
        String actualStrH3 = driver.findElement(By.tagName("h3")).getText();

        Assertions.assertEquals(expectedStrH3,actualStrH3);

        // Click to "Click here"
        driver.findElement(By.xpath("//a[.='Click Here']"))
                .click();

        // Switch to the new window
        ReusableMethods.switchToViaTitle(driver, "New Window");

        // Check if the title is "New Window"
        expectedTitle = "New Window";
        actualTitle = driver.getTitle();

        Assertions.assertEquals(expectedTitle, actualTitle);

        // Go to "Elemental selenium" window
        ReusableMethods.switchToViaTitle(driver, "Home | Elemental Selenium");

        // Check if Tips link is reachable
        WebElement tipsLinkElement = driver.findElement(By.xpath("//button[contains(text(),'tips')]"));

        Assertions.assertTrue(tipsLinkElement.isEnabled());

    }
}
