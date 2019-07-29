# [Sqrt(x)](https://leetcode.com/problems/sqrtx/)

Implement `int sqrt(int x)`.

Compute and return the square root of *x*, where *x* is guaranteed to be a non-negative integer.

Since the return type is an integer, the decimal digits are truncated and only the integer part of the result is returned.

**Example 1:**

```
Input: 4
Output: 2
```

**Example 2:**

```
Input: 8
Output: 2
Explanation: The square root of 8 is 2.82842..., and since 
             the decimal part is truncated, 2 is returned.
```

## 思路0

最简单的办法，直接循环查找

不过效率嘛...15ms

```java
package com.lhj1998.leetcode.Math._0069;

public class Solution {

    public int mySqrt(int x) {
        if(x < 0) return Integer.MIN_VALUE;
        if(x == 1) return 1;
        long i = 1;
        while(i <= x && i * i <= x) i++;
        return (int)i - 1;
    }

}

```

## 思路1

可以试试二分法

```java
package com.lhj1998.leetcode.Math._0069;

public class Solution {

    public int mySqrt(int x) {
        if(x < 0) return Integer.MIN_VALUE;
        if(x == 1) return 1;
        // long temp = 0;
        int left = 0, right = x;
        while(left <= right){
            // int mid = (left + right) / 2;  这种方法求mid可能会溢出
            long mid = left + (right - left) / 2;
            long temp = mid * mid;
            long temp2 = temp + 2 * mid + 1;
            if(temp == x) return (int)mid;
            if(temp < x && temp2 > x) return (int)mid;
            if(temp > x) right = (int)mid - 1;
            else left = (int)mid + 1;
        }
        return 0;
    }

}

```

