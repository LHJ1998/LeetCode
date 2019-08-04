# [Minimum Number of Arrows to Burst Balloons](https://leetcode.com/problems/minimum-number-of-arrows-to-burst-balloons/)

There are a number of spherical balloons spread in two-dimensional space. For each balloon, provided input is the start and end coordinates of the horizontal diameter. Since it's horizontal, y-coordinates don't matter and hence the x-coordinates of start and end of the diameter suffice. Start is always smaller than end. There will be at most 104 balloons.

An arrow can be shot up exactly vertically from different points along the x-axis. A balloon with xstart and xend bursts by an arrow shot at x if xstart ≤ x ≤ xend. There is no limit to the number of arrows that can be shot. An arrow once shot keeps travelling up infinitely. The problem is to find the minimum number of arrows that must be shot to burst all balloons.

**Example:**

```
Input:
[[10,16], [2,8], [1,6], [7,12]]

Output:
2

Explanation:
One way is to shoot one arrow for example at x = 6 (bursting the balloons [2,8] and [1,6]) and another arrow at x = 11 (bursting the other two balloons).
```

## 思路0

我的想法是，先把气球按照`start`排序，如果`start`相等，那么按照`end`排序，最后

`start小的在前面，end小的在前面`

接下来需要判断了，一支箭可以射穿多少气球，就是看这只箭可以射多远。如果气球`start <= further`，那么这个气球就可以被射穿，同时需要更新further的值

```java
package com.lhj1998.leetcode.Greedy._0452;

import java.util.Arrays;
import java.util.Comparator;

public class Solution {

    public int findMinArrowShots(int[][] points) {
        if(null == points || points.length == 0 || points[0].length == 0) return 0;
        Arrays.sort(points, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return o1[0] == o2[0] ? o1[1] - o2[1] : o1[0] - o2[0];
            }
        });
        int res = 1, further = points[0][1];
        for(int i = 1; i < points.length; i++){
            if(points[i][0] <= further){
                further = Math.min(further, points[i][1]);
                continue;
            }
            further = points[i][1];
            res++;
        }
        return res;
    }

}

```

