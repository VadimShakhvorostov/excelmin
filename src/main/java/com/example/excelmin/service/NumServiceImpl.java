package com.example.excelmin.service;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.stereotype.Service;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Collections;
import java.util.PriorityQueue;

@Service
public class NumServiceImpl implements NumService {

    public Integer getMinNum(String path, Integer n) throws IOException {

        PriorityQueue<Integer> tableNum = new PriorityQueue<>(Collections.reverseOrder());
        FileInputStream fileInputStream = new FileInputStream(path);

        XSSFWorkbook workbook = new XSSFWorkbook(fileInputStream);
        XSSFSheet sheet = workbook.getSheetAt(0);
        for (Row row : sheet) {
            for (Cell cell : row) {
                int value = (int) cell.getNumericCellValue();

                if (tableNum.size() < n) {
                    tableNum.offer(value);
                } else if (value < tableNum.peek()) {
                    tableNum.poll();
                    tableNum.offer(value);
                }
            }
        }
        return tableNum.peek();
    }
}
