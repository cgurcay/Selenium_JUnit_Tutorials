package tests.webElements;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import javax.swing.*;
import java.time.Duration;

public class webElement_locate_cssSelector {

    public static void main(String[] args) {

        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

        // 1 - Go to "https://testotomasyonu.com"
        driver.get("https://testotomasyonu.com");

        // 2 - Refresh the page
        driver.navigate().refresh();

        // 3 - Check if title has "Test Otomasyonu" text in it
        String expectedTitle = "Test Otomasyonu";
        String actualTitle = driver.getTitle();

        System.out.print("Title Test: ");
        if (actualTitle.contains(expectedTitle)) {
            System.out.println("PASSED");
        } else System.out.println("FAILED");

        // 4 - Click the "Furniture" link
        driver.findElement(By.xpath("//a[text()='Furniture' and not (@href='#')]"))
                .click();

        // 5 - put min price range as 40 and max price range 200, then filter it
        int minPrice = 40;
        int maxPrice = 200;

        WebElement minPriceElement = driver.findElement(By.xpath("//input[@name='min']"));
        WebElement maxPriceElement = driver.findElement(By.xpath("//input[@name='max']"));

        minPriceElement.clear();
        minPriceElement.sendKeys(minPrice + "");

        maxPriceElement.clear();
        maxPriceElement.sendKeys(maxPrice + "");

        Actions actions = new Actions(driver);
        actions.sendKeys(Keys.PAGE_DOWN).perform();

        driver.findElement(By.xpath("//button[text()='Filter Price']"))
                .click();

        // 6 - Check if there is any results
        WebElement productFoundElement = driver.findElement(By.xpath("//*[contains(text(),'Products Found')]"));

        // System.out.println(productFoundElement.getText());

        String productFoundText = productFoundElement.getText();
        productFoundText = productFoundText.replaceAll("\\D","");

        System.out.print("Item Found Test: ");
        if (Integer.parseInt(productFoundText) > 0 ) {
            System.out.println("PASSED");
        } else System.out.println("FAILED");

        // 7 - Click to the first item
        WebElement firstItemElement = driver.findElement(By.xpath("(//a[@class='prod-img'])[1]"));

        firstItemElement.click();

        // 8 - Check if the price is between 40 and 200
        WebElement itemPriceElement = driver.findElement(By.xpath("//*[@id='priceproduct']"));

        //System.out.println(itemPriceElement.getText());

        String itemPriceText = itemPriceElement.getText();
        itemPriceText = itemPriceText.replaceAll("[$ ]","");

        Double itemPriceDouble = Double.parseDouble(itemPriceText);
        //System.out.println(itemPriceText);

        System.out.print("Price Range Test: ");
        if (minPrice <= itemPriceDouble && itemPriceDouble <= maxPrice) {
            System.out.println("PASSED");
        } else System.out.println("FAILED");

        // 9 - Close the page
        driver.quit();
    }
}
