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
