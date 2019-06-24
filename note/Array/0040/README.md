# [Combination Sum II](https://leetcode.com/problems/combination-sum-ii/)

Given a collection of candidate numbers (`candidates`) and a target number (`target`), find all unique combinations in `candidates` where the candidate numbers sums to `target`.

Each number in `candidates` may only be used **once** in the combination.

**Note:**

- All numbers (including `target`) will be positive integers.
- The solution set must not contain duplicate combinations.

**Example 1:**

```
Input: candidates = [10,1,2,7,6,1,5], target = 8,
A solution set is:
[
  [1, 7],
  [1, 2, 5],
  [2, 6],
  [1, 1, 6]
]
```

**Example 2:**

```
Input: candidates = [2,5,2,1,2], target = 5,
A solution set is:
[
  [1,2,2],
  [5]
]
```

## 思路0

和 [Combination Sum](note/Array/0039/README.md) 不一样的地方在于，

1. 前者可以重复选择已经选过的数，这里只能选一次（Each number in `candidates` may only be used **once** in the combination.）
2. 前者给出的数组还是有序的，这里明显就没有这种规律了（从example中看出来）
3. 前者说明了数组中每个数不会重复，这里会出现重复的数（从example中看出来）

做法和 [Combination Sum](note/Array/0039/README.md) 是一样的，主要是处理上述的几个不一样的地方

```java
package com.lhj1998.leetcode.Array;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class _0040 {

    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        Arrays.sort(candidates);    //整个数组按照从小到大的顺序排序
        List<List<Integer>> res = new ArrayList<>();
        dfs(candidates, target, res, new ArrayList<>(), 0);
        return res;
    }

    private void dfs(int[] candidates, int target, List<List<Integer>> res, List<Integer> temp, int index){
        if(target == 0) res.add(new ArrayList<>(temp));
        else{
            for(int i = index; i < candidates.length; i++){
                if(candidates[i] > target) break;   //剪枝操作 如果i位置已经大于target了，那么后面的也一定会大于target，没有必要继续判断下去
                if(i > index && candidates[i] == candidates[i - 1]) continue;       //剪枝操作，如果前面的那个数已经和当前这个数相同，那么一定会得出一个和之前出现过的相同的结果集，需要排除这种结果集
                temp.add(candidates[i]);
                dfs(candidates, target - candidates[i], res, temp, i + 1);  //避免出现重复的结果集 需要从当前位置的下一个位置开始遍历
                temp.remove(temp.size() - 1);
            }
        }
    }

}

```

