package com.lhj1998.leetcode.DynamicProgramming._0120;

import java.util.List;

public class Solution {

    public int minimumTotal(List<List<Integer>> triangle) {
        if(null == triangle || triangle.size() == 0) return 0;
        int row = triangle.size();
        int[] dp = new int[row];
        for(int i = 0; i < row; i++){
            dp[i] = triangle.get(row - 1).get(i);
        }
        for(int i = row - 2; i >= 0; i--){
            List<Integer> curr = triangle.get(i);
            for(int j = 0; j <= curr.size() - 1; j++){
                dp[j] = curr.get(j) + Math.min(dp[j], dp[j + 1]);
            }
        }
        return dp[0];
    }

}
