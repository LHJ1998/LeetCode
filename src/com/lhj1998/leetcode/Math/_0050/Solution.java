package com.lhj1998.leetcode.Math._0050;

public class Solution {

    public double myPow(double x, int n) {
        if(n == 0) return 1;
        return myPow(x * x, n / 2) * (n % 2 == 0 ? 1 : n > 0 ? x : 1.0 / x);
    }

}
