package com.lhj1998.leetcode.Math._0172;

public class Solution {

    public int trailingZeroes(int n) {
        int res = 0;
        for(int i = 5; n > 0; i *= 5){
            res += n / 5;
            n /= 5;
        }
        return res;
    }

}
