package com.lhj1998.leetcode.Array._0075;

public class Solution {

//    public void sortColors(int[] nums) {
//        int zeroNums = 0, oneNums = 0, twoNums = 0;
//        for(int i = 0; i < nums.length; i++){
//            if(nums[i] == 0) zeroNums++;
//            else if(nums[i] == 1) oneNums++;
//            else twoNums++;
//        }
//        for(int i = 0; i < zeroNums; i++){
//            nums[i] = 0;
//        }
//        for(int i = zeroNums; i < zeroNums + oneNums; i++){
//            nums[i] = 1;
//        }
//        for(int i = zeroNums + oneNums; i < zeroNums + oneNums + twoNums; i++){
//            nums[i] = 2;
//        }
//    }

    public void sortColors(int[] nums) {
        quickSort(nums, 0, nums.length - 1);
    }

    private void quickSort(int[] nums, int left, int right){
        if(left < right) {
            int i = left, j = right, temp = nums[left];
            while(i < j) {
                while(i < j && nums[j] >= temp) j--;
                nums[i] = nums[j];
                while(i < j && nums[i] <= temp) i++;
                nums[j] = nums[i];
            }
            nums[i] = temp;
            quickSort(nums, left, i - 1);
            quickSort(nums, i + 1, right);
        }
    }

}
