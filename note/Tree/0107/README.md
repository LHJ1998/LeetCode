# [Binary Tree Level Order Traversal II](https://leetcode.com/problems/binary-tree-level-order-traversal-ii/)

Given a binary tree, return the *bottom-up level order* traversal of its nodes' values. (ie, from left to right, level by level from leaf to root).

For example:
Given binary tree `[3,9,20,null,null,15,7]`,

```
    3
   / \
  9  20
    /  \
   15   7
```

return its bottom-up level order traversal as:

```
[
  [15,7],
  [9,20],
  [3]
]
```

## 思路0

从后向前呗...

一种做法就是，先从前向后，然后逆转一下就好了...

```java
package com.lhj1998.leetcode.Tree._0107;

import java.util.LinkedList;
import java.util.List;

public class Solution {

    public List<List<Integer>> levelOrderBottom(TreeNode root) {
        List<List<Integer>> res = new ArrayList<>();
        levelOrderBottom(root, res, 0);
        Collections.reverse(res);
        return res;
    }

    private void levelOrderBottom(TreeNode root, List<List<Integer>> res, int level){
        if(root == null) return;
        if(res.size() <= level) res.add(new LinkedList<>());
        ((LinkedList)res.get(level)).addLast(root.val);
        levelOrderBottom(root.left, res, level + 1);
        levelOrderBottom(root.right, res, level + 1);
    }
    
}

```

