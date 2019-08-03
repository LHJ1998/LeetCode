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
