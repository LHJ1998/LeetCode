# [Jump Game](https://leetcode.com/problems/jump-game/)

Given an array of non-negative integers, you are initially positioned at the first index of the array.

Each element in the array represents your maximum jump length at that position.

Determine if you are able to reach the last index.

**Example 1:**

```
Input: [2,3,1,1,4]
Output: true
Explanation: Jump 1 step from index 0 to 1, then 3 steps to the last index.
```

**Example 2:**

```
Input: [3,2,1,0,4]
Output: false
Explanation: You will always arrive at index 3 no matter what. Its maximum
             jump length is 0, which makes it impossible to reach the last index.
```

## 思路0

这题目只需要判断最后可不可以跳到最后一个位置，也就是，如果从`i`位置可以跳到最后一个的话，那么就是true，否则就是false

因此遍历数组，记录下从`0 - i`可以跳到的最远的位置，如果最终这个最远的位置大于数组的长度，那么就可以跳过去

```java
package com.lhj1998.leetcode.Greedy._0055;

public class Solution {

    public boolean canJump(int[] nums){
        int maxJump = 0;
        for(int i = 0; i < nums.length; i++){
            if(i > maxJump) return false;
            maxJump = Math.max(maxJump, i + nums[i]);
        }
        return maxJump >= nums.length - 1;
    }

}

```

