package com.example.task;

import java.util.*;

public class DuplicateData {
    public static void main(String[] args) {
        int[] numbers = {1,2,2};
        System.out.println(duplicate(numbers));

    }
    public static List<Integer> duplicate(int[] numbers) {

        Set<Integer> set = new HashSet<>();
        Set<Integer> result = new HashSet<>();
        for (int number : numbers) {
            if (set.contains(number)) {
                result.add(number);
            }
            set.add(number);
        }
        return new ArrayList<>(result);
    }
}
