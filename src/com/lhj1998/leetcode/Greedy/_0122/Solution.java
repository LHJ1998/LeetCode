package com.lhj1998.leetcode.Greedy._0122;

public class Solution {

    public int maxProfit(int[] prices) {
        int min = 0;
        for(int i = 1; i < prices.length; i++){
            if(prices[i - 1] < prices[i]) min += prices[i] - prices[i - 1];
        }
        return min;
    }

    public int maxProfit(int[] prices) {
        int min = 0, i = 0, j = 0;
        while(i < prices.length){
            i = j;
            //查找低谷
            while(i + 1 < prices.length && prices[i] >= prices[i + 1]) i++;
            j = i;
            //查找峰谷
            while(j + 1 < prices.length && prices[j] <= prices[j + 1]) j++;
            min += prices[j] - prices[i];
            if(i == j) break;
        }
        return min;
    }

}
