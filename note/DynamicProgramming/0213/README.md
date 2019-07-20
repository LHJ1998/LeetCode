# [House Robber II](https://leetcode.com/problems/house-robber-ii/)

You are a professional robber planning to rob houses along a street. Each house has a certain amount of money stashed. All houses at this place are **arranged in a circle.** That means the first house is the neighbor of the last one. Meanwhile, adjacent houses have security system connected and **it will automatically contact the police if two adjacent houses were broken into on the same night**.

Given a list of non-negative integers representing the amount of money of each house, determine the maximum amount of money you can rob tonight **without alerting the police**.

**Example 1:**

```
Input: [2,3,2]
Output: 3
Explanation: You cannot rob house 1 (money = 2) and then rob house 3 (money = 2),
             because they are adjacent houses.
```

**Example 2:**

```
Input: [1,2,3,1]
Output: 4
Explanation: Rob house 1 (money = 1) and then rob house 3 (money = 3).
             Total amount you can rob = 1 + 3 = 4.
```

## 思路0

这个题目和 [House Robber](0198/README.md) 的区别在于，给出的数组可以看作一个环，第一家和最后一家是邻居

那么在解决这个问题的时候，就是分偷第一家和不偷第一家的情况

```java
package com.lhj1998.leetcode.DynamicProgramming._0213;

public class Solution {

    public int rob(int[] nums) {
        if(null == nums || nums.length == 0) return 0;
        if(nums.length == 1) return nums[0];
        int[] dp = new int[nums.length];
        int[] dp2 = new int[nums.length];
        dp[0] = nums[0];
        dp[1] = nums[0] > nums[1] ? nums[0] : nums[1];
        //dp2不偷第一家
        dp2[0] = 0;
        dp2[1] = nums[1];
        for(int i = 2; i < nums.length; i++){
            //偷第一家的必须保证这一家不是第一家的邻居
            if(i != nums.length - 1) dp[i] = Math.max(nums[i] + dp[i - 2], dp[i - 1]);
            else dp[i] = dp[i - 1];
            dp2[i] = Math.max(nums[i] + dp2[i - 2], dp2[i - 1]);
        }
        return Math.max(dp[nums.length - 1], dp2[nums.length - 1]);
    }

}

```

