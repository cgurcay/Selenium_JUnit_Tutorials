package tests.Junit_Framework;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WindowType;
import utilities.TestBase_Each;

import java.awt.*;
import java.util.Set;

public class c09_junit_switchTo_Methods extends TestBase_Each {

    @Test
    public void switchToTest() {

        // Go to "https://the-internet.herokuapp.com/"
        driver.get("https://the-internet.herokuapp.com/");

        System.out.println("Current wh: " + driver.getWindowHandle());

        // Open a new tab and go to "https://youtube.com"
        driver.switchTo().newWindow(WindowType.TAB)
                .get("https://youtube.com");

        System.out.println("New Tab wh: " + driver.getWindowHandle());

        // Open a new window and print the WindowHandle
        driver.switchTo().newWindow(WindowType.WINDOW)
                .get("https://wisequarter.com");

        System.out.println("New Window wh: " + driver.getWindowHandle());

        System.out.println("All open windows: " + driver.getWindowHandles());

    }

    @Test
    public void switchTo_newWindow() {

        // Go to "https://the-internet.herokuapp.com/windows"
        driver.get("https://the-internet.herokuapp.com/windows");

        // Check if the title is "The Internet"
        String expectedTitle = "The Internet";
        String actualTitle = driver.getTitle();

        Assertions.assertEquals(expectedTitle,actualTitle);

        // Save first window handle value then click here button

        String firstWHV = driver.getWindowHandle();

        driver.findElement(By.xpath("//*[.='Click Here']"))
                .click();

        System.out.println(driver.getTitle());

        // Go to the new window
        Set<String> allWHVs = driver.getWindowHandles();

        String secondWHV = "";

        for ( String each : allWHVs ) {
            if ( ! each.equals(firstWHV)) {
                secondWHV = each;
            }
        }

        driver.switchTo().window(secondWHV);

        // Check if the Title is "New Window"
        String expectedNewWindowTitle = "New Window";
        actualTitle = driver.getTitle();

        Assertions.assertEquals(expectedNewWindowTitle, actualTitle);

        System.out.println(actualTitle);

    }
}