package utils;

import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import java.io.FileInputStream;

public class ExcelUtils {

    public static Object[][] getTestData(String filePath, String sheetName) throws Exception {
        FileInputStream fis = new FileInputStream(filePath);
        Workbook workbook = new XSSFWorkbook(fis);
        Sheet sheet = workbook.getSheet(sheetName);

        int rows = sheet.getLastRowNum();      // number of data rows
        int cols = sheet.getRow(0).getLastCellNum(); // number of columns

        Object[][] data = new Object[rows][cols];

        for (int i = 1; i <= rows; i++) {       // start from row 1 (skip header)
            Row row = sheet.getRow(i);
            for (int j = 0; j < cols; j++) {
                data[i-1][j] = row.getCell(j).getStringCellValue();
            }
        }
        workbook.close();
        return data;
    }
}