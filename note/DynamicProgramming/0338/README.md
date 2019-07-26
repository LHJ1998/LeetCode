# [Counting Bits](https://leetcode.com/problems/counting-bits/)

Given a non negative integer number **num**. For every numbers **i** in the range **0 ≤ i ≤ num** calculate the number of 1's in their binary representation and return them as an array.

**Example 1:**

```
Input: 2
Output: [0,1,1]
```

**Example 2:**

```
Input: 5
Output: [0,1,1,2,1,2]
```

**Follow up:**

- It is very easy to come up with a solution with run time **O(n\*sizeof(integer))**. But can you do it in linear time **O(n)** /possibly in a single pass?
- Space complexity should be **O(n)**.
- Can you do it like a boss? Do it without using any builtin function like **__builtin_popcount** in c++ or in any other language.

## 思路0

最简单的方法就是计算出每一个i的二进制序列，然后求出1的个数就好了，但是这个没有用到动态规划的思想，仅作娱乐

```java
class Solution {
    public int[] countBits(int num) {
        int[] res = new int[num + 1];
        for(int i = 0; i <= num; i++){
            res[i] = claculateOneNum(i);
        }
        return res;
    }
    
    private int claculateOneNum(int n){
        int num = 0;
        while(n != 0){
            num = num + (n % 2);
            n = n / 2;
        }
        return num;
    }
}
```

## 思路1

找到一个规律，将一个数一直除以2直到这个数为0或者不为偶数为止，如果除到0，那么就说明这个数是2的幂次方，那么返回1，否则返回这个奇数的1的个数

进一步深挖以后，假设dp[i]是第i个位置的1的个数，那么dp[i]其实还可以写成

`i % 2 == 0 ? dp[i] = dp[i / 2] : dp[i] = dp[i / 2] + 1`

```java
package com.lhj1998.leetcode.DynamicProgramming._0338;

public class Solution {

    public int[] countBits(int num) {
        if(num == 0) return new int[]{0};
        if(num == 1) return new int[]{0,1};
        int[] res = new int[num + 1];
        res[0] = 0;
        res[1] = 1;
        for(int i = 2; i <= num; i++){
            res[i] = i % 2 == 0 ? res[i / 2] : res[i / 2] + 1;
        }
        return res;
    }
    
}

```

1ms nice