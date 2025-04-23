package ru.example.service;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.IntStream;

import static org.junit.jupiter.api.Assertions.*;

class FindMinServiceImpTest {

    FindMinService service = new FindMinServiceImp();

    @Test
    void shouldBeZero() {
        List<Integer> initList = List.of(0);
        assertEquals(0, service.findMinInArray(initList, 1));
    }

    @Test
    void shouldBeEqualWhenListHasTwins() {
        List<Integer> initList = List.of(1, 1);
        assertEquals(1, service.findMinInArray(initList, 1));
    }

    @Test
    void shouldReturnValueFromListWithTwoElements() {
        List<Integer> initList = List.of(1, 2);
        assertEquals(1, service.findMinInArray(initList, 1));
    }

    @Test
    void shouldThrowIllegalArgument() {
        List<Integer> initList = List.of(1);
        assertThrows(IllegalArgumentException.class, () -> service.findMinInArray(initList, 2));
    }

    @Test
    void shouldReturnResultWhenMinInDifferentPositions() {
        List<Integer> initList1 = List.of(0, 1, 2);
        List<Integer> initList2 = List.of(1, 0, 2);
        List<Integer> initList3 = List.of(1, 2, 0);

        assertEquals(0, service.findMinInArray(initList1, 1));
        assertEquals(0, service.findMinInArray(initList2, 1));
        assertEquals(0, service.findMinInArray(initList3, 1));
    }

    @Test
    void shouldReturnResultWithNegativeValues() {
        List<Integer> initList = List.of(-3, -5, -1, 3);

        assertEquals(-5, service.findMinInArray(initList, 1));
    }

    @Test
    void shouldReturnResultWithMinIntValue() {
        List<Integer> initList = List.of(3, 5, Integer.MIN_VALUE);

        assertEquals(Integer.MIN_VALUE, service.findMinInArray(initList, 1));
    }

    @Test
    void shouldReturnResultWithBigList() {
        List<Integer> bigList = new ArrayList<>(
                IntStream.rangeClosed(1, 1_000_000)
                        .boxed()
                        .toList()
        );

        assertEquals(1, service.findMinInArray(bigList, 1));
    }

}