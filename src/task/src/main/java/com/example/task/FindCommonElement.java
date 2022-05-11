package com.example.task;

import java.util.*;

public class FindCommonElement {
    public static void main(String[] args) {
        String[] str1 = new String[] {"123"};
        String[] str2 = new String[] {"123", "456"};
        System.out.println(findCommon(str1, str2));
    }

    public static List<String> findCommon(String[] str1, String[] str2) {
        List<String> result = new ArrayList<>();
        Set<String> set = new HashSet<>();
        set.addAll(Arrays.asList(str1));
        for (String str : str2) {
            if (set.contains(str)) {
                result.add(str);
            }
        }
        return result;
    }
}


