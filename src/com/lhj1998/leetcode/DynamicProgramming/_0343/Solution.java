package com.lhj1998.leetcode.DynamicProgramming._0343;

public class Solution {

    public int integerBreak(int n) {
        int[] dp = new int[n + 1];
        dp[1] = 1;
        dp[2] = 1;
        for(int i = 3; i <= n; i++){
            for(int j = 1; j < i; j++){
                int temp1 = dp[i - j] * dp[j];
                int temp2 = dp[i - j] * j;
                int temp3 = (i - j) * j;
                dp[i] = Math.max(dp[i], Math.max(temp1, Math.max(temp2, temp3)));
            }
        }
        return dp[n];
    }

}
