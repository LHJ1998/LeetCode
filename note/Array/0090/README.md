# [Subsets II](https://leetcode.com/problems/subsets-ii/)

Given a collection of integers that might contain duplicates, **nums**, return all possible subsets (the power set).

**Note:** The solution set must not contain duplicate subsets.

**Example:**

```
Input: [1,2,2]
Output:
[
  [2],
  [1],
  [1,2,2],
  [2,2],
  [1,2],
  []
]
```

## 思路0

这个和 [Subsets](note/Array/0078/README.md) 的区别在于，这个集合会有重复的数字，然后子集里面当然不能有重复的东西，所以难点就在这里，方法和 [Subsets](note/Array/0078/README.md) 一样的，只不过需要过滤掉一些而已

```java
package com.lhj1998.leetcode.Array._0090;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Solution {

    public List<List<Integer>> subsetsWithDup(int[] nums) {
        Arrays.sort(nums);
        List<List<Integer>> res = new ArrayList<>();
        dfs(nums, res, new ArrayList<Integer>(), 0);
        return res;
    }

    private void dfs(int[] nums, List<List<Integer>> res, List<Integer> temp, int index){
        res.add(new ArrayList<Integer>(temp));
        for(int i = index; i < nums.length; i++){
            if(i != index && nums[i - 1] == nums[i]) continue;
            temp.add(nums[i]);
            dfs(nums, res, temp, i + 1);
            temp.remove(temp.size() - 1);
        }
    }
    
}

```

