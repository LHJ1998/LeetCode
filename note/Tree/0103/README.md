# [Binary Tree Zigzag Level Order Traversal](https://leetcode.com/problems/binary-tree-zigzag-level-order-traversal/)

Given a binary tree, return the *zigzag level order* traversal of its nodes' values. (ie, from left to right, then right to left for the next level and alternate between).

For example:
Given binary tree `[3,9,20,null,null,15,7]`,

```
    3
   / \
  9  20
    /  \
   15   7
```



return its zigzag level order traversal as:

```
[
  [3],
  [20,9],
  [15,7]
]
```

## 思路0

这题目和  [Binary Tree Level Order Traversal](0102/README.md) 好像，但是，为什么我觉得这个题目和上一个不一样的地方在于这个题目先右后左

```java
package com.lhj1998.leetcode.Tree._0103;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class Solution {

    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> result = new ArrayList<List<Integer>>();
        zigzagLevelOrder(root, result, 0);
        return result;
    }

    public void zigzagLevelOrder(TreeNode node, List<List<Integer>> result, int level) {
        if (node == null) return;
        if (result.size()-1 < level) result.add(new LinkedList<Integer>());

        if (level % 2 == 0) {
            ((LinkedList<Integer>) result.get(level)).addLast(node.val);
        } else {
            ((LinkedList<Integer>) result.get(level)).addFirst(node.val);
        }

        zigzagLevelOrder(node.left, result, level+1);
        zigzagLevelOrder(node.right, result, level+1);
    }

}

```

