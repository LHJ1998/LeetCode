# [Remove Element](https://leetcode.com/problems/remove-element/)

Given an array *nums* and a value *val*, remove all instances of that value [**in-place**](https://en.wikipedia.org/wiki/In-place_algorithm) and return the new length.

Do not allocate extra space for another array, you must do this by **modifying the input array in-place** with O(1) extra memory.

The order of elements can be changed. It doesn't matter what you leave beyond the new length.

**Example 1:**

```
Given nums = [3,2,2,3], val = 3,

Your function should return length = 2, with the first two elements of nums being 2.

It doesn't matter what you leave beyond the returned length.
```

**Example 2:**

```
Given nums = [0,1,2,2,3,0,4,2], val = 2,

Your function should return length = 5, with the first five elements of nums containing 0, 1, 3, 0, and 4.

Note that the order of those five elements can be arbitrary.

It doesn't matter what values are set beyond the returned length.
```

**Clarification:**

Confused why the returned value is an integer but your answer is an array?

Note that the input array is passed in by **reference**, which means modification to the input array will be known to the caller as well.

Internally you can think of this:

```
// nums is passed in by reference. (i.e., without making a copy)
int len = removeElement(nums, val);

// any modification to nums in your function would be known by the caller.
// using the length returned by your function, it prints the first len elements.
for (int i = 0; i < len; i++) {
    print(nums[i]);
}
```

## 思路0

这道题目要求的是移除给定数组中给定的值，在不使用额外空间的情况下只能选择移动和覆盖，其实最简单的方法就是每找到一个val的值，那么就把后面的向前移动一位，这是没有问题的，但是效率不高，因为可能有这么一种情况`0 1 2 3 2 2 2 2 2 2 2 2 2 2 2 2 2 2 2 2 2 3`这样的情况下，如果要求去除掉val是2，每发现一个2都要把后面的数向前移动，那么代价是很高的，移动的话应该移动那些非val的值

```java
package com.lhj1998.leetcode.Array._0027;

public class Solution {

    public int removeElement(int[] nums, int val) {
        int count = 0, i = 0;
        //找到第一个val位置
        while(i < nums.length && nums[i] != val) i++;
        for(int j = i; j < nums.length; j++){
            if(nums[j] != val) nums[i++] = nums[j]; //避免重复劳动，不移动val的值
            else count++;
        }
        return nums.length - count;
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