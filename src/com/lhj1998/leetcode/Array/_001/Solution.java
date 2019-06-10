package com.lhj1998.leetcode.Array._001;

import java.util.HashMap;

public class Solution {

//    public int[] twoSum(int[] nums, int target) {
//        for(int i = 0; i < nums.length; i++){
//            for(int j = i + 1; j < nums.length; j++){
//                if(nums[i] + nums[j] == target) return new int[] {i, j};
//            }
//        }
//        return null;
//    }

    public int[] twoSum(int[] nums, int target) {
        HashMap<Integer, Integer> map = new HashMap<>();
        for(int i = 0; i < nums.length; i++){
            int next = target - nums[i];
            if(map.containsKey(next)) return new int[] {map.get(next), i};
            map.put(nums[i], i);
        }
        return null;
    }

}
