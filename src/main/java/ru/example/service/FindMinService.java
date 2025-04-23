package ru.example.service;

import java.util.List;

public interface FindMinService {

    /**
     * Поиск минимального N-ого числа в списке
     *
     * @param list список чисел
     * @param n    номер по порядку минимального числа
     * @return минимальное значение
     */
    int findMinInArray(List<Integer> list, int n);
}
