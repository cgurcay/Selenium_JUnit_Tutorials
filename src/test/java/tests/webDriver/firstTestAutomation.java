package tests.webDriver;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class firstTestAutomation {

    public static void main(String[] args) {

        WebDriver driver = new ChromeDriver();

        // 1 - Go to https://www.testotomasyonu.com/
        driver.get("https://www.testotomasyonu.com/");

        // 2 - Print Title
        System.out.println(driver.getTitle());

        // 3 - Check if Title has the words "Test Otomasyonu"
        String expectedTitle = "Test Otomasyonu";
        String actualTitle = driver.getTitle();

        System.out.print("Title Test: ");
        if (actualTitle.contains(expectedTitle)) {
            System.out.println("PASSED");
        } else System.out.println("FAILED");

        // 4 - Print URL
        System.out.println(driver.getCurrentUrl());

        // 5 - Check if the URL is "https://www.testotomasyonu.com/"
        String expectedURL = "https://www.testotomasyonu.com/";
        String actualURL = driver.getCurrentUrl();

        System.out.print("URL Test: ");
        if (actualURL.equals(expectedURL)) {
            System.out.println("PASSED");
        } else System.out.println("FAILED");

        // 6 - Print driver handle ID
        System.out.println(driver.getWindowHandle());

        // 7 - Check if the source code of the site has the work "otomasyon"
        String expectedStr = "otomasyon";
        String actualSource = driver.getPageSource();

        System.out.print("Page Source Test: ");
        if (actualSource.contains(expectedStr)) {
            System.out.println("PASSED");
        } else System.out.println("FAILED");

        // 8 - Close the driver
        driver.quit();

    }
}
