package tests.Junit_Framework;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import utilities.TestBase_Each;

public class q01_junit_dropdown_question extends TestBase_Each {

    @Test
    public void test01() {
        //1. http://zero.webappsecurity.com/ Adresine gidin
        driver.get("http://zero.webappsecurity.com/");

        //2. Sign in butonuna basin
        driver.findElement(By.id("signin_button"))
                .click();

        //3. Login kutusuna “username” yazin
        driver.findElement(By.id("user_login"))
                .sendKeys("username");

        //4. Password kutusuna “password” yazin
        driver.findElement(By.id("user_password"))
                .sendKeys("password");

        //5. Sign in tusuna basin, back tusuna basarak sayfaya donun
        driver.findElement(By.xpath("//input[@name='submit']"))
                .click();

        driver.navigate().back();

        //6. Online banking menusunden Pay Bills sayfasina gidin
        driver.findElement(By.id("onlineBankingMenu"))
                .click();

        driver.findElement(By.id("pay_bills_link"))
                .click();

        //7. “Purchase Foreign Currency” tusuna basin
        driver.findElement(By.xpath("//a[text()='Purchase Foreign Currency']"))
                .click();

        //8. “Currency” drop down menusunden Eurozone’u secin
        WebElement ddmCurreny = driver.findElement(By.id("pc_currency"));

        Select selectCurrency = new Select(ddmCurreny);

        selectCurrency.selectByValue("EUR");

        //9. “amount” kutusuna bir sayi girin
        driver.findElement(By.id("pc_amount"))
                .sendKeys("100");

        //10. “US Dollars” in secilmedigini test edin
        WebElement usDollarElement = driver.findElement(By.id("pc_inDollars_true"));

        Assertions.assertFalse(usDollarElement.isSelected());

        //11. “Selected currency” butonunu secin
        WebElement selectedCurrencyElement = driver.findElement(By.id("pc_inDollars_false"));

        selectedCurrencyElement.click();

        //12. “Calculate Costs” butonuna basin sonra “purchase” butonuna basin
        driver.findElement(By.id("pc_calculate_costs"))
                .click();

        driver.findElement(By.id("purchase_cash"))
                .click();

        //13. “Foreign currency cash was successfully purchased.” yazisinin ciktigini kontrol edin.
        WebElement alertElement = driver.findElement(By.id("alert_content"));

        String expectedAlert = "Foreign currency cash was successfully purchased.";
        String actualAlert = alertElement.getText();

        Assertions.assertEquals(expectedAlert,actualAlert);

    }
}
