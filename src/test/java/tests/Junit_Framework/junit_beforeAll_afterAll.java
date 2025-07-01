package tests.Junit_Framework;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class junit_beforeAll_afterAll {

    // BeforeAll runs once at the start of the class
    // AfterALL runs once at the end of the class

    static WebDriver driver;

    @BeforeAll
    public static void setup() {
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
    }

    @AfterAll @Disabled
    public static void teardown() {
        driver.quit();
    }

    @Test
    public void checkTitleTest() {
        driver.get("https://the-internet.herokuapp.com/");

        driver.navigate().refresh();

        driver.findElement(By.xpath("//a[text()='Checkboxes']"))
                        .click();

        System.out.println("Link clicked");

    }


    @Test
    public void clickTheCheckBox1() {
        WebElement checkbox1 = driver.findElement(By.xpath("(//input[@type='checkbox'])[1]"));

        checkbox1.click();

        System.out.println("Checkbox clicked");

        System.out.println(checkbox1.isSelected());
    }


}
