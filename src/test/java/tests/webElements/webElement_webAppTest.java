package tests.webElements;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;

public class webElement_webAppTest {

    public static void main(String[] args) {

        // 1 - Setup driver
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

        // 2 - Go to "http://zero.webappsecurity.com"
        driver.get("http://zero.webappsecurity.com");

        // 3 - Click "ONLINE BANKING" link
        WebElement onlineBankingLinkElement = driver.findElement(By.id("onlineBankingMenu"));
        onlineBankingLinkElement.click();

        // 4 - Check if there are 6 elements below the picture
        List<WebElement> headerElementList = driver.findElements(By.className("headers"));

        int expectedHeaderSize = 6;
        int actualHeaderSize = headerElementList.size();

        System.out.print("Header Size Test: ");
        if (expectedHeaderSize == actualHeaderSize) {
            System.out.println("PASSED");
        } else System.out.println("FAILED");


        // 5 - Check if one of them called "Pay Bills"
        String expectedHeaderText = "Pay Bills";

        String testResult = "FAILED";

        List<String> headerTextList = new ArrayList<>();

        for (WebElement eachElement : headerElementList) {

            headerTextList.add(eachElement.getText());

        }

        if (headerTextList.contains("Pay Bills")) {
            testResult = "PASSED";
        }

        /*
        // Method 2:
        for (WebElement eachElement : headerElementList) {

            if (eachElement.getText().equals(expectedHeaderText)) {
                testResult = "PASSED";
            }

        }
         */

        /*
        // Method 3:
        for (int i = 0; i < headerElementList.size() ; i++) {
            String headerText = headerElementList.get(i).getText();

            if (headerText.equals(expectedHeaderText)) {
                testResult = "PASSED";
            }
        }
        */


        System.out.println("Pay Bills Element Test: " + testResult);

        // 6 - Close the page
        driver.quit();

    }
}
