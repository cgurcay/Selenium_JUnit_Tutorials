package tests.Junit_Framework;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Cookie;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import utilities.ReusableMethods;
import utilities.TestBase_Each;
import utilities.TestBase_Each_notQuit;

import java.util.Set;

public class c19_cookies extends TestBase_Each {

    @Test
    public void cookieTest() {

        // Go to https://google.com
        driver.get("https://google.com");

        // Accept cookies
        WebElement oturumAcmaElement = wait.until(ExpectedConditions.elementToBeClickable(
                                            driver.findElement(By.xpath("//div[.='Oturum açma']"))
                                        ));

        oturumAcmaElement.click();

        // Count how many cookies in the website
        Set<Cookie> cookieSet = driver.manage().getCookies();

        System.out.println(cookieSet.size());


        // Print details of the cookies
        for (Cookie each : cookieSet) {
            System.out.println(each);
            System.out.println("-----");
        }


        // Print only the names of the cookies
        for (Cookie each : cookieSet) {
            System.out.println(each.getName());
        }
        System.out.println("-----");

        // Add a new cookie named "Celal" and value "Gurcay"
        Cookie newCookie = new Cookie("Celal", "Gurcay");
        driver.manage().addCookie(newCookie);

        // Check if the Celal named cookie's value is "Gurcay"
        String expectedCookieValue = "Gurcay";
        String actualCookieValue = driver.manage().getCookieNamed("Celal").getValue();

        Assertions.assertEquals(expectedCookieValue, actualCookieValue);

        // Delete cookie named AEC and Check if it is deleted
        Cookie aecCookieToDelete = driver.manage().getCookieNamed("AEC");

//        driver.manage().deleteCookieNamed("AEC");
        driver.manage().deleteCookie(aecCookieToDelete);

        cookieSet = driver.manage().getCookies();

        Assertions.assertFalse(cookieSet.contains(aecCookieToDelete));

        for (Cookie each : cookieSet) {
            System.out.println(each.getName());
        }
        System.out.println("-----");

        // Delete all the cookies
        driver.manage().deleteAllCookies();

        // Check if all the cookies are deleted

        Assertions.assertEquals(driver.manage().getCookies().size(), 0);
    }
}
