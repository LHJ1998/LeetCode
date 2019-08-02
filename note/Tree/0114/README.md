# [Flatten Binary Tree to Linked List](https://leetcode.com/problems/flatten-binary-tree-to-linked-list/)

Given a binary tree, flatten it to a linked list in-place.

For example, given the following tree:

```
    1
   / \
  2   5
 / \   \
3   4   6
```

The flattened tree should look like:

```
1
 \
  2
   \
    3
     \
      4
       \
        5
         \
          6
```

## 思路0

这题目很简单，根据示例可以看出来就是要把所有节点放到右子树上去，对于根节点的左右子树也是一样的

这题目的非递归做法就是记录下每一次的左右节点，然后要优先处理左节点，把左节点插到根节点和右节点之间

```java
package com.lhj1998.leetcode.Tree._0114;

import java.util.LinkedList;

public class Solution {

    public void flatten(TreeNode root) {
        if(root == null) return;
        LinkedList<TreeNode> stack = new LinkedList<>();
        TreeNode prev = null;
        stack.push(root);
        while(stack.size() > 0){
            TreeNode node = stack.pop();
            if(prev != null) prev.right = node;
            prev = node;
            if(node.right != null) stack.push(node.right);
            if(node.left != null) stack.push(node.left);
            node.left = null;
            node.right = null;
        }
    }

}

```

## 思路2

使用递归的做法，这个不会...

```java
class Solution {
    private TreeNode prev = null;

    public void flatten(TreeNode root) {
        if (root == null)
            return;
        flatten(root.right);
        flatten(root.left);
        root.right = prev;
        root.left = null;
        prev = root;
    }
}

```

