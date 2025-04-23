package ru.example.controller;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;
import ru.example.service.FindMinService;
import ru.example.service.ParseFile;

@RestController
@AllArgsConstructor
@RequestMapping("/find")
@Tag(name = "Поиск минимального числа", description = "Поиск N-го минимального числа в Excel-файле")
public class FindMinController {
    FindMinService finderService;
    ParseFile fileParser;

    @GetMapping
    @Operation(summary = "Найти N-ое минимальное число в Excel-файле")
    public int findMin(@RequestParam
                       @Parameter(
                               description = "Путь к локальному Excel-файлу (формат .xlsx)",
                               example = "C:/files/numbers.xlsx"
                       )
                       String src,
                       @RequestParam
                       @Parameter(
                               description = "Номер по порядку минимального числа (например, 3 — значит третье по возрастанию)",
                               example = "3"
                       )
                       int n) {
        return finderService.findMinInArray(fileParser.parseFile(src), n);
    }
}
