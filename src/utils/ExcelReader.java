package utils;

import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

public class ExcelReader {
    public static List<Map<String, String>> read() throws IOException {
        String path = "Files/Book1 (1).xlsx";
        FileInputStream fileInputStream = new FileInputStream(path);
        XSSFWorkbook xssfWorkbook = new XSSFWorkbook(fileInputStream);
        Sheet sheet1 = xssfWorkbook.getSheet("Sheet1");
        int noofrow = sheet1.getPhysicalNumberOfRows();
        List<Map<String, String>> excelData = new ArrayList<>();
        Row row0 = sheet1.getRow(0);


        for (int i = 1; i < noofrow; i++) {
            Row row = sheet1.getRow(i);
            LinkedHashMap<String, String> rowMap = new LinkedHashMap<>();

            for (int j = 0; j < row.getPhysicalNumberOfCells(); j++) {
                rowMap.put(row0.getCell(j).toString(), row.getCell(j).toString());
            }

            excelData.add(rowMap);
        }
       return excelData;

    }
}


