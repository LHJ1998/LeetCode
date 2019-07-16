# [Best Time to Buy and Sell Stock II](https://leetcode.com/problems/best-time-to-buy-and-sell-stock-ii/)

Say you have an array for which the *i*th element is the price of a given stock on day *i*.

Design an algorithm to find the maximum profit. You may complete as many transactions as you like (i.e., buy one and sell one share of the stock multiple times).

**Note:** You may not engage in multiple transactions at the same time (i.e., you must sell the stock before you buy again).

**Example 1:**

```
Input: [7,1,5,3,6,4]
Output: 7
Explanation: Buy on day 2 (price = 1) and sell on day 3 (price = 5), profit = 5-1 = 4.
             Then buy on day 4 (price = 3) and sell on day 5 (price = 6), profit = 6-3 = 3.
```

**Example 2:**

```
Input: [1,2,3,4,5]
Output: 4
Explanation: Buy on day 1 (price = 1) and sell on day 5 (price = 5), profit = 5-1 = 4.
             Note that you cannot buy on day 1, buy on day 2 and sell them later, as you are
             engaging multiple transactions at the same time. You must sell before buying again.
```

**Example 3:**

```
Input: [7,6,4,3,1]
Output: 0
Explanation: In this case, no transaction is done, i.e. max profit = 0.
```

## 思路0

这个题目和 [Best Time to Buy and Sell Stock](note/Array/0121/README.md) 的区别在于，前面的题目就是一天买进，然后一天卖出就没了，这个可以多天买进，多天卖出，然后买和卖不能同时发生，就是你在一天内只能选择买东西或者卖东西

这题目给我的感觉就是低价买进，然后在售价只要高于买进价就卖的样子...

```java
package com.lhj1998.leetcode.Array._0122;

public class Solution {

    public int maxProfit(int[] prices) {
        int min = 0;
        for(int i = 1; i < prices.length; i++){
            if(prices[i - 1] < prices[i]) min += prices[i] - prices[i - 1];
        }
        return min;
    }
    
}

```



