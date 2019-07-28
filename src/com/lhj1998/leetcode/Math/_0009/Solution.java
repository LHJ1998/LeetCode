package com.lhj1998.leetcode.Math._0009;

public class Solution {

//    public boolean isPalindrome(int x) {
//        if(x < 0) return false;
//        int temp = 0, n = x;
//        while(n != 0){
//            temp = temp * 10 + (n % 10);
//            n = n / 10;
//        }
//        return temp == x;
//    }

    public boolean isPalindrome(int x) {
        if(x < 0) return false;
        StringBuilder builder = new StringBuilder();
        builder.append(x);
        String temp = builder.reverse().toString();
        return temp.equals(String.valueOf(x));
    }

}
