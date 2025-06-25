package tests.webElements;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class webElement_searchField {

    public static void main(String[] args) throws InterruptedException {

        // 1 - Do necessary setup for driver
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

        // 2 - Go to url "https://testotomasyonu.com"
        driver.get("https://testotomasyonu.com");

        // 3 - Locate search field
        WebElement searchField = driver.findElement(By.id("global-search"));
        // findElement brings the first element matches.
        // If it cannot be found it throws "NoSuchElementException"

        // 4 - Write "shoe" in the search field
        searchField.sendKeys("shoe");

        // 5 - Press enter for search
        searchField.submit();

        Thread.sleep(2000);

        // 6 - Close the page
        driver.quit();


    }
}
