package tests.Junit_Framework;

import org.apache.poi.ss.usermodel.*;
import org.junit.jupiter.api.Test;

import java.io.FileInputStream;
import java.io.IOException;

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

}
