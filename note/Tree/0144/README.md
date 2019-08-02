# [Binary Tree Preorder Traversal](https://leetcode.com/problems/binary-tree-preorder-traversal/)

Given a binary tree, return the *preorder* traversal of its nodes' values.

**Example:**

```
Input: [1,null,2,3]
   1
    \
     2
    /
   3

Output: [1,2,3]
```

**Follow up:** Recursive solution is trivial, could you do it iteratively?

## 思路0

好水啊这题目，先序遍历...

递归解法，最简单的解法

```java
package com.lhj1998.leetcode.Tree._0144;

import java.util.ArrayList;
import java.util.List;

public class Solution {

    public List<Integer> preorderTraversal(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        if(root == null) return res;
        preorder(root, res);
        return res;
    }

    private void preorder(TreeNode root, List<Integer> res){
        if(root == null) return;
        res.add(root.val);
        preorder(root.left, res);
        preorder(root.right, res);
    }
    
}

```

## 思路1

非递归解法就需要用到栈了

按照先序遍历的特点，优先遍历所有的左节点，因此栈里面，先把所有的左节点加进去，同时记录每一个节点的值，然后到了最后一个左节点的时候，拿出这个左节点的右节点，又是一个优先左节点的遍历，重复这个过程就可以了

不过非递归做法似乎慢了一点

```java
package com.lhj1998.leetcode.Tree._0144;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class Solution {

    public List<Integer> preorderTraversal(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        if(root == null) return res;
        LinkedList<TreeNode> stack = new LinkedList<>();
        TreeNode node = root;
        while(node != null || stack.size() > 0){
            while(node != null){
                stack.push(node);
                res.add(node.val);
                node = node.left;
            }
            if(stack.size() > 0){
                node = stack.pop().right;
            }
        }
        return res;
    }

}

```

