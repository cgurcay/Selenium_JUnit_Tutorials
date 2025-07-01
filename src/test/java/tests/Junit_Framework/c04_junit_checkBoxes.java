package tests.Junit_Framework;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class c04_junit_checkBoxes {

    WebDriver driver;

    @BeforeEach
    public void setup() {
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
    }

    @AfterEach
    public void teardown() {
        driver.quit();
    }

    @Test
    public void checkBoxTest() {
    // Go to "https://the-internet.herokuapp.com/checkboxes"
        driver.get("https://the-internet.herokuapp.com/checkboxes");

    // Check the first checkbox
        WebElement checkbox1 = driver.findElement(By.xpath("(//input[@type='checkbox'])[1]"));
        WebElement checkbox2 = driver.findElement(By.xpath("(//input[@type='checkbox'])[2]"));

        checkbox1.click();

    // Check if the checkbox is selected
        Assertions.assertTrue(checkbox1.isSelected());
        Assertions.assertTrue(checkbox2.isSelected());


    // Deselect both boxes and check if there are now deselected
        checkbox1.click();
        checkbox2.click();

        Assertions.assertFalse(checkbox1.isSelected());
        Assertions.assertFalse(checkbox2.isSelected());
    }
}
