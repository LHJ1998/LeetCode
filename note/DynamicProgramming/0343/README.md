# [Integer Break](https://leetcode.com/problems/integer-break/)

Given a positive integer *n*, break it into the sum of **at least** two positive integers and maximize the product of those integers. Return the maximum product you can get.

**Example 1:**

```
Input: 2
Output: 1
Explanation: 2 = 1 + 1, 1 × 1 = 1.
```

**Example 2:**

```
Input: 10
Output: 36
Explanation: 10 = 3 + 3 + 4, 3 × 3 × 4 = 36.
```

## 思路0

感觉已经慢慢有dp的感觉了，这道题用dp分析了一下

假设`dp[i]`是第i个位置的最大值，那么

`dp[i] = max(dp[i], dp[i - j] * j, dp[i - j] * dp[j], (i - j) * j)   j from 1 to i`

```java
package com.lhj1998.leetcode.DynamicProgramming._0343;

public class Solution {

    public int integerBreak(int n) {
        int[] dp = new int[n + 1];
        dp[1] = 1;
        dp[2] = 1;
        for(int i = 3; i <= n; i++){
            for(int j = 1; j < i; j++){
                int temp1 = dp[i - j] * dp[j];
                int temp2 = dp[i - j] * j;
                int temp3 = (i - j) * j;
                dp[i] = Math.max(dp[i], Math.max(temp1, Math.max(temp2, temp3)));
            }
        }
        return dp[n];
    }

}

```

0ms，只超过了51.45%的人，然后看了一下提交的情况，几乎没有人的做法和我的一样.....

```java
class Solution {
    public int integerBreak(int n) {
        if (n == 2){
            return 1;
        } else if (n == 3){
            return 2;
        } else if (n == 4){
            return 4;
        } else if (n == 5){
            return 6;
        } else if (n == 6){
            return 9;
        }
        
        int product = 1;
        while(n > 6){
            product = product * 3;
            n = n - 3;
        }
        
        return product * integerBreak(n);
    }
}
```

