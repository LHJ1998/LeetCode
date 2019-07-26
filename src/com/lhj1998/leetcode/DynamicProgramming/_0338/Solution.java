package com.lhj1998.leetcode.DynamicProgramming._0338;

public class Solution {

    public int[] countBits(int num) {
        if(num == 0) return new int[]{0};
        if(num == 1) return new int[]{0,1};
        int[] res = new int[num + 1];
        res[0] = 0;
        res[1] = 1;
        for(int i = 2; i <= num; i++){
            res[i] = i % 2 == 0 ? res[i / 2] : res[i / 2] + 1;
        }
        return res;
    }

}
