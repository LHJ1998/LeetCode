# [Remove Duplicates from Sorted Array II](https://leetcode.com/problems/remove-duplicates-from-sorted-array-ii/)

Given a sorted array *nums*, remove the duplicates [**in-place**](https://en.wikipedia.org/wiki/In-place_algorithm) such that duplicates appeared at most *twice* and return the new length.

Do not allocate extra space for another array, you must do this by **modifying the input array in-place** with O(1) extra memory.

**Example 1:**

```
Given nums = [1,1,1,2,2,3],

Your function should return length = 5, with the first five elements of nums being 1, 1, 2, 2 and 3 respectively.

It doesn't matter what you leave beyond the returned length.
```

**Example 2:**

```
Given nums = [0,0,1,1,1,1,2,3,3],

Your function should return length = 7, with the first seven elements of nums being modified to 0, 0, 1, 1, 2, 3 and 3 respectively.

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

看了好久才明白这题目是要让数组中的重复元素不得超过2个....

超过了5.04%的垃圾解法仅供参考...

```java
package com.lhj1998.leetcode.Array._0080;

public class Solution {

    public int removeDuplicates(int[] nums) {
        if(null == nums || nums.length == 0) return 0;
        int len = nums.length;
        for(int i = 0, j = 2; j < len; i++, j++){
            if(nums[i] == nums[j]){
                for(int k = j; k < len; k++){
                    nums[k - 1] = nums[k];
                }
                i--;
                j--;
                len--;
            }
        }
        return len;
    }
    
}

```

上面的解法就是重复劳动太多了，比如说重复个数有4个，那么移位的循环就得循环4次，为什么不一次移动4个呢是吧....开始改进

```java
package com.lhj1998.leetcode.Array._0080;

public class Solution {

    public int removeDuplicates(int[] nums) {
        if(null == nums || nums.length == 0) return 0;
        int len = nums.length, count = 1;
        for(int i = 1; i < len; i++){
            if(nums[i - 1] == nums[i]) count++;
            else if(count > 2){
                int t = count - 2;
                count = 1;
                for(int j = i; j < len; j++){
                    nums[j - t] = nums[j];
                }
                i -= t;
                len -= t;
            }else{
                count = 1;
            }
        }
        //清尾
        if(count > 2){
            len = len - (count - 2);
        }
        return len;
    }

}

```

改进后，超越81.50%啦，嘿嘿

## 思路1

即便改进以后还是烂算法（代码也不好看）

然后记得前面有一道题 [Remove Duplicates from Sorted Array](note/Array/0026/README.md) 完全可以参考这一道题的做法，不一样的地方在于，前一道题要求每个数字只能出现一次，这个可以出现2次而已

```java
package com.lhj1998.leetcode.Array._0080;

public class Solution {

    public int removeDuplicates(int[] nums) {
        int count = 2;
        for(int i = 2; i < nums.length; i++){
            if(nums[i] != nums[count - 2]){
                nums[count++] = nums[i];
            }
        }
        return count;
    }
    
}

```

