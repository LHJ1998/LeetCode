# [Range Sum Query - Immutable](https://leetcode.com/problems/range-sum-query-immutable/)

Given an integer array *nums*, find the sum of the elements between indices *i* and *j* (*i* ≤ *j*), inclusive.

**Example:**

```
Given nums = [-2, 0, 3, -5, 2, -1]

sumRange(0, 2) -> 1
sumRange(2, 5) -> -1
sumRange(0, 5) -> -3
```



**Note:**

1. You may assume that the array does not change.
2. There are many calls to *sumRange* function.

## 思路0

不想吐槽的一道题目，都是什么鬼啊

注意这里给定的数组是不会改变的，因此在计算的时候，可以初始化就计算好在每个位置的sum值，然后计算的时候可以返回sumj - sumi，速度会快一点

```java
class NumArray {
    
    private int[] sums = null;

    public NumArray(int[] nums) {
        this.sums = nums;
        for(int i = 1; i < nums.length; i++){
            sums[i] += sums[i - 1];
        }
    }
    
    public int sumRange(int i, int j) {
        return i > 0 ? sums[j] - sums[i - 1] : sums[j];
    }
}

/**
 * Your NumArray object will be instantiated and called as such:
 * NumArray obj = new NumArray(nums);
 * int param_1 = obj.sumRange(i,j);
 */
```

