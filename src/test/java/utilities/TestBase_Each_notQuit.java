package utilities;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class TestBase_Each_notQuit {

    protected WebDriver driver;
    protected Actions actions;

    protected WebDriverWait wait;

    protected JavascriptExecutor jse;

    @BeforeEach
    public void setup(){
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

        actions = new Actions(driver);

        wait = new WebDriverWait(driver, Duration.ofSeconds(10));

        jse = (JavascriptExecutor) driver;
    }

    @AfterEach
    public void teardown() {
        // driver.quit();
    }
}
