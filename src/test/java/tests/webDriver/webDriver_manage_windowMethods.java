package tests.webDriver;

import org.openqa.selenium.Dimension;
import org.openqa.selenium.Point;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class webDriver_manage_windowMethods {

    public static void main(String[] args) throws InterruptedException {

        WebDriver driver = new ChromeDriver();

        // 1 - Go to website "https://testotomasyonu.com/"
        driver.get("https://testotomasyonu.com/");

        // 2 - Print the location and size of the window
        System.out.println("First Position: " + driver.manage().window().getPosition());
        System.out.println("First Size: " + driver.manage().window().getSize());

        // Thread.sleep(1000);

        // 3 - Minimize the window
        driver.manage().window().minimize();

        // 4 - Wait for 3 sec, then maximize the window
        Thread.sleep(3000);

        driver.manage().window().maximize();

        // 5 - Print the location and size of the window
        System.out.println("Maximized Position: " + driver.manage().window().getPosition());
        System.out.println("Maximized Size: " + driver.manage().window().getSize());

        // 6 - Make it fullscreen
        driver.manage().window().fullscreen();

        // 7 - Print the location and size of the window
        System.out.println("Fullscreen Position: " + driver.manage().window().getPosition());
        System.out.println("Fullscreen Size: " + driver.manage().window().getSize());
        // Fullscreen size is the total size of pc's screen where its run

        // 8 - Bring the page to location (50,50) by pixel
        driver.manage().window().setPosition(new Point(50,50));

        // 9 - Set the window size to (1000,500) by pixel
        driver.manage().window().setSize(new Dimension(1000,500));

        System.out.println("Last Position: " + driver.manage().window().getPosition());
        System.out.println("Last Size: " + driver.manage().window().getSize());

        // 10 - Close the window
        driver.quit();
    }
}
