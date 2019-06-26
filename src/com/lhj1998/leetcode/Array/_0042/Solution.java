package com.lhj1998.leetcode.Array._0042;

public class Solution {

    public int trap(int[] height) {
        if(null == height || height.length == 0) return 0;
        int left = 0, right = height.length - 1, maxLeft = 0, maxRight = 0, ans = 0;
        while(left < right){
            if(height[left] < height[right]){
                if (height[left] >= maxLeft) {
                    maxLeft = height[left];
                } else {
                    ans += (maxLeft - height[left]);
                }
                left++;
            }else{
                if (height[right] >= maxRight) {
                    maxRight = height[right];
                } else {
                    ans += (maxRight - height[right]);
                }
                right--;
            }
        }
        return ans;
    }

}
