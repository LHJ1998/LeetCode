# [Search a 2D Matrix](https://leetcode.com/problems/search-a-2d-matrix/)

Write an efficient algorithm that searches for a value in an *m* x *n* matrix. This matrix has the following properties:

- Integers in each row are sorted from left to right.
- The first integer of each row is greater than the last integer of the previous row.

**Example 1:**

```
Input:
matrix = [
  [1,   3,  5,  7],
  [10, 11, 16, 20],
  [23, 30, 34, 50]
]
target = 3
Output: true
```

**Example 2:**

```
Input:
matrix = [
  [1,   3,  5,  7],
  [10, 11, 16, 20],
  [23, 30, 34, 50]
]
target = 13
Output: false
```

## 思路0

从一个排好序的二维数组里面找到一个指定的数，查找的算法这里毫无疑问的选用二分法了，然后主要是查找这个数在哪一行，其实这个也很简单不是吗...

```java
package com.lhj1998.leetcode.Array._0074;

public class Solution {

    public boolean searchMatrix(int[][] matrix, int target) {
        if(matrix.length == 0 || matrix[0].length == 0) return false;
        int m = matrix.length, n = matrix[0].length;
        for(int i = 0; i < m; i++){
            if(target >= matrix[i][0] && target <= matrix[i][n - 1]){
                return binarySearch(matrix[i], target, 0, n - 1);
            }
        }
        return false;
    }

    private boolean binarySearch(int[] array, int target, int left, int right){
        if(left <= right){
            int mid = ( left + right ) / 2;
            if(array[mid] == target) return true;
            if(array[mid] > target) return binarySearch(array, target, left, mid - 1);
            else return binarySearch(array, target, mid + 1, right);
        }else{
            return false;
        }
    }

}

```

