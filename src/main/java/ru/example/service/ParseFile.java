package ru.example.service;

import java.util.List;

public interface ParseFile {
    /**
     * Метод для парсинга файла
     *
     * @param src путь к файлу
     * @return список чисел из файла
     */
    List<Integer> parseFile(String src);
}
