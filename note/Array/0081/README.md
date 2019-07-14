# [Search in Rotated Sorted Array II](https://leetcode.com/problems/search-in-rotated-sorted-array-ii/)

Suppose an array sorted in ascending order is rotated at some pivot unknown to you beforehand.

(i.e., `[0,0,1,2,2,5,6]` might become `[2,5,6,0,0,1,2]`).

You are given a target value to search. If found in the array return `true`, otherwise return `false`.

**Example 1:**

```
Input: nums = [2,5,6,0,0,1,2], target = 0
Output: true
```

**Example 2:**

```
Input: nums = [2,5,6,0,0,1,2], target = 3
Output: false
```

**Follow up:**

- This is a follow up problem to [Search in Rotated Sorted Array](https://leetcode.com/problems/search-in-rotated-sorted-array/description/), where `nums` may contain duplicates.
- Would this affect the run-time complexity? How and why?

## 思路0

这个可以参考 [Search in Rotated Sorted Array](note/Array/0033/README.md) 的做法，这个题目只是说会有重复的数字而已，但是这并不影响解题的方法吧

```java
package com.lhj1998.leetcode.Array._0081;

public class Solution {

    public boolean search(int[] nums, int target) {
        if(null == nums || nums.length == 0) return false;
        if(nums.length == 1) return nums[0] == target;
        int right = 1;
        while(right < nums.length && nums[right] >= nums[right - 1]) right++;
        right--;
        if(right == nums.length - 1){
            return binarySearch(nums, 0, nums.length - 1, target);
        }
        if(target >= nums[0] && target <= nums[right]){
            return binarySearch(nums, 0, right, target);
        }
        if(target >= nums[right + 1] && target <= nums[nums.length - 1]){
            return binarySearch(nums, right + 1, nums.length - 1, target);
        }
        return false;
    }

    private boolean binarySearch(int[] nums, int left, int right, int target){
        if(left <= right){
            int mid = ( left + right ) / 2;
            if(nums[mid] == target) return true;
            else if(nums[mid] > target) return binarySearch(nums, left, mid - 1, target);
            else return binarySearch(nums, mid + 1, right, target);
        }
        return false;
    }
    
}

```

代码通过了，但是效率不高，只超过了50.70的人，并不理想

