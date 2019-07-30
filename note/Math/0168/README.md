# [Excel Sheet Column Title](https://leetcode.com/problems/excel-sheet-column-title/)

Given a positive integer, return its corresponding column title as appear in an Excel sheet.

For example:

```
    1 -> A
    2 -> B
    3 -> C
    ...
    26 -> Z
    27 -> AA
    28 -> AB 
    ...
```

**Example 1:**

```
Input: 1
Output: "A"
```

**Example 2:**

```
Input: 28
Output: "AB"
```

**Example 3:**

```
Input: 701
Output: "ZY"
```

## 思路0

特别简单的题，26一个周期

```java
package com.lhj1998.leetcode.Math._0168;

public class Solution {

    public String convertToTitle(int n) {
        if(n <= 0) return "";
        String[] temp = {"", "A", "B", "C", "D", "E", "F", "G", "H", "I", "J", "K", "L", "M", "N", "O", "P", "Q", "R", "S", "T", "U", "V", "W", "X", "Y", "Z"};
        StringBuilder res = new StringBuilder();
        while(n > 26){
            int r = n % 26;
            n = n / 26;
            if(r == 0){
                res.append(temp[n - 1]);
                res.append("Z");
                return res.toString();
            }
            res.append(temp[r]);
        }
        res.append(temp[n]);
        return res.reverse().toString();
    }
    
}

```

