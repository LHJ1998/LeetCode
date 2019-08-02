# [Binary Tree Postorder Traversal](https://leetcode.com/problems/binary-tree-postorder-traversal/)

Given a binary tree, return the *postorder* traversal of its nodes' values.

**Example:**

```
Input: [1,null,2,3]
   1
    \
     2
    /
   3

Output: [3,2,1]
```

**Follow up:** Recursive solution is trivial, could you do it iteratively?

## 思路0

这是我到目前见过的最水的一道Hard题，后序遍历....

```java
package com.lhj1998.leetcode.Tree._0145;

import java.util.ArrayList;
import java.util.List;

public class Solution {

    public List<Integer> postorderTraversal(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        if(root == null) return res;
        postorder(root, res);
        return res;
    }

    private void postorder(TreeNode root, List<Integer> res){
        if(root == null) return;
        postorder(root.left, res);
        postorder(root.right, res);
        res.add(root.val);
    }
    
}

```

## 思路1

非递归解法

```java
package com.lhj1998.leetcode.Tree._0145;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;

public class Solution {

    public List<Integer> postorderTraversal(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        if(root == null) return res;
        LinkedList<TreeNode> stack = new LinkedList<>();
        Set<TreeNode> visited = new HashSet<>();
        stack.push(root);
        while(stack.size() > 0){
            TreeNode node = stack.peek();
            if(node.left != null && !visited.contains(node.left)) {
                stack.push(node.left);
                continue;
            }
            if(node.right != null && !visited.contains(node.right)) {
                stack.push(node.right);
                continue;
            }
            TreeNode top = stack.pop();
            visited.add(top);
            res.add(top.val);
        }
        return res;
    }

}

```

