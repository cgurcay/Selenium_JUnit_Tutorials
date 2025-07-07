package tests.Junit_Framework;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import utilities.ReusableMethods;
import utilities.TestBase_Each;
import utilities.TestBase_Each_notQuit;

import java.util.List;

public class q06_webTable_question extends TestBase_Each {

    @Test
    public void webTableTest() {

        //    1 - Go to "https://testotomasyonu.com/webtables"
        driver.get("https://testotomasyonu.com/webtables");

        //    2 - Print whole body of Web table
        WebElement tableBodyElement = driver.findElement(By.xpath("//table/tbody"));

        System.out.println("Whole Body: \n" + tableBodyElement.getText() + "\n---------------------------------");

        //    3 - Check if "Comfortable Gaming Chair" in the Web table
        String expectedBodyStr = "Comfortable Gaming Chair";
        String actualBodyStr = tableBodyElement.getText();

        Assertions.assertTrue(actualBodyStr.contains(expectedBodyStr));

        //    4 - Check if the total row count is 5
        List<WebElement> tableRowsList = driver.findElements(By.xpath("//table/tbody/tr"));

        int expectedRowSize = 5;
        int actualtRowSize =tableRowsList.size();

        Assertions.assertEquals(expectedRowSize, actualtRowSize);

        //    5 - Print each row
        for (WebElement each : tableRowsList) {
            System.out.println(each.getText().replaceAll("\n"," - "));
        }
        System.out.println("---------------------------------");

        //    6 - Check if total column count is 4
        List<WebElement> tableColumnHeader = driver.findElements(By.xpath("//table/thead/tr/th"));

        int expectedColumnCount = 4;
        int actualColumnCount = tableColumnHeader.size();

        Assertions.assertEquals(expectedColumnCount, actualColumnCount);

        //    7 - Print 3rd column
        List<WebElement> tableThirdColumn = driver.findElements(By.xpath("//tbody/tr[*]/td[3]"));

        for (WebElement each : tableThirdColumn) {
            System.out.print(each.getText() + " ");
        }
        System.out.println();

        System.out.println("---------------------------------");

        //    8 - Print the headers
        System.out.println(driver.findElement(By.xpath("//thead/tr")).getText());
        System.out.println("---------------------------------");

        //    9 - Write a method that receives row and column and returns data
        findDataInTable(2   ,3);
        findDataInTable(3   ,2);
        findDataInTable(4   ,1);


        //    10 - Check if 4th row category is "Furniture"
        String expectedCategory = "Furniture";
        String actualCategory = findDataInTable(4,2);

        Assertions.assertEquals(expectedCategory, actualCategory);
    }

    public String findDataInTable(int row, int column) {
        System.out.println("Row:[" + row + "] Column:[" + column + "]");
        String result = driver.findElement(By.xpath("//tbody/tr[" + row + "]/td[" + column + "]")).getText();
        System.out.println(result);
        System.out.println("---------------------------------");

        return result;
    }

}
