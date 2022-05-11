package com.example.task;

import java.util.HashMap;
import java.util.Map;

public class TwoSum {
    public static int[] twoSum(int[] nums, int target) {
        if(nums.length == 0) {
            return null;
        }
        Map<Integer,Integer> map = new HashMap<>();
        for(int i = 0; i < nums.length; i++) {
            int rest = target - nums[i];
            if(map.containsKey(rest)){
                return new int[]{i, map.get(rest)};
            }
            map.put(nums[i], i);
        }
        return null;
    }

    public static void main (String[] args) {
        int[] nums = {1,3,8,5,6};
        int target = 9;
        int[] res = twoSum(nums, target);
        System.out.println(res[0] + "," + res[1]);
    }

}

