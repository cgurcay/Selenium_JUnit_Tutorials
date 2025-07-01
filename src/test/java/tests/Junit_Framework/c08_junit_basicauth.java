package tests.Junit_Framework;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import utilities.TestBase_Each;

public class c08_junit_basicauth extends TestBase_Each {

    @Test
    public void testBasicAuth() {

        // Login to "https://the-internet.herokuapp.com/basic_auth"
        // username and password is "admin"
        driver.get("http://admin:admin@the-internet.herokuapp.com/basic_auth");

        // Check if you are successfully logged in
        WebElement congratsString = driver.findElement(By.xpath("//p[contains(text(),'Congratulations')]"));

        Assertions.assertTrue(congratsString.getText().contains("Congratulations"));

    }

}
