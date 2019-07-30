package com.lhj1998.leetcode.Math._0204;

public class Solution {

//    public int countPrimes(int n) {
//        int res = 0;
//        for(int i = 2; i < n; i++){
//            if(isPrime(i)){
//                res++;
//            }
//        }
//        return res;
//    }
//
//    private boolean isPrime(int n){
//        if(n <= 1) return false;
//        for(int i = 2; i * i <= n; i++){
//            if(n % i == 0) return false;
//        }
//        return true;
//    }

    public int countPrimes(int n) {
        boolean[] notPrime = new boolean[n + 1];
        int res = 0;
        for(int i = 2; i < n; i++){
            if(!notPrime[i]){
                res++;
                for(int j = 2; i * j <= n; j++){
                    notPrime[i * j] = true;
                }
            }
        }
        return res;
    }

}
