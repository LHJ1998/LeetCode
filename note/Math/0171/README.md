# [Excel Sheet Column Number](https://leetcode.com/problems/excel-sheet-column-number/)

Given a column title as appear in an Excel sheet, return its corresponding column number.

For example:

```
    A -> 1
    B -> 2
    C -> 3
    ...
    Z -> 26
    AA -> 27
    AB -> 28 
    ...
```

**Example 1:**

```
Input: "A"
Output: 1
```

**Example 2:**

```
Input: "AB"
Output: 28
```

**Example 3:**

```
Input: "ZY"
Output: 701
```

## 思路0

这题目就是 [Excel Sheet Column Title](../0168/README.md) 的一个逆转啊...

```java
package com.lhj1998.leetcode.Math._0171;

public class Solution {

    public int titleToNumber(String s) {
        if(null == s || "".equals(s)) return 0;
        int res = 0, len = s.length();
        char[] array = s.toCharArray();
        for(int i = 0; i < array.length; i++){
            int num = array[i] - 'A' + 1, n = len - i - 1;
            res += Math.pow(26, n) * num;
        }
        return res;
    }
    
}

```

