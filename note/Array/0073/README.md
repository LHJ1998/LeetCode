# [Set Matrix Zeroes](https://leetcode.com/problems/set-matrix-zeroes/)

Given a *m* x *n* matrix, if an element is 0, set its entire row and column to 0. Do it [**in-place**](https://en.wikipedia.org/wiki/In-place_algorithm).

**Example 1:**

```
Input: 
[
  [1,1,1],
  [1,0,1],
  [1,1,1]
]
Output: 
[
  [1,0,1],
  [0,0,0],
  [1,0,1]
]
```

**Example 2:**

```
Input: 
[
  [0,1,2,0],
  [3,4,5,2],
  [1,3,1,5]
]
Output: 
[
  [0,0,0,0],
  [0,4,5,0],
  [0,3,1,0]
]
```

**Follow up:**

- A straight forward solution using O(*m**n*) space is probably a bad idea.
- A simple improvement uses O(*m* + *n*) space, but still not the best solution.
- Could you devise a constant space solution?

## 思路0

题目的意思就是如果matrix有一个是0，那么把所在列和行置为0

问题是，如果找到了一个为0的位置，然后把行和列置为0，那么下次遍历的时候如果遍历到被置为0的这个位置，本来不为0的，但是置为0后，把原本不应该置为0的行和列置为了0

所以应该可以先把为0的行和列记录下来，然后在最后统一置零就可以了

```java
package com.lhj1998.leetcode.Array._0073;

import java.util.ArrayList;
import java.util.List;

public class Solution {

    public void setZeroes(int[][] matrix) {
        int m = matrix.length, n = matrix[0].length;
        List<Integer> rows = new ArrayList<>();
        List<Integer> cols = new ArrayList<>();
        for(int i = 0; i < m; i++){
            for(int j = 0; j < n; j++){
                if(matrix[i][j] == 0){
                    rows.add(i);
                    cols.add(j);
                }
            }
        }
        //置零操作
        for(Integer row : rows){
            for(int i = 0; i < n; i++) matrix[row][i] = 0;
        }
        for(Integer col : cols){
            for(int i = 0; i < m; i++) matrix[i][col] = 0;
        }
    }
    
}

```

代码是通过了，但是用了2ms，而且还只是超过了40%的人，还是有待改进

## 思路1

上一个解法的思路主要耗时在重复的置零上，比如说有两个0在同一行或同一列，那么按照上一个思路就必须对这一行或列重复两次置零操作，因此如果把List换成Set应该就可以解决问题

```java
package com.lhj1998.leetcode.Array._0073;

import java.util.HashSet;
import java.util.Set;

public class Solution {

    public void setZeroes(int[][] matrix) {
        int m = matrix.length, n = matrix[0].length;
        Set<Integer> rows = new HashSet<>();
        Set<Integer> cols = new HashSet<>();
        for(int i = 0; i < m; i++){
            for(int j = 0; j < n; j++){
                if(matrix[i][j] == 0){
                    rows.add(i);
                    cols.add(j);
                }
            }
        }
        //置零操作
        for(Integer row : rows){
            for(int i = 0; i < n; i++) matrix[row][i] = 0;
        }
        for(Integer col : cols){
            for(int i = 0; i < m; i++) matrix[i][col] = 0;
        }
    }
    
}

```

不知道为什么，换成Set以后，速度反而更加慢了...