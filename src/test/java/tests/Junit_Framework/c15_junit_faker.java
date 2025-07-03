package tests.Junit_Framework;

import com.github.javafaker.Faker;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import utilities.ReusableMethods;
import utilities.TestBase_Each;

import java.time.LocalDate;
import java.time.Month;
import java.time.ZoneId;
import java.util.Date;

public class c15_junit_faker extends TestBase_Each {

    @Test
    public void fakerTest() {

        Faker faker = new Faker();

        System.out.println(faker.name().firstName()); // Mitchell
        System.out.println(faker.name().lastName()); // Bogisich
        System.out.println(faker.name().name()); // Ronny Gutkowski
        System.out.println(faker.name().nameWithMiddle()); // Dante Cummerata Carroll MD
        System.out.println(faker.name().fullName()); // Eugene McGlynn
        System.out.println(faker.name().username()); // mary.miller

        System.out.println("--------------------");

        System.out.println(faker.address().city()); // Jastborough
        System.out.println(faker.address().cityName()); // Cartwrightberg
        System.out.println(faker.address().country()); // Vanuatu
        System.out.println(faker.address().countryCode()); // HM
        System.out.println(faker.address().buildingNumber()); // 4061
        System.out.println(faker.address().fullAddress()); // 9276 Mraz Causeway, Runolfsdottirberg, VT 15306-2977
        System.out.println(faker.address().state()); // Utah
        System.out.println(faker.address().streetPrefix()); // xx
        System.out.println(faker.address().streetAddress()); // 62398 Luciano Cliff
        System.out.println(faker.address().streetSuffix()); // Street
        System.out.println(faker.address().streetName()); // Cassin Turnpike
        System.out.println(faker.address().streetAddressNumber()); // 996

        System.out.println("--------------------");

        System.out.println(faker.internet().emailAddress()); // charlotte.reinger@yahoo.com
        System.out.println(faker.internet().password()); // bp0ryasqst
        System.out.println(faker.internet().password(8,10)); // ugcwksxv
        System.out.println(faker.internet().password(8,10,true)); // u9N5rE9DE
        System.out.println(faker.internet().safeEmailAddress()); // arlen.roob@example.com
        System.out.println(faker.internet().userAgentAny()); // Opera/9.80 (Windows NT 6.1; WOW64) Presto/2.12.388 Version/12.18

    }

    @Test
    public void registerWithFaker() {
        // Register to "https://demowebshop.tricentis.com/register"

        Faker faker = new Faker();

        String fakeFirstName = faker.name().firstName();
        String fakeLastName = faker.name().lastName();
        String fakeEmail = faker.internet().emailAddress();
        String fakePassword = faker.internet().password(8,9);


        driver.get("https://demowebshop.tricentis.com/register");

        driver.findElement(By.id("gender-male"))
                .click();

        actions.sendKeys(Keys.TAB)
                .sendKeys(fakeFirstName)
                .sendKeys(Keys.TAB)
                .sendKeys(fakeLastName)
                .sendKeys(Keys.TAB)
                .sendKeys(fakeEmail)
                .sendKeys(Keys.TAB)
                .sendKeys(fakePassword)
                .sendKeys(Keys.TAB)
                .sendKeys(fakePassword)
                .sendKeys(Keys.TAB)
                .sendKeys(Keys.ENTER)
                .perform();

        String expectedStr = "Your registration completed";
        String actualStr = driver.findElement(By.xpath("//div[@class='result']")).getText();

        Assertions.assertEquals(expectedStr, actualStr);

        driver.findElement(By.xpath("//input[@value='Continue']"))
                .click();

        String actualMail = driver.findElement(By.xpath("(//a[@class='account'])[1]")).getText();

        Assertions.assertEquals(fakeEmail, actualMail);
    }

    @Test
    public void facebookRegisterTest() {

        driver.get("Https://facebook.com");

        driver.findElement(By.xpath("//*[@data-testid='open-registration-form-button']"))
                        .click();

        WebElement firstNameElement = driver.findElement(By.xpath(("//input[@name='firstname']")));

        Faker faker = new Faker();

        Date fakeBirthday = faker.date().birthday();

        LocalDate localDate = fakeBirthday.toInstant()
                .atZone(ZoneId.systemDefault())
                .toLocalDate();

        int day   = localDate.getDayOfMonth();
        String month = localDate.getMonth().name();
        int year  = localDate.getYear();

        actions.click(firstNameElement)
                .sendKeys(faker.name().firstName())
                .sendKeys(Keys.TAB)
                .sendKeys(faker.name().lastName())
                .sendKeys(Keys.TAB)
                .sendKeys(Keys.TAB)
                .sendKeys(day + "")
                .sendKeys(Keys.TAB)
                .sendKeys(month)
                .sendKeys(Keys.TAB)
                .sendKeys(year + "")
                .sendKeys(Keys.TAB)
                .sendKeys(Keys.TAB)
                .sendKeys(Keys.ARROW_RIGHT)
                .sendKeys(Keys.TAB)
                .sendKeys(faker.internet().emailAddress())
                .sendKeys(Keys.TAB)
                .sendKeys(faker.internet().password())
                .perform();

        driver.findElement(By.xpath("//button[@type='submit']"))
                .click();
    }

    @Test
    public void fakeBirthdayTest() {
        Faker faker = new Faker();

        Date birthday = faker.date().birthday();

        LocalDate localDate = birthday.toInstant()
                .atZone(ZoneId.systemDefault())
                .toLocalDate();

        int day   = localDate.getDayOfMonth();
        int month = localDate.getMonthValue();
        int year  = localDate.getYear();

        System.out.printf("Birthday: %s%n", localDate);
        System.out.printf("Day  : %d%nMonth: %d%nYear : %d%n",
                day, month, year);

        String monthStr = localDate.getMonth().name();

        System.out.println(monthStr);;

    }

}
