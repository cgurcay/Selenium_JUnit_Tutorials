package tests.Junit_Framework;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import utilities.TestBase_Each;

public class q03_junit_actions_mouse_question extends TestBase_Each {

    @Test
    public void actionsMouseTest(){
        //1- "http://webdriveruniversity.com/Actions" sayfasina gidin
        driver.get("http://webdriveruniversity.com/Actions");

        //2- Hover to "Hover over Me First" box
        WebElement hoverMeElement = driver.findElement(By.xpath("//button[.='Hover Over Me First!']"));

        actions.moveToElement(hoverMeElement)
                .perform();

        //3- Click to "Link 1"
        WebElement link1Element = driver.findElement(By.xpath("//button[.='Hover Over Me First!']/..//a"));

        link1Element.click();

        //4- print the Popup message
        System.out.println(driver.switchTo().alert().getText());

        //5- Accept the popup message
        driver.switchTo().alert().accept();

        //6- Click and hold the “Click and hold" box
        WebElement clickAndHoldElement = driver.findElement(By.id("click-box"));

        System.out.println(clickAndHoldElement.getText());

        actions.clickAndHold(clickAndHoldElement)
                .perform();

        //7- Print the “Click and hold" box string
        System.out.println(clickAndHoldElement.getText());

        //8- double click to “Double click me" box
        WebElement doubleClickElement = driver.findElement(By.id("double-click"));

        String beforeDoubleClickClassAttribute = doubleClickElement.getAttribute("class");

        System.out.println(beforeDoubleClickClassAttribute);

        actions.doubleClick(doubleClickElement)
                .perform();

        // 9 - Check if it is double clicked
        String afterDoubleClickClassAttribute = doubleClickElement.getAttribute("class");

        Assertions.assertNotEquals(beforeDoubleClickClassAttribute, afterDoubleClickClassAttribute);

        System.out.println(afterDoubleClickClassAttribute);


    }

}
