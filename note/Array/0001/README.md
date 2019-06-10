# [Two Sum](https://leetcode.com/problems/two-sum/)

## Description

Given an array of integers, return **indices** of the two numbers such that they add up to a specific target.

You may assume that each input would have **exactly** one solution, and you may not use the *same* element twice.

**Example:**

```java
Given nums = [2, 7, 11, 15], target = 9,

Because nums[0] + nums[1] = 2 + 7 = 9,
return [0, 1].
```

## 思路0

直接暴力枚举就好了，不是说找两个数的和为target吗，先确定一个数，然后遍历数组，找另外一个数就好了。这是最简单最直接也是最慢的一种办法

```java
package com.lhj1998.leetcode.Array._0001;

public class Solution {

    public int[] twoSum(int[] nums, int target) {
        for(int i = 0; i < nums.length; i++){
            for(int j = i + 1; j < nums.length; j++){
                if(nums[i] + nums[j] == target) return new int[] {i, j};
            }
        }
        return null;
    }

}

```

## 思路1

后面我想把数组转化为一个List，然后调List里面的indexOf来解题，后面想了以下，List里面的indexOf底层不就是遍历数组吗？这样搞不仅没有提升性能，而且还会消耗把数组转化为List的时间。

然后想着把数组换成HashMap，因为HashMap可以通过hashCode计算在数组中的位置，然后再比较hashCode相同的数，可以少比较很多次数，性能就上来了

速度飙升啊，前一种方法是19ms，这个是2ms

```java
package com.lhj1998.leetcode.Array._0001;

import java.util.HashMap;

public class Solution {

    public int[] twoSum(int[] nums, int target) {
        HashMap<Integer, Integer> map = new HashMap<>();
        for(int i = 0; i < nums.length; i++){
            int next = target - nums[i];
            if(map.containsKey(next)) return new int[] {map.get(next), i};
            map.put(nums[i], i);
        }
        return null;
    }

}

```

## 最后

可以加一下我，大家一起学习交流交朋友啊:relaxed::see_no_evil:

>QQ: 1392013658
>
>WeChat: LHJL8023
>
>Email: LHJ8023@outlook.com

