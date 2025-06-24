package tests.webDriver;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class secondTest_NavigateButtons {

    public static void main(String[] args) {

        WebDriver driver = new ChromeDriver();

        // 1 - Go to url "https://www.youtube.com/"
        driver.get("https://www.youtube.com/");

        // 2- Check if the url contains "youtube"
        String expectedContainsURLstr = "youtube";
        String actualURL = driver.getCurrentUrl();

        System.out.print("First Site - URL Test: ");
        if (actualURL.contains(expectedContainsURLstr)) {
            System.out.println("PASSED");
        } else System.out.println("FAILED");

        // 3 - Go to the url "https://www.testotomasyonu.com/"
        driver.get("https://www.testotomasyonu.com/");

        // 4 - Check if the title contains "Test Otomasyonu"
        String expectedTitleStr = "Test Otomasyonu";
        String actualTitle = driver.getTitle();

        System.out.print("Second Site - Title Test: ");
        if (actualTitle.contains(expectedTitleStr)) {
            System.out.println("PASSED");
        } else System.out.println("FAILED");

        // 5 - Go back to first website through the back button
        driver.navigate().back();

        // 6 - Check if the Title has "YouTube"
        expectedTitleStr = "YouTube";
        actualTitle = driver.getTitle();

        System.out.print("First Site - Title Test: ");
        if (actualTitle.contains(expectedTitleStr)) {
            System.out.println("PASSED");
        } else System.out.println("FAILED");

        // 7 - Refresh the Page
        driver.navigate().refresh();

        // 8 - Close the driver
        driver.quit();

    }
}
