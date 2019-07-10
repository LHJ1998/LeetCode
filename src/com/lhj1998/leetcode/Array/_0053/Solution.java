package com.lhj1998.leetcode.Array._0053;

public class Solution {

    public int maxSubArray(int[] nums) {
        if(null == nums || nums.length == 0) return 0;
        int max = Integer.MIN_VALUE, curr = 0;
        for (int num : nums) {
            curr += num;
            max = Math.max(curr, max);
            //如果curr小于0了，那么就应该舍弃前面的累加，判断当前位置的值
            //从当前位置开始累加或者从下一个位置开始累加（curr = 0）
            if (curr < 0) {
                curr = num < 0 ? 0 : num;
            }
        }
        return max;
    }

}
