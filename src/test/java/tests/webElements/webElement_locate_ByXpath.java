package tests.webElements;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class webElement_locate_ByXpath {

    public static void main(String[] args) {

        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

        // 1 - Go to "https://testotomasyonu.com/addremove"
        driver.get("https://testotomasyonu.com/addremove");

        // 2 - Press Add Button
        WebElement addButtonElement = driver.findElement(By.xpath("//button[@id='sub-btn']"));

        addButtonElement.click();

        // 3 - Check if Remove Button is visible
        WebElement removeButtonElement = driver.findElement(By.xpath("//button[@class='remove-btn']"));

        System.out.print("Remove Element Visibility Test: ");
        if (removeButtonElement.isDisplayed()) {
            System.out.println("PASSED");
        } else System.out.println("FAILED");

        // 4 - Press Remove Button
        removeButtonElement.click();

        // 5 - Check if "Add/Remove Elements" text is visible

        // WebElement addRemoveElementsTextElement = driver.findElement(By.tagName("h2"));
        // WebElement addRemoveElementsTextElement = driver.findElement(By.xpath("//h2"));
        // WebElement addRemoveElementsTextElement = driver.findElement(By.xpath("//h2[text()='Add/Remove Elements']"));
        // WebElement addRemoveElementsTextElement = driver.findElement(By.xpath("//h2[.='Add/Remove Elements']"));
        WebElement addRemoveElementsTextElement = driver.findElement(By.xpath("//h2[contains(text(),'Add/Remove')]"));

        System.out.print("Add/Remove Elements Text Visibility Test: ");
        if (addRemoveElementsTextElement.isDisplayed()) {
            System.out.println("PASSED");
        } else System.out.println("FAILED");

        // 6 - Close the page
        driver.quit();

    }
}
