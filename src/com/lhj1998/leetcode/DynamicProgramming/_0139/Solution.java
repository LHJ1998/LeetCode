package com.lhj1998.leetcode.DynamicProgramming._0139;

import java.util.List;

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
