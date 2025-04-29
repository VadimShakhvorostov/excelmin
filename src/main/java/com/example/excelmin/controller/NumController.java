package com.example.excelmin.controller;

import com.example.excelmin.service.NumService;
import com.example.excelmin.service.NumServiceImpl;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;

@RestController
@RequestMapping("/api")
@Tag(name = "Минимальный элемент", description = "Ищет минимальный номер из таблицы")
public class NumController {

    private final NumService numService;

    public NumController(NumServiceImpl numService) {
        this.numService = numService;
    }

    @Operation(summary = "Вернуть N-ное минимальное число из файла Excel")
    @PostMapping("/min")
    public Integer getMinNumber(
            @Parameter(description = "Путь к файлу XLSX", example = "C:/num.xlsx") @RequestParam String path,
            @Parameter(description = "Порядковый номер N", example = "5") @RequestParam Integer n
    ) throws IOException {
        return numService.getMinNum(path, n);
    }
}
