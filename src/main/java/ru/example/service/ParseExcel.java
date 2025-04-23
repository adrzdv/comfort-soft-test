package ru.example.service;

import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.stereotype.Component;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@Component
public class ParseExcel implements ParseFile {

    @Override
    public List<Integer> parseFile(String src) {

        List<Integer> res = new ArrayList<>();

        try (FileInputStream file = new FileInputStream(src)) {
            Workbook workbook = new XSSFWorkbook(file);

            Sheet sheet = workbook.getSheetAt(0);

            for (Row row : sheet) {
                Cell cell = row.getCell(0);
                if (cell != null && cell.getCellType() == CellType.NUMERIC) {
                    res.add((int) cell.getNumericCellValue());
                }
            }

        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        return res;
    }
}
