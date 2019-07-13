# [Plus One](https://leetcode.com/problems/plus-one/)

Given a **non-empty** array of digits representing a non-negative integer, plus one to the integer.

The digits are stored such that the most significant digit is at the head of the list, and each element in the array contain a single digit.

You may assume the integer does not contain any leading zero, except the number 0 itself.

**Example 1:**

```
Input: [1,2,3]
Output: [1,2,4]
Explanation: The array represents the integer 123.
```

**Example 2:**

```
Input: [4,3,2,1]
Output: [4,3,2,2]
Explanation: The array represents the integer 4321.
```

## 思路0

这个就是个水题了，看到题目的时候我一脸懵逼，这个其实就是注意一下高位+1的进位问题就行了，其他的没什么

```java
package com.lhj1998.leetcode.Array._0066;

public class Solution {

    public int[] plusOne(int[] digits) {
        for(int i = digits.length - 1; i >= 0; i--){
            if((digits[i] + 1 >= 10) && i == 0){
                //最高位+1进位
                digits[i] = digits[i] - 9;
                return insert(digits);
            }else if((digits[i] + 1 >= 10) && i != 0){
                //中间某位+1进位
                digits[i] = digits[i] - 9;
            }else{
                digits[i]++;
                break;
            }
        }
        return digits;
    }

    private int[] insert(int[] digits){
        int[] res = new int[digits.length + 1];
        for(int i = 1; i < res.length; i++){
            res[i] = digits[i - 1];
        }
        res[0] = 1;
        return res;
    }
    
}

```

