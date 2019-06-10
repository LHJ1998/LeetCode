# [Container With Most Water](https://leetcode.com/problems/container-with-most-water/)

Given *n* non-negative integers *a1*, *a2*, ..., *an* , where each represents a point at coordinate (*i*, *ai*). *n* vertical lines are drawn such that the two endpoints of line *i* is at (*i*, *ai*) and (*i*, 0). Find two lines, which together with x-axis forms a container, such that the container contains the most water.

**Note:** You may not slant the container and *n* is at least 2.

![img](https://s3-lc-upload.s3.amazonaws.com/uploads/2018/07/17/question_11.jpg)

The above vertical lines are represented by array [1,8,6,2,5,4,8,3,7]. In this case, the max area of water (blue section) the container can contain is 49.

**Example:**

```
Input: [1,8,6,2,5,4,8,3,7]
Output: 49
```

## 思路0

很简单的一道题啊，求面积嘛，就是左右两根棍子中最小的那一根*两根棍子的距离。

那么首先确定两根根子，left和right，距离就是right - left（设为dis吧）

然后要想他们的面积最大，要么是最短的那根棍子月初越好，或者是他们的距离越远越好。两根棍子最远也就那样了，所以可以不用考虑了，需要考虑的是怎么让最短的那一根变长一点。

两根木棍比较的时候，总有一根会相对短一点（一样长也无所谓啦），那么就可以让相对短一点的那一根移动到下一个位置去，不就好了嘛

```java
package com.lhj1998.leetcode.Array._002;

public class Solution {

    public int maxArea(int[] height) {
        int max = 0, left = 0, right = height.length - 1;
        while(left < right) {
            max = Math.max(max, Math.min(height[left], height[right]) * right - left);
            if(height[left] > height[right]) right--;
            else left++;
        }
        return max;
    }

}

```

## 思路1

当然你也可以遍历每一种组合，然后得出最终的结果，不过这种办法显然不是很高效的方法

208ms，第一种方法是2ms，算法之美~

```java
package com.lhj1998.leetcode.Array._002;

public class Solution {

    public int maxArea(int[] height) {
        int max = 0;
        for(int i = 0; i < height.length; i++){
            for(int j = i + 1; j < height.length; j++){
                max = Math.max(max, Math.min(height[i], height[j]) * (j - i));
            }
        }
        return max;
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

