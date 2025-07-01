package tests.Junit_Framework;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class c01_junit_beforeEach_afterEach {

    WebDriver driver;

    @BeforeEach
    public void setup() {
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
    }

    @AfterEach
    public void teardown() {
        driver.quit();
    }

    @Test
    public void youtubeTest() {
        driver.get("https://youtube.com");

        String expectedTitle = "YouTube";
        String actualTitle = driver.getTitle();

        System.out.print("Youtube Title Test: ");
        if (expectedTitle.equals(actualTitle)) {
            System.out.println("PASSED");
        } else System.out.println("FAILED");
    }

    @Test
    public void wiseQuarterTest() {
        driver.get("https://wisequarter.com");

        String expectedTitle = "https://wisequarter.com/";
        String actualTitle = driver.getCurrentUrl();

        System.out.print("Wise Quarter URL Test: ");
        if (expectedTitle.equals(actualTitle)) {
            System.out.println("PASSED");
        } else System.out.println("FAILED");
    }

    @Test
    public void arabamTest() {
        driver.get("https://arabam.com");

        String expectedTitle = "arabam.com";
        String actualTitle = driver.getTitle();

        System.out.print("Arabam Title Test: ");
        if (actualTitle.contains(expectedTitle)) {
            System.out.println("PASSED");
        } else System.out.println("FAILED");
    }
}
