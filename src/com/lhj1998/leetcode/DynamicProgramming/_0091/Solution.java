package com.lhj1998.leetcode.DynamicProgramming._0091;

public class Solution {

    public int numDecodings(String s) {
        if(null == s || s.length() == 0) return 0;
        int[] dp = new int[s.length() + 1];
        dp[0] = 1;
        dp[1] = s.charAt(0) == '0' ? 0 : 1;
        for(int i = 2; i <= s.length(); i++){
            int num1 = s.charAt(i - 1) - '0';
            int num2 = (s.charAt(i - 2) - '0') * 10 + num1;
            if(num1 > 0 && num1 < 10) dp[i] += dp[i - 1];
            if(num2 >= 10 && num2 <= 26) dp[i] += dp[i - 2];
        }
        return dp[s.length()];
    }

}
