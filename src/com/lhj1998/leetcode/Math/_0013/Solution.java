package com.lhj1998.leetcode.Math._0013;

public class Solution {

    public int romanToInt(String s) {
        if(null == s || "".equals(s)) return 0;
        String[] romans = {"I", "IV", "V", "IX", "X", "XL", "L", "XC", "C", "CD", "D", "CM", "M"};
        int[] nums = {1, 4, 5, 9, 10, 40, 50, 90, 100, 400, 500, 900, 1000};
        String temp = new String(s);
        int res = 0;
        while(temp.length() > 0){
            for(int i = romans.length - 1; i >= 0; i--){
                if(temp.startsWith(romans[i])){
                    temp = temp.substring(romans[i].length());
                    res += nums[i];
                }
            }
        }
        return res;
    }

}
