package utilities;

import org.openqa.selenium.WebDriver;

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



}