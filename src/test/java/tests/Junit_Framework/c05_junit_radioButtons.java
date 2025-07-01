package tests.Junit_Framework;

import org.junit.jupiter.api.*;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import utilities.ReusableMethods;

import java.time.Duration;

public class c05_junit_radioButtons {

    WebDriver driver;

    @BeforeEach
    public void setup(){
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
    }

//    @AfterEach @Disabled
//    public void teardown() {
//        driver.quit();
//    }

    @Test
    public void radioButtonTest(){

        // Go to "https://demowebshop.tricentis.com/register"
        driver.get("https://demowebshop.tricentis.com/register");

//        Actions actions = new Actions(driver);
//        actions.sendKeys(Keys.PAGE_DOWN).perform();

        // Click on the male Gender radio button
        WebElement maleRadioElement = driver.findElement(By.xpath("//input[@id='gender-male']"));
        WebElement femaleRadioElement = driver.findElement(By.xpath("//input[@id='gender-female']"));

        // Check if the male is selected and others are not selected
        maleRadioElement.click();

        Assertions.assertTrue(maleRadioElement.isSelected());
        Assertions.assertFalse(femaleRadioElement.isSelected());

    }
}
