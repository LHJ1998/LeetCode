# [Next Permutation](https://leetcode.com/problems/next-permutation/)

Implement **next permutation**, which rearranges numbers into the lexicographically next greater permutation of numbers.

If such arrangement is not possible, it must rearrange it as the lowest possible order (ie, sorted in ascending order).

The replacement must be **in-place** and use only constant extra memory.

Here are some examples. Inputs are in the left-hand column and its corresponding outputs are in the right-hand column.

`1,2,3` → `1,3,2`

`3,2,1` → `1,2,3`

`1,1,5` → `1,5,1`

## 思路0

这道题就是给你一个全排列，然后求下一个全排列。这道题我感觉我就只会先求出所有的全排列，然后再找到给定的这个排列的下一个就解决了，但是这种方法绝对过不去的

说到底还是我不会做呗:see_no_evil:然后果断参考了别人的做法:see_no_evil:

![Next_Permutation](Next_Permutation.gif)

以上是原理图，没想到还有这种规律...

```java
package com.lhj1998.leetcode.Array._0031;

public class Solution {

    public void nextPermutation(int[] nums) {
        int i = nums.length - 2, j = nums.length - 1;
        while(i >= 0 && nums[i] >= nums[i + 1]) i--;
        if(i >= 0){
            while(j >= 0 && nums[j] <= nums[i]) j--;
            swap(nums, i, j);
        }
        for(i = i + 1, j = nums.length - 1; i < j; i++, j--){
            swap(nums, i, j);
        }
    }

    private void swap(int[] nums, int i, int j){
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
    
}

```

## 最后

可以加一下我，大家一起学习交流交朋友啊:relaxed::see_no_evil:

> QQ: 1392013658
>
> WeChat: LHJL8023
>
> Email: LHJ8023@outlook.com