# [Is Subsequence](https://leetcode.com/problems/is-subsequence/)

Given a string **s** and a string **t**, check if **s** is subsequence of **t**.

You may assume that there is only lower case English letters in both **s** and **t**. **t** is potentially a very long (length ~= 500,000) string, and **s** is a short string (<=100).

A subsequence of a string is a new string which is formed from the original string by deleting some (can be none) of the characters without disturbing the relative positions of the remaining characters. (ie, `"ace"` is a subsequence of `"abcde"` while `"aec"` is not).

**Example 1:**
**s** = `"abc"`, **t** = `"ahbgdc"`

Return `true`.

**Example 2:**
**s** = `"axc"`, **t** = `"ahbgdc"`

Return `false`.

**Follow up:**
If there are lots of incoming S, say S1, S2, ... , Sk where k >= 1B, and you want to check one by one to see if T has its subsequence. In this scenario, how would you change your code?

**Credits:**
Special thanks to [@pbrother](https://leetcode.com/pbrother/) for adding this problem and creating all test cases.

## 思路0

我的想法是，有两个指针，一个指着s的位置，一个指着t的位置，然后一个一个的在t里面找s的字符，如果都找到了，那么就说明s是t的字串，否则就不是

```java
package com.lhj1998.leetcode.Greedy._0392;

public class Solution {

    public boolean isSubsequence(String s, String t) {
        if(s.length() > t.length()) return false;
        char[] sch = s.toCharArray();
        char[] tch = t.toCharArray();
        boolean find = false;
        for(int i = 0, j = 0; i < sch.length; i++){
            find = false;
            for(; j < tch.length; j++){
                if(tch[j] == sch[i]) {
                    j++;
                    find = true;
                    break;
                }
            }
            if(!find) return false;
        }
        return true;
    }

}

```

这个我觉得思路和我的是一样的啊，为什么他的0ms，我的就要17ms .....

```java
class Solution {
    public boolean isSubsequence(String s, String t) {
        int index = -1;
        for (char c : s.toCharArray()) {
            index = t.indexOf(c, index+1);

            if (index == -1) {
                return false;
            }
        }

        return true;
    }
}
```

