# [Unique Paths](https://leetcode.com/problems/unique-paths/)

A robot is located at the top-left corner of a *m* x *n* grid (marked 'Start' in the diagram below).

The robot can only move either down or right at any point in time. The robot is trying to reach the bottom-right corner of the grid (marked 'Finish' in the diagram below).

How many possible unique paths are there?

![img](https://assets.leetcode.com/uploads/2018/10/22/robot_maze.png)

Above is a 7 x 3 grid. How many possible unique paths are there?

**Note:** *m* and *n* will be at most 100.

**Example 1:**

```
Input: m = 3, n = 2
Output: 3
Explanation:
From the top-left corner, there are a total of 3 ways to reach the bottom-right corner:
1. Right -> Right -> Down
2. Right -> Down -> Right
3. Down -> Right -> Right
```

**Example 2:**

```
Input: m = 7, n = 3
Output: 28
```

## 思路0

这道题有点像dfs啊，我感觉我可以模拟一下行走路线，然后统计一下就可以了吧

```java
package com.lhj1998.leetcode.Array._0062;

public class Solution {

    public int uniquePaths(int m, int n) {
        return dfs(m - 1, n - 1, 0);
    }

    private int dfs(int m, int n, int count){
        if(m == 0 && n == 0){
            return ++count;
        }
        if(n > 0){
            //右走
            count = dfs(m, n - 1, count);
        }
        if(m > 0){
            //下走
            count = dfs(m - 1, n, count);
        }
        return count;
    }

}

```

事实证明是不行的，答案没问题，但是因为模拟，然后就超时了...

## 思路1

既然模拟不行，那么就应该找找规律了

题目上说明了，只能想下或者向右移动，那么如果想要知道最后一个位置的路径数，那么肯定就需要知道上面一个位置的路径数和左边那个位置的路径数，扩展到（i，j）位置上来说，到达这个位置的路径数就应该是从

（i - 1，j）的路径数 + 从（i，j - 1）的路径数的和

```java
package com.lhj1998.leetcode.Array._0062;

public class Solution {

    public int uniquePaths(int m, int n) {
        int[][] matrix = new int[m][n];
        for(int i = 0; i < m; i++) matrix[i][0] = 1;
        for(int i = 0; i < n; i++) matrix[0][i] = 1;
        for(int i = 1; i < m; i++) {
            for(int j = 1; j < n; j++) {
                matrix[i][j] = matrix[i - 1][j] + matrix[i][j - 1];
            }
        }
        return matrix[m - 1][n - 1];
    }

}

```

