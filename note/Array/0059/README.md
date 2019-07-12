# [Spiral Matrix II](https://leetcode.com/problems/spiral-matrix-ii/)

Given a positive integer *n*, generate a square matrix filled with elements from 1 to *n*2 in spiral order.

**Example:**

```
Input: 3
Output:
[
 [ 1, 2, 3 ],
 [ 8, 9, 4 ],
 [ 7, 6, 5 ]
]
```

## 思路0

这道题是[Spiral Matrix](note/Array/0054/README.md)的进化版，要求输入一个数字，然后打构造出回旋矩阵

和[Spiral Matrix](note/Array/0054/README.md)的做法一样，只不过是赋值罢了，然后这里有一个问题，当n为奇数的时候中间最后一个值没有加进去，然后就在最后判断一下是不是奇数，手动给加了，感觉有点low...

```java
package com.lhj1998.leetcode.Array._0059;

public class Solution {

    public int[][] generateMatrix(int n) {
        if(n <= 0) return new int[0][0];
        int[][] res = new int[n][n];
        int currNum = 1, top = 0, bottom = n - 1, left = 0, right = n - 1;
        while(currNum < n * n){
            //右遍历
            for(int i = left; i <= right; i++){
                res[top][i] = currNum++;
            }
            //下遍历
            for(int i = top + 1; i <= bottom; i++){
                res[i][right] = currNum++;
            }
            if(top < bottom && left < right){
                //左遍历
                for(int i = right - 1; i > left; i--){
                    res[bottom][i] = currNum++;
                }
                //上遍历
                for(int i = bottom; i > top; i--){
                    res[i][left] = currNum++;
                }
            }
            top++;
            bottom--;
            left++;
            right--;
        }
        if(n % 2 != 0) res[n / 2][n / 2] = n * n;
        return res;
    }
    
}

```

