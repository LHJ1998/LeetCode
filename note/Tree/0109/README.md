# [Balanced Binary Tree](https://leetcode.com/problems/balanced-binary-tree/)

Given a binary tree, determine if it is height-balanced.

For this problem, a height-balanced binary tree is defined as:

> a binary tree in which the depth of the two subtrees of *every* node never differ by more than 1.

**Example 1:**

Given the following tree `[3,9,20,null,null,15,7]`:

```
    3
   / \
  9  20
    /  \
   15   7
```

Return true.

**Example 2:**

Given the following tree `[1,2,2,3,3,null,null,4,4]`:

```
       1
      / \
     2   2
    / \
   3   3
  / \
 4   4
```

Return false.

## 思路0

这个题目就是判断一下是不是平衡二叉树而已啦，求出左子树的深度和右子树的深度，比较一下就好了

忘记比较子树也是不是平衡二叉树了，错了几次才发现...

```java
package com.lhj1998.leetcode.Tree._0109;

public class Solution {

    public boolean isBalanced(TreeNode root) {
        if(root == null) return true;
        return (Math.abs(deepth(root.left) - deepth(root.right)) <= 1) &&
                isBalanced(root.left) && isBalanced(root.right);
    }

    private int deepth(TreeNode root){
        if(root == null) return 0;
        return Math.max(deepth(root.left), deepth(root.right)) + 1;
    }
    
}

```

