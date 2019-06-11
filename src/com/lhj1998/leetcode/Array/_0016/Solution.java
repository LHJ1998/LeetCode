package com.lhj1998.leetcode.Array._0016;

import java.util.Arrays;

public class Solution {

    public int threeSumClosest(int[] nums, int target) {
        Arrays.sort(nums);
        int res = nums[0] + nums[1] + nums[2];
        for(int i = 0; i < nums.length; i++){
            int left = i + 1, right = nums.length - 1;
            while(left < right){
                int sum = nums[i] + nums[left] + nums[right];
                if(sum == target) return target;
                res = Math.abs(target - res) > Math.abs(target - sum) ? sum : res;
                if(sum > target) right--;
                else left++;
            }
        }
        return res;
    }

}
