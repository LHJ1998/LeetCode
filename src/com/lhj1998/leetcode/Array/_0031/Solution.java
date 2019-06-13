package com.lhj1998.leetcode.Array._0031;

public class Solution {

    public void nextPermutation(int[] nums) {
        int i = nums.length - 2, j = nums.length - 1;
        while(i >= 0 && nums[i] >= nums[i + 1]) i--;
        if(i >= 0){
            while(j >= 0 && nums[j] <= nums[i]) j--;
            swap(nums, i, j);
        }
        for(i = i + 1, j = nums.length - 1; i < j; i++, j--){
            swap(nums, i, j);
        }
    }

    private void swap(int[] nums, int i, int j){
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }

}
