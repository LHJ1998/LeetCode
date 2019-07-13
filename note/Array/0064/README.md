# [Minimum Path Sum](https://leetcode.com/problems/minimum-path-sum/)

Given a *m* x *n* grid filled with non-negative numbers, find a path from top left to bottom right which *minimizes* the sum of all numbers along its path.

**Note:** You can only move either down or right at any point in time.

**Example:**

```
Input:
[
  [1,3,1],
  [1,5,1],
  [4,2,1]
]
Output: 7
Explanation: Because the path 1→3→1→1→1 minimizes the sum.
```

## 思路0

题目的意思就是从左上角到右小角，找到一个值最小的路径

这样的话，我第一想法是用dfs搜索一下，先不管能不能成吧，试试再说

```java
package com.lhj1998.leetcode.Array._0064;

public class Solution {

    public int minPathSum(int[][] grid) {
        return dfs(grid, 0, 0, 0, Integer.MAX_VALUE);
    }

    private int dfs(int[][] grid, int x, int y, int curr, int min){
        curr = curr + grid[x][y];
        if(x == grid.length - 1 && y == grid[0].length - 1){
            min = Math.min(curr, min);
            return min;
        }
        //右移
        if(y < grid[0].length - 1){
            min = dfs(grid, x, y + 1, curr, min);
        }
        //下移
        if(x < grid.length - 1){
            min = dfs(grid, x + 1, y, curr, min);
        }
        return min;
    }

}

```

我感觉我的dfs就每一次成功过...hhh

答案没问题，但是时间超了...

## 思路1

强行破解不行的话，就只能找找规律了，这题目其实和[Unique Paths](note/Array/0062/README.md) 和 [Unique Paths II](note/Array/0063/README.md)挺像的，那么思路的话也可以参考两个的做法，这里不一样的地方就是每移动一步花费的代价，前面两个的代价都是1，这里的代价是`grid[i][j]`，然后求的也不是路径数，二十花费的代价，那么对于`matrix[i][j]`记录的就应该是从`matrix[0][0]到matrix[i][j]所花费的最小代价`，所以其实本质上并没有什么区别

```java
package com.lhj1998.leetcode.Array._0064;

public class Solution {

    public int minPathSum(int[][] grid) {
        int m = grid.length, n = grid[0].length;
        int[][] matrix = new int[m][n];
        matrix[0][0] = grid[0][0];
        //第一行只能从左往右走这一种路线，因此第一行的代价就是前面一个的代价和当前位置代价的和
        for(int i = 1; i < n; i++) matrix[0][i] = matrix[0][i - 1] + grid[0][i];
        //第一列同理
        for(int i = 1; i < m; i++) matrix[i][0] = matrix[i - 1][0] + grid[i][0];
        //现在计算每一个位置的最小代价
        for(int i = 1; i < m; i++){
            for(int j = 1; j < n; j++){
                matrix[i][j] = Math.min(matrix[i -1][j], matrix[i][j - 1]) + grid[i][j];
            }
        }
        return matrix[m - 1][n - 1];
    }

}

```

算法是通过了，但是用了2ms，而且也只超过了90.12%的人，还有更好的解题思路...

## 别人的题解

```java
private static int mincostpathM(int sr, int sc, int dr, int dc, int[][] arr, int[][] qb) {
		if (sr == dr && sc == dc) {
			return arr[sr][sc];
		}
		if (sr > dr || sc > dc) {
			return Integer.MAX_VALUE;
		}
		if (qb[sr][sc] != 0) {
			return qb[sr][sc];
		}
		int cstod = 0;

		int cihtod = mincostpathM(sr, sc + 1, dr, dc, arr, qb);
		int civtod = mincostpathM(sr + 1, sc, dr, dc, arr, qb);

		cstod = arr[sr][sc] + Math.min(cihtod, civtod);
		qb[sr][sc] = cstod;
		return cstod;
}
```

这是大神1ms的解法，但是我感觉也是一个递归遍历啊，是哪里比我的快呢