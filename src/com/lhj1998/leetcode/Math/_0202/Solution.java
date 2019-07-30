package com.lhj1998.leetcode.Math._0202;

import java.util.HashMap;
import java.util.Map;

public class Solution {

    public boolean isHappy(int n) {
        if(n < 0) return false;
        Map<Integer, Integer> map = new HashMap<>();
        while(true){
            int temp = 0;
            while(n != 0){
                int r = n % 10;
                n = n / 10;
                temp += Math.pow(r, 2);
            }
            if(temp == 1) return true;
            if(map.containsKey(temp)) return false;
            map.put(temp, 1);
            n = temp;
        }
        // return false;
    }

}
