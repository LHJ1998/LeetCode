package com.lhj1998.leetcode.Tree._0096;

public class Solution {

    public int numTrees(int n) {
        if(n <= 0) return 0;
        if(n == 1) return 1;
        int[] res = new int[n + 1];
        res[1] = 1;
        res[0] = 1;
        return dp(res, n);
    }

    private int dp(int[] res, int n){
        if(res[n] != 0) return res[n];
        int ans = 0;
        for(int i = 0; i < n; i++){
            int left = i, right = n - i - 1;
            ans += dp(res, left) * dp(res, right);
        }
        res[n] = ans;
        return ans;
    }

}
