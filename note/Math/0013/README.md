# [Roman to Integer](https://leetcode.com/problems/roman-to-integer/)

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

Given a roman numeral, convert it to an integer. Input is guaranteed to be within the range from 1 to 3999.

**Example 1:**

```
Input: "III"
Output: 3
```

**Example 2:**

```
Input: "IV"
Output: 4
```

**Example 3:**

```
Input: "IX"
Output: 9
```

**Example 4:**

```
Input: "LVIII"
Output: 58
Explanation: L = 50, V= 5, III = 3.
```

**Example 5:**

```
Input: "MCMXCIV"
Output: 1994
Explanation: M = 1000, CM = 900, XC = 90 and IV = 4.
```

## 思路0

这个和 [Integer to Roman](../0012/README.md) 差不多啊，就是倒过来了而已，思路其实是一样的

```java
package com.lhj1998.leetcode.Math._0013;

public class Solution {

    public int romanToInt(String s) {
        if(null == s || "".equals(s)) return 0;
        String[] romans = {"I", "IV", "V", "IX", "X", "XL", "L", "XC", "C", "CD", "D", "CM", "M"};
        int[] nums = {1, 4, 5, 9, 10, 40, 50, 90, 100, 400, 500, 900, 1000};
        String temp = new String(s);
        int res = 0;
        while(temp.length() > 0){
            for(int i = romans.length - 1; i >= 0; i--){
                if(temp.startsWith(romans[i])){
                    temp = temp.substring(romans[i].length());
                    res += nums[i];
                }
            }
        }
        return res;
    }
    
}

```

这样的做法的缺点就是，总是需要分割字符串，比较麻烦和耗时间。总共4ms，超过了76.14%的人，看看其他人的做法

下面的这种做法主要是用了罗马数字的一个特性，就是如果小的在前面，大的在后面，那么就是要用大的减去小的，否则就是用小的加上大的

```java
class Solution {
    public int romanToInt(String s) {
        int nums[]=new int[s.length()];
        for(int i=0;i<s.length();i++){
            switch (s.charAt(i)){
                case 'M':
                    nums[i]=1000;
                    break;
                case 'D':
                    nums[i]=500;
                    break;
                case 'C':
                    nums[i]=100;
                    break;
                case 'L':
                    nums[i]=50;
                    break;
                case 'X' :
                    nums[i]=10;
                    break;
                case 'V':
                    nums[i]=5;
                    break;
                case 'I':
                    nums[i]=1;
                    break;
            }
        }
        int sum=0;
        for(int i=0;i<nums.length-1;i++){
            if(nums[i]<nums[i+1]) sum-=nums[i];
            else sum+=nums[i];
        }
        return sum+nums[nums.length-1];        
    }
}
```

