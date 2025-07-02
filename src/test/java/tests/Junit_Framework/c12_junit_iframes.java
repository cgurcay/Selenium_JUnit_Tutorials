package tests.Junit_Framework;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import utilities.TestBase_Each;

import java.util.List;

public class c12_junit_iframes extends TestBase_Each {

    @Test
    public void iframeTest() {
        driver.get("https://demoqa.com/frames");

        // Locate "This is a sample page" text in the iframe

        // 1 - with locating iframe
//        WebElement iframeElement = driver.findElement(By.id("frame1"));
//        driver.switchTo().frame(iframeElement);

        // 2 - by name or id
        driver.switchTo().frame("frame1");

        // 3 - by index
        // There could be lost of iframe. Therefore going with index is so risky.
//        List<WebElement> iframeList = driver.findElements(By.tagName("iframe"));
//        System.out.println("Total iframes: " + iframeList.size()); // Total iframes: 12
//
//        for (WebElement each : iframeList) {
//            System.out.println(each.getAttribute("id"));
//        }
//
//        driver.switchTo().frame(2);

        String expectedStr = "This is a sample page";
        String actualtStr = driver.findElement(By.id("sampleHeading")).getText();

        Assertions.assertEquals(expectedStr,actualtStr);

        // Locate ToolsWA logo in the page
        // There are two ways to go back from a frame
        // 1 - Directly go to the main page
//        driver.switchTo().defaultContent();

        // 2 - Go to one step back to the parentFrame
        driver.switchTo().parentFrame();

        WebElement imageElement = driver.findElement(By.xpath("//img[contains(@src,'Toolsqa')]"));

        Assertions.assertTrue(imageElement.isDisplayed());
    }
}
