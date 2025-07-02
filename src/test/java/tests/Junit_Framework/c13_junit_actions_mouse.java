package tests.Junit_Framework;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import utilities.ReusableMethods;
import utilities.TestBase_Each;

public class c13_junit_actions_mouse extends TestBase_Each {


    @Test
    public void contextMenuTest() {

        driver.get("https://the-internet.herokuapp.com/context_menu");

        WebElement rightClickElement = driver.findElement(By.id("hot-spot"));

        actions.contextClick(rightClickElement)
                .perform();

        // ReusableMethods.wait(1)
        String expectedStr = "You selected a context menu";
        String actualStr = driver.switchTo().alert().getText();

        Assertions.assertEquals(expectedStr, actualStr);

        driver.switchTo().alert().accept();

        // ReusableMethods.wait(3);

    }


    @Test
    public void dragAndDropTest() {
        driver.get("https://the-internet.herokuapp.com/drag_and_drop");

        WebElement draggableElement = driver.findElement(By.id("column-a"));
        WebElement dropToElement = driver.findElement(By.id("column-b"));

        String firstText = draggableElement.getText();

        actions.dragAndDrop(draggableElement, dropToElement)
                .perform();

        String textAfterDragAndDrop = draggableElement.getText();

        Assertions.assertNotEquals(firstText,textAfterDragAndDrop);

        driver.navigate().refresh();

        draggableElement = driver.findElement(By.id("column-a"));
        dropToElement = driver.findElement(By.id("column-b"));

        firstText = draggableElement.getText();

        actions.dragAndDrop(dropToElement, draggableElement)
                .perform();

        textAfterDragAndDrop = draggableElement.getText();

        Assertions.assertNotEquals(firstText,textAfterDragAndDrop);
    }


    @Test
    public void moveToElementTest() {
        driver.get("https://the-internet.herokuapp.com/hovers");

        WebElement firstProfileElement = driver.findElement(By.xpath("(//img[@alt='User Avatar'])[1]"));
        WebElement usernameElement = driver.findElement(By.xpath("(//h5)[1]"));

        Assertions.assertFalse(usernameElement.isDisplayed());

        actions.moveToElement(firstProfileElement)
                .perform();

        Assertions.assertTrue(usernameElement.isDisplayed());
    }
}
