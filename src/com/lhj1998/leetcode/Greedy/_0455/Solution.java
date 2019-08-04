package com.lhj1998.leetcode.Greedy._0455;

import java.util.Arrays;

public class Solution {

    public int findContentChildren(int[] g, int[] s) {
        if(g.length == 0 || s.length == 0) return 0;
        Arrays.sort(g);
        Arrays.sort(s);
        int i = 0, j = 0, res = 0;
        while(i < g.length && j < s.length){
            if(s[j] >= g[i]){
                i++;
                j++;
                res++;
            }
            j++;
        }
        return res;
    }

}
