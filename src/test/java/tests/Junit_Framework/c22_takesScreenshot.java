package tests.Junit_Framework;

import org.apache.commons.io.FileUtils;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebElement;
import utilities.ReusableMethods;
import utilities.TestBase_Each;

import java.io.File;
import java.io.IOException;

public class c22_takesScreenshot extends TestBase_Each {

    @Test
    public void screenshotTest() throws IOException {

        // Go to https://testotomasyonu.com
        driver.get("https://testotomasyonu.com");

        ReusableMethods.wait(1);

        // Take a screenshot of the page
        TakesScreenshot takesScreenshot = (TakesScreenshot) driver;

        String filePath = "target/screenshots/testScreenshot.png";
        File pageScreenshot = new File(filePath);

        File tempFile = takesScreenshot.getScreenshotAs(OutputType.FILE);

        FileUtils.copyFile(tempFile, pageScreenshot);

    }

    @Test
    public void screenshotWithMethodTest() {

        // Go to https://testotomasyonu.com
        driver.get("https://testotomasyonu.com");

        ReusableMethods.wait(1);

        ReusableMethods.takeScreenshot(driver, "testScreenshotWithMethod");
        ReusableMethods.takeScreenshotDateTime(driver, "testScreenshotWithMethod");

    }

    @Test
    public void screenshotWebElement() {

        // Go to https://testotomasyonu.com
        driver.get("https://testotomasyonu.com");

        WebElement bannerElement = driver.findElement(By.xpath("//img[contains(@src,'side')]"));

        ReusableMethods.wait(1);
        ReusableMethods.takeScreenshotDateTime(bannerElement, "bannerTest");


    }


}
