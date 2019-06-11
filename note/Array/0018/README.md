# [4Sum](https://leetcode.com/problems/4sum/)

Given an array `nums` of *n* integers and an integer `target`, are there elements *a*, *b*, *c*, and *d* in `nums` such that *a* + *b* + *c* + *d* = `target`? Find all unique quadruplets in the array which gives the sum of `target`.

**Note:**

The solution set must not contain duplicate quadruplets.

**Example:**

```
Given array nums = [1, 0, -1, 0, -2, 2], and target = 0.

A solution set is:
[
  [-1,  0, 0, 1],
  [-2, -1, 1, 2],
  [-2,  0, 0, 2]
]
```

# 思路0

感觉又碰到了[3Sum](../0011/README.md)一样的套路...

只是这边需要注意的地方就是会出现重复的结果，然后就需要进行剪枝操作，去除那些重复的结果还有就是提升以下速度

```java
package com.lhj1998.leetcode.Array._0018;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Solution {

    public List<List<Integer>> fourSum(int[] nums, int target) {
        Arrays.sort(nums);
        List<List<Integer>> res = new ArrayList<>();
        for(int i = 0; i < nums.length; i++){
            for(int j = i + 1; j < nums.length; j++){
                int left = j + 1, right = nums.length - 1;
                while(left < right){
                    int sum = nums[i] + nums[j] + nums[left] + nums[right];
                    if(sum == target) {
                        res.add(Arrays.asList(nums[i], nums[j], nums[left++], nums[right--]));
                        while(i < nums.length - 3 && nums[i] == nums[i + 1]) i++;
                        while(j < nums.length - 2 && nums[j] == nums[j + 1]) j++;
                        while(left < right && nums[left] == nums[left - 1]) left++;
                        while(left < right && nums[right] == nums[right + 1]) right--;
                    }
                    else if(sum > target) right --;
                    else left++;
                }
            }
        }
        return res;
    }

}

```

## 思路1

我感觉这么整下去不是个办法，4Sum两个for循环，那么5Sum、6Sum呢？一直加循环？

个人认为应该可以用递归的方式解决问题...但是还不会:see_no_evil: 先留个地，等会了我再补上来

```java

```

## 最后

可以加一下我，大家一起学习交流交朋友啊:relaxed::see_no_evil:

> QQ: 1392013658
>
> WeChat: LHJL8023
>
> Email: LHJ8023@outlook.com