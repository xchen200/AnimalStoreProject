package com.example.task;

public class FindSecondNumber {
    public static void main(String[] args) {
        int[] inputs = {6,2,3,5,4};
        System.out.println(findSecondLargeNumber(inputs));
    }

    public static int findSecondLargeNumber(int[] nums) {
        if (nums.length < 2) {
            throw new RuntimeException("Array length cannot be less then 2");
        }
        int max = Integer.MIN_VALUE;
        int secondMax = Integer.MIN_VALUE;
        for (int num : nums) {
            if (num > max) {
                secondMax = max;
                max = num;
            } else if (num <= max && num > secondMax) {
                secondMax = num;
            }
        }
        return secondMax;
    }

}
