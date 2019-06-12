package com.lhj1998.leetcode.Array._0026;

public class Solution {

//    public int removeDuplicates(int[] nums) {
//        if(nums.length == 0) return 0;
//        int count = 1;
//        //从前向后扫描
//        for(int i = 1; i < nums.length; i++){
//            boolean flag = false;	//记录是否有被修改
//            if(nums[i] <= nums[i - 1]){
//                for(int j = i + 1; j < nums.length; j++){
//                    if(nums[j] > nums[i - 1]){	//找到第一个比当前位置的前一个数大的数
//                        nums[i] = nums[j];
//                        count++;
//                        flag = true;
//                        break;
//                    }
//                }
//                if(!flag) break;	//如果没有被修改，那么说明找不到更大的数了，就没有必要继续遍历了
//            }else count++;
//        }
//        return count;
//    }

//    public int removeDuplicates(int[] nums) {
//        if(nums.length == 0) return 0;
//        int count = 1;
//        for(int i = 1; i < nums.length; i++){
//            if(nums[i - 1] >= nums[i]){
//                int j = i + 1;
//                while(j < nums.length && nums[j] <= nums[i - 1]) j++;
//                if(j < nums.length){
//                    count++;
//                    nums[i] = nums[j];
//                } else break;
//            } else count++;
//        }
//        return count;
//    }

    public int removeDuplicates(int[] nums) {
        if(nums.length == 0) return 0;
        int count = 1;
        for(int i = 1, j = i + 1; i < nums.length; i++){
            if(nums[i - 1] >= nums[i]){
                //找到第一个符合要求的数
                while(j < nums.length && nums[j] <= nums[i - 1]) j++;
                if(j < nums.length){
                    count++;
                    nums[i] = nums[j++];
                    //去除重复的数
                    while(j < nums.length && nums[j] == nums[j - 1]) j++;
                } else break;
            } else count++;
        }
        return count;
    }
}
