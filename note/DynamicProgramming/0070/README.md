# [Climbing Stairs](https://leetcode.com/problems/climbing-stairs/)

You are climbing a stair case. It takes *n* steps to reach to the top.

Each time you can either climb 1 or 2 steps. In how many distinct ways can you climb to the top?

**Note:** Given *n* will be a positive integer.

**Example 1:**

```
Input: 2
Output: 2
Explanation: There are two ways to climb to the top.
1. 1 step + 1 step
2. 2 steps
```

**Example 2:**

```
Input: 3
Output: 3
Explanation: There are three ways to climb to the top.
1. 1 step + 1 step + 1 step
2. 1 step + 2 steps
3. 2 steps + 1 step
```

## 思路0

这题目我昨天晚上还在牛客上刷剑指offer的时候刷到了，就是变了个名字而已。

然后我在牛客上的解法过了，在leetcode上竟然时间超限了，突然角色leetcode真的牛皮

```java
package com.lhj1998.leetcode.DynamicProgramming._0070;

public class Solution {

    public int climbStairs(int n) {
        if(n == 0) return 0;
        if(n == 1) return 1;
        if(n == 2) return 2;
        return climbStairs(n - 1) + climbStairs(n - 2);
    }
    
}

```

## 思路1

本来想用递归简单的解决问题，然后非要用dp...

```java
package com.lhj1998.leetcode.DynamicProgramming._0070;

public class Solution {

    public int climbStairs(int n) {
        if(n == 0) return 0;
        if(n == 1) return 1;
        if(n == 2) return 2;
        int[] dp = new int[n + 1];
        dp[1] = 1;
        dp[2] = 2;
        for(int i = 3; i <= n; i++){
            dp[i] = dp[i - 1] + dp[i - 2];
        }
        return dp[n];
    }

}

```

我有点费解，思路0用递归要求n个位置的步数，思路1也是要求n个位置的步数，为什么思路0就慢了呢