# [Remove Duplicates from Sorted Array](https://leetcode.com/problems/remove-duplicates-from-sorted-array/)

Given a sorted array *nums*, remove the duplicates [**in-place**](https://en.wikipedia.org/wiki/In-place_algorithm) such that each element appear only *once* and return the new length.

Do not allocate extra space for another array, you must do this by **modifying the input array in-place** with O(1) extra memory.

**Example 1:**

```
Given nums = [1,1,2],

Your function should return length = 2, with the first two elements of nums being 1 and 2 respectively.

It doesn't matter what you leave beyond the returned length.
```

**Example 2:**

```
Given nums = [0,0,1,1,1,2,2,3,3,4],

Your function should return length = 5, with the first five elements of nums being modified to 0, 1, 2, 3, and 4 respectively.

It doesn't matter what values are set beyond the returned length.
```

**Clarification:**

Confused why the returned value is an integer but your answer is an array?

Note that the input array is passed in by **reference**, which means modification to the input array will be known to the caller as well.

Internally you can think of this:

```
// nums is passed in by reference. (i.e., without making a copy)
int len = removeDuplicates(nums);

// any modification to nums in your function would be known by the caller.
// using the length returned by your function, it prints the first len elements.
for (int i = 0; i < len; i++) {
    print(nums[i]);
}
```

## 思路0

题目要求是去掉重复的数字，然后给出最终的长度，就是说我最终长度前面的几个数字是不能重复的呗，而且注意题目说的是一个已经排好序的数组，那就可以这样子啊，设定两个指针，一个从前向后扫描，如果当前位置和前一个位置相同了或者小于前面的数，那么说明这个数需要被替换，然后引出另一个指针，从当前位置的前一个向后扫面，知道找到比当前位置的前一个数大的数位置，用这个数替换掉当前位置的数就OK

```java
package com.lhj1998.leetcode.Array._0026;

public class Solution {

    public int removeDuplicates(int[] nums) {
        if(nums.length == 0) return 0;
        int count = 1;
        //从前向后扫描
        for(int i = 1; i < nums.length; i++){
            boolean flag = false;	//记录是否有被修改
            if(nums[i] <= nums[i - 1]){
                for(int j = i + 1; j < nums.length; j++){
                    if(nums[j] > nums[i - 1]){	//找到第一个比当前位置的前一个数大的数
                        nums[i] = nums[j];
                        count++;
                        flag = true;
                        break;
                    }
                }
                if(!flag) break;	//如果没有被修改，那么说明找不到更大的数了，就没有必要继续遍历了
            }else count++;
        }
        return count;
    }

}

```

好烂的代码啊:see_no_evil:耗时13ms，只超过了6.29%的Java Coder，继续改进

```java
package com.lhj1998.leetcode.Array._0026;

public class Solution {

    public int removeDuplicates(int[] nums) {
        if(nums.length == 0) return 0;
        int count = 1;
        for(int i = 1; i < nums.length; i++){
            if(nums[i - 1] >= nums[i]){
                int j = i + 1;
                while(j < nums.length && nums[j] <= nums[i - 1]) j++;
                if(j < nums.length){
                    count++;
                    nums[i] = nums[j];
                } else break;
            } else count++;
        }
        return count;
    }

}

```

代码执行效率并没有提高，只是相对于第一种显得简洁了一些而已... 那应该是我的思路有问题了 换个角度思考问题

## 思路1

上述的思路我应该是没有什么其他问题的，感觉效率主要耗在了当当前位置的数字小于等于前一个数字的时候的搜索上面，事实上如果出现了一个这种情况，那么后面就会一直出现，因此不应该重置 j 的位置，而应该保留以避免重复的搜索

```java
package com.lhj1998.leetcode.Array._0026;

public class Solution {

    public int removeDuplicates(int[] nums) {
        if(nums.length == 0) return 0;
        int count = 1;
        for(int i = 1, j = i + 1; i < nums.length; i++){
            if(nums[i - 1] >= nums[i]){
                //找到第一个符合要求的数
                while(j < nums.length && nums[j] <= nums[i - 1]) j++;
                if(j < nums.length){
                    count++;
                    nums[i] = nums[j++];
                    //去除重复的数
                    while(j < nums.length && nums[j] == nums[j - 1]) j++;
                } else break;
            } else count++;
        }
        return count;
    }
}

```

1ms 嘿嘿，果然我还是没有太蠢:see_no_evil:

## 最后

可以加一下我，大家一起学习交流交朋友啊:relaxed::see_no_evil:

> QQ: 1392013658
>
> WeChat: LHJL8023
>
> Email: LHJ8023@outlook.com