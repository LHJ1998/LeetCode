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
