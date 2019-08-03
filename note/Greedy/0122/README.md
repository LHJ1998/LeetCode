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

这个的话就是低价买进，高价售出呗。可以画一下这个的折线图，就可以发现都是在低谷买进，峰谷卖出。所以只要找到低谷和峰谷就可以了。而低估就是递减的最后一个数字，峰谷就是递增的最后一个数字

```java
package com.lhj1998.leetcode.Greedy._0122;

public class Solution {

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

```

## 思路1

另一种办法比较简单，就是每次都认为可以售出(当然是买进的价格低于卖出的价格的情况下)，以尽可能多卖的办法找到最大收益

```java
package com.lhj1998.leetcode.Greedy._0122;

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

