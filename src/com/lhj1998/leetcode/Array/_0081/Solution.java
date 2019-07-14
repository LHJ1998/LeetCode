package com.lhj1998.leetcode.Array._0081;

public class Solution {

    public boolean search(int[] nums, int target) {
        if(null == nums || nums.length == 0) return false;
        if(nums.length == 1) return nums[0] == target;
        int right = 1;
        while(right < nums.length && nums[right] >= nums[right - 1]) right++;
        right--;
        if(right == nums.length - 1){
            return binarySearch(nums, 0, nums.length - 1, target);
        }
        if(target >= nums[0] && target <= nums[right]){
            return binarySearch(nums, 0, right, target);
        }
        if(target >= nums[right + 1] && target <= nums[nums.length - 1]){
            return binarySearch(nums, right + 1, nums.length - 1, target);
        }
        return false;
    }

    private boolean binarySearch(int[] nums, int left, int right, int target){
        if(left <= right){
            int mid = ( left + right ) / 2;
            if(nums[mid] == target) return true;
            else if(nums[mid] > target) return binarySearch(nums, left, mid - 1, target);
            else return binarySearch(nums, mid + 1, right, target);
        }
        return false;
    }

}
