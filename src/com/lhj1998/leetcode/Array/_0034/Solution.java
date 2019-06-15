package com.lhj1998.leetcode.Array._0034;

public class Solution {

    public int[] searchRange(int[] nums, int target) {
        if(nums.length == 0) return new int[] { -1, -1 };
        int left = 0, right = nums.length - 1;
        while(left <= right) {
            int mid = ( left + right ) / 2;
            if(nums[mid] == target) {
                left = right = mid;
                while(left > 0 && nums[left - 1] == target) left--;
                while(right < nums.length - 1 && nums[right + 1] == target) right++;
                return new int[] {left, right};
            }
            if(nums[mid] > target) right = mid - 1;
            else left = mid + 1;
        }
        return new int[] { -1, -1 };
    }

}
