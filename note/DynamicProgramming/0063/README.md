# [Unique Paths II](https://leetcode.com/problems/unique-paths-ii/)

A robot is located at the top-left corner of a *m* x *n* grid (marked 'Start' in the diagram below).

The robot can only move either down or right at any point in time. The robot is trying to reach the bottom-right corner of the grid (marked 'Finish' in the diagram below).

Now consider if some obstacles are added to the grids. How many unique paths would there be?

![img](https://assets.leetcode.com/uploads/2018/10/22/robot_maze.png)

An obstacle and empty space is marked as `1` and `0` respectively in the grid.

**Note:** *m* and *n* will be at most 100.

**Example 1:**

```
Input:
[
  [0,0,0],
  [0,1,0],
  [0,0,0]
]
Output: 2
Explanation:
There is one obstacle in the middle of the 3x3 grid above.
There are two ways to reach the bottom-right corner:
1. Right -> Right -> Down -> Down
2. Down -> Down -> Right -> Right
```

## 思路0

这道题和[Unique Paths](note/Array/0062/README.md)的区别在于，上一个没有障碍物，这个有障碍物了

这里参考了[Unique Paths](note/Array/0062/README.md)的做法，特殊情况，即到达障碍物处的路径数为0（因为根本不可能去到那边），其它的并没有什么区别（当然初始赋值的地方也有一些改动...）

```java
package com.lhj1998.leetcode.DynamicProgramming._0063;

public class Solution {

    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        int m = obstacleGrid.length, n = obstacleGrid[0].length;
        int[][] matrix = new int[m][n];
        for(int i = 0; i < m && obstacleGrid[i][0] != 1; i++) matrix[i][0] = 1;
        for(int i = 0; i < n && obstacleGrid[0][i] != 1; i++) matrix[0][i] = 1;
        for(int i = 1; i < m; i++){
            for(int j = 1; j < n; j++){
                if(obstacleGrid[i][j] == 1) matrix[i][j] = 0;
                else matrix[i][j] = matrix[i - 1][j] + matrix[i][j - 1];
            }
        }
        return matrix[m - 1][n - 1];
    }
    
}

```

