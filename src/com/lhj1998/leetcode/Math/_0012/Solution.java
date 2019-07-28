package com.lhj1998.leetcode.Math._0012;

public class Solution {

    public String intToRoman(int num) {
        if(num <= 0) return null;
        //先把不好表示的都预先写出来
        String[] romans = {"I", "IV", "V", "IX", "X", "XL", "L", "XC", "C", "CD", "D", "CM", "M"};
        int[] nums = {1, 4, 5, 9, 10, 40, 50, 90, 100, 400, 500, 900, 1000};
        //从大到小一个一个的减过去就好了
        StringBuilder res = new StringBuilder();
        while(num != 0){
            for(int i = nums.length - 1; i >= 0; i--){
                if(num >= nums[i]){
                    //找到第一个适合的
                    num = num - nums[i];
                    res.append(romans[i]);
                    break;
                }
            }
        }
        return res.toString();
    }

}
