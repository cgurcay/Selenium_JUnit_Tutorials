package tests.webDriver;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class webDriver_openSouce {

    public static void main(String[] args) throws InterruptedException {

        // To use an open source Webdriver you only need to setup rest will be the same
        WebDriverManager.chromedriver().setup();


        WebDriver driver = new ChromeDriver();

        driver.get("https://testotomasyonu.com");

        Thread.sleep(1000);

        driver.quit();

    }

}
