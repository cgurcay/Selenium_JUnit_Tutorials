package tests.Junit_Framework;

import org.apache.poi.ss.usermodel.*;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Map;
import java.util.TreeMap;

public class c20_excel_read {

    @Test
    public void test01() throws IOException {
        // 1 - find path for Excel file
        String pathExcel = "src/test/java/tests/Junit_Framework/ulkeler.xlsx";

        // 2 - put path into FileStream object
        FileInputStream fileInputStream = new FileInputStream(pathExcel);

        // 3 - create a Workbook object using WorkbookFactory
        Workbook workbook = WorkbookFactory.create(fileInputStream);

        // 4 - print Sayfa1 sheet, 5th row 3rd cell
        // Due to Java uses index, rows and columns starts from 0
        Sheet sayfa1 = workbook.getSheet("Sayfa1");
        Row row5 = sayfa1.getRow(4);
        Cell cell3 = row5.getCell(2);

        System.out.println(cell3); // Andorra

        // or

        System.out.println(workbook.getSheet("Sayfa1")
                .getRow(5)
                .getCell(3)); // Luanda

        // 5 - print the last row number
        // Due to index lastrow + 1
        System.out.println(sayfa1.getLastRowNum()+1);

        // 6 - print how many rows are used
        System.out.println(sayfa1.getPhysicalNumberOfRows());
    }

    @Test
    public void test02() throws IOException {

        // Go to Sayfa1 Sheet in the ulkeler.xlsx
        String filePath = "src/test/java/tests/Junit_Framework/ulkeler.xlsx";
        FileInputStream fileInputStream = new FileInputStream(filePath);
        Workbook workbook = WorkbookFactory.create(fileInputStream);
        Sheet sayfa1 = workbook.getSheet("Sayfa1");

        // Print 1st row 2nd cell
        System.out.println(sayfa1.getRow(0)
                                .getCell(1));

        // Check if the cell is “Başkent (İngilizce)”
        String expectedStr = "Başkent (İngilizce)";
        String actualStr = sayfa1.getRow(0).getCell(1).getStringCellValue();

        Assertions.assertEquals(expectedStr, actualStr);

        // Check if 2nd row 4th cell is "Kabil"
        expectedStr = "Kabil";
        actualStr = sayfa1.getRow(1).getCell(3).getStringCellValue();

        Assertions.assertEquals(expectedStr, actualStr);

        // Check if Total Country Number is 190
        int expectedTotalCountryCount = 190;
        int actualTotalCountryCount = sayfa1.getLastRowNum();

        Assertions.assertEquals(expectedTotalCountryCount, actualTotalCountryCount);

        // Check if psychically used row number is 191
        int expectedPsychicalRow = 191;
        int actualPsychicalRow = sayfa1.getPhysicalNumberOfRows();

        Assertions.assertEquals(expectedPsychicalRow, actualPsychicalRow);

        // Check if the country "Netherlands" has the Turkish capital is "Amsterdam"
        expectedStr = "Amsterdam";
        actualStr = "";

        for (int i = 0; i <= sayfa1.getLastRowNum(); i++) {

            String countryName = sayfa1.getRow(i).getCell(0).getStringCellValue();

            if (countryName.equals("Netherlands")) {
                actualStr = sayfa1.getRow(i).getCell(3).getStringCellValue();
                break;
            }
        }

        Assertions.assertEquals(expectedStr, actualStr);

        // Check if there is a "Ankara" in the Turkish Capitals

        Map<String, String> countryMap = new TreeMap<>();

        for (int i = 1; i <= sayfa1.getLastRowNum() ; i++) {

            String countryName = sayfa1.getRow(i).getCell(0).getStringCellValue();

            String capitalName = sayfa1.getRow(i).getCell(3).getStringCellValue();

            countryMap.put(countryName, capitalName);

        }

        Assertions.assertTrue(countryMap.containsValue("Ankara"));

        // Check if there is a "Angola" in the Countries
        Assertions.assertTrue(countryMap.containsKey("Angola"));

        // Turkce baskent isimlerinde Ankara bulundugunu test edin
        // Turkce baskent isimleri her satirin 3.index'inde
        // bir flag olusturup, her satirdaki baskent ismini kontrol edelim
        // Ankara olan varsa flag'i degistirelim


        // Turkce baskent isminde A olan ulke sayisini bulun
        int count = 0;

        for (String each : countryMap.values()) {
            if (each.startsWith("A")) {
                count++;
            };
        }

        System.out.println("Total number of capitals starts with A: " + count);

        // Ingilizce ismi B ile baslayan kac ulke bulundugunu test edin
        count = 0;

        for (String each : countryMap.keySet()) {
            if (each.startsWith("B")) {
                count++;
            }
        }

        System.out.println("Total number of countries starts with B: " + count);

    }



}
