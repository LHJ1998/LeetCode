# [Trapping Rain Water](https://leetcode.com/problems/trapping-rain-water/)

Given *n* non-negative integers representing an elevation map where the width of each bar is 1, compute how much water it is able to trap after raining.

![img](https://assets.leetcode.com/uploads/2018/10/22/rainwatertrap.png)
The above elevation map is represented by array [0,1,0,2,1,0,1,3,2,1,2,1]. In this case, 6 units of rain water (blue section) are being trapped. **Thanks Marcos** for contributing this image!

**Example:**

```
Input: [0,1,0,2,1,0,1,3,2,1,2,1]
Output: 6
```

## 思路0

这道题和 [Container With Most Water ](note/Array/0011/README.md)有点像，区别在于前者求的是两边之间的最大容量，这道题目要求的是不同的块组合之间能够容纳的水的最大容量

积水一定是两个柱子之间的高度差，或者说最高的柱子和当前柱子的高度差就是当前位置可以产生的积水，那这样就需要找到最高的那根柱子，但是找全局唯一的那根最高柱子似乎是不可取的，从例题就可以看出，用全局的最高柱子会产生多余的积水，这边最高的柱子应该是相对而言的，相对不同的位置，最高柱子的高度也应该会变化。

```java
package com.lhj1998.leetcode.Array._0042;

public class Solution {

    public int trap(int[] height) {
        if(null == height || height.length == 0) return 0;
        int left = 0, right = height.length - 1, maxLeft = 0, maxRight = 0, ans = 0;
        while(left < right){
            if(height[left] < height[right]){
                if (height[left] >= maxLeft) {
                    maxLeft = height[left];
                } else {
                    ans += (maxLeft - height[left]);
                }
                left++;
            }else{
                if (height[right] >= maxRight) {
                    maxRight = height[right];
                } else {
                    ans += (maxRight - height[right]);
                }
                right--;
            }
        }
        return ans;
    }

}

```

