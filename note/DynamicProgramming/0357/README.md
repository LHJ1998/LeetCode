# [Count Numbers with Unique Digits](https://leetcode.com/problems/count-numbers-with-unique-digits/)

Given a **non-negative** integer n, count all numbers with unique digits, x, where 0 ≤ x < 10n.

**Example:**

```
Input: 2
Output: 91 
Explanation: The answer should be the total numbers in the range of 0 ≤ x < 100, 
             excluding 11,22,33,44,55,66,77,88,99
```

## 思路0

原来这个题目是有提示的啊....

`f(1) = 10, ..., f(k) = 9 * 9 * 8 * ... (9 - k + 2) [The first factor is 9 because a number cannot start with 0].`

```java
package com.lhj1998.leetcode.DynamicProgramming._0357;

public class Solution {

    public int countNumbersWithUniqueDigits(int n) {
        if(n == 0) return 1;
        int[] dp = new int[n + 1];
        dp[1] = 10;
        for(int i = 2; i <= n; i++){
            dp[i] = 9 * fact(i) + dp[i - 1];
        }
        return dp[n];
    }

    private int fact(int n){
        int res = 1, count = 1;
        for(int i = 9; count < n; i--, count++){
            res = res * i;
        }
        return res;
    }
    
}

```

