# [Longest Palindromic Substring](https://leetcode.com/problems/longest-palindromic-substring/)

Given a string **s**, find the longest palindromic substring in **s**. You may assume that the maximum length of **s** is 1000.

**Example 1:**

```
Input: "babad"
Output: "bab"
Note: "aba" is also a valid answer.
```

**Example 2:**

```
Input: "cbbd"
Output: "bb"
```

## 思路0

找到最长的回文串，这个题目很简单啊，回文串的话是对齐的，只需要找到一个中心点，以这个中心点向两边扩展就可以得出一个回文串了，然后从这些回文串中找到最大的那个就行了

```java
package com.lhj1998.leetcode.DynamicProgramming._0005;

public class Solution {

    public String longestPalindrome(String s) {
        if(s == null || s.length() == 1 || s.length() == 0) return s;
        int start = 0;
        int end = 0;
        for(int i = 0; i < s.length(); i++){
            int len1 = expand(s, i, i);
            int len2 = expand(s, i, i + 1);
            int len = Math.max(len1, len2);
            if(len > end - start){
                start = i - (len - 1) / 2;
                end = i + len / 2;
            }
        }
        return s.substring(start, end + 1);
    }

    private int expand(String str, int start, int end){
        while(start >= 0 && end < str.length() && str.charAt(start) == str.charAt(end)){
            start--;
            end++;
        }
        return end - start - 1;
    }

}

```

