package tests.Junit_Framework;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import utilities.ReusableMethods;
import utilities.TestBase_All;

public class c11_junit_jsAlert extends TestBase_All {

    // There are 3 types of js alerts
    // 1 - click alert
    // 2 - confirm alert
    // 3 - prompt alert

    // There are 4 types of methods
    // driver.switchTo().alert().accept();
    // driver.switchTo().alert().dismiss();
    // driver.switchTo().alert().sendKeys();
    // driver.switchTo().alert().getText();


    @BeforeAll
    public static void setup_init(){
        driver.get("https://the-internet.herokuapp.com/javascript_alerts");
    }

    @Test
    public void jsAlertClickTest() {
        driver.findElement(By.xpath("//button[@onclick='jsAlert()']"))
                .click();

        driver.switchTo().alert().accept();

        String expectedStr = "You successfully clicked an alert";
        String actualStr = driver.findElement(By.id("result")).getText();

        Assertions.assertEquals(expectedStr, actualStr);
    }

    @Test
    public void jsAlertConfirmTest() {

        driver.findElement(By.xpath("//button[@onclick='jsConfirm()']"))
                .click();

        driver.switchTo().alert().accept();

        String expectedStr = "You clicked: Ok";
        String actualStr = driver.findElement(By.id("result")).getText();

        Assertions.assertEquals(expectedStr, actualStr);

        driver.findElement(By.xpath("//button[@onclick='jsConfirm()']"))
                .click();

        driver.switchTo().alert().dismiss();

        expectedStr = "You clicked: Cancel";
        actualStr = driver.findElement(By.id("result")).getText();

        Assertions.assertEquals(expectedStr, actualStr);

    }

    @Test
    public void jsAlertPromptTest() {

        driver.findElement(By.xpath("//button[@onclick='jsPrompt()']"))
                .click();

        System.out.println(driver.switchTo().alert().getText());

        driver.switchTo().alert().sendKeys("Hi There");

        driver.switchTo().alert().accept();

        String expectedStr = "You entered: Hi There";
        String actualStr = driver.findElement(By.id("result")).getText();

        Assertions.assertEquals(expectedStr, actualStr);

        driver.findElement(By.xpath("//button[@onclick='jsPrompt()']"))
                .click();

        driver.switchTo().alert().dismiss();

        expectedStr = "You entered: null";
        actualStr = driver.findElement(By.id("result")).getText();

        Assertions.assertEquals(expectedStr, actualStr);


    }

}
