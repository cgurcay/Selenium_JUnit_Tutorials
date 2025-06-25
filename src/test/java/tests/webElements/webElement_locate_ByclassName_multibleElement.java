package tests.webElements;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;
import java.util.List;

public class webElement_locate_ByclassName_multibleElement {

    public static void main(String[] args) throws InterruptedException {

        // 1 - Do necessary setup for driver
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

        // 2 - Go to url "https://testotomasyonu.com"
        driver.get("https://testotomasyonu.com");

        // 3 - Locate search field
        WebElement searchField = driver.findElement(By.id("global-search"));

        // 4 - Write "phone" in the search field and press ENTER
        searchField.sendKeys("phone" + Keys.ENTER);

        // 5 - Check if there are 8 elements in the panel
        List<WebElement> searchCategoryList = driver.findElements(By.className("panel-list"));

        int expectedCategorySize = 8;
        int actualCategorySize = searchCategoryList.size();

        System.out.print("Search Result Test: ");
        if (actualCategorySize == expectedCategorySize) {
            System.out.println("PASSED");
        } else System.out.println("FAILED");

        // 6 - Print the category names
        for (int i = 0; i < actualCategorySize; i++) {
            System.out.println(searchCategoryList.get(i).getText());
        }

        // 7 - Close the page
        driver.quit();

    }
}
