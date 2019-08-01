# [Minimum Depth of Binary Tree](https://leetcode.com/problems/minimum-depth-of-binary-tree/)

Given a binary tree, find its minimum depth.

The minimum depth is the number of nodes along the shortest path from the root node down to the nearest leaf node.

**Note:** A leaf is a node with no children.

**Example:**

Given binary tree `[3,9,20,null,null,15,7]`,

```
    3
   / \
  9  20
    /  \
   15   7
```

return its minimum depth = 2.

## 思路0

这个，我记得 [Balanced Binary Tree](../0110/README.md) 才求过深度...

```java
package com.lhj1998.leetcode.Tree._0111;

public class Solution {

    public int minDepth(TreeNode root) {
        if(root == null){
            return 0;
        }
        if(root.left == null && root.right == null){
            return 1;
        }
        if(root.left != null && root.right == null){
            return 1 + minDepth(root.left);
        }
        if(root.left == null && root.right != null){
            return 1 + minDepth(root.right);
        }
        return 1 + Math.min(minDepth(root.right),minDepth(root.left));

    }
    
}

```



 