package tests.webDriver;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class webdriver_manage_timeoutMethods {

    public static void main(String[] args) {


        // It is best practice to maximize screen at the beginning
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        // It is also best practice to use an implicitlyWait
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

        // Difference between implicitlyWait and Thread.sleep:
        // implicitlyWait only waits until the object is found, but Thread.sleep waits no matter what.

        driver.quit();

    }
}
