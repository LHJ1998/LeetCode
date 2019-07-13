# [Sort Colors](https://leetcode.com/problems/sort-colors/)

Given an array with *n* objects colored red, white or blue, sort them **in-place** so that objects of the same color are adjacent, with the colors in the order red, white and blue.

Here, we will use the integers 0, 1, and 2 to represent the color red, white, and blue respectively.

**Note:** You are not suppose to use the library's sort function for this problem.

**Example:**

```
Input: [2,0,2,1,1,0]
Output: [0,0,1,1,2,2]
```

**Follow up:**

- A rather straight forward solution is a two-pass algorithm using counting sort.
  First, iterate the array counting number of 0's, 1's, and 2's, then overwrite array with total number of 0's, then 1's and followed by 2's.
- Could you come up with a one-pass algorithm using only constant space?

## 思路0

题目末尾提示了可以用计数排序做，然后我就试了一下...

```java
package com.lhj1998.leetcode.Array._0075;

public class Solution {

    public void sortColors(int[] nums) {
        int zeroNums = 0, oneNums = 0, twoNums = 0;
        for(int i = 0; i < nums.length; i++){
            if(nums[i] == 0) zeroNums++;
            else if(nums[i] == 1) oneNums++;
            else twoNums++;
        }
        for(int i = 0; i < zeroNums; i++){
            nums[i] = 0;
        }
        for(int i = zeroNums; i < zeroNums + oneNums; i++){
            nums[i] = 1;
        }
        for(int i = zeroNums + oneNums; i < zeroNums + oneNums + twoNums; i++){
            nums[i] = 2;
        }
    }
    
}

```

## 思路1

这题目纯粹就是考排序，然后我顺便练练我的快排

```java
package com.lhj1998.leetcode.Array._0075;

public class Solution {

    public void sortColors(int[] nums) {
        quickSort(nums, 0, nums.length - 1);
    }

    private void quickSort(int[] nums, int left, int right){
        if(left < right) {
            int i = left, j = right, temp = nums[left];
            while(i < j) {
                while(i < j && nums[j] >= temp) j--;
                nums[i] = nums[j];
                while(i < j && nums[i] <= temp) i++;
                nums[j] = nums[i];
            }
            nums[i] = temp;
            quickSort(nums, left, i - 1);
            quickSort(nums, i + 1, right);
        }
    }

}

```

## 思路2

大神的一次操作排序法

```java
    public void sortColors(int[] nums) {
        int i = 0, j = 0, k = 0;
        for (; k < nums.length; ++k) {
            int v = nums[k];
            nums[k] = 2;
            if (v < 2) nums[j++] = 1;
            if (v == 0) nums[i++] = 0;
        }
    }
```

