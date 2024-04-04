package org.example.utis;

import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

import java.io.File;
import java.io.FileInputStream;
import java.util.ArrayList;
import java.util.List;

public class ExcelDataReader {

    public static List<Object[]> readTestData(String filePath) {
        List<Object[]> testData = new ArrayList<>();
        try (FileInputStream fis = new FileInputStream(new File(filePath))) {
            Workbook workbook = WorkbookFactory.create(fis);
            Sheet sheet = workbook.getSheetAt(0);
            for (Row row : sheet) {
                if (row.getRowNum() == 0) continue; // Skip header row

                String name = row.getCell(0).getStringCellValue();
                String gender = row.getCell(1).getStringCellValue();
                String country = row.getCell(2).getStringCellValue();
                double expectedTotal = row.getCell(3).getNumericCellValue();

                testData.add(new Object[]{name, gender, country, expectedTotal});
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return testData;
    }
}
