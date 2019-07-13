package com.lhj1998.leetcode.Array._0066;

public class Solution {

    public int[] plusOne(int[] digits) {
        for(int i = digits.length - 1; i >= 0; i--){
            if((digits[i] + 1 >= 10) && i == 0){
                //最高位+1进位
                digits[i] = digits[i] - 9;
                return insert(digits);
            }else if((digits[i] + 1 >= 10) && i != 0){
                //中间某位+1进位
                digits[i] = digits[i] - 9;
            }else{
                digits[i]++;
                break;
            }
        }
        return digits;
    }

    private int[] insert(int[] digits){
        int[] res = new int[digits.length + 1];
        for(int i = 1; i < res.length; i++){
            res[i] = digits[i - 1];
        }
        res[0] = 1;
        return res;
    }

}
