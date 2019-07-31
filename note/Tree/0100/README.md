# [Same Tree](https://leetcode.com/problems/same-tree/)

Given two binary trees, write a function to check if they are the same or not.

Two binary trees are considered the same if they are structurally identical and the nodes have the same value.

**Example 1:**

```
Input:     1         1
          / \       / \
         2   3     2   3

        [1,2,3],   [1,2,3]

Output: true
```

**Example 2:**

```
Input:     1         1
          /           \
         2             2

        [1,2],     [1,null,2]

Output: false
```

**Example 3:**

```
Input:     1         1
          / \       / \
         2   1     1   2

        [1,2,1],   [1,1,2]

Output: false
```

## 思路0

判断两棵树是否相等，可以判断它们的先序遍历是否相等

```java
package com.lhj1998.leetcode.Tree._0100;

public class Solution {

    public boolean isSameTree(TreeNode p, TreeNode q) {
        String str1 = preOrder(p, new StringBuilder()).toString();
        String str2 = preOrder(q, new StringBuilder()).toString();
        return str1.equals(str2);
    }

    private StringBuilder preOrder(TreeNode root, StringBuilder builder) {
        if (root != null) {
            builder.append(root.val);
            builder = preOrder(root.left, builder);
            return preOrder(root.right, builder);
        }else {
            builder.append("null");
            return builder;
        }
    }

}

```

## 思路1

既然两棵树相等，那么两棵树的子树也是相等的

可以递归两棵树，如果不相等直接返回false

```java
package com.lhj1998.leetcode.Tree._0100;

public class Solution {

    public boolean isSameTree(TreeNode p, TreeNode q) {
        if(p == null && q == null) return true;
        if(p == null && q != null || p != null && q == null) return false;
        if(p.val != q.val) return false;
        return isSameTree(p.left, q.left) && isSameTree(p.right, q.right);
    }

}

```

