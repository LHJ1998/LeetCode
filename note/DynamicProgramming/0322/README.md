# [Coin Change](https://leetcode.com/problems/coin-change/)

You are given coins of different denominations and a total amount of money *amount*. Write a function to compute the fewest number of coins that you need to make up that amount. If that amount of money cannot be made up by any combination of the coins, return `-1`.

**Example 1:**

```
Input: coins = [1, 2, 5], amount = 11
Output: 3 
Explanation: 11 = 5 + 5 + 1
```

**Example 2:**

```
Input: coins = [2], amount = 3
Output: -1
```

## 思路0

咋一看这个题感觉就是贪心啊，然后写出来以后直接超时了...

如果用动态规划的想法做的话，假设dp[i]是使用最少的硬币数，在第`i`个位置的时候，这里需要的硬币数就是`dp[i - coin] + 1`的硬币数了（如果i大于coin而且i位置的硬币数多于这个数的话）

```java
package com.lhj1998.leetcode.DynamicProgramming._0322;

import java.util.Arrays;

public class Solution {

    public int coinChange(int[] coins, int amount) {
        int[] dp = new int[amount + 1];
        Arrays.fill(dp, amount + 1);
        dp[0] = 0;
        for(int i = 1; i <= amount; i++){
            for(int coin : coins){
                if(i >= coin){
                    dp[i] = Math.min(dp[i], dp[i - coin] + 1);
                }
            }
        }
        return dp[amount] > amount ? -1 : dp[amount];
    }
    
}

```

然而这种我感觉应该很快的算法，也用了15ms

看不懂系列的1ms

```java
class Solution {
    int min = Integer.MAX_VALUE;

    public int coinChange(int[] coins, int amount) {
        Arrays.sort(coins);
        coinChange(coins, amount, coins.length - 1, 0);
        return min == Integer.MAX_VALUE ? -1 : min;
    }
    private void coinChange(int[] coins, int amount, int cur, int cnt) {
        if (cur < 0){
            return ;
        }
        int i = amount / coins[cur];
        if (amount % coins[cur] == 0) {
            min = Math.min(min, cnt + i);
            return ;
        }
        for (; i >= 0; i--) {
            if (cnt + i >= min - 1){
                return;
            }
            coinChange(coins, amount - coins[cur] * i, cur - 1, cnt + i);
        }
    }
}
```

