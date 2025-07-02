package tests.Junit_Framework;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import utilities.ReusableMethods;
import utilities.TestBase_Each;

public class c14_junit_actions_keyboard extends TestBase_Each {

    // actions.keyDown()
    // actions.keyUp()
    // actions.sendKeys()

    @Test
    public void keyboardActionsTest() {
        // Register to "https://demowebshop.tricentis.com/register"

        String givenMail = "test_email3@hotmail.com";

        driver.get("https://demowebshop.tricentis.com/register");

        driver.findElement(By.id("gender-male"))
                .click();

        actions.sendKeys(Keys.TAB)
                .sendKeys("Celal")
                .sendKeys(Keys.TAB)
                .sendKeys("Gurcay")
                .sendKeys(Keys.TAB)
                .sendKeys(givenMail)
                .sendKeys(Keys.TAB)
                .sendKeys("password1")
                .sendKeys(Keys.TAB)
                .sendKeys("password1")
                .sendKeys(Keys.TAB)
                .sendKeys(Keys.ENTER)
                .perform();

        String expectedStr = "Your registration completed";
        String actualStr = driver.findElement(By.xpath("//div[@class='result']")).getText();

        Assertions.assertEquals(expectedStr, actualStr);

        driver.findElement(By.xpath("//input[@value='Continue']"))
                .click();

        String actualMail = driver.findElement(By.xpath("(//a[@class='account'])[1]")).getText();

        Assertions.assertEquals(givenMail, actualMail);
    }

}
