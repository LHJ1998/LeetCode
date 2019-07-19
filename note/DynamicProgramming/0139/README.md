# [Word Break](https://leetcode.com/problems/word-break/)

Given a **non-empty** string *s* and a dictionary *wordDict* containing a list of **non-empty** words, determine if *s* can be segmented into a space-separated sequence of one or more dictionary words.

**Note:**

- The same word in the dictionary may be reused multiple times in the segmentation.
- You may assume the dictionary does not contain duplicate words.

**Example 1:**

```
Input: s = "leetcode", wordDict = ["leet", "code"]
Output: true
Explanation: Return true because "leetcode" can be segmented as "leet code".
```

**Example 2:**

```
Input: s = "applepenapple", wordDict = ["apple", "pen"]
Output: true
Explanation: Return true because "applepenapple" can be segmented as "apple pen apple".
             Note that you are allowed to reuse a dictionary word.
```

**Example 3:**

```
Input: s = "catsandog", wordDict = ["cats", "dog", "sand", "and", "cat"]
Output: false
```

## 思路0

题目的意思就是给出一个字符串，然后求这个字符串能不能切分成给出的字典中的一些单词

这题目可以用dp求解，假设dp[i]表示（0,i）的字符串是否可以切分，那么dp[s.length()]就是这个字符串是否可以被切分

```java
package com.lhj1998.leetcode.DynamicProgramming._0139;

public class Solution {

    public boolean wordBreak(String s, List<String> wordDict) {
        boolean[] dp = new boolean[s.length() + 1];
        dp[0] = true;
        for(int i = 0; i <= s.length(); i++){
            for(int j = 0; j < i; j++){
                String word = s.substring(j, i);
                //首先需要保证单词在字典中
                //其次，切割出来的单词只是表示（j，i）是可切分的
                //但是必须要保证（0，j）也是可切分的，即dp[j] = true
                if(wordDict.contains(word) && dp[j]){
                    dp[i] = true;
                    break;
                }
            }
        }
        return dp[s.length()];
    }

}

```

