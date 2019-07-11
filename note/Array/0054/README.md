# [Spiral Matrix](https://leetcode.com/problems/spiral-matrix/)

Given a matrix of *m* x *n* elements (*m* rows, *n* columns), return all elements of the matrix in spiral order.

**Example 1:**

```
Input:
[
 [ 1, 2, 3 ],
 [ 4, 5, 6 ],
 [ 7, 8, 9 ]
]
Output: [1,2,3,6,9,8,7,4,5]
```

**Example 2:**

```
Input:
[
  [1, 2, 3, 4],
  [5, 6, 7, 8],
  [9,10,11,12]
]
Output: [1,2,3,4,8,12,11,10,9,5,6,7]
```

## 思路0

总体来说就是一个遍历，从左至右，从上至下，模拟这个过程就行了

```java
package com.lhj1998.leetcode.Array.__0054;

import java.util.ArrayList;
import java.util.List;

public class Solution {

    public List<Integer> spiralOrder(int[][] matrix) {
        if(null == matrix || matrix.length == 0) return new ArrayList<Integer>();
        int rows = matrix.length, cols = matrix[0].length;
        int top = 0, bottom = rows - 1, left = 0, right = cols -1;
        List<Integer> res = new ArrayList<>();
        while(left <= right && top <= bottom){
            //右移
            for(int i = left; i <= right; i++){
                res.add(matrix[top][i]);
            }
            //下移
            for(int j = top + 1; j <= bottom; j++){
                res.add(matrix[j][right]);
            }
            if(left < right && top < bottom){
                //左移
                for(int i = right - 1; i > left; i--){
                    res.add(matrix[bottom][i]);
                }
                //上移
                for(int j = bottom; j > top; j--){
                    res.add(matrix[j][left]);
                }
            }
            top++;
            left++;
            right--;
            bottom--;
        }
        return res;
    }

}

```

