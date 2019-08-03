# [Wiggle Subsequence](https://leetcode.com/problems/wiggle-subsequence/)

A sequence of numbers is called a **wiggle sequence** if the differences between successive numbers strictly alternate between positive and negative. The first difference (if one exists) may be either positive or negative. A sequence with fewer than two elements is trivially a wiggle sequence.

For example, `[1,7,4,9,2,5]` is a wiggle sequence because the differences `(6,-3,5,-7,3)` are alternately positive and negative. In contrast, `[1,4,7,2,5]` and `[1,7,4,5,5]` are not wiggle sequences, the first because its first two differences are positive and the second because its last difference is zero.

Given a sequence of integers, return the length of the longest subsequence that is a wiggle sequence. A subsequence is obtained by deleting some number of elements (eventually, also zero) from the original sequence, leaving the remaining elements in their original order.

**Example 1:**

```
Input: [1,7,4,9,2,5]
Output: 6
Explanation: The entire sequence is a wiggle sequence.
```

**Example 2:**

```
Input: [1,17,5,10,13,15,10,5,16,8]
Output: 7
Explanation: There are several subsequences that achieve this length. One is [1,17,10,13,10,16,8].
```

**Example 3:**

```
Input: [1,2,3,4,5,6,7,8,9]
Output: 2
```

**Follow up:**
Can you do it in O(*n*) time?

## 思路0

这题目可以用动态规划的方式解决，假如用`up[i]`表示`i`位置的，开头是正数的序列的最大长度，`down[i]`表示i位置的，开头是负数的序列的最大长度。那么`up[i] = down[i - 1] + 1`、`down[i] = up[i - 1] + 1`。

```java
package com.lhj1998.leetcode.Greedy._0376;

public class Solution {

    public int wiggleMaxLength(int[] nums) {
        if(nums == null || nums.length == 0) return 0;
        int[] up = new int[nums.length];
        int[] down = new int[nums.length];
        up[0] = down[0] = 1;
        for(int i = 1; i < nums.length; i++){
            if(nums[i] > nums[i - 1]){
                up[i] = down[i - 1] + 1;
                down[i] = down[i - 1];
            }else if(nums[i] < nums[i - 1]){
                down[i] = up[i - 1] + 1;
                up[i] = up[i - 1];
            }else{
                down[i] = down[i - 1];
                up[i] = up[i - 1];
            }
        }
        return Math.max(up[nums.length - 1], down[nums.length - 1]);
    }
    
}

```

## 思路1

贪心算法，计算每个位置的差值，然后和前一个差值作比较，如果相反那么就把这个数拉进去

```java
public class Solution {
    public int wiggleMaxLength(int[] nums) {
        if (nums.length < 2)
            return nums.length;
        int prevdiff = nums[1] - nums[0];
        int count = prevdiff != 0 ? 2 : 1;
        for (int i = 2; i < nums.length; i++) {
            int diff = nums[i] - nums[i - 1];
            if ((diff > 0 && prevdiff <= 0) || (diff < 0 && prevdiff >= 0)) {
                count++;
                prevdiff = diff;
            }
        }
        return count;
    }
}
```

