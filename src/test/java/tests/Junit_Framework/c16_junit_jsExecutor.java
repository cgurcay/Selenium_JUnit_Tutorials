package tests.Junit_Framework;

import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import utilities.TestBase_Each;

public class c16_junit_jsExecutor extends TestBase_Each {

    @Test
    public void jsExecutorTest() {
        driver.get("https://fizz.ca/");

        // Click an element with jse
        WebElement mobileElement = driver.findElement(By.id("desktop-mobile"));
        jse.executeScript("arguments[0].click();", mobileElement);

        // Scroll into an element
        WebElement scollToElement = driver.findElement(By.xpath("//*[.='Demystify the areas ']"));
        // jse.executeScript("arguments[0].scrollIntoView(true);", scollToElement);
        jse.executeScript("arguments[0].scrollIntoView({block: 'center'});", scollToElement);

        //Scroll to top of the page
        jse.executeScript("window.scrollTo(0, 0);");

        // Scroll to the bottom of the page
        jse.executeScript("window.scrollTo(0, document.body.scrollHeight);");

    }

}
