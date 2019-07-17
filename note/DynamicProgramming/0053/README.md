# [Maximum Subarray](https://leetcode.com/problems/maximum-subarray/)

Given an integer array `nums`, find the contiguous subarray (containing at least one number) which has the largest sum and return its sum.

**Example:**

```
Input: [-2,1,-3,4,-1,2,1,-5,4],
Output: 6
Explanation: [4,-1,2,1] has the largest sum = 6.
```

**Follow up:**

If you have figured out the O(*n*) solution, try coding another solution using the divide and conquer approach, which is more subtle.

## 思路0

这个问题很好解决，就是找到连续的最大的和。

一开始肯定是从头往后遍历一个序列，并记录这个序列的值，但是在累加的过程中，可能出现负数的情况，使得这个序列的值变小，也许后面还会有一个正数让这个序列的值变得更大，当然也有可能变得更小，那么怎么判定这个序列有保存下来的必要而不是兴起一个序列就是关键了

如果这个序列的累加和都是负数了，当然就没有保存下来的必要了，想想如果后面有一个正数可以让这个序列的和变成正数，但是这个变化后的正数一定会比原来的正数小，既然如此，为了找到最大的和，为什么不直接从那个正数开始呢是吧

```java
package com.lhj1998.leetcode.DynamicProgramming._0053;

public class Solution {

    public int maxSubArray(int[] nums) {
        if(null == nums || nums.length == 0) return 0;
        int max = Integer.MIN_VALUE, curr = 0;
        for (int num : nums) {
            curr += num;
            max = Math.max(curr, max);
            //如果curr小于0了，那么就应该舍弃前面的累加，判断当前位置的值
            //从当前位置开始累加或者从下一个位置开始累加（curr = 0）
            if (curr < 0) {
                curr = num < 0 ? 0 : num;
            }
        }
        return max;
    }

}

```



