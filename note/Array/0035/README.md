# [Search Insert Position](https://leetcode.com/problems/search-insert-position/)

Given a sorted array and a target value, return the index if the target is found. If not, return the index where it would be if it were inserted in order.

You may assume no duplicates in the array.

**Example 1:**

```
Input: [1,3,5,6], 5
Output: 2
```

**Example 2:**

```
Input: [1,3,5,6], 2
Output: 1
```

**Example 3:**

```
Input: [1,3,5,6], 7
Output: 4
```

**Example 4:**

```
Input: [1,3,5,6], 0
Output: 0
```

## 思路0

给出一个已经排好序的数组和一个目标值，如果有这个目标值，那么给出目标值的位置，否则找到这个目标值的插入位置。

em...最简单的就是从前到后的一次遍历了

```java
package com.lhj1998.leetcode.Array._0035;

public class Solution {

    public int searchInsert(int[] nums, int target) {
        int pos = 0;
        while(pos < nums.length && nums[pos] < target) pos++;
        return pos;
    }

}
```

## 思路1

我感觉是可以用二分的吧，毕竟这个东西是排好序的，而且题目说了`You may assume no duplicates in the array.`没有重复的值，那么最后通过二分拿到那个mid，如果mid位置的值等于target，皆大欢喜，否则判断以下大小，取mid或者mid-1不就好了

```java
package com.lhj1998.leetcode.Array._0035;

public class Solution {

    public int searchInsert(int[] nums, int target) {
        int index = binarySearch(nums, target);
        if(nums[index] == target) return index;
        else if(nums[index] > target) return index;
        else return index + 1;
    }

    private int binarySearch(int[] nums, int target){
        int left = 0, right = nums.length - 1, mid = 0;
        while(left <= right){
            mid = (left + right) / 2;
            if(nums[mid] == target) return mid;
            else if(nums[mid] > target) right = mid - 1;
            else left = mid + 1;
        }
        return mid;
    }
    
}

```

