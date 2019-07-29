package com.lhj1998.leetcode.Math._0069;

public class Solution {

//    public int mySqrt(int x) {
//        if(x < 0) return Integer.MIN_VALUE;
//        if(x == 1) return 1;
//        long i = 1;
//        while(i <= x && i * i <= x) i++;
//        return (int)i - 1;
//    }

    public int mySqrt(int x) {
        if(x < 0) return Integer.MIN_VALUE;
        if(x == 1) return 1;
        // long temp = 0;
        int left = 0, right = x;
        while(left <= right){
            // int mid = (left + right) / 2;  这种方法求mid可能会溢出
            long mid = left + (right - left) / 2;
            long temp = mid * mid;
            long temp2 = temp + 2 * mid + 1;
            if(temp == x) return (int)mid;
            if(temp < x && temp2 > x) return (int)mid;
            if(temp > x) right = (int)mid - 1;
            else left = (int)mid + 1;
        }
        return 0;
    }

}
