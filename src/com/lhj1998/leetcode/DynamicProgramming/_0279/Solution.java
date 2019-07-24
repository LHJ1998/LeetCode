package com.lhj1998.leetcode.DynamicProgramming._0279;

public class Solution {

    public int numSquares(int n) {
        int[] dp = new int[n + 1];
        dp[0] = 0;
        dp[1] = 1;
        for(int i = 2; i <= n; i++){
            dp[i] = Integer.MAX_VALUE;
            for(int j = 1; j <= i / 2; j++){
                int s = j * j;
                //超出范围了，直接退出
                if(i - s < 0) break;
                //第i个数 - 平方数以后 + 1和当前最小比较
                dp[i] = Math.min(dp[i], dp[i - s] + 1);
            }
        }
        return dp[n];
    }

}
