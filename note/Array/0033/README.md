# [Search in Rotated Sorted Array](https://leetcode.com/problems/search-in-rotated-sorted-array/)

Suppose an array sorted in ascending order is rotated at some pivot unknown to you beforehand.

(i.e., `[0,1,2,4,5,6,7]` might become `[4,5,6,7,0,1,2]`).

You are given a target value to search. If found in the array return its index, otherwise return `-1`.

You may assume no duplicate exists in the array.

Your algorithm's runtime complexity must be in the order of *O*(log *n*).

**Example 1:**

```
Input: nums = [4,5,6,7,0,1,2], target = 0
Output: 4
```

**Example 2:**

```
Input: nums = [4,5,6,7,0,1,2], target = 3
Output: -1
```

## 思路0

在一个排好序的数组里找给定数的位置，很简单啦，要么直接遍历整个数组（当然这种办法肯定是最傻的，题目都说了是排好序的了），当然应该根据现有的条件`an array sorted`，使用二分查找法来做

另外需要注意的就是这里的有序是部分有序，因此需要分前后两个部分

```java
package com.lhj1998.leetcode.Array._0033;

public class Solution {

    public int search(int[] nums, int target) {
        if(nums.length == 0) return -1;
        int left = 0, right = left + 1;
        while(right < nums.length && nums[right] > nums[left]) right++; //找到前后两个部分的分界点
        right--;
        if(right != nums.length - 1) {  //如果分界点是最后一个元素的话 那么整体就是有序的 不需要分前后
            if(nums[left] > target) {   //如果前部分最小的那个大于目标值 那么目标值肯定是在后部分
                left = right + 1;
                right = nums.length - 1;
            }
        }
        while(left <= right) {
            int mid = ( left + right ) / 2;
            if(nums[mid] == target) return mid;
            if(nums[mid] > target) right = mid - 1;
            else left = mid + 1;
        }
        return -1;
    }

}

```

