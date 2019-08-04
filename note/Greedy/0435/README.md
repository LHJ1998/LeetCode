# [Non-overlapping Intervals](https://leetcode.com/problems/non-overlapping-intervals/)

Given a collection of intervals, find the minimum number of intervals you need to remove to make the rest of the intervals non-overlapping.

**Note:**

1. You may assume the interval's end point is always bigger than its start point.
2. Intervals like [1,2] and [2,3] have borders "touching" but they don't overlap each other.

 

**Example 1:**

```
Input: [ [1,2], [2,3], [3,4], [1,3] ]

Output: 1

Explanation: [1,3] can be removed and the rest of intervals are non-overlapping.
```

 

**Example 2:**

```
Input: [ [1,2], [1,2], [1,2] ]

Output: 2

Explanation: You need to remove two [1,2] to make the rest of intervals non-overlapping.
```

 

**Example 3:**

```
Input: [ [1,2], [2,3] ]

Output: 0

Explanation: You don't need to remove any of the intervals since they're already non-overlapping.
```

**NOTE:** input types have been changed on April 15, 2019. Please reset to default code definition to get new method signature.

## 思路0

一开始我傻了，我根据开头进行排序，然后结尾小的排前面，这种方法我都不知道我怎么想的。然后改成了按照结尾进行排序，结尾小的在前面，这样，如果后面一个的开头小于这个结尾，那么这个就是不符合要求的，直接pass

```java
package com.lhj1998.leetcode.Greedy._0435;

import java.util.Arrays;
import java.util.Comparator;

public class Solution {

    public int eraseOverlapIntervals(int[][] intervals) {
        if(null == intervals || intervals.length == 0 || intervals[0].length == 0) return 0;
        Arrays.sort(intervals, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return o1[1] - o2[1];
            }
        });
        int res = 0;
        int end = intervals[0][1];
        for(int i = 1; i < intervals.length; i++){
            if(intervals[i][0] >= end){
                end = intervals[i][1];
                continue;
            }
            res++;
        }
        return res;
    }

}

```

