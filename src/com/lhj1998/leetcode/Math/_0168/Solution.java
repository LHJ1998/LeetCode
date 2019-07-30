package com.lhj1998.leetcode.Math._0168;

public class Solution {

    public String convertToTitle(int n) {
        if(n <= 0) return "";
        String[] temp = {"", "A", "B", "C", "D", "E", "F", "G", "H", "I", "J", "K", "L", "M", "N", "O", "P", "Q", "R", "S", "T", "U", "V", "W", "X", "Y", "Z"};
        StringBuilder res = new StringBuilder();
        while(n > 26){
            int r = n % 26;
            n = n / 26;
            if(r == 0){
                res.append(temp[n - 1]);
                res.append("Z");
                return res.toString();
            }
            res.append(temp[r]);
        }
        res.append(temp[n]);
        return res.reverse().toString();
    }

}
