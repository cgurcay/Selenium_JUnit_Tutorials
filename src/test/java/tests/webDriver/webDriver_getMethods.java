package tests.webDriver;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class webDriver_getMethods {

    public static void main(String[] args) {

        WebDriver driver = new ChromeDriver();

        driver.get("https://www.testotomasyonu.com");

        // Get title of the website
        // driver.getTitle()
        System.out.println(driver.getTitle()); // Test Otomasyonu - Test Otomasyonu

        // Get current url
        // driver.getCurrentUrl()
        System.out.println(driver.getCurrentUrl()); // https://www.testotomasyonu.com/

        // Get HTML source of the page
        // driver.getPageSource()
        System.out.println(driver.getPageSource()); // <html lang="en" class=" ... >

        // Get unique window ID
        // driver.getWindowHandle() // returns current window id
        // driver.getWindowHandles() // returns all the window ids
        System.out.println(driver.getWindowHandle()); // A014408E183394092CB647C1A2547199
        System.out.println(driver.getWindowHandles()); // [A014408E183394092CB647C1A2547199]

        // Closing the driver and windows
        // Close window
        // driver.close();

        // Close all the windows and driver
        // driver.quit();

        driver.close();

    }
}
