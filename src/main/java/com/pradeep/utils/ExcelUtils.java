package com.pradeep.utils;

import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


public final class ExcelUtils {
    private ExcelUtils() {
    }
    public static List<Map<Object, Object>> readExcel(String excelFilePath, String sheetName) {
        List<Map<Object, Object>> data=new ArrayList<>();
        try (FileInputStream fis = new FileInputStream(excelFilePath)) {
            XSSFWorkbook workbook = new XSSFWorkbook(fis);
            XSSFSheet sheet = workbook.getSheet(sheetName);
            int lastRow = sheet.getLastRowNum();
            int lastCol = sheet.getRow(0).getLastCellNum();
            for (int i = 1; i <= lastRow; i++) {
                Map<Object, Object> map = new HashMap<>();
                for (int j = 0; j < lastCol; j++) {
                    XSSFRow row = sheet.getRow(i);
                    XSSFCell headerCell = sheet.getRow(0).getCell(j);
                    XSSFCell cell = row.getCell(j);
                    if (headerCell != null && cell != null) {
                        map.put(headerCell.getStringCellValue(), cell.getStringCellValue());
                    }
                }
                data.add(map);
            }
        } catch (FileNotFoundException e) {
            throw new RuntimeException("File not found at location \"src/test/resources/testdata/controller.xlsx\"");
        } catch (IOException e) {
            throw new RuntimeException("Some I/o Exception occured while reading the file at location \"src/test/resources/testdata/controller.xlsx\"");
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        return data;
    }
}
