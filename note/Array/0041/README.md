# [First Missing Positive](https://leetcode.com/problems/first-missing-positive/)

Given an unsorted integer array, find the smallest missing positive integer.

**Example 1:**

```
Input: [1,2,0]
Output: 3
```

**Example 2:**

```
Input: [3,4,-1,1]
Output: 2
```

**Example 3:**

```
Input: [7,8,9,11,12]
Output: 1
```

## 思路0

可以用桶排序做，每个桶放一个数字的个数，然后遍历这个桶，找到第一个为0的位置就是结果了。

题目中，数字小于等于0的还有大于nums.length + 1的可以排除掉，因为最大的数是nums.length + 1 （1 2 3）那么最大的数是4

```java
package com.lhj1998.leetcode.Array._0041;

public class Solution {

    public int firstMissingPositive(int[] nums) {
        if(nums.length == 0 || nums.length == 1 && nums[0] <= 0) return 1;
        int[] array = new int[nums.length + 1];
        for(int i = 0; i < nums.length; i++){
            //排除非正常情况
            if(nums[i] <= 0 || nums[i] > nums.length + 1) continue;
            array[nums[i] - 1]++;
        }
        for(int i = 0; i < array.length; i++){
            if(array[i] == 0) return i + 1;
        }
        return 0;
    }

}

```

