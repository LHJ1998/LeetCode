# [Range Sum Query 2D - Immutable](https://leetcode.com/problems/range-sum-query-2d-immutable/)

Given a 2D matrix *matrix*, find the sum of the elements inside the rectangle defined by its upper left corner (*row*1, *col*1) and lower right corner (*row*2, *col*2).

![Range Sum Query 2D](https://leetcode.com/static/images/courses/range_sum_query_2d.png)
The above rectangle (with the red border) is defined by (row1, col1) = **(2, 1)** and (row2, col2) = **(4, 3)**, which contains sum = **8**.

**Example:**

```
Given matrix = [
  [3, 0, 1, 4, 2],
  [5, 6, 3, 2, 1],
  [1, 2, 0, 1, 5],
  [4, 1, 0, 1, 7],
  [1, 0, 3, 0, 5]
]

sumRegion(2, 1, 4, 3) -> 8
sumRegion(1, 1, 2, 2) -> 11
sumRegion(1, 2, 2, 4) -> 12
```



**Note:**

1. You may assume that the matrix does not change.
2. There are many calls to *sumRegion* function.
3. You may assume that *row*1 ≤ *row*2 and *col*1 ≤ *col*2.

## 思路0

我感觉我的脑子要被LeetCode挤爆了，一维数组我还能想到先计算sum节约时间，这个肯定也是一样的套路了，但是二维的啊，这么搞怎么搞，我果然还是太菜了吗

自家代码

```java
class NumMatrix {
    
    private int[][] matrix = null;

    public NumMatrix(int[][] matrix) {
        this.matrix = matrix;
    }
    
    public int sumRegion(int row1, int col1, int row2, int col2) {
        int sum = 0;
        for(int i = row1; i <= row2; i++){
            for(int j = col1; j <= col2; j++){
                sum += matrix[i][j];
            }
        }
        return sum;
    }
}

/**
 * Your NumMatrix object will be instantiated and called as such:
 * NumMatrix obj = new NumMatrix(matrix);
 * int param_1 = obj.sumRegion(row1,col1,row2,col2);
 */
```

人家代码

```java
class NumMatrix {
    int[][] sumMatrix;

    public NumMatrix(int[][] matrix) {
        if (matrix.length == 0) return; 
        
        sumMatrix = new int[matrix.length][matrix[0].length];
        for (int i=0; i<matrix.length; i++) {
            for (int j=0; j<matrix[i].length; j++) {
                int A = 0; int B = 0; int C = 0;
                if (i-1>=0 && j-1>=0) C = sumMatrix[i-1][j-1];
                if (j-1 >= 0) B = sumMatrix[i][j-1];
                if (i-1 >= 0) A = sumMatrix[i-1][j];
                sumMatrix[i][j] = A + B - C + matrix[i][j];
            }
        }
    }
    
    public int sumRegion(int row1, int col1, int row2, int col2) {
        if (sumMatrix.length == 0) return 0;
        
        int sum = 0;
        int D = 0;
        int B = 0;
        int C = 0;
        if (row1-1 >= 0 && col1-1 >= 0) D = sumMatrix[row1-1][col1-1];
        if (col1-1 >= 0) B = sumMatrix[row2][col1-1];
        if (row1-1 >= 0) C = sumMatrix[row1-1][col2];
        
        return sumMatrix[row2][col2] - B - C + D;
    }
}

/**
 * Your NumMatrix object will be instantiated and called as such:
 * NumMatrix obj = new NumMatrix(matrix);
 * int param_1 = obj.sumRegion(row1,col1,row2,col2);
 */
```

