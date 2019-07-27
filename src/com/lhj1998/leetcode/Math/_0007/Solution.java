package com.lhj1998.leetcode.Math._0007;

public class Solution {

    public int reverse(int x) {
        int res = 0, flag = x > 0 ? 1 : -1;
        x = x > 0 ? x : -x;
        while(x != 0){
            if(res > Integer.MAX_VALUE / 10 || x < Integer.MIN_VALUE * 10){
                return 0;
            }
            res = res * 10 + (x % 10);
            x = x / 10;
        }
        return res * flag;
    }

}
