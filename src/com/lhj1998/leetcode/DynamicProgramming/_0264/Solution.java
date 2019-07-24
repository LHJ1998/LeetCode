package com.lhj1998.leetcode.DynamicProgramming._0264;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Solution {

//    public int nthUglyNumber(int n) {
//        List<Integer> store = new ArrayList<>(Collections.singletonList(1));
//        int i2 = 0, i3 = 0, i5 = 0;
//        while(store.size() != n){
//            int temp2 = store.get(i2) * 2;
//            int temp3 = store.get(i3) * 3;
//            int temp5 = store.get(i5) * 5;
//            int min = Math.min(Math.min(temp2, temp3), temp5);
//            if(min == temp2) ++i2;
//            if(min == temp3) ++i3;
//            if(min == temp5) ++i5;
//            store.add(min);
//        }
//        return store.get(n - 1);
//    }

    public int nthUglyNumber(int n) {
        int[] dp = new int[n + 1];
        dp[1] = 1;
        int i2 = 1, i3 = 1, i5 = 1;
        for(int i = 2; i <= n; i++){
            int temp2 = dp[i2] * 2;
            int temp3 = dp[i3] * 3;
            int temp5 = dp[i5] * 5;
            int min = Math.min(Math.min(temp2, temp3), temp5);
            if(min == temp2) ++i2;
            if(min == temp3) ++i3;
            if(min == temp5) ++i5;
            dp[i] = min;
        }
        return dp[n];
    }

}
