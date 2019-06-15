package com.lhj1998.leetcode.Array._0033;

public class Solution {

    public int search(int[] nums, int target) {
        if(nums.length == 0) return -1;
        int left = 0, right = left + 1;
        while(right < nums.length && nums[right] > nums[left]) right++; //找到前后两个部分的分界点
        right--;
        if(right != nums.length - 1) {  //如果分界点是最后一个元素的话 那么整体就是有序的 不需要分前后
            if(nums[left] > target) {   //如果前部分最小的那个大于目标值 那么目标值肯定是在后部分
                left = right + 1;
                right = nums.length - 1;
            }
        }
        while(left <= right) {
            int mid = ( left + right ) / 2;
            if(nums[mid] == target) return mid;
            if(nums[mid] > target) right = mid - 1;
            else left = mid + 1;
        }
        return -1;
    }

}
