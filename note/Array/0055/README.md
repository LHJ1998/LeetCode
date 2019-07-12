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

题目的意思就是

- 先跳到一个位置上
- 接着跳这个位置上的数字n的步数
- 到了一个新位置上后，重复第二个步骤，直到跳到最后一个位置上
- 给出最终的结果，能不能跳到最后一个位置上

这里其实有一个可以取巧的地方，因为首先是跳到一个位置上，这个位置没有说明具体是哪个位置（当然不可能是最后一个位置），那么完全就可以跳到第k个位置上，然后判断这个位置上的数字能不能刚好到最后一个位置不就好了

```java
package com.lhj1998.leetcode.Array._0055;

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

