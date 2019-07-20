package com.lhj1998.leetcode.DynamicProgramming._0152;

public class Solution {

    public int maxProduct(int[] nums) {
        if(null == nums || nums.length == 0) return 0;
        int max, min, res;
        max = min = res = nums[0];
        for(int i = 1; i < nums.length; i++){
            int temp = max;
            int num = nums[i];
            max = Math.max(num, Math.max(temp * num, min * num));
            min = Math.min(num, Math.min(temp * num, min * num));
            res = Math.max(max, res);
        }
        return res;
    }

}
