package tests.webDriver;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class webDriver_navigateMethods {

    public static void main(String[] args) throws InterruptedException {

        WebDriver driver = new ChromeDriver();

        driver.get("https://www.testotomasyonu.com");

        Thread.sleep(1000);

        driver.get("https://wisequarter.com");

        Thread.sleep(1000);

        // driver.get() and driver.navigate().to() is the same.

        // Back button in the web browser
        driver.navigate().back();

        Thread.sleep(1000);

        // Forward button in the web browser
        driver.navigate().forward();

        Thread.sleep(1000);

        // Refresh button in the web browser
        driver.navigate().refresh();

        Thread.sleep(3000);

        driver.quit();
    }
}
