# [3Sum](https://leetcode.com/problems/3sum/)

Given an array `nums` of *n* integers, are there elements *a*, *b*, *c* in `nums` such that *a* + *b* + *c*= 0? Find all unique triplets in the array which gives the sum of zero.

**Note:**

The solution set must not contain duplicate triplets.

**Example:**

```
Given array nums = [-1, 0, 1, 2, -1, -4],

A solution set is:
[
  [-1, 0, 1],
  [-1, -1, 2]
]
```

## 思路0

这道题其实不难啊，就是找三个数（a、b、c）的和为0的组合，那么我直接三个循环不就完美解决问题了吗:see_no_evil: 崇尚暴力美学

```java
package com.lhj1998.leetcode.Array._0015;

import java.util.*;

public class Solution {

    public List<List<Integer>> threeSum(int[] nums) {
        Set<List<Integer>> res = new HashSet<>();
        for(int i = 0; i < nums.length; i++){
            for(int j = i + 1; j < nums.length; j++){
                for(int k = j + 1; k < nums.length; k++){
                    if(nums[i] + nums[j] + nums[k] == 0){
                        int[] array = new int[] {nums[i], nums[j], nums[k]};
                        Arrays.sort(array); //排序 通过set去重
                        res.add(Arrays.asList(array[0], array[1], array[2]));
                    }
                }
            }
        }
        return new ArrayList<>(res);
    }

}

```

代码写完啦，但是咱过不去 [Time Limit Exceeded]()​ ​ ​ :see_no_evil: 暴力美学惨遭滑铁卢

## 思路1

暴力破解是过不去了，其实这个只要先确定一个数，然后不就像求两数之和 [Two Sum](../0001/README.md) 一样了吗，思路是这样没错，但是不一样的地方在于 [Two Sum](../0001/README.md) 的做法是构造一个HashMap，但是这道题如果还去构造一个HashMap就太麻烦了~估计也是过不去

换个思路，这道题分析到现在我们需要的是`a + b = -c` 已知c求a、b，如果给定的这个`nums`是有序的呢？如果是有序的，那么就可以引入两个指针指向数组的两端，然后通过移动这两个指针快速定位到剩下的两个数，然后又因为c是确定的，三个数不就出来了吗~

26ms通关，如果没看懂思路可以看看代码，可能不善于表达:see_no_evil: 

```java
package com.lhj1998.leetcode.Array._0015;

import java.util.*;

public class Solution {

    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        Arrays.sort(nums);  //先给nums排序
        for(int i = 0; i < nums.length; i++){
            //如果前一个数和现在的这个数相同 那么就没有必要继续下去了 因为重复了啊
            if(i > 0 && nums[i - 1] == nums[i]) continue;
            //如果第一个数都大于0了 后面的数就不可能是小于0的 那么三个数的和就不可能是0了
            if(nums[i] > 0) break;
            int left = i + 1, right = nums.length - 1;
            while(left < right){
                int sum = nums[i] + nums[left] + nums[right];
                if(sum == 0){
                    res.add(Arrays.asList(nums[i], nums[left++], nums[right--]));
                    //去重 很重要
                    while(left < right && nums[left] == nums[left - 1]) left++;
                    while(left < right && nums[right] == nums[right + 1]) right--;
                }
                else if(sum > 0) right--;   //太大啦
                else left++;    //太小啦
            }
        }
        return res;
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