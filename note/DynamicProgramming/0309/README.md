# [Best Time to Buy and Sell Stock with Cooldown](https://leetcode.com/problems/best-time-to-buy-and-sell-stock-with-cooldown/)

Say you have an array for which the *i*th element is the price of a given stock on day *i*.

Design an algorithm to find the maximum profit. You may complete as many transactions as you like (ie, buy one and sell one share of the stock multiple times) with the following restrictions:

- You may not engage in multiple transactions at the same time (ie, you must sell the stock before you buy again).
- After you sell your stock, you cannot buy stock on next day. (ie, cooldown 1 day)

**Example:**

```
Input: [1,2,3,0,2]
Output: 3 
Explanation: transactions = [buy, sell, cooldown, buy, sell]
```

## 思路0

这题目和之前的 [Best Time to Buy and Sell Stock](../0121/README.md) 有点类似，不一样的地方在于，这个还有个休息时间。

思路是一样的，无非就是找最大的那个，在第`i`天买进还是卖出，或者是休息。

如果是买进，那么总是要亏钱的，因此买进这一天需要尽可能亏的少

卖出的时候就是前一天买进亏得钱+今天卖出的价值就是卖出这一天的到的钱了

休息是在卖出以后必须要休息，那么今天是否休息取决于前一天是卖出获利高还是不卖获利高

```java
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

```

