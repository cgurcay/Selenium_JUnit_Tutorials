package tests.Junit_Framework;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import utilities.TestBase_Each;
import utilities.TestBase_Each_notQuit;

public class q05_filesUpload_question extends TestBase_Each {

    @Test
    public void fileUploadTest(){

        // 1 - Go to https://the-internet.herokuapp.com/upload
        driver.get("https://the-internet.herokuapp.com/upload");

        // 2 - Click to "Choose File" button
        WebElement chooseFileElement = driver.findElement(By.id("file-upload"));

        // 3 - Choose the deneme.txt file in the project
        String denemeFilePathStr = System.getProperty("user.dir") + "/src/test/java/tests/Junit_Framework/deneme.txt";

        // Steps 2 and 3 should be made together with sendKeys method
        chooseFileElement.sendKeys(denemeFilePathStr);

        // 4 - Click the "Upload" button
        driver.findElement(By.id("file-submit"))
                .click();

        // 5 - Locate the "File Uploaded!" text
        String expectedStr = "File Uploaded!";
        String actualStr = driver.findElement(By.tagName("h3")).getText();

        Assertions.assertEquals(expectedStr,actualStr);

        String expectedFileNameUploaded = "deneme.txt";
        String actualFileNameUploaded = driver.findElement(By.id("uploaded-files")).getText();

        Assertions.assertEquals(expectedFileNameUploaded,actualFileNameUploaded);

    }
}
