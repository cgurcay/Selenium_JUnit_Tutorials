package tests.webDriver;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class webDriver_create {

    public static void main(String[] args) {

        // Create WebDriver
        WebDriver driver = new ChromeDriver();

        // Go to required website ("Http/Https is necessary")
        driver.get("https://www.testotomasyonu.com");

        /*
        try {
            Thread.sleep(3000);
        } catch (Exception ignored) {

        }

        driver.close();
        */
    }

}
