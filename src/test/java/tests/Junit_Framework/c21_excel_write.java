package tests.Junit_Framework;

import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.junit.jupiter.api.Test;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.List;

public class c21_excel_write {

    @Test
    public void excelWriteTest() throws IOException {

        // Open Sayfa1 in ulkeler.xlsx
        String filePath = "src/test/java/tests/Junit_Framework/ulkeler.xlsx";
        FileInputStream fileInputStream = new FileInputStream(filePath);
        Workbook workbook = WorkbookFactory.create(fileInputStream);
        Sheet sayfa1 = workbook.getSheet("Sayfa1");

        // Create cell on 1st row 5th column "Nufus"
        sayfa1.getRow(0).createCell(4).setCellValue("Nufus");

        // Set 2nd row value for Nufus as 1500000
        sayfa1.getRow(1).createCell(4).setCellValue(1500000);

        // Set 10th row value for Nufus as 250000
        sayfa1.getRow(9).createCell(4).setCellValue(250000);

        // Set 15th row value for Nufus as 54000
        sayfa1.getRow(14).createCell(4).setCellValue(54000);

        // Write to the first empty row "Java Rocks", "Second Row Here", "Third Row Here", "Forth Row Here", "0"
        int rowNumToInsert = sayfa1.getLastRowNum()+1;

        sayfa1.createRow(rowNumToInsert);

        sayfa1.getRow(rowNumToInsert).createCell(0).setCellValue("Java Rocks");
        sayfa1.getRow(rowNumToInsert).createCell(1).setCellValue("Second Row Here");
        sayfa1.getRow(rowNumToInsert).createCell(2).setCellValue("Third Row Here");
        sayfa1.getRow(rowNumToInsert).createCell(3).setCellValue("Forth Row Here");
        sayfa1.getRow(rowNumToInsert).createCell(4).setCellValue(0);

        // Save excel
        FileOutputStream fileOutputStream = new FileOutputStream(filePath);
        workbook.write(fileOutputStream);

        // close streams and workbook
        fileInputStream.close();
        fileOutputStream.close();
        workbook.close();

    }
}
