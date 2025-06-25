package tests.webElements;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class webElement_locate_ByclassName {

    public static void main(String[] args) throws InterruptedException {

        // 1 - Do necessary setup for driver
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

        // 2 - Go to url "https://testotomasyonu.com"
        driver.get("https://testotomasyonu.com");

        // 3 - Locate search field
        WebElement searchField = driver.findElement(By.name("search"));
        // <input class="search-input" id="global-search"
        // -> // name="search"
        // type="search" placeholder="Search Product,Category..." onkeyup="searchData(this.value)">

        // 4 - Write "shoe" in the search field
        searchField.sendKeys("shoe");

        // 5 - Press enter for search
        searchField.submit();

        // 6 - Check if it finds any search results
        WebElement searchResultElement = driver.findElement(By.className("product-count-text"));

        System.out.println(searchResultElement);
        // [[ChromeDriver: chrome on windows (fcec5b96d6906755b8a5864ca0a61feb)] -> class name: product-count-text]

        System.out.println(searchResultElement.getText());
        // 4 Products Found

        String searchResultText = searchResultElement.getText();

        searchResultText = searchResultText.replaceAll("\\D", ""); // "4"

        int searchResultInt = Integer.parseInt(searchResultText);

        System.out.print("Search Test: ");
        System.out.println(searchResultInt > 0 ? "PASSED" : "FAILED");
        /*
        if (searchResultInt > 0 ) {
            System.out.println("PASSED");
        } else System.out.println("FAILED");
        */


        Thread.sleep(2000);

        // 7 - Close the page
        driver.quit();

    }
}
