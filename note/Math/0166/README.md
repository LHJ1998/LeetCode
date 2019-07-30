# [Fraction to Recurring Decimal](https://leetcode.com/problems/fraction-to-recurring-decimal/)

Given two integers representing the numerator and denominator of a fraction, return the fraction in string format.

If the fractional part is repeating, enclose the repeating part in parentheses.

**Example 1:**

```
Input: numerator = 1, denominator = 2
Output: "0.5"
```

**Example 2:**

```
Input: numerator = 2, denominator = 1
Output: "2"
```

**Example 3:**

```
Input: numerator = 2, denominator = 3
Output: "0.(6)"
```

## 思路0

这题目写的我很烦，需要注意的地方有很多，主要是细心

```java
package com.lhj1998.leetcode.Math._0166;

import java.util.HashMap;

public class Solution {

    public String fractionToDecimal(int numerator, int denominator) {
        StringBuilder res = new StringBuilder();
        if(numerator > 0 && denominator < 0 || numerator < 0 && denominator > 0){
            res.append("-");
        }
        long n = numerator, d = denominator;
        n = Math.abs(n);
        d = Math.abs(d);
        long r = (n % d) * 10;
        res.append(n / d);
        if(r == 0) return res.toString();

        res.append(".");
        HashMap<Long, Integer> map = new HashMap<>();
        while(r != 0){
            if(map.containsKey(r)){
                //如果发现了相同的数字，那么就说明开始重复了
                int index = map.get(r);
                res.insert(index, "(");
                res.append(")");
                return res.toString();
            }
            map.put(r, res.length());
            long temp = r / d;
            r = (r % d) * 10;
            res.append(temp);
        }
        return res.toString();
    }

}

```

