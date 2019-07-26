package com.lhj1998.leetcode.DynamicProgramming._0309;

public class Solution {

    public int maxProfit(int[] prices) {
        if(prices.length < 2) return 0;
        int[][] dp = new int[3][prices.length];
        //0i买进 1i卖出 2i休息
        dp[0][0] = -prices[0];
        dp[1][0] = 0;
        dp[2][0] = 0;
        for(int i = 1; i < prices.length; i++){
            dp[0][i] = Math.max(dp[0][i - 1], dp[2][i - 1] - prices[i]);
            dp[1][i] = dp[0][i - 1] + prices[i];
            dp[2][i] = Math.max(dp[2][i - 1], dp[1][i - 1]);
        }
        return Math.max(dp[1][prices.length - 1], dp[2][prices.length - 1]);
    }

}
