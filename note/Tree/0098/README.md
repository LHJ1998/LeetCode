# [Validate Binary Search Tree](https://leetcode.com/problems/validate-binary-search-tree/)

Given a binary tree, determine if it is a valid binary search tree (BST).

Assume a BST is defined as follows:

- The left subtree of a node contains only nodes with keys **less than** the node's key.
- The right subtree of a node contains only nodes with keys **greater than** the node's key.
- Both the left and right subtrees must also be binary search trees.

 

**Example 1:**

```
    2
   / \
  1   3

Input: [2,1,3]
Output: true
```

**Example 2:**

```
    5
   / \
  1   4
     / \
    3   6

Input: [5,1,4,null,null,3,6]
Output: false
Explanation: The root node's value is 5 but its right child's value is 4.
```

## 思路0

第一个想法就是，二叉搜索数的中序遍历不就是一个递增序列吗，然后把后序遍历弄出来，看看是不是递增的不就好了

用了1ms，感觉还行，不过还有0ms的，看看

```java
package com.lhj1998.leetcode.Tree._0098;

import java.util.ArrayList;
import java.util.List;

public class Solution {

    public boolean isValidBST(TreeNode root) {
        return isValidBST(root, new ArrayList<Integer>());
    }

    private boolean isValidBST(TreeNode root, List<Integer> list){
        if(root != null){
            boolean validLeft = isValidBST(root.left, list);
            if(!validLeft) return false;
            if(list.size() > 0 && root.val <= list.get(list.size() - 1)) return false;
            list.add(root.val);
            return isValidBST(root.right, list);
        }
        return true;
    }

}

```

## 思路1

这个解法就是用了二叉搜索树左子树和右子树也是二叉搜索树的特点

```java
class Solution {
    public boolean isValidBST(TreeNode root) {
        return dfs(root, Integer.MIN_VALUE, Integer.MAX_VALUE);
    }
    
    public boolean dfs(TreeNode node, long min, long max){
        if( node == null)
            return true;
        if(node.val < min || node.val > max)
            return false;
        return dfs(node.left, min, node.val - (long)1) && dfs(node.right, node.val + (long)1, max); 
    }
}
```

