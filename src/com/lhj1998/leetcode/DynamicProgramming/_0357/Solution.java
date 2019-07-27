package com.lhj1998.leetcode.DynamicProgramming._0357;

public class Solution {

    public int countNumbersWithUniqueDigits(int n) {
        if(n == 0) return 1;
        int[] dp = new int[n + 1];
        dp[1] = 10;
        for(int i = 2; i <= n; i++){
            dp[i] = 9 * fact(i) + dp[i - 1];
        }
        return dp[n];
    }

    private int fact(int n){
        int res = 1, count = 1;
        for(int i = 9; count < n; i--, count++){
            res = res * i;
        }
        return res;
    }

}
