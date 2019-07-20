# [House Robber](https://leetcode.com/problems/house-robber/)

You are a professional robber planning to rob houses along a street. Each house has a certain amount of money stashed, the only constraint stopping you from robbing each of them is that adjacent houses have security system connected and **it will automatically contact the police if two adjacent houses were broken into on the same night**.

Given a list of non-negative integers representing the amount of money of each house, determine the maximum amount of money you can rob tonight **without alerting the police**.

**Example 1:**

```
Input: [1,2,3,1]
Output: 4
Explanation: Rob house 1 (money = 1) and then rob house 3 (money = 3).
             Total amount you can rob = 1 + 3 = 4.
```

**Example 2:**

```
Input: [2,7,9,3,1]
Output: 12
Explanation: Rob house 1 (money = 2), rob house 3 (money = 9) and rob house 5 (money = 1).
             Total amount you can rob = 2 + 9 + 1 = 12.
```

## 思路0

总的来说，题目就是要求非连续得子集最大和

很简单的一道题，但是我一开始没做出来，看了别人的解析才恍然大悟

可以这么设想，偷第i家的时候，有两种情况，一种是偷这家（`dp[i - 2] + nums[i]`），一种是不偷这家（`dp[i - 1]`），因为要实现最大的价值，所以要尽可能多偷几家，因此偷这家的时候需要从前前一家开始偷，即`dp[i - 2]`

```java
package com.lhj1998.leetcode.DynamicProgramming._0198;

public class Solution {

    public int rob(int[] nums) {
        if(nums == null || nums.length == 0) return 0;
        if(nums.length == 1) return nums[0];
        int[] dp = new int[nums.length];
        dp[0] = nums[0];
        dp[1] = nums[0] > nums[1] ? nums[0] : nums[1];
        for(int i = 2; i < nums.length; i++){
            dp[i] = Math.max(nums[i] + dp[i - 2], dp[i - 1]);
        }
        return dp[nums.length - 1];
    }

}

```

