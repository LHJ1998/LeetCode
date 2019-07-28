package com.lhj1998.leetcode.Math._0029;

public class Solution {

//    public int divide(int dividend, int divisor) {
//        //用减法不要用除法
//        if(dividend == Integer.MAX_VALUE && divisor == -1) return Integer.MIN_VALUE;
//        if(dividend == Integer.MIN_VALUE && divisor == -1) return Integer.MAX_VALUE;
//        if(dividend == Integer.MIN_VALUE && divisor == 1) return Integer.MIN_VALUE;
//        if(dividend == Integer.MAX_VALUE && divisor == 1) return Integer.MAX_VALUE;
//        //记录是否为负数
//        boolean isNagetive = (dividend < 0 && divisor > 0) || (dividend > 0 && divisor < 0);
//        //正数化
//        long a = Math.abs((long)dividend);
//        long b = Math.abs((long)divisor);
//        //然后每次减divisor，记录减了多少次
//        int res = 0;
//        while(a >= b){
//            a -= b;
//            res++;
//        }
//        return isNagetive ? -res : res;
//    }

    public int divide(int dividend, int divisor) {
        //用减法不要用除法
        if(dividend == Integer.MAX_VALUE && divisor == -1) return Integer.MIN_VALUE;
        if(dividend == Integer.MIN_VALUE && divisor == -1) return Integer.MAX_VALUE;
        if(dividend == Integer.MIN_VALUE && divisor == 1) return Integer.MIN_VALUE;
        if(dividend == Integer.MAX_VALUE && divisor == 1) return Integer.MAX_VALUE;
        //记录是否为负数
        boolean isNagetive = (dividend < 0 && divisor > 0) || (dividend > 0 && divisor < 0);
        //正数化
        long a = Math.abs((long)dividend);
        long b = Math.abs((long)divisor);
        //然后每次减divisor，记录减了多少次
        int res = 0;
        while(a >= b){
            long divisor_ = b;
            long mutiply = 1;
            while(divisor_ + divisor_ <= a){
                divisor_ += divisor_;
                mutiply += mutiply;
            }
            res += mutiply;
            a -= divisor_;
        }
        return isNagetive ? -res : res;
    }

}
