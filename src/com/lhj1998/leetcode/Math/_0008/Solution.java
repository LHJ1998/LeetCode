package com.lhj1998.leetcode.Math._0008;

public class Solution {

    public int myAtoi(String str) {
        if(str == null || str.length() == 0) return 0;
        int start = 0, flag = 1;
        while(start < str.length() && str.charAt(start) == ' ') start++;
        if(start < str.length()){
            if(str.charAt(start) == '-'){
                start++;
                flag = -1;
            }else if(str.charAt(start) == '+'){
                start++;
                flag = 1;
            }
            long res = 0;
            for(int i = start; i < str.length(); i++){
                if(str.charAt(i) < '0' || str.charAt(i) > '9') break;
                res = res * 10 + (str.charAt(i) - '0');
                if(flag == 1 && res > Integer.MAX_VALUE) return Integer.MAX_VALUE;
                if(flag == -1 && (res * -1) < Integer.MIN_VALUE) return Integer.MIN_VALUE;
            }
            res = res * flag;
            return (int) res;
        }else return 0;
    }

}
