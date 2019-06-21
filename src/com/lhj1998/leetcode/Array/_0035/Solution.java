package com.lhj1998.leetcode.Array._0035;

public class Solution {

    public int searchInsert(int[] nums, int target) {
        int index = binarySearch(nums, target);
        if(nums[index] == target) return index;
        else if(nums[index] > target) return index;
        else return index + 1;
    }

    private int binarySearch(int[] nums, int target){
        int left = 0, right = nums.length - 1, mid = 0;
        while(left <= right){
            mid = (left + right) / 2;
            if(nums[mid] == target) return mid;
            else if(nums[mid] > target) right = mid - 1;
            else left = mid + 1;
        }
        return mid;
    }

//    public int searchInsert(int[] nums, int target) {
//        int pos = 0;
//        while(pos < nums.length && nums[pos] < target) pos++;
//        return pos;
//    }


}
