package tests.Junit_Framework;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import utilities.TestBase_All;

public class c10_junit_assertions extends TestBase_All {

    @BeforeAll
    public static void setup_init() {
        driver.get("https://bestbuy.com");
    }

    @Test
    public void assertionsAT() {

        // Check if the en logo is visible

        WebElement bestBuyENLogo = driver.findElement(By.xpath("//div[@lang='en']//img[@class='logo']"));

        Assertions.assertTrue(bestBuyENLogo.isDisplayed());
    }

    @Test
    public void assertionsAF() {
            // Check if the logo fr is not visible

            WebElement bestBuyFRLogo = driver.findElement(By.xpath("//div[@lang='fr']//img[@class='logo']"));

            Assertions.assertFalse(bestBuyFRLogo.isDisplayed());
    }


    @Test
    public void assertionsAE() {
        // Check if the welcome string "Choose a country."

        String expectedStr = "Choose a country.";
        String actualStr = driver.findElement(By.xpath("//div[@lang='en']//h1")).getText();

        Assertions.assertEquals(actualStr,expectedStr);
    }

    @Test
    public void assertionsANE() {
        // Check if the welcome string "Choose a country."

        String expectedStr = "Choose a country.";
        String actualStr = driver.findElement(By.xpath("//div[@lang='en']//h1")).getText();

        // Assertions.assertNotEquals(expectedStr,actualStr);
        Assertions.assertNotEquals(actualStr,expectedStr,"Intentionally False to see the message..");

        // Assertions.assertEquals("Yes","No");
    }

}
