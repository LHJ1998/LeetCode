# [Reverse Integer](https://leetcode.com/problems/reverse-integer/)

Given a 32-bit signed integer, reverse digits of an integer.

**Example 1:**

```
Input: 123
Output: 321
```

**Example 2:**

```
Input: -123
Output: -321
```

**Example 3:**

```
Input: 120
Output: 21
```

## 思路0

很水的一道题，第一种方法是用数学的方法逆转

```java
package com.lhj1998.leetcode.Math._0007;

public class Solution {

    public int reverse(int x) {
        int res = 0, flag = x > 0 ? 1 : -1;
        x = x > 0 ? x : -x;
        while(x != 0){
            if(res > Integer.MAX_VALUE / 10 || res < Integer.MIN_VALUE * 10){
                return 0;
            }
            res = res * 10 + (x % 10);
            x = x / 10;
        }
        return res * flag;
    }

}

```

## 思路1

另一种办法就是，用StringBuffer的reverse方法直接反转，但是因为可能有溢出的可能，因此这种办法感觉上不是很好

```java
class Solution {
    public int reverse(int x) {
        boolean flag  = false;
        if(x < 0){
            flag = true;
            x = x * -1;
        }
        StringBuilder builder = new StringBuilder();
        builder.append(x).reverse();
        int temp = 0;
        try{
            if(flag) temp = -1 * Integer.parseInt(builder.toString());
            else temp = Integer.parseInt(builder.toString());
        } catch (Exception e){
            return 0;
        }
        return temp;
    }
}
```

