# [Path Sum](https://leetcode.com/problems/path-sum/)

Given a binary tree and a sum, determine if the tree has a root-to-leaf path such that adding up all the values along the path equals the given sum.

**Note:** A leaf is a node with no children.

**Example:**

Given the below binary tree and `sum = 22`,

```
      5
     / \
    4   8
   /   / \
  11  13  4
 /  \      \
7    2      1
```

return true, as there exist a root-to-leaf path `5->4->11->2` which sum is 22.

## 思路0

这个深搜吧...

```java
package com.lhj1998.leetcode.Tree._0112;

public class Solution {

    public boolean hasPathSum(TreeNode root, int sum) {
        if(null == root) return false;
        return dfs(root, sum);
    }

    private boolean dfs(TreeNode root, int sum){
        if(root == null) return false;
        if(sum == root.val && root.left == null && root.right == null) return true;
        return dfs(root.left, sum - root.val) || dfs(root.right, sum - root.val);
    }
    
}

```

