# [Longest Increasing Subsequence](https://leetcode.com/problems/longest-increasing-subsequence/)

Given an unsorted array of integers, find the length of longest increasing subsequence.

**Example:**

```
Input: [10,9,2,5,3,7,101,18]
Output: 4 
Explanation: The longest increasing subsequence is [2,3,7,101], therefore the length is 4. 
```

**Note:**

- There may be more than one LIS combination, it is only necessary for you to return the length.
- Your algorithm should run in O(*n2*) complexity.

**Follow up:** Could you improve it to O(*n* log *n*) time complexity?

## 思路0

一开始我以为这个题目要的是连续的递增序列，然后再看示例的时候`2 3 7 10`是最长的，但是2 3之间还隔着一个5呢...

所以这个是找到**非连续**的最长递增子序列的长度。可以确定的是，在每一个位置，最小的长度肯定是1。对于第i个位置来说，他的最长长度应该是前面的最长长度+1，当然前提是第i个位置的值大于第j个位置的值

```java
package com.lhj1998.leetcode.DynamicProgramming._0300;

import java.util.Arrays;

public class Solution {

    public int lengthOfLIS(int[] nums) {
        if(null == nums || nums.length == 0) return 0;
        int[] dp = new int[nums.length];
        int max = 1;
        Arrays.fill(dp, 1);
        for(int i = 1; i < nums.length; i++){
            //找前面的j个位置
            for(int j = 0; j < i; j++){
                if(nums[i] > nums[j]){
                    dp[i] = Math.max(dp[i], dp[j] + 1);
                }
                max = Math.max(max, dp[i]);
            }
        }
        return max;
    }
    
}

```

最后是通过了的，但是世家效率不高，但是好歹是自己动了脑筋想出来的，还是挺高兴的 13ms 32.35%

## 思路1

题目要求的是找一个递增序列的最大长度，递增哦，那么是不是可以试试二分搜索。

可以这么想，如果有一个数组temp，然后先把给定的数组nums的第一个元素加进去，再遍历nums，用二分搜索找nums[i]在temp的位置，如果这个位置在最后面，说明数组长度+1了，最后得到的长度就是这个长度了

0ms解法，牛逼

```java
package com.lhj1998.leetcode.DynamicProgramming._0300;

import java.util.Arrays;

public class Solution {

    public int lengthOfLIS(int[] nums) {
        if(null == nums || nums.length == 0) return 0;
        int[] temp = new int[nums.length];
        int size = 0;
        for(int i = 0; i < nums.length; i++){
            int index = binarySearch(temp, 0, size - 1, nums[i]);
            temp[index] = nums[i];
            if(index == size) size++;
        }
        return size;
    }

    private int binarySearch(int[] nums, int left, int right, int target){
        if(left <= right){
            int mid = (left + right) / 2;
            if(nums[mid] == target) return mid;
            if(nums[mid] > target) return binarySearch(nums, left, mid - 1, target);
            return binarySearch(nums, mid + 1, right, target);
        }
        return left;
    }

}

```

