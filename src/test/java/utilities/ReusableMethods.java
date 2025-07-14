package utilities;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.io.File;
import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Set;

public class ReusableMethods {


    public static void wait(int seconds) {
        try {
            Thread.sleep(seconds * 1000);
        } catch (InterruptedException e) {
            System.out.println("Error on Thread.sleep");
        }
    }


    public static void switchToNextWindow(WebDriver driver) {

        String currentWHV = driver.getWindowHandle();

        Set<String> allWHVs = driver.getWindowHandles();

        for (String each : allWHVs) {
            if (! currentWHV.equals(each)) {
                driver.switchTo().window(each);
                break;
            }
        }
    }


    public static void switchToViaTitle(WebDriver driver, String title) {

        Set<String> allWHVs = driver.getWindowHandles();

        for (String each : allWHVs) {
            driver.switchTo().window(each);

            if (title.equals(driver.getTitle())) {
                break;
            }
        }
    }


    public static void switchToViaUrl(WebDriver driver, String url) {

        Set<String> allWHVs = driver.getWindowHandles();

        for (String each : allWHVs) {
            driver.switchTo().window(each);

            if (url.equals(driver.getCurrentUrl())) {
                break;
            }
        }
    }


    public static void takeScreenshot(WebDriver driver, String fileName) {

        TakesScreenshot takesScreenshot = (TakesScreenshot) driver;

        String filePath = "target/screenshots/" + fileName + ".jpeg";
        File pageScreenshot = new File(filePath);

        File tempFile = takesScreenshot.getScreenshotAs(OutputType.FILE);

        try {
            FileUtils.copyFile(tempFile, pageScreenshot);
        } catch (IOException e) {
            System.out.println("Couldn't take a screenshot..");
        }
    }


    public static void takeScreenshotDateTime(WebDriver driver, String fileName) {

        LocalDateTime localDateTime = LocalDateTime.now();
        DateTimeFormatter format = DateTimeFormatter.ofPattern("_yyMMdd_HHmmss");
        String dateFormatted = localDateTime.format(format);

        TakesScreenshot takesScreenshot = (TakesScreenshot) driver;

        String filePath = "target/screenshots/" + fileName + dateFormatted + ".jpeg";
        File pageScreenshot = new File(filePath);

        File tempFile = takesScreenshot.getScreenshotAs(OutputType.FILE);

        try {
            FileUtils.copyFile(tempFile, pageScreenshot);
        } catch (IOException e) {
            System.out.println("Couldn't take a screenshot..");
        }
    }


    public static void takeScreenshotDateTime(WebElement webElement, String fileName) {

        LocalDateTime localDateTime = LocalDateTime.now();
        DateTimeFormatter format = DateTimeFormatter.ofPattern("_yyMMdd_HHmmss");
        String dateFormatted = localDateTime.format(format);

        String filePath = "target/screenshots/" + fileName + dateFormatted + ".jpeg";
        File pageScreenshot = new File(filePath);

        File tempFile = webElement.getScreenshotAs(OutputType.FILE);

        try {
            FileUtils.copyFile(tempFile, pageScreenshot);
        } catch (IOException e) {
            System.out.println("Couldn't take a screenshot..");
        }
    }
}