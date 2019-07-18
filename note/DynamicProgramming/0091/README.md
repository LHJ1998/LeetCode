# [Decode Ways](https://leetcode.com/problems/decode-ways/)

A message containing letters from `A-Z` is being encoded to numbers using the following mapping:

```
'A' -> 1
'B' -> 2
...
'Z' -> 26
```

Given a **non-empty** string containing only digits, determine the total number of ways to decode it.

**Example 1:**

```
Input: "12"
Output: 2
Explanation: It could be decoded as "AB" (1 2) or "L" (12).
```

**Example 2:**

```
Input: "226"
Output: 3
Explanation: It could be decoded as "BZ" (2 26), "VF" (22 6), or "BBF" (2 2 6).
```

## 思路0

这个就是给一个字符串，然后要求计算出有几种不同的字母组合。

这个题目我觉得和跳台阶差不多，也是1个数字和2个数字的组合，不一样的地方在于，跳台阶是没有什么条件，直接判断就上去了，但是这个要求的范围在0~16

```java
package com.lhj1998.leetcode.DynamicProgramming._0091;

public class Solution {

    public int numDecodings(String s) {
        if(null == s || s.length() == 0) return 0;
        int[] dp = new int[s.length() + 1];
        dp[0] = 1;
        dp[1] = s.charAt(0) == '0' ? 0 : 1;
        for(int i = 2; i <= s.length(); i++){
            int num1 = s.charAt(i - 1) - '0';
            int num2 = (s.charAt(i - 2) - '0') * 10 + num1;
            if(num1 > 0 && num1 < 10) dp[i] += dp[i - 1];
            if(num2 >= 10 && num2 <= 26) dp[i] += dp[i - 2];
        }
        return dp[s.length()];
    }
    
}

```

