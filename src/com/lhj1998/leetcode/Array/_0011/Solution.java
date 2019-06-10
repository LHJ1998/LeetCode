package com.lhj1998.leetcode.Array._0011;

public class Solution {

//    public int maxArea(int[] height) {
//        int max = 0, left = 0, right = height.length - 1;
//        while(left < right) {
//            max = Math.max(max, Math.min(height[left], height[right]) * right - left);
//            if(height[left] > height[right]) while(height[right - 1] < height[right]) right--;
//            else left++;
//        }
//        return max;
//    }

    public int maxArea(int[] height) {
        int max = 0;
        for(int i = 0; i < height.length; i++){
            for(int j = i + 1; j < height.length; j++){
                max = Math.max(max, Math.min(height[i], height[j]) * (j - i));
            }
        }
        return max;
    }

}
