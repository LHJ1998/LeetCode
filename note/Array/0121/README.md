# [Best Time to Buy and Sell Stock](https://leetcode.com/problems/best-time-to-buy-and-sell-stock/)

Say you have an array for which the *i*th element is the price of a given stock on day *i*.

If you were only permitted to complete at most one transaction (i.e., buy one and sell one share of the stock), design an algorithm to find the maximum profit.

Note that you cannot sell a stock before you buy one.

**Example 1:**

```
Input: [7,1,5,3,6,4]
Output: 5
Explanation: Buy on day 2 (price = 1) and sell on day 5 (price = 6), profit = 6-1 = 5.
             Not 7-1 = 6, as selling price needs to be larger than buying price.
```

**Example 2:**

```
Input: [7,6,4,3,1]
Output: 0
Explanation: In this case, no transaction is done, i.e. max profit = 0.
```

## 思路0

最简单的方法无非就是一个一个试探过去就好了

```java
package com.lhj1998.leetcode.Array._0121;

public class Solution {

    public int maxProfit(int[] prices) {
        int max = 0;
        for(int i = 0; i < prices.length; i++){
            for(int j = i + 1; j < prices.length; j++){
                max = Math.max(max, prices[j] - prices[i]);
            }
        }
        return max;
    }
    
}

```

很简单吧，然后用了215ms....难以接受

## 思路1

上面两层循环太耗时间了，其实思考一下，在找最大收益的时候，最低价肯定是在最高价前面，也就是说如果我们找到了最低价，那么后面的都是最高价，也就是说可以一次遍历就可以了，完全不需要两个循环嵌套比较

```java
package com.lhj1998.leetcode.Array._0121;

public class Solution {

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

```

提交结果1ms搞定，算法nb，但是只超过了88.17%的人，也就是还有0ms的算法!!!

## 思路2

```java
class Solution {
    public int maxProfit(int[] prices) {
        if (prices.length == 0) return 0;
        int max = 0, min = prices[0];
        for (int i : prices) {
            if (i > min) max = Math.max(max, i - min);
            else min = i;
        }
        return max;
    }
}
```

以上1ms的解法，不明白和我第二种解法有什么不一样...