package tests.webElements;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;
import java.util.List;

public class webElement_locate_ByTagName_ByLinkText {

    public static void main(String[] args) {

        // 1 - Setup driver
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

        // 2 - Go to "https://automationexercise.com"
        driver.get("https://www.automationexercise.com");

        // 3 - Accept cookies
        // ?

        // 4 - Check if the page has 149 links
        List<WebElement> linkElementList = driver.findElements(By.tagName("a"));

        //System.out.println(linkElementList.size());

        int expectedLinkElementSize = 147;
        int actualLinkElementSize = linkElementList.size();

        System.out.print("Total Link Test: ");
        if (expectedLinkElementSize == actualLinkElementSize) {
            System.out.println("PASSED");
        } else System.out.println("FAILED - " + actualLinkElementSize);

        // 5 - Click the product link

        // This is not able to find the element due to the space in the text
        // Best practise is to use partialLinkText in this situation
        // driver.findElement(By.linkText(" Products")).click();

        driver.findElement(By.partialLinkText("Products"))
                .click();

        // 6 - Check if there is a "special offer" as an image in the page
        WebElement specialOfferImageElement = driver.findElement(By.id("sale_image"));

        System.out.print("Special Offer Image Test: ");
        if (specialOfferImageElement.isDisplayed()) {
            System.out.println("PASSED");
        } else System.out.println("FAILED");

        // 7 - Close the driver
        driver.quit();

    }
}
