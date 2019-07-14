# [Merge Sorted Array](https://leetcode.com/problems/merge-sorted-array/)

Given two sorted integer arrays *nums1* and *nums2*, merge *nums2* into *nums1* as one sorted array.

**Note:**

- The number of elements initialized in *nums1* and *nums2* are *m* and *n* respectively.
- You may assume that *nums1* has enough space (size that is greater or equal to *m* + *n*) to hold additional elements from *nums2*.

**Example:**

```
Input:
nums1 = [1,2,3,0,0,0], m = 3
nums2 = [2,5,6],       n = 3

Output: [1,2,2,3,5,6]
```

## 思路0

两个有序的数组合并成一个，很简单啦，我的想法就是遍历那个`nums2`，然后比较`nums1`，通过移动`nums1`的元素位置，插入`nums2`的元素，最后合并

```java
package com.lhj1998.leetcode.Array._0088;

public class Solution {

    public void merge(int[] nums1, int m, int[] nums2, int n) {
        int index1 = 0;
        for(int i = 0; i < n; i++){
            while(index1 < m && nums1[index1] <= nums2[i]) index1++;
            for(int j = nums1.length - 1; j > index1; j--){
                nums1[j] = nums1[j - 1];
            }
            nums1[index1] = nums2[i];
            m++;
        }
    }

}

```

代码通过了，用了1ms，但是只超过了11%的人，唉

## 思路1

上述思路耗时主要是在对`nums1`的移位操作上，如果可以减少这种操作就可以提高速度

后面想了一下，好像避免不了不移位的操作

思路0是按照惯性思维，从左往右遍历，那么为什么不换一种思路，从后向前遍历呢？因为`nums1`是有空位的，可以先把尾巴补满，然后剩下的按照顺序归为就好啦

```java
package com.lhj1998.leetcode.Array._0088;

public class Solution {

    public void merge(int[] nums1, int m, int[] nums2, int n) {
        for(int i = nums1.length - 1; i >= 0 && n > 0; i--){
            if(m - 1 < 0){
                nums1[i] = nums2[n - 1];
                n--;
            }else if(nums1[m - 1] >= nums2[n - 1]){
                nums1[i] = nums1[m - 1];
                m--;
            }else{
                nums1[i] = nums2[n - 1];
                n--;
            }
        }
    }

}

```

