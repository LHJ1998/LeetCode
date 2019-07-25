package com.lhj1998.leetcode.DynamicProgramming._0300;

import java.util.Arrays;

public class Solution {

//    public int lengthOfLIS(int[] nums) {
//        if(null == nums || nums.length == 0) return 0;
//        int[] dp = new int[nums.length];
//        int max = 1;
//        Arrays.fill(dp, 1);
//        for(int i = 1; i < nums.length; i++){
//            for(int j = 0; j < i; j++){
//                if(nums[i] > nums[j]){
//                    dp[i] = Math.max(dp[i], dp[j] + 1);
//                }
//                max = Math.max(max, dp[i]);
//            }
//        }
//        return max;
//    }

    public int lengthOfLIS(int[] nums) {
        if(null == nums || nums.length == 0) return 0;
        int[] temp = new int[nums.length];
        int size = 0;
        for(int i = 0; i < nums.length; i++){
            int index = binarySearch(temp, 0, size - 1, nums[i]);
            temp[index] = nums[i];
            if(index == size) size++;
        }
        return size;
    }

    private int binarySearch(int[] nums, int left, int right, int target){
        if(left <= right){
            int mid = (left + right) / 2;
            if(nums[mid] == target) return mid;
            if(nums[mid] > target) return binarySearch(nums, left, mid - 1, target);
            return binarySearch(nums, mid + 1, right, target);
        }
        return left;
    }

}
