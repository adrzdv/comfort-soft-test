package ru.example.service;

import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class FindMinServiceImp implements FindMinService {

    @Override
    public int findMinInArray(List<Integer> list, int n) {

        int pivot;

        if (list.size() > 1) {
            pivot = list.get(list.size() / 2);
        } else if (n > list.size()) {
            throw new IllegalArgumentException("N can't be more than size of entry list");
        } else {
            return list.get(0);
        }

        List<Integer> left = new ArrayList<>();
        List<Integer> right = new ArrayList<>();
        List<Integer> equals = new ArrayList<>();

        for (int element : list) {
            if (element < pivot) {
                left.add(element);
            } else if (element > pivot) {
                right.add(element);
            } else {
                equals.add(element);
            }
        }

        if (left.size() > n - 1) {
            return findMinInArray(left, n);
        } else if (left.size() < n - 1) {
            return findMinInArray(right, n - left.size() - equals.size());
        }

        return pivot;

    }

}
