package com.lhj1998.leetcode.DynamicProgramming._0121;

public class Solution {

//    public int maxProfit(int[] prices) {
//        int max = 0;
//        for(int i = 0; i < prices.length; i++){
//            for(int j = i + 1; j < prices.length; j++){
//                max = Math.max(max, prices[j] - prices[i]);
//            }
//        }
//        return max;
//    }

    public int maxProfit(int[] prices) {
        int max = 0, min = Integer.MAX_VALUE;
        for(int i = 0; i < prices.length; i++){
            if(prices[i] < min){
                min = prices[i];
            }else{
                max = Math.max(max, prices[i] - min);
            }
        }
        return max;
    }

}
