# [Maximum Product Subarray](https://leetcode.com/problems/maximum-product-subarray/)

Given an integer array `nums`, find the contiguous subarray within an array (containing at least one number) which has the largest product.

**Example 1:**

```
Input: [2,3,-2,4]
Output: 6
Explanation: [2,3] has the largest product 6.
```

**Example 2:**

```
Input: [-2,0,-1]
Output: 0
Explanation: The result cannot be 2, because [-2,-1] is not a subarray.
```

## 思路0

这题目要的是最大的乘积子集，和最大和子集不一样。因为最大和子集可以直接丢掉小于0的子集，但是乘积这边不行，因为负负得正，说不定最小的那个最后逆袭最大了也说不定

因此除了保留最大的那个值，还需要保留最小的那个值

```java
package com.lhj1998.leetcode.DynamicProgramming._0152;

public class Solution {

    public int maxProduct(int[] nums) {
        if(null == nums || nums.length == 0) return 0;
        int max, min, res;
        max = min = res = nums[0];
        for(int i = 1; i < nums.length; i++){
            int temp = max;
            int num = nums[i];
            max = Math.max(num, Math.max(temp * num, min * num));
            min = Math.min(num, Math.min(temp * num, min * num));
            res = Math.max(max, res);
        }
        return res;
    }

}

```



