package com.lhj1998.leetcode.DynamicProgramming._0213;

public class Solution {

    public int rob(int[] nums) {
        if(null == nums || nums.length == 0) return 0;
        if(nums.length == 1) return nums[0];
        int[] dp = new int[nums.length];
        int[] dp2 = new int[nums.length];
        dp[0] = nums[0];
        dp[1] = nums[0] > nums[1] ? nums[0] : nums[1];
        //dp2不偷第一家
        dp2[0] = 0;
        dp2[1] = nums[1];
        for(int i = 2; i < nums.length; i++){
            if(i != nums.length - 1) dp[i] = Math.max(nums[i] + dp[i - 2], dp[i - 1]);
            else dp[i] = dp[i - 1];
            dp2[i] = Math.max(nums[i] + dp2[i - 2], dp2[i - 1]);
        }
        return Math.max(dp[nums.length - 1], dp2[nums.length - 1]);
    }

}
