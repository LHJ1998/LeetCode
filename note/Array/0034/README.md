# [Find First and Last Position of Element in Sorted Array](https://leetcode.com/problems/find-first-and-last-position-of-element-in-sorted-array/)

Given an array of integers `nums` sorted in ascending order, find the starting and ending position of a given `target` value.

Your algorithm's runtime complexity must be in the order of *O*(log *n*).

If the target is not found in the array, return `[-1, -1]`.

**Example 1:**

```
Input: nums = [5,7,7,8,8,10], target = 8
Output: [3,4]
```

**Example 2:**

```
Input: nums = [5,7,7,8,8,10], target = 6
Output: [-1,-1]
```

## 思路0

这题目和[0033](note/Array/0033/README.md)差不多啊，反正思路是一样的，就是先用二分搜索法找到target，但是在这个题目中，首先找到的位置可能是中间的位置，因此还需要前后搜索找到最左和最右的两个位置就搞定啦

```java
package com.lhj1998.leetcode.Array._0034;

public class Solution {

    public int[] searchRange(int[] nums, int target) {
        if(nums.length == 0) return new int[] { -1, -1 };
        int left = 0, right = nums.length - 1;
        while(left <= right) {
            int mid = ( left + right ) / 2;
            if(nums[mid] == target) {
                left = right = mid;
                while(left > 0 && nums[left - 1] == target) left--;
                while(right < nums.length - 1 && nums[right + 1] == target) right++;
                return new int[] {left, right};
            }
            if(nums[mid] > target) right = mid - 1;
            else left = mid + 1;
        }
        return new int[] { -1, -1 };
    }

}

```

