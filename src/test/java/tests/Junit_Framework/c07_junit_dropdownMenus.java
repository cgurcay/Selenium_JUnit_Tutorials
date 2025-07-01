package tests.Junit_Framework;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import utilities.TestBase_Each;

import java.util.List;

public class c07_junit_dropdownMenus extends TestBase_Each {

    // Select Option elemens

    // selectByVisibleText
    // selectByIndex
    // selectByValue

    @Test
    public void dropdownTests() {
        // Go to "https://the-internet.herokuapp.com/dropdown"
        driver.get("https://the-internet.herokuapp.com/dropdown");

        // Locate dropdown and assign to Select
        WebElement dropdownElement = driver.findElement(By.id("dropdown"));

        Select select = new Select(dropdownElement);

        // Select the 1. index and print
        select.selectByIndex(1);
        System.out.println(select.getFirstSelectedOption().getText());

        // Select the 2. value and print
        select.selectByValue("2");
        System.out.println(select.getFirstSelectedOption().getText());

        // Select "Option 1" by the VisibleText and print
        select.selectByVisibleText("Option 1");
        System.out.println(select.getFirstSelectedOption().getText());

        // Print all the values in the dropdown
        // Only prints the options, but you cannot use it
        System.out.println(dropdownElement.getText());

        // select.getOptions returns a List of WebElements.
        List<WebElement> dropdownElements = select.getOptions();

        for (WebElement each : dropdownElements) {
            System.out.println(each.getText());
        }

        // Check if there are 4 options

        int expectedDropdownSize = 4;
        int actualDropdownSize = dropdownElements.size();

        Assertions.assertEquals(expectedDropdownSize,actualDropdownSize);

    }

}
