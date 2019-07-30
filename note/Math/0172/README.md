# [Factorial Trailing Zeroes](https://leetcode.com/problems/factorial-trailing-zeroes/)

Given an integer *n*, return the number of trailing zeroes in *n*!.

**Example 1:**

```
Input: 3
Output: 0
Explanation: 3! = 6, no trailing zero.
```

**Example 2:**

```
Input: 5
Output: 1
Explanation: 5! = 120, one trailing zero.
```

**Note:** Your solution should be in logarithmic time complexity.

## 思路0

这题目就是计算某一个数的阶乘尾巴上的0的个数

如果直接算出阶乘然后再求0的个数肯定是不行的...

```java
package com.lhj1998.leetcode.Math._0172;

public class Solution {

    public int trailingZeroes(int n) {
        int res = 0;
        for(int i = 5; n > 0; i *= 5){
            res += n / 5;
            n /= 5;
        }
        return res;
    }
    
}

```

