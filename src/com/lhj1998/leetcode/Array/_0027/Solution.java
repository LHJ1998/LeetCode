package com.lhj1998.leetcode.Array._0027;

public class Solution {

    public int removeElement(int[] nums, int val) {
        int count = 0, i = 0;
        //找到第一个val位置
        while(i < nums.length && nums[i] != val) i++;
        for(int j = i; j < nums.length; j++){
            if(nums[j] != val) nums[i++] = nums[j]; //避免重复劳动，不移动val的值
            else count++;
        }
        return nums.length - count;
    }

}
