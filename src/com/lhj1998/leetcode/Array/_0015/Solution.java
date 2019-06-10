package com.lhj1998.leetcode.Array._0015;

import java.util.*;

public class Solution {

//    public List<List<Integer>> threeSum(int[] nums) {
//        Set<List<Integer>> res = new HashSet<>();
//        for(int i = 0; i < nums.length; i++){
//            for(int j = i + 1; j < nums.length; j++){
//                for(int k = j + 1; k < nums.length; k++){
//                    if(nums[i] + nums[j] + nums[k] == 0){
//                        int[] array = new int[] {nums[i], nums[j], nums[k]};
//                        Arrays.sort(array); //排序 通过set去重
//                        res.add(Arrays.asList(array[0], array[1], array[2]));
//                    }
//                }
//            }
//        }
//        return new ArrayList<>(res);
//    }

    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        Arrays.sort(nums);  //先给nums排序
        for(int i = 0; i < nums.length; i++){
            //如果前一个数和现在的这个数相同 那么就没有必要继续下去了 因为重复了啊
            if(i > 0 && nums[i - 1] == nums[i]) continue;
            //如果第一个数都大于0了 后面的数就不可能是小于0的 那么三个数的和就不可能是0了
            if(nums[i] > 0) break;
            int left = i + 1, right = nums.length - 1;
            while(left < right){
                int sum = nums[i] + nums[left] + nums[right];
                if(sum == 0){
                    res.add(Arrays.asList(nums[i], nums[left++], nums[right--]));
                    //去重 很重要
                    while(left < right && nums[left] == nums[left - 1]) left++;
                    while(left < right && nums[right] == nums[right + 1]) right--;
                }
                else if(sum > 0) right--;   //太大啦 右指针往前走
                else left++;    //太小啦
            }
        }
        return res;
    }

}
