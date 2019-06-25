package com.lhj1998.leetcode.Array._0041;

public class Solution {

    public int firstMissingPositive(int[] nums) {
        if(nums.length == 0 || nums.length == 1 && nums[0] <= 0) return 1;
        int[] array = new int[nums.length + 1];
        for(int i = 0; i < nums.length; i++){
            if(nums[i] <= 0 || nums[i] > nums.length + 1) continue;
            array[nums[i] - 1]++;
        }
        for(int i = 0; i < array.length; i++){
            if(array[i] == 0) return i + 1;
        }
        return 0;
    }

}
