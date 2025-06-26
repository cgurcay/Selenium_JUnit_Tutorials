package tests.webElements;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.locators.RelativeLocator;

import java.time.Duration;

public class webElement_relativeLocators {

    public static void main(String[] args) {

        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

        // 1 - Go to "https://testotomasyonu.com/relativeLocators"
        driver.get("https://testotomasyonu.com/relativeLocators");

        // 2 - Find DSLR Camera with 3 different relative locators
        WebElement motorE13Element = driver.findElement(By.id("pic8_thumb"));

        WebElement dslrCamera1 = driver.findElement(RelativeLocator.with(By.tagName("img")).toLeftOf(motorE13Element) );

        // 3 - After clicking the webElement Check if the element is DSLR Camera
        dslrCamera1.click();

        WebElement itemNameElement = driver.findElement(By.xpath("//div[@class=' heading-sm mb-4']"));

        String expectedItemName = "DSLR Camera";
        String actualItemName = itemNameElement.getText();

        System.out.print("Item Name Test 1: ");
        if (expectedItemName.equals(actualItemName)) {
            System.out.println("PASSED");
        } else System.out.println("FAILED");

        // 4 - Try Apple Airpods right location
        driver.get("https://testotomasyonu.com/relativeLocators");

        WebElement appleHeadPhoneElement = driver.findElement(By.id("pic6_thumb"));

        WebElement dslrCamera2 = driver.findElement(RelativeLocator.with(By.tagName("img")).toRightOf(appleHeadPhoneElement) );

        dslrCamera2.click();

        itemNameElement = driver.findElement(By.xpath("//div[@class=' heading-sm mb-4']"));
        actualItemName = itemNameElement.getText();

        System.out.print("Item Name Test 2: ");
        if (expectedItemName.equals(actualItemName)) {
            System.out.println("PASSED");
        } else System.out.println("FAILED");

        // 5 - Try with Bat Rockerz bottom
        driver.navigate().back();

        WebElement batRockerz = driver.findElement(By.id("pic2_thumb"));

        WebElement dslrCamera3 = driver.findElement(RelativeLocator.with(By.tagName("img")).below(batRockerz) );

        dslrCamera3.click();

        itemNameElement = driver.findElement(By.xpath("//div[@class=' heading-sm mb-4']"));
        actualItemName = itemNameElement.getText();

        System.out.print("Item Name Test 3: ");
        if (expectedItemName.equals(actualItemName)) {
            System.out.println("PASSED");
        } else System.out.println("FAILED");

    }
}
