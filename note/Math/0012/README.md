# [Integer to Roman](https://leetcode.com/problems/integer-to-roman/)

Roman numerals are represented by seven different symbols: `I`, `V`, `X`, `L`, `C`, `D` and `M`.

```
Symbol       Value
I             1
V             5
X             10
L             50
C             100
D             500
M             1000
```

For example, two is written as `II` in Roman numeral, just two one's added together. Twelve is written as, `XII`, which is simply `X` + `II`. The number twenty seven is written as `XXVII`, which is `XX` + `V` + `II`.

Roman numerals are usually written largest to smallest from left to right. However, the numeral for four is not `IIII`. Instead, the number four is written as `IV`. Because the one is before the five we subtract it making four. The same principle applies to the number nine, which is written as `IX`. There are six instances where subtraction is used:

- `I` can be placed before `V` (5) and `X` (10) to make 4 and 9. 
- `X` can be placed before `L` (50) and `C` (100) to make 40 and 90. 
- `C` can be placed before `D` (500) and `M` (1000) to make 400 and 900.

Given an integer, convert it to a roman numeral. Input is guaranteed to be within the range from 1 to 3999.

**Example 1:**

```
Input: 3
Output: "III"
```

**Example 2:**

```
Input: 4
Output: "IV"
```

**Example 3:**

```
Input: 9
Output: "IX"
```

**Example 4:**

```
Input: 58
Output: "LVIII"
Explanation: L = 50, V = 5, III = 3.
```

**Example 5:**

```
Input: 1994
Output: "MCMXCIV"
Explanation: M = 1000, CM = 900, XC = 90 and IV = 4.
```

## 思路0

把数字转成罗马数字...

一开始这题目还真不知道怎么下手，不过再看看题目，有很多的提示啊，比如一开始就告诉你哪些罗马数字对应哪些数字，然后又告诉你怎么组合可以的得到哪些数字，再看看下面的示例，感觉就好像先找到最大的那个罗马数字放上去就好了，比如1994不就是先放1000、900、90、4这样吗

那就可以先把知道的数字全部列出来，然后一个一个遍历就好啦

```java
package com.lhj1998.leetcode.Math._0012;

public class Solution {

    public String intToRoman(int num) {
        if(num <= 0) return null;
        //先把不好表示的都预先写出来
        String[] romans = {"I", "IV", "V", "IX", "X", "XL", "L", "XC", "C", "CD", "D", "CM", "M"};
        int[] nums = {1, 4, 5, 9, 10, 40, 50, 90, 100, 400, 500, 900, 1000};
        //从大到小一个一个的减过去就好了
        StringBuilder res = new StringBuilder();
        while(num != 0){
            for(int i = nums.length - 1; i >= 0; i--){
                if(num >= nums[i]){
                    //找到第一个适合的
                    num = num - nums[i];
                    res.append(romans[i]);
                    break;
                }
            }
        }
        return res.toString();
    }
    
}

```

