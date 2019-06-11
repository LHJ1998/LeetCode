# [3Sum Closest](https://leetcode.com/problems/3sum-closest/)

Given an array `nums` of *n* integers and an integer `target`, find three integers in `nums` such that the sum is closest to `target`. Return the sum of the three integers. You may assume that each input would have exactly one solution.

**Example:**

```
Given array nums = [-1, 2, 1, -4], and target = 1.

The sum that is closest to the target is 2. (-1 + 2 + 1 = 2).
```

## 思路0

这道题目和之前的[3Sum](../0015/README.md)差不多就是一道题，唯一的区别就是不是求三个数的和为target，而是求和target最近的那个值，不就是|target - sum|最小的那个吗，做法和[3Sum](../0015/README.md)一样

```java
package com.lhj1998.leetcode.Array._0016;

import java.util.Arrays;

public class Solution {

    public int threeSumClosest(int[] nums, int target) {
        Arrays.sort(nums);
        //初始化res的值 随意设定会有风险 还是用给定的东西比较好 -- 亲测随意设定错误
        int res = nums[0] + nums[1] + nums[2];
        for(int i = 0; i < nums.length; i++){
            int left = i + 1, right = nums.length - 1;
            while(left < right){
                int sum = nums[i] + nums[left] + nums[right];
                if(sum == target) return target;
                res = Math.abs(target - res) > Math.abs(target - sum) ? sum : res;
                if(sum > target) right--;
                else left++;
            }
        }
        return res;
    }

}

```

