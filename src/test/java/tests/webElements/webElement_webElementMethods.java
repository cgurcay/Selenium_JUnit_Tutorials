package tests.webElements;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class webElement_webElementMethods {

    public static void main(String[] args) {

        // 1 - setup driver
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

        // 2 - Go to "https://testotomasyonu.com/form"
        driver.get("https://testotomasyonu.com/form");

        // 3 - Locate "Erkek" radio button and select
        WebElement genderErkekRadioElement = driver.findElement(By.id("inlineRadio2"));

        genderErkekRadioElement.click();

        // 4 - Check if the radio button is selected

        System.out.print("Gender selected Test: ");
        if ( genderErkekRadioElement.isSelected() ) {
            System.out.println("PASSED");
        } else System.out.println("FAILED");

        // 5 - Check if the other radio buttons for genders are not selected
        WebElement genderKadinRadioElement = driver.findElement(By.id("inlineRadio1"));
        WebElement genderDigerRadioElement = driver.findElement(By.id("inlineRadio3"));

        System.out.print("Genders not selected Test: ");
        if ( ! (genderKadinRadioElement.isSelected() || genderDigerRadioElement.isSelected()) ) {
            System.out.println("PASSED");
        } else System.out.println("FAILED");

        // 6 - Print location and size of the "Soyisim" input element
        WebElement soyisimElement = driver.findElement(By.id("surname"));

        System.out.println("Size of the soyisim input: " + soyisimElement.getSize());
        System.out.println("Location of the soyisim input: " + soyisimElement.getLocation());

        // 7 - Check if soyisim box has HTML class attribute "form-control"
        String expectedSoyisimAttribute = "form-control";
        String actualSoyisimAttribute = soyisimElement.getAttribute("class");

        System.out.print("Soyisim attribute Test: ");
        if (expectedSoyisimAttribute.equals(actualSoyisimAttribute)) {
            System.out.println("PASSED");
        } else System.out.println("FAILED");

        // 8 - Close the page
        driver.quit();

    }
}
