# [Subsets](https://leetcode.com/problems/subsets/)

Given a set of **distinct** integers, *nums*, return all possible subsets (the power set).

**Note:** The solution set must not contain duplicate subsets.

**Example:**

```
Input: nums = [1,2,3]
Output:
[
  [3],
  [1],
  [2],
  [1,2,3],
  [1,3],
  [2,3],
  [1,2],
  []
]
```

## 思路0

题目的意思就是找给定序列的子集咯

这个我觉得就dfs递归遍历一下就好啦，为了不出现重复的子集，然后循环的地方就需要是从上一次遍历位置的下一个位置开始

```java
package com.lhj1998.leetcode.Array._0078;

import java.util.ArrayList;
import java.util.List;

public class Solution {

    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        res.add(new ArrayList<Integer>());
        dfs(0, nums, res, new ArrayList<Integer>());
        return res;
    }

    private void dfs(int index, int[] nums, List<List<Integer>> res, List<Integer> temp){
        for(int i = index; i < nums.length; i++) {
            temp.add(nums[i]);
            res.add(new ArrayList<Integer>(temp));
            dfs(i + 1, nums, res, temp);
            temp.remove(temp.size() - 1);
        }
    }
    
}

```

