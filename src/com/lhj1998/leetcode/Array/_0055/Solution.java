package com.lhj1998.leetcode.Array._0055;

public class Solution {

    public boolean canJump(int[] nums){
        int maxJump = 0;
        for(int i = 0; i < nums.length; i++){
            if(i > maxJump) return false;
            maxJump = Math.max(maxJump, i + nums[i]);
        }
        return maxJump >= nums.length - 1;
    }

}
