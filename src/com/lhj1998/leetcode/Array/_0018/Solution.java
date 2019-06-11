package com.lhj1998.leetcode.Array._0018;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Solution {

    public List<List<Integer>> fourSum(int[] nums, int target) {
        Arrays.sort(nums);
        List<List<Integer>> res = new ArrayList<>();
        for(int i = 0; i < nums.length; i++){
            for(int j = i + 1; j < nums.length; j++){
                int left = j + 1, right = nums.length - 1;
                while(left < right){
                    int sum = nums[i] + nums[j] + nums[left] + nums[right];
                    if(sum == target) {
                        res.add(Arrays.asList(nums[i], nums[j], nums[left++], nums[right--]));
                        while(i < nums.length - 3 && nums[i] == nums[i + 1]) i++;
                        while(j < nums.length - 2 && nums[j] == nums[j + 1]) j++;
                        while(left < right && nums[left] == nums[left - 1]) left++;
                        while(left < right && nums[right] == nums[right + 1]) right--;
                    }
                    else if(sum > target) right --;
                    else left++;
                }
            }
        }
        return res;
    }

}
