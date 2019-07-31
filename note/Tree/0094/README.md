# [Binary Tree Inorder Traversal](https://leetcode.com/problems/binary-tree-inorder-traversal/)

Given a binary tree, return the *inorder* traversal of its nodes' values.

**Example:**

```
Input: [1,null,2,3]
   1
    \
     2
    /
   3

Output: [1,3,2]
```

**Follow up:** Recursive solution is trivial, could you do it iteratively?

## 思路0

中序遍历嘛，很简单的啦...

```java
package com.lhj1998.leetcode.Tree._0094;

public class Solution {

    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        inorder(res, root);
        return res;
    }

    private void inorder(List<Integer> res, TreeNode root){
        if(null == root) return;
        inorder(res, root.left);
        res.add(root.val);
        inorder(res, root.right);
    }

}

```

## 思路1

上面是递归解法，试试非递归的解法

非递归解法似乎得用栈来解决

```java
package com.lhj1998.leetcode.Tree._0094;

import java.util.List;

public class Solution {

    public List<Integer> inorderTraversal(TreeNode root) {
        Stack<TreeNode> stack = new Stack<>();
        List<Integer> res = new ArrayList<>();
        TreeNode curr = root;
        while(curr != null || !stack.isEmpty()){
            while(curr != null){
                stack.push(curr);
                curr = curr.left;
            }
            curr = stack.pop();
            res.add(curr.val);
            curr = curr.right;
        }
        return res;
    }

}

```

