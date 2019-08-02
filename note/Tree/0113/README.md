# [Path Sum II](https://leetcode.com/problems/path-sum-ii/)

Given a binary tree and a sum, find all root-to-leaf paths where each path's sum equals the given sum.

**Note:** A leaf is a node with no children.

**Example:**

Given the below binary tree and `sum = 22`,

```
      5
     / \
    4   8
   /   / \
  11  13  4
 /  \    / \
7    2  5   1
```

Return:

```
[
   [5,4,11,2],
   [5,8,4,5]
]
```

## 思路0

和 [Path Sum](../0112/README.md) 的区别在于，前一个只是求有没有这个路径，现在要把路径找出来

其实思路还是一样的

```java
package com.lhj1998.leetcode.Tree._0113;

import java.util.ArrayList;
import java.util.List;

public class Solution {

    public List<List<Integer>> pathSum(TreeNode root, int sum) {
        List<List<Integer>> res = new ArrayList<>();
        if(root == null) return res;
        findPath(root, sum, res, new ArrayList<>());
        return res;
    }

    private void findPath(TreeNode root, int sum, List<List<Integer>> res, List<Integer> temp){
        if(root == null) return;
        if(sum == root.val && root.left == null && root.right == null){
            res.add(new ArrayList<>(temp));
            res.get(res.size() - 1).add(root.val);
            return;
        }
        temp.add(root.val);
        findPath(root.left, sum - root.val, res, temp);
        findPath(root.right, sum - root.val, res, temp);
        temp.remove(temp.size() - 1);
    }
    
}

```

