package tests.Junit_Framework;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import utilities.ReusableMethods;
import utilities.TestBase_Each;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class q04_filesDownload_question extends TestBase_Each {

    @Test
    public void checkDownloads() {

        // 1 - Go to https://the-internet.herokuapp.com/download
        driver.get("https://the-internet.herokuapp.com/download");

        // 2 - Download webDriverIO.png
        driver.findElement(By.xpath("//a[.='webdriverIO.png']"))
                .click();

        ReusableMethods.wait(3);

        // 3 - Check if the file is downloaded
        Path downloadsPath = Paths.get(System.getProperty("user.home"),"Downloads","webdriverIO.png");
        Assertions.assertTrue(Files.exists(downloadsPath));

//        String downloadsPath = System.getProperty("user.home") + "/Downloads/webdriverIO.png";
//        Assertions.assertTrue( Files.exists(Paths.get(downloadsPath)) );

        // 4 - Delete the downloaded file in Downloads
        try {
            Files.deleteIfExists(downloadsPath);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        Assertions.assertFalse(Files.exists(downloadsPath));

    }

}
