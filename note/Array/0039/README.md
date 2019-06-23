# [Combination Sum](https://leetcode.com/problems/combination-sum/)

Given a **set** of candidate numbers (`candidates`) **(without duplicates)** and a target number (`target`), find all unique combinations in `candidates` where the candidate numbers sums to `target`.

The **same** repeated number may be chosen from `candidates` unlimited number of times.

**Note:**

- All numbers (including `target`) will be positive integers.
- The solution set must not contain duplicate combinations.

**Example 1:**

```
Input: candidates = [2,3,6,7], target = 7,
A solution set is:
[
  [7],
  [2,2,3]
]
```

**Example 2:**

```
Input: candidates = [2,3,5], target = 8,
A solution set is:
[
  [2,2,2,2],
  [2,3,3],
  [3,5]
]
```

## 思路0

这个题目我第一个想法就是，好像我之前在杭电OJ上刷的一道题目，应该是说给出了若干根木棍，然后求组合成长度为xxx的解法，和这道题一模一样...

其实很简单啊，就是一个深搜，不断尝试各种组合条件，当然还需要一定的剪枝操作，不然会超时

```java
package com.lhj1998.leetcode.Array._0039;

import java.util.ArrayList;
import java.util.List;

public class Solution {

    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> res = new ArrayList<>();
        dfs(candidates, target, res, new ArrayList<>(), 0);
        return res;
    }

    private void dfs(int[] candidates, int target, List<List<Integer>> res, List<Integer> temp, int index){
        //类似截木棍的做法，如果木棍截到0了，就是满足条件的序列 加入进去
        if(target == 0) res.add(new ArrayList<>(temp));
        else{
            //为了避免出现重复的结果 需要至少从index位置（即上一个遍历满足条件的位置开始）
            for(int i = index; i < candidates.length; i++){
                if(candidates[i] > target) continue;
                temp.add(candidates[i]);
                dfs(candidates, target - candidates[i], res, temp, i);
                //将最后一个加入进去的条件去除 重新寻找合适的条件
                temp.remove(temp.size() - 1);
            }
        }
    }

}

```

