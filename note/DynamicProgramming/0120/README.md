# [Triangle](https://leetcode.com/problems/triangle/)

Given a triangle, find the minimum path sum from top to bottom. Each step you may move to adjacent numbers on the row below.

For example, given the following triangle

```
[
     [2],
    [3,4],
   [6,5,7],
  [4,1,8,3]
]
```

The minimum path sum from top to bottom is `11` (i.e., **2** + **3** + **5** + **1** = 11).

**Note:**

Bonus point if you are able to do this using only *O*(*n*) extra space, where *n* is the total number of rows in the triangle.

## 思路0

一开始我以为每次走一行中最小的那个就会使得结果最小，后来我错了...

```java
package com.lhj1998.leetcode.Array._0120;

import java.util.List;

public class Solution {

    public int minimumTotal(List<List<Integer>> triangle) {
        if(null == triangle || triangle.size() == 0) return 0;
        int row = triangle.size();
        int[] dp = new int[row];
        for(int i = 0; i < row; i++){
            dp[i] = triangle.get(row - 1).get(i);
        }
        for(int i = row - 2; i >= 0; i--){
            List<Integer> curr = triangle.get(i);
            for(int j = 0; j <= curr.size() - 1; j++){
                dp[j] = curr.get(j) + Math.min(dp[j], dp[j + 1]);
            }
        }
        return dp[0];
    }
    
}

```

